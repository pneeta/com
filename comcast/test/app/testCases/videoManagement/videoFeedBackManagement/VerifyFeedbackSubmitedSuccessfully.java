package comcast.test.app.testCases.videoManagement.videoFeedBackManagement;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;

/**
 * Class Name: VerifyFeedbackSubmitedSuccessfully 
 * Description: This test case validates whether video feedback provided is submitted successfully
 * for the selected video by logging registered user into Comcast application.
 * **/

public class VerifyFeedbackSubmitedSuccessfully extends BaseTest 
{
	UserLoginFunctions userLogin = new UserLoginFunctions();
	UserRegistrationUsingComcast userReg = new UserRegistrationUsingComcast();

	@Test
	public void testVerifyFeedbackSubmitedSuccessfully() throws Exception 
	{
		//This method is used to register new user into Comcast Application
		userReg.testUserRegistrationUsingComcast(driver);
		
		driver.get(DataServiceProperties.APPURL);
		
		Thread.sleep(sleepTime);
		//This method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();

		//This method is used to Change Password
		userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
		
		//driver.findElement(By.name("commit")).click();

	    driver.findElement(By.id("search-query")).clear();
	    driver.findElement(By.id("search-query")).sendKeys(DataServiceProperties._SEARCH_VIDEO_BY);
	    driver.findElement(By.id("go-search")).click();

	    Thread.sleep(sleepTime);
	    driver.findElement(By.cssSelector("img[alt=\"African Cats\"]")).click();
	    
		driver.findElement(By.linkText("Give Feedback")).click();

		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Give feedback to the publisher[\\s\\S]*$"));
		
		driver.findElement(By.xpath("(//input[@name='subject'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='subject'])[2]")).sendKeys("Feedback");
		
		driver.findElement(By.xpath("(//textarea[@name='message'])[2]")).clear();
		driver.findElement(By.xpath("(//textarea[@name='message'])[2]")).sendKeys("This video is nice one.");
		
		driver.findElement(By.xpath("(//input[@name='Submit'])[2]")).click();
		
		Thread.sleep(sleepTime);
		Alert javascriptAlert = driver.switchTo().alert();
		String AlertMsg = (javascriptAlert.getText().toString());
		javascriptAlert.accept();

		assertEquals("Thanks for your valuable feedback. Your feedback has been communicated to the Publisher",AlertMsg);

		driver.findElement(By.linkText("Sign out")).click();
	}
}
