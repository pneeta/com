package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularShowsCategoryTestCases.ShowsDetailsPageTestCases;

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
 * Class Name: VerifyVideosUnderHomePopularShows
 * Description: This test case validates whether the videos is displayed under Popular Shows section in Home page by 
 *  logging registered user into Comcast application.
 * **/

public class VerifyVideosUnderHomePopularShows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyVideosUnderHomePopularShows() throws Exception {
		
	  	Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularShowsAPIs();
	  	List<VideoDetails> popularShowList=videoDetails.get("popularShows");
	  	List<VideoDetails> popularVideoList=videoDetails.get("popularvideos");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

		driver.findElement(By.linkText("HOME")).click();
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));
		
		Thread.sleep(sleepTime);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
    	driver.findElement(By.linkText(popularShowList.get(0).getTitle())).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularVideoList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    String Videocount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/section/article/div/div/section/ul/li[1]/article/h1/a")).getText();
	    assertEquals(popularVideoList.get(0).getTitle(),Videocount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
