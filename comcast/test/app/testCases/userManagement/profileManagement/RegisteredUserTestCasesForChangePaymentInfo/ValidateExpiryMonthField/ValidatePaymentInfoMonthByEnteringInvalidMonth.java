package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePaymentInfo.ValidateExpiryMonthField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidatePaymentInfoMonthByEnteringInvalidMonth
 * Description: This test case validates Payment Info Month field by entering Invalid Input
 * By logging registered user into Comcast application.
 * **/

public class ValidatePaymentInfoMonthByEnteringInvalidMonth extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	@Test
	public void testPaymentInfoInvalidMonth() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change payment info")).click();
	    
	    //This method is used to validate invalid month
	    profMangScenarioFun.ValidateInvalidCreditCardDetials(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._INVALID_CC_EXPIRY_MONTH,DataServiceProperties._CC_YEAR,DataServiceProperties._CC_SECURITY_CODE);
	    
	    driver.findElement(By.cssSelector("#uniform-undefined > span")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter Expiration Month between 1 and 12.[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
 	}
}

