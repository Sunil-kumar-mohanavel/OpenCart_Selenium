package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	
	
	  public  WebDriver driver;

	     @BeforeClass
	     
	     void setup()
	     {
	    	 driver=new ChromeDriver();
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	 		 driver.manage().window().maximize();
	    	 
	     }
	              
	         @AfterClass
	     
	     void close()
	     {
	    	 driver.quit();
	    	 
	     }
	         
}
