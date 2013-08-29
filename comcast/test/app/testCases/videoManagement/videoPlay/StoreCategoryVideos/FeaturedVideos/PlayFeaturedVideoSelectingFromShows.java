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
 * Class Name: PlayFeaturedVideoSelectingFromShows
 * Description: This test case is to play the video by clicking a channel followed by 'SHOWS' link
 * displayed under channel page from 'Featured' section on 'Store' screen
 * by logging into Comcast application.
 */

public class PlayFeaturedVideoSelectingFromShows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testPlayVideoSelectingFromShows() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StoreFeaturedAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> subShowList=videoDetails.get("subshow");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

	   	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("SHOWS")).click();
	    
	    Thread.sleep(sleepTime);
	   	driver.findElement(By.linkText(subShowList.get(1).getTitle())).click();
	    
	    Thread.sleep(sleepTime);
	    String VideoTitle=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/ul/li[1]/article/h1/a")).getText();
	    driver.findElement(By.linkText(VideoTitle)).click();

	    Thread.sleep(sleepTimeForVideoPlay);
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
