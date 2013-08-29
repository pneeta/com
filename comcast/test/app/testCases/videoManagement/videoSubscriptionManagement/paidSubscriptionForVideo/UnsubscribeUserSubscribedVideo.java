package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.paidSubscriptionForVideo;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.subscribePaidVideo.DS_SearchAndSubscribePaidVideo;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;

/**  
 * Class Name: UnsubscribeUserSubscribedVideo
 * Function: This test case validates un-subscription of video feature for the 
 * subscribed video by logging registered user into Comcast application.
 * **/

public class UnsubscribeUserSubscribedVideo extends BaseTest
{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	DS_SearchAndSubscribePaidVideo dsSubscribe=new DS_SearchAndSubscribePaidVideo();
	
	@Test
	public void testUnsubscribeUserSubscribedVideo() throws Exception 
	{

		driver.get(DataServiceProperties.APPURL);
		
		Thread.sleep(sleepTime);
		//This method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
		driver.findElement(By.linkText("My Channels")).click();
	    
	    driver.findElement(By.id("search-query")).clear();
	    driver.findElement(By.id("search-query")).sendKeys(DataServiceProperties._SEARCH_VIDEO_BY);
	    
	    driver.findElement(By.id("go-search")).click();
	    
	    driver.findElement(By.cssSelector("img[alt=\"African Cats\"]")).click();
	    
	    driver.findElement(By.linkText("Unsubscribe")).click();
	    
	    driver.findElement(By.cssSelector("fieldset.unsubscribed > input[type=\"submit\"]")).click();
	
	    driver.findElement(By.linkText("Sign out")).click();
	}
}

