package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePaymentInfo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.exception.ComcastTestException;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateChangePaymentInfoMandatoryFields
 * Description: This test case validates payment Details All Mandatory Fields by
 * logging registered user into Comcast application.
 * **/

public class ValidateChangePaymentInfoMandatoryFields extends BaseTest
{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	UserRegistrationValidationFuncitons userRegValFun=new UserRegistrationValidationFuncitons();
	
	@Test
	public void testUserProfileChanges() throws Exception {
			
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    try{
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change payment info")).click();
    	    
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Credit Card Number is required[\\s\\S]*$"));
    
    //Below lines are commented because Requirement is changed from Text boxes to Dropdowns. 
    /*assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Expiration Month is required[\\s\\S]*$"));
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Expiration Year is required[\\s\\S]*$"));*/
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Security Code is required[\\s\\S]*$"));
    
    Thread.sleep(sleepTime);
    driver.findElement(By.linkText("Sign out")).click();
    
	}
	catch(Exception e){
		//throw new ComcastTestException("ValidateChangePaymentInfoMandatoryFields", "testUserProfileChanges",e );
		captureScreenshot();
			}
	}
}

