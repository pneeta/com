package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePaymentInfo.ValidateCreditCardField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidatePaymentInfoCreditCardNumberWithInvalidInput
 * Description: This test case validates payment Details Credit Card with Invalid Input
 * By logging registered user into Comcast application.
 * **/

public class ValidatePaymentInfoCreditCardNumberWithInvalidInput extends BaseTest{
	
	  RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	  ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	  @Test
	  public void testCCNumberWithInvalidInput() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
		Thread.sleep(sleepTime);		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change payment info")).click();
	    
	    //This method is used to validate the invalid Credit Card Number
	    profMangScenarioFun.ValidateInvalidCreditCardDetials(driver,DataServiceProperties._INVALID_CC_NUMBER,DataServiceProperties._CC_EXPIRY_MONTH,DataServiceProperties._CC_YEAR,DataServiceProperties._CC_SECURITY_CODE);
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter a valid credit card number[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("#uniform-undefined > span")).click();
	    
	    Thread.sleep(sleepTime);
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Payment info has not been updated[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}

