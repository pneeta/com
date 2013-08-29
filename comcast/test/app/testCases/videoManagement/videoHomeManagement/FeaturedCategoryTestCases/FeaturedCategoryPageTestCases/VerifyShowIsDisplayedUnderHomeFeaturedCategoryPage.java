package comcast.test.app.testCases.videoManagement.videoHomeManagement.FeaturedCategoryTestCases.FeaturedCategoryPageTestCases;

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
 * Class Name: VerifyShowIsDisplayedUnderHomeFeaturedCategoryPage
 * Description: This test case validates whether the Show is displayed under Featured section in Home page by 
 *  logging registered user into Comcast application.
 * **/

public class VerifyShowIsDisplayedUnderHomeFeaturedCategoryPage extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyShowIsDisplayedUnderHomeFeaturedCategoryPage() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomeFeaturedAPI();
		List<VideoDetails> subShowList=videoDetails.get("subshow");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));

	    boolean present;
	    int count=0;
	     do{
	    	try {
	    		present=driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowList.get(0).getTitle()+"[\\s\\S]*$");
	 	    	count++;
	 	    	} catch (NoSuchElementException e) {
	 	    		present = false;
	 	    }
		    if(present==true)
		    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+subShowList.get(0).getTitle()+"[\\s\\S]*$"));
		    else
	    	driver.findElement(By.xpath(".//*[@id='next_featured']/span")).click();
	    }
	    while(present == false && count<2);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
