package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePassword.ValidateCurrentUserPassWhileChangingPass;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateCurrentPasswordWhenChangingPassword
 * Description: This test case validates changing password form Profile Management
 * by registered user into Comcast application.
 * **/
 
public class ValidateCurrentPasswordWhenChangingPassword extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
 
  @Test
  public void testValidateCurrentPasswordWhenChangingPassword() throws Exception {
	
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	Thread.sleep(sleepTime);
	driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change password")).click();
    
    profMangScenarioFun.ValidatePassword(driver,DataServiceProperties._NONDIGIT_PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._INVALID_PASSWORD);
    
    //driver.findElement(By.name("commit")).click();
   
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Password has not been updated[\\s\\S]*$"));

    driver.findElement(By.linkText("Sign out")).click();
  }
}

