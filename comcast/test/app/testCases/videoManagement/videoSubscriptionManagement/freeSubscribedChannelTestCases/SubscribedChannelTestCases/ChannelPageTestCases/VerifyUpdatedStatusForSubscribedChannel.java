package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscribedChannelTestCases.SubscribedChannelTestCases.ChannelPageTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.subscribeFreeFeaturedChannelFromStore.DS_SubscribeAFreeChannelFromStoreFeatured;

/** 
 * Class Name: VerifyUpdatedStatusForSubscribedChannel
 * Description: This test case is to verify the shown last updated status/day
 * for a subscribed channel by logging into Comcast application.
 */

public class VerifyUpdatedStatusForSubscribedChannel extends BaseTest{
	
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testVerifyUpdatedDayForSubscribedChannel() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		//This Method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
	    driver.findElement(By.linkText("Subscriptions")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Trailer Mania[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Trailer Mania")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Trailer Mania[\\s\\S]*$"));
	    
	    /*Have to Rest Service Call*/
	    String Videocount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div[2]/div[1]/ul/li[3]")).getText();
	    assertEquals("Updated 2weeks ago",Videocount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
