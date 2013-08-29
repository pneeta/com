package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscriptionOfVideosFromStoreCategory.UnsubscriptionOfChannel;

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
 * Class Name: UnsubscribeASubscribedChannel
 * Description: This test case allows a user to unsubscribe the already subscribed channel  
 * from the 'Store' Page by logging into Comcast application.
 */

public class UnsubscribeASubscribedChannel extends BaseTest{
	
	  DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	  UserLoginFunctions userLogin=new UserLoginFunctions();
	
	  @Test
	  public void testUnsubscribeAChannel() throws Exception {
		  
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StoreFeaturedAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		  
		//This method registers new user and subscribe a free channel For Store Featured
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();

		//This method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
	    driver.findElement(By.linkText("SUBSCRIPTIONS")).click();
	    
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("a.subscribe > span.translation_missing")).click();
	    
	    driver.findElement(By.cssSelector("fieldset > input[type=\"submit\"]")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You have been unsubscribed.[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	  }
}
