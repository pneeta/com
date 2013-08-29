package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.BundlesTestCases.BundlesPageTestCases;

import static org.junit.Assert.assertEquals;
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
 * Class Name: VerifyVideoCountForStoreFeaturedBundle
 * Description: This test case is to verify the count of videos available
 * for a Bundle displayed under 'Featured' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyVideoCountForStoreFeaturedBundle extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyVideoCountForAFeaturedBundle() throws Exception {
		
		Map<String,List<VideoDetails>> videoDetails=restAPIServices.episodeListUnderBundle();
		List <VideoDetails> bundlesList=videoDetails.get("bundlesList");
		List <VideoDetails> episodeListbundle=videoDetails.get("episodeCountInBundle");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();
		
		Thread.sleep(sleepTime);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+bundlesList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText(bundlesList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+bundlesList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    String Videocount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div[2]/div[1]/ul/li[3]")).getText();
	    assertEquals("Videos "+episodeListbundle.get(0).getNoOfHits()+"",Videocount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}

}
