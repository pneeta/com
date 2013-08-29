package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularChannelsCategoryTestCases.ChannelTestCases.ChannelPageTestCases;

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
 * Class Name: EnsureRowsShowsVideosAreDisplayedForPopularChannels
 * Description: This test case validates whether Rows,Shows and Videos link are displayed in channel page for the channel
 * present under Popular Channels section in Home pageby logging registered user into Comcast application.
 * **/

public class EnsureRowsShowsVideosAreDisplayedForPopularChannels extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testEnsureRowsShowsVideosAreDisplayedForPopularChannels() throws Exception {
		
	Map<String,List<VideoDetails>> videoDetails=restAPIServices.HomePopularChannelDetailsAPIs();
	List<VideoDetails> showList=videoDetails.get("show");
	
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Channels[\\s\\S]*$"));

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
