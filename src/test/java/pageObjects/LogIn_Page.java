package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn_Page extends BasePage{
	
	// constructor 
	
		public LogIn_Page(WebDriver driver) {
			super(driver);
		}

		
		// locators  
		
		@FindBy(xpath="//input[@id='input-email']")
		
		WebElement emal;
		
	@FindBy(xpath="//input[@id='input-password']")
		
		WebElement epas;

	   

	 

	  @FindBy(xpath="//button[normalize-space()='Login']")
	  
	  WebElement locli;


	     // action methods

	       public void maile(String email) {
	    	   
	    	   emal.sendKeys(email);
	       }
	       
	       

  public void pwds(String pasw) {
	    	   
	    	   emal.sendKeys(pasw);
	       }

	       public void logcli() {
	    	   
	    	   locli.click();
	       }
	       

}
