package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscribedChannelTestCases.SubscribedChannelTestCases.ChannelPageTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.subscribeFreeFeaturedChannelFromStore.DS_SubscribeAFreeChannelFromStoreFeatured;
import comcast.test.config.dataServices.vo.VideoDetails;

/** 
 * Class Name: VerifyVideoCountForSubscribedChannel
 * Description: This test case is to verify the count of available videos 
 * for a subscribed channel by logging into Comcast application.
 */

public class VerifyVideoCountForSubscribedChannel extends BaseTest{
	
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testVerifyVideoCountForSubscribedChannel() throws Exception {
		
		List<VideoDetails> videoDetailsList=restAPIServices.episodeListUnderChannel();
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		//This Method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
	    driver.findElement(By.linkText("SUBSCRIPTIONS")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetailsList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText(videoDetailsList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoDetailsList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    String Videocount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div[2]/div[1]/ul/li[2]")).getText();
	    assertEquals("Videos "+videoDetailsList.get(0).getNoOfHits()+"",Videocount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
