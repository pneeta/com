package comcast.test.app.testCases.videoManagement.videoPlay.StoreCategoryVideos.PopularVideos;

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
 * Class Name: PlayPopularVideoSelectingFromVideos
 * Description: This test case is to play the video by clicking a channel followed by 'VIDEOS' link
 * displayed under channel page from 'Popular' section on 'Store' screen
 * by logging into Comcast application.
 */

public class PlayPopularVideoSelectingFromVideos extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testPlayPopularVideoSelectingFromVideos() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StorePopularAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> videoList=videoDetails.get("video");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));
	    
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("VIDEOS")).click();
	    
	    Thread.sleep(sleepTime);
	    /*Below line will take videoTitile by xpath.*/
	    //driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/ul/li[1]/article/h1/a")).click();
	    
	    driver.findElement(By.linkText(videoList.get(0).getTitle())).click();
	    
	    Thread.sleep(sleepTimeForVideoPlay);
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
