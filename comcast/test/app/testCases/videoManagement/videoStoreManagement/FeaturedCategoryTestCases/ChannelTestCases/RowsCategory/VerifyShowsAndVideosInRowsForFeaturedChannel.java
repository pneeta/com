package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.ChannelTestCases.RowsCategory;

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
 * Class Name: VerifyShowsAndVideosInRowsForFeaturedChannel
 * Description: This test case is to verify the available options of shows and videos 
 * after sorting by 'ROWS'and by clicking 'Next' and 'Previous' button
 * for a channel displayed under 'Featured' section on 'Store' screen 
 * by logging into Comcast application.
 */

public class VerifyShowsAndVideosInRowsForFeaturedChannel extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowsAndVideosInRowsForFeaturedChannel() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.storeShowListUnderChannel();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> subShowListUnderChannel=videoDetails.get("showsUnderChannel");
		List <VideoDetails> showVideoList=videoDetails.get("video");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
		
    	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("ROWS")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowListUnderChannel.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowListUnderChannel.get(1).getTitle()+"[\\s\\S]*$"));
	    
	    String VideoTitle=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div[1]/section/div/div/ul[1]/li[1]/article/h1/a")).getText();
	    assertEquals(showVideoList.get(0).getTitle(),VideoTitle);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
