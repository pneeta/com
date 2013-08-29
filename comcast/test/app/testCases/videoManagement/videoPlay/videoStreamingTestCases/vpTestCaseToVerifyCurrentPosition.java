package comcast.test.app.testCases.videoManagement.videoPlay.videoStreamingTestCases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.FlashObjectWebDriver;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class vpTestCaseToVerifyCurrentPosition extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVideoPlayFunctionality() throws Exception {
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "PlayerPlatformAPI");
		
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(5000);		
		driver.findElement(By.linkText("My Dog Eve")).click();
		
		Thread.sleep(10000);
		flashApp.callFlashObject("pause");

		String currentPosition=flashApp.callFlashObject("getCurrentPosition");
		
		//Response and UI values are in different format Need Clarification from client.
	    assertEquals("0:00:10 /", driver.findElement(By.id("display")).getText());
	    
		Thread.sleep(sleepTimeForVideoPlay);
		driver.findElement(By.linkText("Sign out")).click();
		
	}
	
}
