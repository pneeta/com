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
 * Class Name: PlayHomeFeaturedVideoFromRows 
 * Description: This test case is to play the video from Rows category by directly 
 * selecting the videos in the channel page for featured section in Home page.
 * **/

public class PlayHomeFeaturedVideoFromRows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testPlayHomeFeaturedVideoFromRows() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.HomeFeaturedAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> videoList=videoDetails.get("video");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(showList.get(0).getTitle())).click();
	    
	    driver.findElement(By.linkText("ROWS")).click();
	    
	    //Below commented lines are used to play video using xpath.
	    /*String VideoId=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div[1]/section/div/div/ul[1]/li[1]/article/h1/a")).getText();
	    driver.findElement(By.linkText(VideoId)).click();*/
	    
	    Thread.sleep(sleepTime); 
	    driver.findElement(By.linkText(videoList.get(0).getTitle())).click();
	    
	    Thread.sleep(sleepTimeForVideoPlay);
	    driver.findElement(By.linkText("Sign out")).click();
	    
	 }
}
