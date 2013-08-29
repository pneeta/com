package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForEmail.UserRegWithInvalidEmailID.UserRegWithInvalidEmailIDMissingInputs;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/** Class Name: RegisterToXidioApplicationByEnteringInValidEmail
 *  Description: This test case is for user registration to comcast application
 *  by entering invalid Email
 * **/

public class RegisterToXidioApplicationByEnteringInValidEmail extends BaseTest{
	
  UserRegistrationValidationFuncitons userRegValidationFun=new UserRegistrationValidationFuncitons();
  
  @Test
  public void testRegisterToXidioApplicationByEnteringInValidEmail() throws Exception {
	  
		driver.get(DataServiceProperties.APPURL);
		
	    driver.findElement(By.linkText("Register")).click();
	    
	    //This method is used to validate invalid Email in registration page
	    userRegValidationFun.validateInvalidEmail(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._INVALID_EMAIL,DataServiceProperties._REG_PASSWORD);

	    driver.findElement(By.linkText("Submit")).click();
	    
	    Thread.sleep(sleepTime);	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter a valid email address[\\s\\S]*$"));
  }
}
