package comcast.test.app.testCases.videoManagement.videoPlay.SubscriptionsCategoryVideos.SubscriptionsPageVideoTestCases;

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
 * Class Name: PlaySubscribedChannelVideoBySelectingShowsInSubscriptionsPage
 * Description: This test case is to play the video by clicking on 'Shows' link for a subscribed channel
 * displayed in 'Subscriptions' screen by logging into Comcast application with registered user.
 */

public class PlaySubscribedChannelVideoBySelectingShowsInSubscriptionsPage extends BaseTest{
	
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testPlaySubscribedChannelVideoBySelectingShowsInSubscriptionsPage() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.subscriptionChannelAPIs();
		List<VideoDetails> subscribedShowList=videoDetails.get("subscribedShows");
		List<VideoDetails> subscribedSubShowListUnderChannel=videoDetails.get("subscribedShowsUnderChannel");
		List<VideoDetails> subscribedVideoList=videoDetails.get("subscribedVideo");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
		driver.findElement(By.linkText("SUBSCRIPTIONS")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("SHOWS")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedSubShowListUnderChannel.get(0).getTitle()+"[\\s\\S]*$"));
	    
    	driver.findElement(By.linkText(subscribedSubShowListUnderChannel.get(0).getTitle())).click();
	    
	    /*Below commented line will click on video by taking videoTitile by xpath.*/
	    //driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/ul/li[1]/article/h1/a")).click();
    	
    	Thread.sleep(sleepTime);
    	driver.findElement(By.linkText(subscribedVideoList.get(0).getTitle())).click();
	    
	    Thread.sleep(sleepTimeForVideoPlay);
	    driver.findElement(By.linkText("Sign out")).click();
	    
	  }
}
