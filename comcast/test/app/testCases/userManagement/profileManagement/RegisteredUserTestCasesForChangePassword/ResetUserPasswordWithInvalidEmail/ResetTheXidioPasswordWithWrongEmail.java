package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePassword.ResetUserPasswordWithInvalidEmail;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/**  
 * Class Name: ResetTheXidioPasswordWithWrongEmail
 * Description: This test case allows the registered user to reset the password with wrong Email by
 * logging registered user into Comcast application.
 * **/

public class ResetTheXidioPasswordWithWrongEmail extends BaseTest{
  
	@Test
  public void testResetTheXidioPasswordWithWrongEmail() throws Exception {
		
    driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Reset password")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Enter your email[\\s\\S]*$"));
    
    //driver.findElement(By.cssSelector("#uniform-user_login > span")).click();
    
    driver.findElement(By.id("user_login")).click();
    
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(DataServiceProperties._INVALID_EMAIL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Email is wrong[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Enter your email[\\s\\S]*$"));
 
  }
}
