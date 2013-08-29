package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateLastNameField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: ValidateLastNameFieldByDeletingValue
 * Description: This test case validates Last Name field by deleting the value
 * by logging registered user into Comcast application.
 **/

public class ValidateLastNameFieldByDeletingValue extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
  @Test
  public void testValidateLastNameFieldByDeletingValueInPM() throws Exception {

	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	
	Thread.sleep(sleepTime);	
	driver.findElement(By.cssSelector("span.translation_missing")).click();
	
    driver.findElement(By.name("user[last_name]")).clear();
    driver.findElement(By.name("user[last_name]")).sendKeys("");
    
    driver.findElement(By.linkText("Save profile")).click();
	
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Last name is required[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
