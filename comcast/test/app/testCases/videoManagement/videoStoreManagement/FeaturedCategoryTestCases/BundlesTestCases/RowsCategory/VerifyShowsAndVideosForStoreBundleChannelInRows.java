package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.BundlesTestCases.RowsCategory;

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
 * Class Name: VerifyShowsAndVideosForStoreBundleChannelInRows
 * Description: This test case is to verify Shows and Video  
 * after sorting by 'ROWS'for a Bundle Channel displayed under 'Featured' 
 * section on 'Store' Rows category screen by logging into Comcast application.
 */

public class VerifyShowsAndVideosForStoreBundleChannelInRows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowsAndVideosInRowsForFeaturedChannel() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.FeaturedBundleAPI();
		List <VideoDetails> BundlesList=videoDetails.get("bundlesList");
		List <VideoDetails> ChannelsListUnderBundleRows=videoDetails.get("showsInBundle");
		List <VideoDetails> ShowsListUnderBundleRows=videoDetails.get("subShowInBundleChannel");
		List <VideoDetails> VideoListUnderBundleRows=videoDetails.get("videosInBundleChannel");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();
		
		Thread.sleep(sleepTime);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
		
    	driver.findElement(By.linkText(BundlesList.get(1).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+BundlesList.get(1).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("ROWS")).click();
	    
	    driver.findElement(By.linkText(ChannelsListUnderBundleRows.get(1).getTitle())).click();

	    //This is to assert Channel Name.
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ChannelsListUnderBundleRows.get(1).getTitle()+"[\\s\\S]*$"));
	    
	    //This is to assert Show Name.
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ShowsListUnderBundleRows.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    //This is to assert Video Name.
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+VideoListUnderBundleRows.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
