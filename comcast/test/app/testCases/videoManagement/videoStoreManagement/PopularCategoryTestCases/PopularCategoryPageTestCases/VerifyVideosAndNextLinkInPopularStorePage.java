package comcast.test.app.testCases.videoManagement.videoStoreManagement.PopularCategoryTestCases.PopularCategoryPageTestCases;

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
 * Class Name: VerifyVideosAndNextLinkInPopularStorePage
 * Description: This test case is to verify if a set of videos is displayed
 * and the link 'Next' works fine under 'Popular' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyVideosAndNextLinkInPopularStorePage extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyVideosAndNextLinkInPopularStorePage() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.StorePopularAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.xpath("//div[@id='content-wrap']/div[2]/section/a[2]/span")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/div[2]/section/a/span")).click();
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
