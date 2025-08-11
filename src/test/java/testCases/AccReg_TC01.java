package testCases;


import org.apache.commons.lang3.RandomStringUtils;

import org.testng.Assert;

import org.testng.annotations.Test;


import pageObjects.AccRegistration;
import pageObjects.HomePage;

public class AccReg_TC01 extends BaseClass{

       
         
            @Test
            
             void verifyaccreg() throws InterruptedException {
            	
            	HomePage h1=new HomePage(driver);
            	
            	h1.clickacc();
            	h1.clickreg();
            	
            	AccRegistration ar= new AccRegistration(driver);
            	
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
            	
            	
            	
            	String conms = ar.getconfirmationmg();
            	Assert.assertEquals(conms, "Your Account Has Been Created!");
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
	
	
}
