package comcast.test.app.testCases.videoManagement.videoStoreManagement.PopularCategoryTestCases.ChannelTestCases.ChannelPageTestCases;

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
 * Class Name: VerifyDropDownCategoriesForPopularChannel
 * Description: This test case verifies the category of available dropdowns
 * for a channel displayed under 'Popular' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyDropDownCategoriesForPopularChannel extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyDropDownsForPopularChannel() throws Exception {
	
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StorePopularAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> subShowListUnderChannel=videoDetails.get("showsUnderChannel");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

		driver.findElement(By.linkText("STORE")).click();
	
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));
	
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	
	    //Assertion is pending After Sorting the value.
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select/option[2]")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowListUnderChannel.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select[2]/option[2]")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowListUnderChannel.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
