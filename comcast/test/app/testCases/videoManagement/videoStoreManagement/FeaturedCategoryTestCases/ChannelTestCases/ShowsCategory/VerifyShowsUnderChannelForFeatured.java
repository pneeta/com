package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.ChannelTestCases.ShowsCategory;

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
 * Class Name: VerifyShowsUnderChannelForFeatured
 * Description: This test case is to verify the available options of shows
 * after sorting by 'SHOWS'and by clicking 'Next' and 'Previous' button
 * for a channel displayed under 'Featured' section on 'Store' screen 
 * by logging into Comcast application.
 */

public class VerifyShowsUnderChannelForFeatured extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowsUnderChannelForFeatured() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.storeShowListUnderChannel();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> showsListUnderChannel=videoDetails.get("showsUnderChannel");
				
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

	   	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("SHOWS")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showsListUnderChannel.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showsListUnderChannel.get(1).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
