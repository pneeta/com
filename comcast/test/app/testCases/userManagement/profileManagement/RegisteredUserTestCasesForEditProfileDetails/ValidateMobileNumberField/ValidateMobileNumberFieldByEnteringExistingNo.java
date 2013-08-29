package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateMobileNumberField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: ValidateMobileNumberFieldByEnteringExistingNo
 * Description: This test case validates mobile number field by entering existing number
 * by logging registered user into Comcast application.
 **/

public class ValidateMobileNumberFieldByEnteringExistingNo extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
  @Test
  public void testValidateMobileNumberByEnteringExistingNo() throws Exception {

	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	
	driver.findElement(By.cssSelector("span.translation_missing")).click();
	
    driver.findElement(By.name("user[mobile_number]")).clear();
    driver.findElement(By.name("user[mobile_number]")).sendKeys(DataServiceProperties._MOBILE_NUMBER);
    
    driver.findElement(By.linkText("Save profile")).click();
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Mobile number "+DataServiceProperties._MOBILE_NUMBER+" is already in use[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
