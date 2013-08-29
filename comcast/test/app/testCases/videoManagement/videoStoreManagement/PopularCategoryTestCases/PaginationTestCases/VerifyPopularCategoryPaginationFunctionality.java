package comcast.test.app.testCases.videoManagement.videoStoreManagement.PopularCategoryTestCases.PaginationTestCases;

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
 * Class Name: VerifyPopularCategoryPaginationWorksFine
 * Description: This test case verifies that 'Pagination' feature functions properly 
 * under 'Popular' section on 'Store' screen
 * by logging into Comcast application.
 */

public class VerifyPopularCategoryPaginationFunctionality extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyPopularCategoryPaginationFunctinality() throws Exception {
		
		Map <String,List<VideoDetails>> videoDetails=restAPIServices.StorePopularAPI();
		List <VideoDetails> showList=videoDetails.get("show");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("STORE")).click();

		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular[\\s\\S]*$"));
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));
	    
	    Thread.sleep(sleepTime);
	    boolean isPresent;
	    isPresent=driver.findElements(By.xpath(".//*[@id='pagination_popular_channels']/a[2]")).size()>0;
	    Thread.sleep(sleepTime);
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
