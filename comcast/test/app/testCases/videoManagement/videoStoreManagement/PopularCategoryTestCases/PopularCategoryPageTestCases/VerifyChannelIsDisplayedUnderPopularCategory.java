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
 * Class Name: VerifyChannelIsDisplayedUnderPopularCategory
 * Description: This test case is to verify if a set of channels is displayed
 * under 'Popular' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyChannelIsDisplayedUnderPopularCategory extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
    @Test
    public void testVerifyChannelIsDisplayedUnderPopularCategory() throws Exception {
	  
	Map<String, List<VideoDetails>> videoDetails=restAPIServices.storePopularShowListUnderChannel();
	List <VideoDetails> showList=videoDetails.get("show");
	  
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	driver.findElement(By.linkText("STORE")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));

    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
    
   	driver.findElement(By.linkText(showList.get(0).getTitle())).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
    }
}
