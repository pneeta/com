package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscribedChannelTestCases.SubscriptionsPageTestCases.SubscriptionsDetailPage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.subscribeFreeFeaturedChannelFromStore.DS_SubscribeAFreeChannelFromStoreFeatured;

/** 
 * Class Name: EnsureRowsChannelsAndShowsAreDisplayedInSubscriptions
 * Description: This test case is to verify and ensure if 'ROWS','CHANNELS' and 'SHOWS'
 * links are displayed on subscriptions screen
 * by logging into Comcast application.
 */

public class EnsureRowsChannelsAndShowsAreDisplayedInSubscriptions extends BaseTest{
	
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testEnsureRowsChannelsAndShowsAreDisplayed() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		//This Method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
	    driver.findElement(By.linkText("SUBSCRIPTIONS")).click();
	    
	    Thread.sleep(sleepTime); 
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*ROWS[\\s\\S]*$"));
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*CHANNELS[\\s\\S]*$"));
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*SHOWS[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
