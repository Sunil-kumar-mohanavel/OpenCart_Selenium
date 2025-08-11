package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegistration  extends BasePage


   // constructor 

{

	public AccRegistration(WebDriver driver) {
		super(driver);
	}
	
	
	
 // locator
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	
	WebElement firnam;
	
@FindBy(xpath="//input[@id=\"input-lastname\"]")
	
	WebElement lasnam;


@FindBy(xpath="//input[@id='input-email']")

WebElement mainam;

@FindBy(xpath="//input[@id='input-telephone']")

WebElement telp;


@FindBy(xpath="//input[@id='input-password']")

WebElement pas;


@FindBy(xpath="//input[@id='input-confirm']")

WebElement conpas;

	
@FindBy(xpath="//input[@name='agree']")

WebElement agr;


@FindBy(xpath="//input[@value='Continue']")

WebElement cont;



@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")

WebElement commg;

  

  // action method


   public void frsname (String fname)
   {
	   firnam.sendKeys(fname);
	   
   }
   
   public void lasname(String lname)
   {
	   lasnam.sendKeys(lname);
	   
   }
   
   public void mailids(String mailid)
   {
	  mainam.sendKeys(mailid);
	   
   }
   
   public void  telpho(String tel)
   {
	   telp.sendKeys(tel);
	   
   }

   
   public void pwd (String pwds)
   {
	   pas.sendKeys(pwds);
	   
   }
   
   
   public void conpasw(String conpwds)
   {
	   conpas.sendKeys(conpwds);
	   
   }
   
   
   public void agree()
   {
	   agr.click();
	   
	   
	  
   }
   
   public void conts( )
   {
	   cont.click();
	   
   }
   
   
   public String getconfirmationmg()
   {
	   try {
		   
		   return (commg.getText());
	   } catch(Exception e)
	   {
		   return (e.getMessage());
	   }
	   
   }
  
}
