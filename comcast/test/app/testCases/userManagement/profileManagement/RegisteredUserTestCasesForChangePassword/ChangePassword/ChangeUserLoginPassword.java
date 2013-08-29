package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePassword.ChangePassword;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;

/**  
 * Class Name: ChangeUserLoginPassword
 * Description: This test case validates changing user login password feature
 * by logging registered user into Comcast application.
 * **/

public class ChangeUserLoginPassword extends BaseTest{
	
  UserLoginFunctions userLogin=new UserLoginFunctions();
  UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
  
  @Test
  public void testLoginToCamcast() throws Exception {

  TestDataGenerator proUtil = new TestDataGenerator();
  proUtil.load(new FileInputStream(new File("com/data.properties")));
	
  //This method is used to register new user into Comcast Application
  userReg.testUserRegistrationUsingComcast(driver);

  assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Username[\\s\\S]*$"));
  
  Thread.sleep(sleepTime);
  assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Password[\\s\\S]*$"));
    
  //This method is used to enter user name and password credential
  userLogin.UserLoginCredentials(driver);
  
  driver.findElement(By.id("user_login")).click();
    
  driver.findElement(By.cssSelector("span.translation_missing")).click();
   
  driver.findElement(By.linkText("Change password")).click();
  
  //This method is used to Change Password
  //userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
  
  driver.findElement(By.name("old_password")).clear();
  driver.findElement(By.name("old_password")).sendKeys(DataServiceProperties._PASSWORD);
  
  driver.findElement(By.id("password")).clear();
  driver.findElement(By.id("password")).sendKeys(DataServiceProperties._RESET_PASSWORD);
  
  driver.findElement(By.name("confirm_password")).clear();
  driver.findElement(By.name("confirm_password")).sendKeys(DataServiceProperties._CONFIRM_PASSWORD);
  
  driver.findElement(By.name("commit")).click();
  
  TestDataGenerator.updateResetPasswordDataPropertiesFields();
  
  driver.findElement(By.linkText("Sign out")).click();
  
  driver.findElement(By.name("user[user_name]")).clear();
  driver.findElement(By.name("user[user_name]")).sendKeys(proUtil.getProperty("USER_NAME"));
  
  driver.findElement(By.name("user[password]")).clear();
  driver.findElement(By.name("user[password]")).sendKeys(proUtil.getProperty("PASSWORD"));
  
  driver.findElement(By.id("user_login")).click();
    
  assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
  
  driver.findElement(By.linkText("Sign out")).click();
  }
}


