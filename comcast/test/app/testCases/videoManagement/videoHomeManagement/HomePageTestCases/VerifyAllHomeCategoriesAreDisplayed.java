package comcast.test.app.testCases.videoManagement.videoHomeManagement.HomePageTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: VerifyAllHomeCategoriesAreDisplayed
 * Description: This test case validates whether all categories are displayed
 * in Home page by logging registered user into Comcast application.
 * **/

public class VerifyAllHomeCategoriesAreDisplayed extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	  
	 @Test
	  public void testVerifyAllHomeCategoriesAreDisplayed() throws Exception {
		 
		 /* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Up Next[\\s\\S]*$"));
	    assertEquals("", driver.findElement(By.xpath("//div[@id='content-wrap']/div/section/div/div/ul/li/article/a/img")).getText());

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Featured[\\s\\S]*$"));
	    assertEquals("", driver.findElement(By.xpath("//div[@id='content-wrap']/div[2]/section/div/div/ul/li/article/a/img")).getText());
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));
	    assertEquals("", driver.findElement(By.xpath("//div[@id='content-wrap']/div[3]/section/div/div/ul/li/article/a/img")).getText());
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Channels[\\s\\S]*$"));
	    assertEquals("", driver.findElement(By.xpath("//div[@id='content-wrap']/div[4]/section/div/div/ul/li/article/a/img")).getText());
	    
	    driver.findElement(By.linkText("Sign out")).click();
	 }
}
