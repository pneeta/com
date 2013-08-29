package comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.LoginFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** 
 * Class Name: LoginToXidioApplicationUsingInValidPassword
 * Description: This test case is used to login to camcast application with an invalid Password
 * for registered user.
 * **/

public class LoginToXidioApplicationUsingInValidPassword extends BaseTest{
 
  LoginFunctions loginFuntion=new LoginFunctions();	
  
  @Test
  public void testLoginToXidioApplicationUsingInValidPassword() throws Exception {
    
	driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
  	//This method is used to enter invalid password with valid UserName  
  	loginFuntion.LoginToXidioApplication(driver,DataServiceProperties._USER_NAME,DataServiceProperties._INVALID_PASSWORD);
    
  	driver.findElement(By.id("user_login")).click();
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Incorrect username or password[\\s\\S]*$"));
  }
}
