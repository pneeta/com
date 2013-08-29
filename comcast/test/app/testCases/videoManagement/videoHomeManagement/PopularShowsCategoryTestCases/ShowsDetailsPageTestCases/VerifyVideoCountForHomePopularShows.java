package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularShowsCategoryTestCases.ShowsDetailsPageTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/** 
 * Class Name: VerifyVideoCountForHomePopularShows
 * Description: This test case validates whether 'Videos' count is displayed in shows page for the show
 * present under Popular Shows section in Home page by logging registered user into Comcast application.
 * **/

public class VerifyVideoCountForHomePopularShows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyVideoCountForPopularShows() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

		driver.findElement(By.linkText("HOME")).click();
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));
		
		Thread.sleep(sleepTime);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Brave[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Brave")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Brave[\\s\\S]*$"));
	    
	    /*Have to Rest Service Call*/
	    String Videocount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div/div[1]/ul/li[1]")).getText();
	    assertEquals("Videos 10",Videocount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	    
	  }
}
