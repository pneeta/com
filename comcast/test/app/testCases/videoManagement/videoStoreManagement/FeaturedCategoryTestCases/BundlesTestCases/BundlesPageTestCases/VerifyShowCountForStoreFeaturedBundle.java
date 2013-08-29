package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.BundlesTestCases.BundlesPageTestCases;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;
import comcast.test.config.dataServices.vo.VideoDetails;

/** 
 * Class Name: VerifyShowCountForStoreFeaturedBundle
 * Description: This test case is to verify the count of shows available
 * for a Bundle displayed under 'Featured' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyShowCountForStoreFeaturedBundle extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowCountForStoreFeaturedBundle() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.FeaturedBundleAPI();
		List <VideoDetails> bundlesList=videoDetails.get("bundlesList");
		
		String showCount=restAPIServices.ShowsCountFeaturedBundle();
			System.out.println("Show Count>>"+showCount);
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
    	driver.findElement(By.linkText(bundlesList.get(0).getTitle())).click();
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+bundlesList.get(0).getTitle()+"[\\s\\S]*$"));
	
	    String Showcount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div[2]/div[1]/ul/li[2]")).getText();
	    assertEquals("Shows "+showCount+"",Showcount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
