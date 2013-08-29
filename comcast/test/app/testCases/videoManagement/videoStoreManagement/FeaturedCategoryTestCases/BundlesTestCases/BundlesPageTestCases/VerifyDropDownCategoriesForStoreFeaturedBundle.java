package comcast.test.app.testCases.videoManagement.videoStoreManagement.FeaturedCategoryTestCases.BundlesTestCases.BundlesPageTestCases;

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
 * Class Name: VerifyDropDownCategoriesForStoreFeaturedBundle
 * Description: This test case verifies the category of available dropdowns
 * for a Bundle displayed under 'Featured' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyDropDownCategoriesForStoreFeaturedBundle extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyDropDownsForStoreFeaturedBundles() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.FeaturedBundleAPI();
		List <VideoDetails> bundlesList=videoDetails.get("bundlesList");
		List <VideoDetails> showsListInBundle=videoDetails.get("showsInBundle");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
    	driver.findElement(By.linkText(bundlesList.get(0).getTitle())).click();
	
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+bundlesList.get(0).getTitle()+"[\\s\\S]*$"));
	
	    //Assertion is pending After Sorting the value.
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select/option[2]")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showsListInBundle.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.xpath("//div[@id='content-wrap']/article/section/article/div/header/nav/select[2]/option[2]")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showsListInBundle.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
