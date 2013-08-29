package comcast.test.app.testCases.videoManagement.videoSearch.searchVideoByCategory;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;

/**
 * Class Name: EnsureSearchChannelStoreIsWorkingFine 
 * Description: This test case validates whether search channel store is 
 * working fine for the selected video by logging registered user into Comcast
 * application.
 * **/
public class EnsureSearchChannelStoreIsWorkingFine extends BaseTest
{
	
  UserLoginFunctions userLogin=new UserLoginFunctions();
  UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
 
  @Test
  public void testEnsureSearchChannelStoreIsWorkingFine() throws Exception 
  {
	
	//This method is used to register new user into Comcast Application
	userReg.testUserRegistrationUsingComcast(driver);
	  
	driver.get(DataServiceProperties.APPURL);
	  
	//This method is used to enter user name and password credential
	userLogin.UserLoginCredentials(driver);
	
	driver.findElement(By.id("user_login")).click();
	    
	//This method is used to Change Password
    userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
    
    //driver.findElement(By.name("commit")).click();
    
    Thread.sleep(sleepTime);
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.id("search-query")).clear();
    driver.findElement(By.id("search-query")).sendKeys("Avatar");
    
    driver.findElement(By.id("go-search")).click();
    
    Thread.sleep(sleepTime);
    try 
    {
    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Results for 'Avatar'[\\s\\S]*$"));
    } 
    catch (Error e) 
    {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Sign out")).click();
  }
}

