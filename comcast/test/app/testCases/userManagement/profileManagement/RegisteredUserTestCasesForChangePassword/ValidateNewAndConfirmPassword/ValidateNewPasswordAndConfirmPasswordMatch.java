package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePassword.ValidateNewAndConfirmPassword;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateNewPasswordAndConfirmPasswordMatch
 * Description: This test case validates whether New and Confirm password matches 
 * for registered user into Comcast application.
 * **/

public class ValidateNewPasswordAndConfirmPasswordMatch extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();

	
	@Test
  public void testVerifyPasswordChangeWorks() throws Exception {
	
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
    
	driver.findElement(By.cssSelector("span.translation_missing")).click();
   
    driver.findElement(By.linkText("Change password")).click();
    
    //This method is used to validate whether new and confirm password matches
    profMangScenarioFun.VerifyNewPassAndConfirmPassMatch(driver,DataServiceProperties._PASSWORD,DataServiceProperties._PASSWORD,DataServiceProperties._INVALID_PASSWORD_LENGTH);
    
    Thread.sleep(sleepTime);    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Passwords doesn't match[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
