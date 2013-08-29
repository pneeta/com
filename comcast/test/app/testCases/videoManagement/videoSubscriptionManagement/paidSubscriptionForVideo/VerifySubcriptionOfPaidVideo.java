package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.paidSubscriptionForVideo;

import org.junit.*;
import org.openqa.selenium.*;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;

/**  
 * Class Name : VerifySubcriptionOfPaidVideo
 * Function : This test case validates subscription of video feature for the 
 * paid video by logging registered user into Comcast application.
 * **/

public class VerifySubcriptionOfPaidVideo extends BaseTest
{
  UserLoginFunctions userLogin=new UserLoginFunctions();
  UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
  
  @Test
  public void testVerifySubcriptionOfPaidVideo() throws Exception 
  {
	//This method is used to register new user into Comcast Application
	userReg.testUserRegistrationUsingComcast(driver);
	
	Thread.sleep(sleepTime);
	driver.get(DataServiceProperties.APPURL);
	
	//This method is used to enter user name and password credential
	userLogin.UserLoginCredentials(driver);
	
	driver.findElement(By.id("user_login")).click();
	
	Thread.sleep(sleepTime);
	//This method is used to Change Password
	userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
	
	//driver.findElement(By.name("commit")).click();
    
	Thread.sleep(sleepTime);
    driver.findElement(By.id("search-query")).clear();
    driver.findElement(By.id("search-query")).sendKeys(DataServiceProperties._SEARCH_VIDEO_BY);
    
    driver.findElement(By.id("go-search")).click();
    
    Thread.sleep(sleepTime);
    assertEqual("Results for 'Norcal Publishing'",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/h2")).getText());
	
	String SearchResult="Results for 'Norcal Publishing'";
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*'"+SearchResult+"'[\\s\\S]*$")); 
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Results for 'Norcal Publishing'[\\s\\S]*$"));
    
    try 
    {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Norcal Publishing[\\s\\S]*$"));
    } 
    catch (Error e) 
    {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("img[alt=\"African Cats\"]")).click();
    
    driver.findElement(By.linkText("Subscribe")).click();
    
    driver.findElement(By.name("pin_code")).clear();
    driver.findElement(By.name("pin_code")).sendKeys("1234");
    
    driver.findElement(By.cssSelector("fieldset > input[type=\"submit\"]")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You have been subscribed\\.[\\s\\S]*$"));

    try 
    {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*It's all in the family[\\s\\S]*$"));
    } 
    catch (Error e) 
    {
      verificationErrors.append(e.toString());
    }

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Unsubscribe[\\s\\S]*$"));
    driver.findElement(By.linkText("My Channels")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\r\nIt's all in the family [\\s\\S]*$"));
    driver.findElement(By.linkText("Sign out")).click();
  }
  private void assertEqual(String string, String text) 
  {

  }

  private void assertTrue(boolean matches) 
  {
	
  }
}

