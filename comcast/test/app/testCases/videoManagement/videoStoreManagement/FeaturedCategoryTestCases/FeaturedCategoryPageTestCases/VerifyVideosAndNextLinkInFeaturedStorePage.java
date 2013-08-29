package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.FeaturedCategoryPageTestCases;

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
 * Class Name: VerifyVideosAndNextLinkInFeaturedStorePage
 * Description: This test case is to verify if a set of videos is displayed
 * and the link 'Next' works fine under 'Featured' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyVideosAndNextLinkInFeaturedStorePage extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyVideosAndNextLinkInFeaturedStorePage() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StoreFeaturedAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.cssSelector("a.next > span")).click();
	    
	    /*Some video's need to assert based on API service response*/
	    Thread.sleep(sleepTime);
	    driver.findElement(By.cssSelector("a.prev > span")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
