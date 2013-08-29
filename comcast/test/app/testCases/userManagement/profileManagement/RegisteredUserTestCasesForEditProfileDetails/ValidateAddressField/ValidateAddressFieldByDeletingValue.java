package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateAddressField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateAddressFieldByDeletingValue
 * Description: This test case validates the Address field by deleting value by
 * logging registered user into Comcast application.
 * **/

public class ValidateAddressFieldByDeletingValue extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testValidateAddressFieldByDeletingValueInPM() throws Exception {

	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	
	driver.findElement(By.cssSelector("span.translation_missing")).click();
	
    driver.findElement(By.name("user[address]")).clear();
    driver.findElement(By.name("user[address]")).sendKeys("");
    
    driver.findElement(By.linkText("Save profile")).click();
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Address is required[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
