package comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingValidCredentials;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** 
 * Class Name: LoginToXidioApplicationWithValidCredentials
 * Description: This test case is used to login to camcast application with valid UserName and Password
 * for registered user.
 * **/

public class LoginToXidioApplicationWithValidCredentials extends BaseTest{
 
  @Test
  public void testLoginToCamcast() throws Exception {
	  
	driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Username[\\s\\S]*$"));
    
    driver.findElement(By.name("user[user_name]")).clear();
    driver.findElement(By.name("user[user_name]")).sendKeys(DataServiceProperties._USER_NAME);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Password[\\s\\S]*$"));
    
    driver.findElement(By.name("user[password]")).clear();
    driver.findElement(By.name("user[password]")).sendKeys(DataServiceProperties._PASSWORD);
    
    driver.findElement(By.id("user_login")).click();

    Thread.sleep(sleepTime);
   String signOut=driver.findElement(By.xpath(".//*[@id='top_menu']/ul/li[3]/a")).getText();
   assertEquals("Sign out",signOut);
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
