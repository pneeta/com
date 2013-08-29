package comcast.test.app.testCases.videoManagement.videoStoreManagement.PopularCategoryTestCases.ChannelTestCases.ChannelPageTestCases;

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
 * Class Name: VerifyUpdatedStatusForAPopularChannel
 * Description: This test case is to verify the shown last updated status/day
 * for a channel displayed under 'Popular' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyUpdatedStatusForAPopularChannel extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyUpdatedDayForAPopularChannel() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StorePopularAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();
	    
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    /*Have to Rest Service Call*/
	    String Videocount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div[2]/div[1]/ul/li[3]")).getText();
	    assertEquals("Updated 2weeks ago",Videocount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
