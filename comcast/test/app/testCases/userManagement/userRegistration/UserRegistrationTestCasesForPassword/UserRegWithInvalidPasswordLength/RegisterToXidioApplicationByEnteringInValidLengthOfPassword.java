package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForPassword.UserRegWithInvalidPasswordLength;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/**
 * Class Name: RegisterToXidioApplicationByEnteringInValidLengthOfPassword
 * Description: This test case registers to Xidio application by entering invalid length of password.
 **/

public class RegisterToXidioApplicationByEnteringInValidLengthOfPassword extends BaseTest {

	UserRegistrationValidationFuncitons userRegValidationFun = new UserRegistrationValidationFuncitons();

	@Test
	public void testRegisterToXidioApplicationByEnteringInValidLengthOfPassword()throws Exception {
		driver.get(DataServiceProperties.APPURL);
		
		driver.findElement(By.linkText("Register")).click();

		//This method is used to validate length of password
		userRegValidationFun.validateUserRegistrationFields(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._INVALID_PASSWORD_LENGTH);
		
		driver.findElement(By.linkText("Submit")).click();
		
		Thread.sleep(sleepTime);		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter at least 8 characters in Password[\\s\\S]*$"));
	}
}
