package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	
	  public  static WebDriver driver;
	  
	  public Logger logger;
	  
	public Properties p; 

	     @BeforeClass(groups= {"sanity","regression","master","datadriven"})
	     @Parameters({"browser"})
	     
	     void setup( String br) throws IOException
	     {
	    	 // loading config.properties file
	    	 
	   FileReader file= new FileReader("./src//test//resources//config.properties");
	    	 
	    	p = new Properties();
	    	 p.load(file);
	    	 
	    	 
	    	 logger=LogManager.getLogger(this.getClass());
	    	 
	    	 
	    	 
	    	  switch(br.toLowerCase())
	    	  {
	    	  
	    	  case "chrome" : driver = new ChromeDriver(); break;
	    	  case "edge" : driver = new EdgeDriver(); break;
	    	  case "firefox" : driver = new FirefoxDriver(); break;
	    	  
	    	  default: System.out.println("invalid browser"); return;
	    	  		
	    	  }
	    	  
	    	
	    	 
	    	 
	    	 
	    	 driver.manage().deleteAllCookies();
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 		driver.get(p.getProperty("url"));  // reading URL in property file 
	 		 driver.manage().window().maximize();
	    	 
	     }
	              
	         @AfterClass(groups= {"sanity","regression","master"})
	     
	     void close()
	     {
	    	 driver.quit();
	    	 
	     }
	         
	         
	         public String randomstring() {
	            	
	            	String genst = RandomStringUtils.randomAlphabetic(6);
	            	
	            	return genst;
	            }
	            
	            
	  public String randomno() {
	            	
	            	String genno = RandomStringUtils.randomNumeric(7);
	            	
	            	return genno;
	            }
	  
	  public String randomalnu() {
	  	
	  	String genalnu = RandomStringUtils.randomNumeric(2);
	  	
	  	String genstal = RandomStringUtils.randomAlphabetic(5);
	  	
	  	return (genstal+"%"+genalnu);
	  }
	  
	  
	  //capture screen method
	  
	  
	  public String captureScreen(String tname) throws IOException {

		    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		    File targetFile = new File(targetFilePath);

		    sourceFile.renameTo(targetFile);

		    return targetFilePath;
		}

	         
}
