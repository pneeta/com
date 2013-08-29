package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularChannelsCategoryTestCases.ChannelTestCases.ShowsCategory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/** 
 * Class Name: VerifyUpdatedStatusForHomePopularChannelShows
 * Description: This test case validates whether 'Updated' status is displayed in show page for the show
 * present in a channel under Popular Channels section in Home page by logging registered user
 * into Comcast application.
 * **/

public class VerifyUpdatedStatusForHomePopularChannelShows extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVerifyUpdatedStatusForHomePopularChannelShows() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Channels[\\s\\S]*$"));
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Trailer Mania[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Trailer Mania")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Trailer Mania[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("500 Days of Summer")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*500 Days of Summer[\\s\\S]*$"));
	    
	    /*Have to Rest Service Call*/
	    String Videocount=driver.findElement(By.xpath(".//*[@id='content-wrap']/article/div/div[2]/div/div[1]/ul/li[2]")).getText();
	    assertEquals("Updated Last month",Videocount);
	    
	    driver.findElement(By.linkText("Sign out")).click();
	    
	  }
}
