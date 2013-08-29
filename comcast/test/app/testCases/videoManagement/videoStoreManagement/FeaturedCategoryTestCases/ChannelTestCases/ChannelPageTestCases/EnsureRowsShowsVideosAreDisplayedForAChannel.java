package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.ChannelTestCases.ChannelPageTestCases;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;
import comcast.test.config.dataServices.vo.VideoDetails;

/** 
 * Class Name: EnsureRowsShowsVideosAreDisplayedForAChannel
 * Description: This test case is to verify and ensure if 'Rows','Shows' and 'Videos'
 * links are present for a channel displayed under 'Featured' section on 'Store' screen
 * by logging into Comcast application with registered user.
 */

public class EnsureRowsShowsVideosAreDisplayedForAChannel extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
		
	@Test
	public void testEnsureRowsShowsVideosAreDisplayedForAChannel() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StoreFeaturedAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText(showList.get(0).getTitle())).click();
	
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*ROWS[\\s\\S]*$"));
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*SHOWS[\\s\\S]*$"));
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*VIDEOS[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("Sign out")).click();
  }
}
