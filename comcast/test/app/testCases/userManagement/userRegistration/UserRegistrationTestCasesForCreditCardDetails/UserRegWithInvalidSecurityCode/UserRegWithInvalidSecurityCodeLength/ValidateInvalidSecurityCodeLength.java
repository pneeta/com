package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegWithInvalidSecurityCode.UserRegWithInvalidSecurityCodeLength;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** Class Name: ValidateInvalidSecurityCodeLength
 *  Description: This test case is to validate Security Code Length
 *  by registering to Comcast Application.
 * **/

public class ValidateInvalidSecurityCodeLength extends BaseTest{
	
	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
	UserRegistrationValidationFuncitons userRegVal=new UserRegistrationValidationFuncitons();
  
	@Test
	public void terstValidateInvalidSecurityCodeLength() throws Exception {
		
	driver.get(DataServiceProperties.APPURL);
	
	Thread.sleep(sleepTime);
    driver.findElement(By.linkText("Register")).click();
    
    Thread.sleep(sleepTime);
    //This method is used to enter registration fields details
    userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
    
    driver.findElement(By.name("terms_conditions")).click();
    
    driver.findElement(By.linkText("Next")).click();
    
    Thread.sleep(sleepTime);
    //This method is used to validate security code length	    
    userRegVal.ValidateSecurityCodeLength(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._CC_EXPIRY_MONTH,DataServiceProperties._CC_YEAR,DataServiceProperties._INVALID_CC_SECURITY_CODE,DataServiceProperties._CC_PIN_CODE);
    
    driver.findElement(By.linkText("Next")).click();
    //driver.findElement(By.cssSelector("input.change_input_type.ignore")).click();
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter Security Code 3 characters long[\\s\\S]*$"));
    
    //driver.findElement(By.linkText("Next")).click();
  }
}