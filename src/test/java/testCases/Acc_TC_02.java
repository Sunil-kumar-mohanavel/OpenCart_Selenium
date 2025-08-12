package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccRegistration;
import pageObjects.HomePage;
import pageObjects.LogIn_Page;
import pageObjects.MyAcc;

public class Acc_TC_02 extends BaseClass
{
	

    @Test (groups= {"regression","functional"})
    
 public    void verifyaccreg() 
	 
    {
    
    	
    	try {
    		
    		// HOME PAGE
    	
    	HomePage h1=new HomePage(driver);
    	
    	
    	h1.clickacc();
    	
    	h1.login();
   
    	
    	  // LogIn_Page 
    	
    	LogIn_Page  lp= new LogIn_Page (driver);
 
    	
      lp.maile("email");
      
      lp.pwds("pass");
      
      lp.logcli();
    	
     // myacc
      
      MyAcc  mc= new MyAcc (driver);
      
  	
    boolean ext=  mc.isaccexsits();
    
    Assert.assertTrue(ext);
      
      

    }catch(Exception e)
 {
    	
    	Assert.fail();
 }
    	
    	
    	
}

}
