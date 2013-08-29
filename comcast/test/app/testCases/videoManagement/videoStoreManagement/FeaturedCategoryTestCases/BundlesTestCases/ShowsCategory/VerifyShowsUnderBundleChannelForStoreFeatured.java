package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.BundlesTestCases.ShowsCategory;

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
 * Class Name: VerifyShowsUnderChannelForFeatured
 * Description: This test case is to verify the available options of shows
 * after sorting by 'SHOWS'and by clicking 'Next' and 'Previous' button
 * for a channel displayed under 'Featured' section on 'Store' screen 
 * by logging into Comcast application.
 */

public class VerifyShowsUnderBundleChannelForStoreFeatured extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowsUnderChannelForFeatured() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.FeaturedBundleAPI();
		List <VideoDetails> BundlesList=videoDetails.get("bundlesList");
		List <VideoDetails> ChannelsListUnderBundleRows=videoDetails.get("showsInBundle");
		List <VideoDetails> ShowsListUnderBundleSHOWS=videoDetails.get("subShowInBundleChannel");
		List <VideoDetails> VideoListUnderBundleSHOWS=videoDetails.get("videosInBundleChannel");
				
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

	   	driver.findElement(By.linkText(BundlesList.get(1).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+BundlesList.get(1).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("SHOWS")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ShowsListUnderBundleSHOWS.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
