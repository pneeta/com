package comcast.test.app.testCases.videoManagement.videoStoreManagement.PopularCategoryTestCases.ChannelTestCases.RowsCategory;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;
import comcast.test.config.dataServices.vo.VideoDetails;

/** 
 * Class Name: VerifyShowsAndVideosInRowsForPopularChannel
 * Description: This test case is to verify the available options of shows and videos 
 * after sorting by 'ROWS'and by clicking 'Next' and 'Previous' button
 * for a channel displayed under 'Popular' section on 'Store' screen 
 * by logging into Comcast application.
 */

public class VerifyShowsAndVideosInRowsForPopularChannel extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowsAndVideosInRowsForPopularChannel() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.storePopularShowListUnderChannel();
		List <VideoDetails> showList=videoDetails.get("show");
		List <VideoDetails> subShowList=videoDetails.get("subshow");
		List <VideoDetails> videoList=videoDetails.get("video");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));

	   	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("ROWS")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	   boolean present;
	     do{
	    	try {
	    		driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoList.get(0).getTitle()+"[\\s\\S]*$");
	 	    	present = false;
	 	    	} catch (NoSuchElementException e) {
	 	    		present = true;
	 	    }
		    if(present==true)
		    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+videoList.get(0).getTitle()+"[\\s\\S]*$"));
		    else
	    	driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/ul/li[1]/article/h1/a")).click();
	    }
	    while(present == false);
	     
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
