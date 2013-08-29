package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularChannelsCategoryTestCases.PaginationTestCases;

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
 * Class Name: VerifyHomePopularChannelsCategoryPaginationWorksFine
 * Description: This test case validates whether pagination feature under Popular Channels section 
 * works fine in Home page by logging registered user into Comcast application.
 * **/

public class VerifyHomePopularChannelsCategoryPaginationWorksFine extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
  @Test
  public void testVerifyPopularChannelsPaginationWorksFine() throws Exception {
	  
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularChannelAPIs();
		List<VideoDetails> showList=videoDetails.get("show");
	  
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Channels[\\s\\S]*$"));
	
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    boolean isPresent;
	    isPresent=driver.findElements(By.xpath(".//*[@id='pagination_popular_channels']/a[2]")).size()>0;
	    
	    if(isPresent==true)
	    {
	    	driver.findElement(By.xpath(".//*[@id='pagination_popular_channels']/a[2]")).click();
	    
		    Thread.sleep(sleepTime);
		    driver.findElement(By.xpath(".//*[@id='pagination_popular_channels']/a[1]")).click();
		
		    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    }
	    else
	    	
	    driver.findElement(By.linkText("Sign out")).click();
    }
}
