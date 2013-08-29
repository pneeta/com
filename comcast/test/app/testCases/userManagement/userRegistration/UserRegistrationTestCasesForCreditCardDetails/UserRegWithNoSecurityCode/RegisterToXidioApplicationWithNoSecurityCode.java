package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegWithNoSecurityCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/** Class Name: RegisterToXidioApplicationWithNoSecurityCode
 *  Description: This test case is for user registration to comcast application
 *  without entering Security code
 * **/

public class RegisterToXidioApplicationWithNoSecurityCode extends BaseTest{
	
  	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
  	UserRegistrationValidationFuncitons userRegVal=new UserRegistrationValidationFuncitons();
  	
  	@Test
  	public void testRegisterToXidioApplicationWithNoSecurityCode() throws Exception {
		
		driver.get(DataServiceProperties.APPURL);
		Thread.sleep(sleepTime);
		
	    driver.findElement(By.linkText("Register")).click();
	    Thread.sleep(sleepTime);
	    
	    //This method is used to enter registration fields details
	    userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	    
	    driver.findElement(By.name("terms_conditions")).click();
	    
	    driver.findElement(By.linkText("Next")).click();
	    
	    Thread.sleep(sleepTime);
	  
	    //This method is used to verify that security code is mandatory field
	    userRegVal.ValidateSecurityCodeMandatoryField(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._CC_PIN_CODE);
	    
	    driver.findElement(By.linkText("Next")).click();
	    
	    Thread.sleep(sleepTime);
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Security Code is required[\\s\\S]*$"));
	 }
}
