package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscribedChannelTestCases.SubscriptionsPageTestCases.ShowsCategory;

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
 * Description: This test case is to verify the available options of shows
 * after sorting by 'SHOWS'category for a subscribed channel displayed on subscriptions screen
 * by logging into Comcast application.
 */

public class VerifyShowsForSubscribedChannelInSubscriptions extends BaseTest{
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testVerifyShowsForSubscribedChannelInSubscriptions() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.subscriptionChannelAPIs();
		List<VideoDetails> subscribedShowList=videoDetails.get("subscribedShows");
		List<VideoDetails> subscribedSubShowListUnderChannel=videoDetails.get("subscribedShowsUnderChannel");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		//This Method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
		Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("SUBSCRIPTIONS")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);	    
	    driver.findElement(By.linkText("SHOWS")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedSubShowListUnderChannel.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
