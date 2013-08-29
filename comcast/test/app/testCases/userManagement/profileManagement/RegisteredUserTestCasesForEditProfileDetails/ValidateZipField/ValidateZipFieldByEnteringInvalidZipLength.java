package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateZipField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: ValidateZipFieldByEnteringInvalidZipLength
 * Description: This test case validates Zip field by entering invalid zip length
 * by logging registered user into Comcast application.
 **/

public class ValidateZipFieldByEnteringInvalidZipLength extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
  @Test
  public void testValidateZipFieldByEnteringInvalidLength() throws Exception {

	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

	driver.findElement(By.cssSelector("span.translation_missing")).click();
	
    driver.findElement(By.name("user[zip]")).clear();
    driver.findElement(By.name("user[zip]")).sendKeys(DataServiceProperties._INVALID_ZIP_LENGTH);
    
    driver.findElement(By.linkText("Save profile")).click();
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter Zip code 5 characters long[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
