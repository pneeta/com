package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscriptionOfVideosFromHomeCategory.SubscriptionOfChannel;

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
 * Class Name: SubscribeAFreeChannelFromHomePopularChannelsCategory
 * Description: This test case allows a user to subscribe a channel for free 
 * from the 'PopularChannels' section of 'Home' Page
 * and also verifies if the user has been subscribed successfully by navigating to 'Subscription' screen
 * by logging into Comcast application.
 */

public class SubscribeAFreeChannelFromHomePopularChannelsCategory extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testSubscribeAFreeChannelFromPopularChannelsCategory() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularChannelDetailsAPIs();
		List<VideoDetails> showList=videoDetails.get("show");
		
		/* This Method is to register new user using Comcast application 
		* and to change a password. 
		*/
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Free[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("a.subscribe > span.translation_missing")).click();
	    
	    driver.findElement(By.cssSelector("fieldset > input[type=\"submit\"]")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You have been subscribed\\.[\\s\\S]*$"));

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Unsubscribe[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Subscriptions")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Unsubscribe[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
