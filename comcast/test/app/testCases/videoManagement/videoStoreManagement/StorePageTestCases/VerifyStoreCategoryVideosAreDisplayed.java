package comcast.test.app.testCases.videoManagement.videoStoreManagement.StorePageTestCases;

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
 * Class Name: VerifyStoreCategoryVideosAreDisplayed 
 * Description: This test case is used to verify Store category video/videos are displayed
 * for registered Comcast Application user.
 * **/

public class VerifyStoreCategoryVideosAreDisplayed extends BaseTest{
  
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
  
  @Test
  public void testVerifyStoreCategoryVideosAreDisplayed() throws Exception {
	
	Map<String, List<VideoDetails>> videoDetails=restAPIServices.StorePageAPIs();
	List <VideoDetails> featuredShowList=videoDetails.get("Featuredshow");
	List <VideoDetails> popularShowList=videoDetails.get("Popularshow");
	
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	driver.findElement(By.linkText("STORE")).click();

	Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+featuredShowList.get(0).getTitle()+"[\\s\\S]*$"));
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+popularShowList.get(0).getTitle()+"[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
