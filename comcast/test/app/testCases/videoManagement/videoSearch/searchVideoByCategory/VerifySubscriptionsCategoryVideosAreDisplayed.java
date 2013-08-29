package comcast.test.app.testCases.videoManagement.videoSearch.searchVideoByCategory;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;

/**
 * Class Name: VerifySubscriptionsCategoryVideosAreDisplayed 
 * Description: This test case is used to verify Subscription category video/videos are displayed
 * for registered Comcast Application user.
 * **/

public class VerifySubscriptionsCategoryVideosAreDisplayed extends BaseTest{
  
  UserLoginFunctions userLogin=new UserLoginFunctions();
  UserRegistrationUsingComcast userReg = new UserRegistrationUsingComcast();
  
  @Test
  public void testVerifySubscriptionCategoryVideosAreDisplayed() throws Exception {
	
	//This method is used to register new user into Comcast Application
	userReg.testUserRegistrationUsingComcast(driver);
	  
	driver.get(DataServiceProperties.APPURL);
    
	//This method is used to enter user name and password credential
	userLogin.UserLoginCredentials(driver);
	
	driver.findElement(By.id("user_login")).click();
    
	//This method is used to Change Password
	userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
	
	//driver.findElement(By.name("commit")).click();
	
	driver.findElement(By.linkText("SUBSCRIPTIONS")).click();

	/*Subscription feature is still not implemented because of that no assertions*/
    driver.findElement(By.linkText("Sign out")).click();
  }
}
