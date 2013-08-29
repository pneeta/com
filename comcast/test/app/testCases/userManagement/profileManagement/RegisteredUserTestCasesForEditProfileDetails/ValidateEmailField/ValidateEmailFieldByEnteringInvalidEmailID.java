package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateEmailField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: ValidateEmailFieldByEnteringInvalidEmailID
 * Description: This test case validates Email Field by entering invalid Email ID by
 * logging registered user into Comcast application.
 **/

public class ValidateEmailFieldByEnteringInvalidEmailID extends BaseTest {
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();

	@Test
	public void testValidateUserNameFieldWithInValidEmail() throws Exception {

		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

		driver.findElement(By.cssSelector("span.translation_missing")).click();
		
		driver.findElement(By.name("user[email]")).clear();
		driver.findElement(By.name("user[email]")).sendKeys(DataServiceProperties._INVALID_EMAIL);

		driver.findElement(By.linkText("Save profile")).click();

		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter a valid email address[\\s\\S]*$"));

		driver.findElement(By.linkText("Sign out")).click();
	}
}
