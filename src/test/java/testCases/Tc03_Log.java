package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LogIn_Page;
import pageObjects.MyAcc;
import utilities.DataProviders_Utility;

public class Tc03_Log extends BaseClass{
	
	@Test(dataProvider="LogData",dataProviderClass=DataProviders_Utility.class, groups="datadriven")
	
	public void log(String mail, String pwd, String exp)
	{
		
		logger.info("Tc03_Log stared");
		
		
		try {
// HOME PAGE
    	
    	HomePage h1=new HomePage(driver);
    	
    	
    	h1.clickacc();
    	
    	h1.login();
   
    	
    	  // LogIn_Page 
    	
    	LogIn_Page  lp= new LogIn_Page (driver);
 
    	
      lp.maile(mail);
      
      lp.pwds(pwd);
      
      lp.logcli();
    	
     // myacc
      
      MyAcc  mc= new MyAcc (driver);
      
  	
    boolean ext=  mc.isaccexsits();
    
    /* Data is valid   - login success - test pass  - logout
    login failed  - test fail

Data is invalid - login success - test fail  - logout
    login failed  - test pass
*/
    
    if (exp.equalsIgnoreCase("Valid")) {
        if (ext == true) {
        	mc.lgot();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    if (exp.equalsIgnoreCase("Invalid")) {
        if (ext == true) {
        	mc.lgot();
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }
    }

		}catch(Exception e)
		{
			
			Assert.fail();
		}
		
		
		logger.info("Tc03_Log finished");
      
	}

}
