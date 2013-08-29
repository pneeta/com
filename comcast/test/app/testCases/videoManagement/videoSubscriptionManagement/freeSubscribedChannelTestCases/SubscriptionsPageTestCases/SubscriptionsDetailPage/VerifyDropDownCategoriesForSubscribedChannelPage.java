package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscribedChannelTestCases.SubscriptionsPageTestCases.SubscriptionsDetailPage;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.subscribeFreeFeaturedChannelFromStore.DS_SubscribeAFreeChannelFromStoreFeatured;

/** 
 * Class Name: VerifyDropDownCategoriesForSubscribedChannelPage
 * Description: This test case is to verify the dropdowns category 
 * for a subscribed channel from subscriptions screen
 * by logging into Comcast application.
 */

public class VerifyDropDownCategoriesForSubscribedChannelPage extends BaseTest{
	
	DS_SubscribeAFreeChannelFromStoreFeatured subscribeFreeStoreChannel=new DS_SubscribeAFreeChannelFromStoreFeatured();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	public void testVerifyDropDownsInSubscriptionsPage() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		subscribeFreeStoreChannel.RegisterAndSubscribeAFreeChannelStoreFeatured();
		
		//This Method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
	    driver.findElement(By.linkText("SUBSCRIPTIONS")).click();
	    
	    Thread.sleep(sleepTime); 
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select/option[2]")).click();

	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select[2]/option[2]")).click();
	    
	    /*Assertion is pending Before and After Drop Downs selection*/
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
