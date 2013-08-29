package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularShowsCategoryTestCases.ShowsDetailsPageTestCases;

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
 * Class Name: VerifyDropDownCategoriesForHomePopularShows
 * Description: This test case validates whether Category dropdowns are displayed in shows page for the show
 * present under Popular Shows section in Home page by logging registered user into Comcast application.
 * **/

public class VerifyDropDownCategoriesForHomePopularShows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyDropDownsForHomePopularShows() throws Exception {
		
	  	Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularShowsAPIs();
	  	List<VideoDetails> popularShowList=videoDetails.get("popularShows");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("HOME")).click();
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
    	driver.findElement(By.linkText(popularShowList.get(0).getTitle())).click();
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
	
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select[2]/option[2]")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select/option[2]")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    /*need to assert videos before and after sorting.*/
	    driver.findElement(By.linkText("Sign out")).click();
	    
	}
}
