package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularChannelsCategoryTestCases.ChannelTestCases.ChannelPageTestCases;

import static org.junit.Assert.assertEquals;
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
 * Class Name: VerifyShowCountForHomePopularChannels
 * Description: This test case validates whether Shows count is displayed in channel page for the channel
 * present under Popular Channels section in Home page by logging registered user into Comcast application.
 * **/

public class VerifyShowCountForHomePopularChannels extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowCountForHomePopularChannels() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularChannelDetailsAPIs();
		List<VideoDetails> showList=videoDetails.get("show");
		
		String showCount=restAPIServices.showCountForHomePopularChannel();
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Channels[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showCount+" Shows[\\s\\S]*$"));
	    
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();
	
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	
	    String Showcount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div[2]/div[1]/ul/li[1]")).getText();
	    assertEquals("Shows "+showCount+"",Showcount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	    
	  }
}
