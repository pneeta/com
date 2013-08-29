package comcast.test.app.testCases.videoManagement.videoPlay.HomeCategoryVideos.FeaturedVideos;

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
 * Class Name: PlayHomeFeaturedVideoSelectingFromShows 
 * Description: This test case is to play the video from Shows category by 
 * selecting the videos in the channel page for featured section in Home page.
 * **/

public class PlayHomeFeaturedVideoSelectingFromShows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testPlayHomeFeaturedVideoSelectingFromShows() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.HomeFeaturedAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> videoList=videoDetails.get("video");
		List <VideoDetails> subShowListUnderChannel=videoDetails.get("showsUnderChannel");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
	   
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("SHOWS")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(subShowListUnderChannel.get(0).getTitle())).click();
	    
	    //Below commented line is to play video using xpath.
	    /*String VideoTitle=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/ul/li[1]/article/h1/a")).getText();
	    driver.findElement(By.linkText(VideoTitle)).click();*/
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(videoList.get(0).getTitle())).click();
	    
	    Thread.sleep(sleepTimeForVideoPlay);
	    driver.findElement(By.linkText("Sign out")).click();
	    
	}
}
