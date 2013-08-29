package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForEmail.UserRegWithNoEmailID;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/** Class Name: RegisterToXidioApplicationWithoutEnteringEmail
 *  Description: This test case is for user registration to comcast application
 *  without entering Email
 * **/

public class RegisterToXidioApplicationWithoutEnteringEmail extends BaseTest{
	
	UserRegistrationValidationFuncitons userRegValFun=new UserRegistrationValidationFuncitons();
  
	@Test
	public void testRegisterToXidioApplicationWithoutEnteringEmail() throws Exception {
		
	    driver.get(DataServiceProperties.APPURL);
	    
	    driver.findElement(By.linkText("Register")).click();
	    
	    //This method is used to verify Email field in registration page
	    userRegValFun.validateEmail(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	    
	    driver.findElement(By.linkText("Submit")).click();
	    
	    Thread.sleep(sleepTime);	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Email is required[\\s\\S]*$"));
	}
}
