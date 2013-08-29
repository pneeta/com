package comcast.test.app.testCases.videoManagement.videoPlay.videoStreamingTestCases.PauseFunctionalityTestCases;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.FlashObjectWebDriver;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class vpTestCaseToVerifyPauseFunctionality extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVideoPauseFunctionality() throws Exception {
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "PlayerPlatformAPI");
		
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(5000);		
		driver.findElement(By.linkText("My Dog Eve")).click();
		
		Thread.sleep(10000);
		flashApp.callFlashObject("pause");
		//Need to add Assertion to ensure its paused.
		
		Thread.sleep(5000);
		flashApp.callFlashObject("play");
				
		Thread.sleep(10000);
		flashApp.callFlashObject("pause");
		//Need to add Assertion to ensure its paused.
		
		Thread.sleep(sleepTime);
		driver.findElement(By.linkText("Sign out")).click();
		
	}
	
}
