package testCases;




import org.testng.Assert;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccRegistration;
import pageObjects.HomePage;

public class AccReg_TC01 extends BaseClass {

       
         
            @Test(groups= {"sanity","functional"})
            
         public    void verifyaccreg() throws InterruptedException {
            
            	
            	try {
            	logger.info("starting AccReg_TC01");
            	
            	HomePage h1=new HomePage(driver);
            	
            	h1.clickacc();
            	
            	logger.info("clicked on acc");
            	h1.clickreg();
            	
            	logger.info("clicked on reg");
            	
          AccRegistration ar= new AccRegistration(driver);
          
          logger.info(" user info details ");
            	
            	ar.frsname(randomstring());
            	
            	ar.lasname(randomstring());
            	
            	ar.mailids(randomstring()+"@gmail.com");
            	
            	ar.telpho(randomno());
            	
            	
            	String pawd = randomalnu();
            	
            	ar.pwd(pawd);
            	
            	
            	ar.conpasw(pawd);
            	
            	ar.agree();
            	
            	Thread.sleep(5000);
            	
            	ar.conts();
            	
            	logger.info(" confirmation message  ");
            	
            	String conms = ar.getconfirmationmg();
            	
            	if(conms.equals("Your Account Has Been Created!"))
            	{
            		Assert.assertTrue(true);
            		
            	}
            	
            	else
            	{
            		
            		logger.error("test failed");
            		
            		logger.debug("debug log");
            		Assert.assertTrue(false);
            	}
            	
             
	
            }catch(Exception e)
         {
            	
            	Assert.fail();
         }
            	
            	
            	logger.info("finsh text for AccReg_TC01");
}
}