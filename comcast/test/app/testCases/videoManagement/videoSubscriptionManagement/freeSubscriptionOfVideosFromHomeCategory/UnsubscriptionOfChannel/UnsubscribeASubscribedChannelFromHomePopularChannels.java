package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscriptionOfVideosFromHomeCategory.UnsubscriptionOfChannel;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.subscribeFreePopularChannelFromHome.DS_SubscribeAFreeChannelFromHomePopularChannels;
import comcast.test.config.dataServices.vo.VideoDetails;
/** 
 * Class Name: UnsubscribeASubscribedChannelFromHomePopularChannels
 * Description: This test case allows a user to unsubscribe the already subscribed channel  
 * from the 'PopularChannels' section of 'Home' Page by logging into Comcast application.
 */
public class UnsubscribeASubscribedChannelFromHomePopularChannels extends BaseTest{
	
	DS_SubscribeAFreeChannelFromHomePopularChannels subHomePopularChannels=new DS_SubscribeAFreeChannelFromHomePopularChannels();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	  public void testUnsubscribeAChannelFromHomePopularChannel() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularChannelDetailsAPIs();
		List<VideoDetails> showList=videoDetails.get("show");
		
		//This method registers new user and subscribe a free channel For Home Featured
		subHomePopularChannels.RegisterAndSubscribeAFreeChannelFromHomePopularChannels();
		
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
