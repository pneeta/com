package comcast.test.app.testCases.videoManagement.videoHomeManagement.FeaturedCategoryTestCases.ShowTestCases;

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
 * Class Name: VerifyVideoCountForHomeFeaturedShows
 * Description: This test case is to verify the count of videos available
 * for a Show displayed under 'Featured' section on 'Home' screen
 * by logging into Comcast application.
 */

public class VerifyVideoCountForHomeFeaturedShows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyVideoCountForHomeFeaturedShows() throws Exception {
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.videoCountUnderShows();
		List <VideoDetails> subShowList=videoDetails.get("subshow");

		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(subShowList.get(0).getTitle())).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Videos "+subShowList.get(0).getNoOfHits()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
