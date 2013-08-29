package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePassword.VerifyPasswordChangesSuccessfully;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;
/**  
 * Class Name: VerifyPasswordChangeWorks
 * Description: This test case validates changing password form Profile Management
 * by registered user into Comcast application.
 * **/

public class VerifyPasswordChangeWorks extends BaseTest{
	
	UserLoginFunctions userLogFun=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	
	@Test
  public void testVerifyPasswordChangeWorks() throws Exception {
	
	//This method is used to register new user into Comcast Application
	userReg.testUserRegistrationUsingComcast(driver);
	
	driver.get(DataServiceProperties.APPURL);
	
	//This method is used to enter user name and password credential
	userLogFun.UserLoginCredentials(driver);
	
	driver.findElement(By.id("user_login")).click();
		
	driver.findElement(By.cssSelector("span.translation_missing")).click();
	       
    driver.findElement(By.linkText("Change password")).click();
    
    //This method is used to Change Password
    userLogFun.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
    
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(sleepTime);
    
    try {
    	
        assertEquals("", driver.findElement(By.cssSelector("a.logo")).getText());
        
      } catch (Error e) {
    	  
        verificationErrors.append(e.toString());
      }
      
    driver.findElement(By.linkText("Sign out")).click();
  }
}

