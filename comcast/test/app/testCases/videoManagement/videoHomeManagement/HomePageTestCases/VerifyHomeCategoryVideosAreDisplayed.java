package comcast.test.app.testCases.videoManagement.videoHomeManagement.HomePageTestCases;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;
import comcast.test.config.dataServices.vo.VideoDetails;

/**
 * Class Name: VerifyHomeCategoryVideosAreDisplayed 
 * Description: This test case is used to verify Home category video/videos are displayed
 * for registered Comcast Application user.
 * **/

public class VerifyHomeCategoryVideosAreDisplayed extends BaseTest{
  
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
  
  @Test
  public void testVerifyStoreCategoryVideosAreDisplayed() throws Exception {
	
	List<VideoDetails> videoDetails=restAPIServices.homePageAPIs();
	  
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Up Next[\\s\\S]*$"));
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetails.get(0).getTitle()+"[\\s\\S]*$"));

    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetails.get(0).getTitle()+"[\\s\\S]*$"));
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetails.get(1).getTitle()+"[\\s\\S]*$"));
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Channels[\\s\\S]*$"));
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetails.get(2).getTitle()+"[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }

	private void assertTrue(boolean matches) {
		
	}
}
