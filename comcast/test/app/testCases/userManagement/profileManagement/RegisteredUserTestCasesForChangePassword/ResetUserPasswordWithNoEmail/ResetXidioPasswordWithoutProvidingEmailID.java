package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePassword.ResetUserPasswordWithNoEmail;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/**  
 * Class Name: ResetXidioPasswordWithoutProvidingEmailID
 * Description: This test case allows the registered user to reset the password without providing Email ID by
 * logging registered user into Comcast application.
 * **/

public class ResetXidioPasswordWithoutProvidingEmailID extends BaseTest{
 
  @Test
  public void testResetXidioPasswordWithoutProvidingEmailID() throws Exception {
	  
    driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Reset password")).click();
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Enter your email[\\s\\S]*$"));
    
    driver.findElement(By.id("user_login")).click();
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Email is wrong[\\s\\S]*$"));
    
  }
}
