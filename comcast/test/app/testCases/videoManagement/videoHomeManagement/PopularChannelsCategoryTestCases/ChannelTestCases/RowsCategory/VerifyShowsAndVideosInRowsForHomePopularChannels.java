package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularChannelsCategoryTestCases.ChannelTestCases.RowsCategory;

import static org.junit.Assert.assertEquals;
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
 * Class Name: VerifyShowsAndVideosInRowsForHomePopularChannels
 * Description: This test case validates whether Shows and Videos are displayed after clicking on Rows link in channel page for the channel
 * present under Popular Channels section in Home page by logging registered user into Comcast application.
 * **/

public class VerifyShowsAndVideosInRowsForHomePopularChannels extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowsAndVideosInRowsForHomePopularChannels() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularChannelAPIs();
		List<VideoDetails> showList=videoDetails.get("show");
		List<VideoDetails> subShowListUnderChannel=videoDetails.get("showsUnderChannel");
		List<VideoDetails> videoList=videoDetails.get("video");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Channels[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("ROWS")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowListUnderChannel.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    String VideoTitle=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div[1]/section/div/div/ul[1]/li[1]/article/h1/a")).getText();
	    assertEquals(videoList.get(0).getTitle(),VideoTitle);
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	    
	}
}
