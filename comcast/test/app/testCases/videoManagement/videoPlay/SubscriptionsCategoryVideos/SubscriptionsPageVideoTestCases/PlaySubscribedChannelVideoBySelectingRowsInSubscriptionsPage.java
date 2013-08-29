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
 * Class Name: PlaySubscribedChannelVideoBySelectingRowsInSubscriptionsPage
 * Description: This test case is to play the video by clicking on 'Rows' link for a subscribed channel
 * displayed in 'Subscriptions' screen by logging into Comcast application with registered user.
 */

public class PlaySubscribedChannelVideoBySelectingRowsInSubscriptionsPage extends BaseTest{
	
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testPlaySubscribedChannelVideoBySelectingRowsInSubscriptionsPage() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.subscriptionChannelAPIs();
		List<VideoDetails> subscribedShowList=videoDetails.get("subscribedShows");
		List<VideoDetails> subscribedVideoList=videoDetails.get("subscribedVideo");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
		driver.findElement(By.linkText("SUBSCRIPTIONS")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subscribedShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("ROWS")).click();
	    
	    /*Below commented line will click on video by taking videoTitile by xpath.*/
	    //String VideoId=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/div/div/ul[1]/li[1]/article/h1/a")).getText();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(subscribedVideoList.get(0).getTitle())).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("Sign out")).click();
	    
	  }
}
