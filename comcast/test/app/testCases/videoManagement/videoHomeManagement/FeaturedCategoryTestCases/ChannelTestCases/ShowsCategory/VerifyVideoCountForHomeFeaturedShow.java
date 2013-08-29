package comcast.test.app.testCases.videoManagement.videoHomeManagement.FeaturedCategoryTestCases.ChannelTestCases.ShowsCategory;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;
import comcast.test.config.dataServices.vo.VideoDetails;

/** 
 * Class Name: VerifyVideoCountForHomeFeaturedShow
 * Description: This test case validates whether 'Videos' count is displayed in show page for the show
 * present in a channel under Featured section in Home page by logging registered user into Comcast application.
 * **/

public class VerifyVideoCountForHomeFeaturedShow extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyVideoCountForHomeFeaturedShows() throws Exception {
		
		List<VideoDetails> videoDetailsList=restAPIServices.featuredEpisodeListUnderShows();
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetailsList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText(videoDetailsList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetailsList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText(videoDetailsList.get(1).getTitle())).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetailsList.get(1).getTitle()+"[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Videos "+videoDetailsList.get(0).getNoOfHits()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	    
	  }
}
