package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	// constructor 
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	// locators  
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	
	WebElement lnkacc;
	
@FindBy(xpath="//a[normalize-space()='Register']")
	
	WebElement lnkreg;

   

 // log in

  @FindBy(xpath="//a[normalize-space()='Login']")
  
  WebElement loin;


     // action methods

       public void clickacc() {
    	   
    	   lnkacc.click();
       }
       
       

       public void clickreg() {
    	   
    	   lnkreg.click();
       }
       
       

       public void login() {
    	   
    	   loin.click();
       }
       
       
	
}
