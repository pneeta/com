package comcast.test.app.testCases.videoManagement.videoPlay.StoreCategoryVideos.FeaturedVideos;

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
 * Class Name: PlayFeaturedVideoFromRows
 * Description: This test case is to play the video by clicking a channel followed by 'ROWS' link
 * displayed under channel page from 'Featured' section on 'Store' screen
 * by logging into Comcast application.
 */

public class PlayFeaturedVideoFromRows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testPlayFeaturedVideoFromRows() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StoreFeaturedAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> videoList=videoDetails.get("video");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();
	    
	    driver.findElement(By.linkText("ROWS")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(videoList.get(0).getTitle())).click();
	    
	    //Below commented lines plays the video using xpath.
	    /*String VideoId=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div[1]/section/div/div/ul[1]/li[1]/article/h1/a")).getText();
	    driver.findElement(By.linkText(VideoId)).click();*/
	    
	    Thread.sleep(sleepTimeForVideoPlay);	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
