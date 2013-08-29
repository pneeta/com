package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePinCode.ValidatePinCodeField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateChangePinCodeByEnteringInvalidPinLength
 * Description: This test case validates Pin by entering invalid pin length
 * by logging registered user into Comcast application.
 * **/

public class ValidateChangePinCodeByEnteringInvalidPinLength extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword(); 
		
	@Test
	public void testChangePinCodeByEnteringInvalidPinLength() throws Exception {
	
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	    
	    Thread.sleep(sleepTime);	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change pin code")).click();
	    
	    driver.findElement(By.name("cc_pin_code")).clear();
	    driver.findElement(By.name("cc_pin_code")).sendKeys(DataServiceProperties._INVALID_CC_PIN_CODE_LENGTH);
	    
	    driver.findElement(By.name("commit")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Pin code has not been updated[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
