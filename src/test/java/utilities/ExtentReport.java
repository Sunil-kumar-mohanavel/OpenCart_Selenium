package utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener 

{
	 private ExtentReports extent;
	    private ExtentTest test;
	    private ExtentSparkReporter sparkReporter;
	    private String repName;

	    // Selenium driver instance should be set from your BaseClass
	    private static org.openqa.selenium.WebDriver driver;

	    public static void setDriver(org.openqa.selenium.WebDriver driverInstance) {
	        driver = driverInstance;
	    }

	    @Override
	    public void onStart(ITestContext testContext) {
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repName = "Test-Report-" + timeStamp + ".html";

	        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
	        sparkReporter.config().setDocumentTitle("Opencart Automation Report");
	        sparkReporter.config().setReportName("Opencart Functional Testing");
	        sparkReporter.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application", "opencart");
	        extent.setSystemInfo("Module", "Admin");
	        extent.setSystemInfo("Sub Module", "Customers");
	        extent.setSystemInfo("User Name", System.getProperty("user.name"));
	        extent.setSystemInfo("Environment", "QA");

	        String os = testContext.getCurrentXmlTest().getParameter("os");
	        extent.setSystemInfo("Operating System", os);

	        String browser = testContext.getCurrentXmlTest().getParameter("browser");
	        extent.setSystemInfo("Browser", browser);

	        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
	        if (!includedGroups.isEmpty()) {
	            extent.setSystemInfo("Groups", includedGroups.toString());
	        }
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.PASS, result.getName() + " got successfully executed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.FAIL, result.getName() + " got failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());

	        try {
	            String imgPath = captureScreen(result.getName());
	            test.addScreenCaptureFromPath(imgPath);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.SKIP, result.getName() + " got skipped");

	        if (result.getThrowable() != null) {
	            test.log(Status.INFO, result.getThrowable().getMessage());
	        }
	    }

	    @Override
	    public void onFinish(ITestContext testContext) {
	        extent.flush();

	        String reportPath = System.getProperty("user.dir") + "\\reports\\" + repName;
	        File extentReport = new File(reportPath);

	        try {
	            if (extentReport.exists()) {
	                Desktop.getDesktop().browse(extentReport.toURI());
	                sendEmailWithReport(reportPath); // Send email after test run
	            } else {
	                System.out.println("Report file not found: " + reportPath);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Screenshot capture utility
	    public String captureScreen(String tname) throws IOException {
	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	        File targetFile = new File(targetFilePath);
	        sourceFile.renameTo(targetFile);

	        return targetFilePath;
	    }

	    // Email sending utility
	    private void sendEmailWithReport(String reportPath) {
	        try {
	            URL url = new URL("file:///" + reportPath);
	            ImageHtmlEmail email = new ImageHtmlEmail();
	            email.setDataSourceResolver(new DataSourceUrlResolver(url));

	            email.setHostName("smtp.googlemail.com");
	            email.setSmtpPort(465);
	            email.setAuthenticator(new DefaultAuthenticator("yourEmail@gmail.com", "yourAppPassword"));
	            email.setSSLOnConnect(true);

	            email.setFrom("yourEmail@gmail.com");
	            email.setSubject("Test Results");
	            email.setMsg("Please find Attached Report...");
	            email.addTo("receiverEmail@gmail.com");
	            email.attach(url, "Extent Report", "Please check the report...");

	            email.send();
	            System.out.println("Email sent successfully with report attached.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	
}
