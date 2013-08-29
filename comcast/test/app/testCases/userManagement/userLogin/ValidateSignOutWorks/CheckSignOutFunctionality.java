package comcast.test.app.testCases.userManagement.userLogin.ValidateSignOutWorks;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;

/**
 * Class Name: CheckSignOutFeatureWorksFine 
 * Description: This test case validates if 'SignOut' feature works properly
 * for registered user in Comcast application.
 * **/
 
public class CheckSignOutFunctionality extends BaseTest{
 
  UserRegistrationUsingComcast userRegDS=new UserRegistrationUsingComcast();
  UserLoginFunctions userLogin=new UserLoginFunctions();
 
  @Test
  public void testSignOutFeatureInCamcast() throws Exception {
	  
	//This method is used to register new user into Comcast Application
	userRegDS.testUserRegistrationUsingComcast(driver);
	
	driver.get(DataServiceProperties.APPURL);
	
	//This method is used to enter user name and password credential
	userLogin.UserLoginCredentials(driver);
	
	driver.findElement(By.id("user_login")).click();
	
	Thread.sleep(sleepTime);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign out[\\s\\S]*$"));
	
    driver.findElement(By.linkText("Sign out")).click();
  }
}
