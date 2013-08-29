package comcast.test.app.testCases.videoManagement.videoPlay.videoStreamingTestCases.PlayFunctionalityTestCases;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.FlashObjectWebDriver;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class vpTestCaseToVerifyPalyFunctionality extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVideoPlayFunctionality() throws Exception {
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "PlayerPlatformAPI");
		
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(5000);		
		driver.findElement(By.linkText("My Dog Eve")).click();
		
		Thread.sleep(10000);
		flashApp.callFlashObject("pause");
		
		//Need to add Assertion to ensure its its Palying.
		Thread.sleep(5000);
		flashApp.callFlashObject("play");
		
		Thread.sleep(sleepTime);
		flashApp.callFlashObject("pause");
		
		Thread.sleep(sleepTimeForVideoPlay);
		driver.findElement(By.linkText("Sign out")).click();
		
	}
	
}
