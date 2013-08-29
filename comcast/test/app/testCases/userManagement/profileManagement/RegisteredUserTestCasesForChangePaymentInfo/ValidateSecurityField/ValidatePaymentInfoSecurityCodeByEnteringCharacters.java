package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePaymentInfo.ValidateSecurityField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidatePaymentInfoSecurityCodeByEnteringCharacters
 * Description: This test case validates payment Details Security Code By Entering Character value
 * By logging registered user into Comcast application.
 * **/

public class ValidatePaymentInfoSecurityCodeByEnteringCharacters extends BaseTest{
	
	  RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	  ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	  @Test
	  public void testSecurityCodeByEnteringCharacters() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change payment info")).click();
	    
	    //This method is used to validate Security Code Field By Entering Character value
	    profMangScenarioFun.ValidateInvalidCreditCardDetials(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._CC_EXPIRY_MONTH,DataServiceProperties._CC_YEAR,DataServiceProperties._INVALID_CC_SECURITY_CODE_CHAR);
	    
	    driver.findElement(By.name("commit")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter only digits in Security Code[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}

