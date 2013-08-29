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
 * Class Name: VerifyUpdatedStatusForStoreFeaturedBundle
 * Description: This test case is to verify the shown last updated status/day
 * for a Bundle displayed under 'Featured' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyUpdatedStatusForStoreFeaturedBundle extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyUpdatedDayForStoreFeaturedBundle() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.FeaturedBundleAPI();
		List <VideoDetails> bundlesList=videoDetails.get("bundlesList");

		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+bundlesList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText(bundlesList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+bundlesList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    /*Have to Rest Service Call to get Updated value*/
	    String lastUpdated=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div[2]/div[1]/ul/li[4]")).getText();
	    assertEquals("Updated -",lastUpdated);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
