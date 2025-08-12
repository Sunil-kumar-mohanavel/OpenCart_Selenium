package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcc extends BasePage{
	
	// constructor 
	
			public MyAcc(WebDriver driver) {
				super(driver);
			}

			
			// locators  
			
			@FindBy(xpath="//h2[text()='My Account']")
			
			WebElement acc;
			
			
			@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
			
			WebElement out;
			
			// action method
			
			
			public boolean isaccexsits() {
				
				try
				{
					return(acc.isDisplayed());
					
				}catch(Exception e)
				{
					return false;
				}
			}
			
			
			public void lgot() {
				
				out.click();
			}

}
