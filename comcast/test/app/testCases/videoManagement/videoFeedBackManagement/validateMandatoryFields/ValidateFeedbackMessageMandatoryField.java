package comcast.test.app.testCases.videoManagement.videoFeedBackManagement.validateMandatoryFields;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;

/**
 * Class Name: ValidateFeedbackMessageMandatoryField 
 * Description: This test case validates the Message mandatory field of give feedback to the publisher
 * feature for the selected video by logging registered user into Comcast
 * application.
 * **/

public class ValidateFeedbackMessageMandatoryField extends BaseTest 
{
	UserLoginFunctions userLogin = new UserLoginFunctions();
	UserRegistrationUsingComcast userReg = new UserRegistrationUsingComcast();

	@Test
	public void testValidateFeedbackMessageMandatoryField() throws Exception 
	{
		//This method is used to register new user into Comcast Application
		userReg.testUserRegistrationUsingComcast(driver);

		driver.get(DataServiceProperties.APPURL);

		//This method is used to enter user name and password credential
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		
		//This method is used to Change Password
		userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
		
		//driver.findElement(By.name("commit")).click();

		Thread.sleep(sleepTime);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*XIDIO[\\s\\S]*$"));
		assertEquals("",driver.findElement(By.xpath("//img[@alt='Comcast Labs, XIDIO']")).getText());
		
		driver.findElement(By.id("search-query")).clear();
		driver.findElement(By.id("search-query")).sendKeys(DataServiceProperties._SEARCH_VIDEO_BY);
		
		driver.findElement(By.id("go-search")).click();

		driver.findElement(By.cssSelector("img[alt=\"African Cats\"]")).click();

		driver.findElement(By.linkText("Give Feedback")).click();
		
		driver.findElement(By.xpath("(//textarea[@name='message'])[2]")).clear();
		driver.findElement(By.xpath("(//textarea[@name='message'])[2]")).sendKeys("This video is wonderfull.");

		driver.findElement(By.xpath("(//input[@name='Submit'])[2]")).click();
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Subject is required[\\s\\S]*$"));
		
		driver.findElement(By.linkText("Sign out")).click();

	}
}
