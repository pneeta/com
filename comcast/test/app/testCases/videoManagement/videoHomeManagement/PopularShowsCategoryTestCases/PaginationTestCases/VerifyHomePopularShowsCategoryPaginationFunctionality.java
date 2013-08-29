package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularShowsCategoryTestCases.PaginationTestCases;

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
 * Class Name: VerifyHomePopularShowsCategoryPaginationWorksFine
 * Description: This test case validates whether pagination feature under Popular Shows section 
 * works fine in Home page by logging registered user into Comcast application.
 * **/

public class VerifyHomePopularShowsCategoryPaginationFunctionality extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
  @Test
  public void testVerifyPopularShowsPaginationWorksFine() throws Exception {
	 
	  	Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularShowsAPIs();
	  	List<VideoDetails> popularShowList=videoDetails.get("popularShows");
	  
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));
	
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    boolean isPresent;
	    isPresent=driver.findElements(By.xpath(".//*[@id='pagination_popular_shows']/a[2]")).size()>0;
	    
	    if(isPresent==true)
	    {
		    driver.findElement(By.xpath(".//*[@id='pagination_popular_shows']/a[2]")).click();
		    
		    Thread.sleep(sleepTime);
		    driver.findElement(By.xpath(".//*[@id='pagination_popular_shows']/a[1]")).click();
		
		    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    }
	    else
	    		    
	    driver.findElement(By.linkText("Sign out")).click();
	    
  }
}
