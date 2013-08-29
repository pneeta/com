package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscribedChannelTestCases.SubscriptionsPageTestCases.RowsCategory;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.subscribeFreeFeaturedChannelFromStore.DS_SubscribeAFreeChannelFromStoreFeatured;
import comcast.test.config.dataServices.vo.VideoDetails;

/** 
 * Class Name: VerifyRowsVideosForSubscribedChannelInSubscriptions
 * Description: This test case is to verify the available options of videos
 * after sorting by 'ROWS'category for a subscribed channel displayed on subscriptions screen
 * by logging into Comcast application.
 */

public class VerifyRowsVideosForSubscribedChannelInSubscriptions extends BaseTest{
	
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testVerifyRowsVideosForSubscribedChannelInSubscriptions() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.subscriptionChannelAPIs();
		List<VideoDetails> subscribedShowList=videoDetails.get("subscribedShows");
		List<VideoDetails> subscribedVideoList=videoDetails.get("subscribedVideo");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		//This Method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
		Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("SUBSCRIPTIONS")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("ROWS")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedVideoList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/a[2]/span")).click();
	   
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/a[1]/span")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedVideoList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
