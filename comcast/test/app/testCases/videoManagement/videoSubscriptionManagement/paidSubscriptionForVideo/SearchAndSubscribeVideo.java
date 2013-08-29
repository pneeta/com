package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.paidSubscriptionForVideo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;

/**  
 * Class Name: SearchAndSubscribeVideo
 * Description: This test case validates video search functionality and video subscribing 
 * selected video by logging registered user into Comcast application.
 * **/

public class SearchAndSubscribeVideo extends BaseTest
{
	  UserLoginFunctions userLogin=new UserLoginFunctions();
	  UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	
	  @Test
	  public void testSearchAndSubscribeVideo() throws Exception 
	  {
		
		//This method is used to register new user into Comcast Application
		userReg.testUserRegistrationUsingComcast(driver);
		
		driver.get(DataServiceProperties.APPURL);
		
		Thread.sleep(sleepTime);
		//This method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
	    
		//This method is used to Change Password
	    userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
	    
	    //driver.findElement(By.name("commit")).click();
	    
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    assertEquals("", driver.findElement(By.xpath("//img[@alt='Comcast Labs, XIDIO']")).getText());
	    
	    driver.findElement(By.id("search-query")).clear();
	    driver.findElement(By.id("search-query")).sendKeys(DataServiceProperties._SEARCH_VIDEO_BY);
	    
	    driver.findElement(By.id("go-search")).click();

	    driver.findElement(By.cssSelector("img[alt=\"African Cats\"]")).click();
	    
	    driver.findElement(By.linkText("Subscribe")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.name("pin_code")).clear();
	    driver.findElement(By.name("pin_code")).sendKeys(DataServiceProperties._CC_PIN_CODE);
	    
	    driver.findElement(By.cssSelector("fieldset > input[type=\"submit\"]")).click();

	    driver.findElement(By.linkText("Sign out")).click();
	  }
}
