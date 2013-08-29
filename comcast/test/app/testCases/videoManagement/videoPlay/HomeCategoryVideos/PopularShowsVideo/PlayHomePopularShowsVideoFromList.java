package comcast.test.app.testCases.videoManagement.videoPlay.HomeCategoryVideos.PopularShowsVideo;

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
 * Class Name: PlayHomePopularShowsVideoFromList 
 * Description: This test case is to play the video by selecting the shows present 
 * under 'Popular Shows' section in Home page.
 * **/

public class PlayHomePopularShowsVideoFromList extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testPlayHomePopularShowsVideoFromList() throws Exception {
		
	  	Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularShowsAPIs();
	  	List<VideoDetails> popularShowList=videoDetails.get("popularShows");
	  	List<VideoDetails> popularVideoList=videoDetails.get("popularvideo");
	  	
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("HOME")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
    	driver.findElement(By.linkText(popularShowList.get(0).getTitle())).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));

	    //Below commented line plays the video using xpath.
	    //driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/ul/li[1]/article/h1/a")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(popularVideoList.get(0).getTitle())).click();
	    
	    Thread.sleep(sleepTimeForVideoPlay);
	    driver.findElement(By.linkText("Sign out")).click();
	    
	}
}
