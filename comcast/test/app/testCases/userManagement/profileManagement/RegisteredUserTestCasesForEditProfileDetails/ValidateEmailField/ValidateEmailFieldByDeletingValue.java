package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateEmailField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: ValidateEmailFieldByDeletingValue
 * Description: This test case validates Email field by deleting value by
 * logging registered user into Comcast application.
 **/

public class ValidateEmailFieldByDeletingValue extends BaseTest {

	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();

	@Test
	public void testValidateEmailFieldByDeletingValueInPM() throws Exception {

		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

		driver.findElement(By.className("translation_missing")).click();
		
		driver.findElement(By.name("user[email]")).clear();
		driver.findElement(By.name("user[email]")).sendKeys("");

		driver.findElement(By.linkText("Save profile")).click();

		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Email is required[\\s\\S]*$"));

		driver.findElement(By.linkText("Sign out")).click();
	}
}
