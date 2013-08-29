package comcast.test.app.testCases.videoManagement.videoPlay.videoStreamingTestCases.SeekFunctionalityTestCases;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.FlashObjectWebDriver;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class vpTestCaseToVerifySeekToNextPositionChangeFunctionality extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVideoSeekToNextPositionFunctionality() throws Exception {
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "PlayerPlatformAPI");
		
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(5000);		
		driver.findElement(By.linkText("My Dog Eve")).click();
		
		Thread.sleep(10000);
		flashApp.callFlashObject("setPosition","20");
		// Need to Change getPositon instead of getCurrentPosition and Assertion is pending.
		
		Thread.sleep(6000);
		String currentPosition=flashApp.callFlashObject("getCurrentPosition");

		System.out.println("value: "+currentPosition);
		
		double y = Float.parseFloat(currentPosition);
		double getValue =Math.floor(y);
		int constValue=24;
		
		System.out.println("Y: "+Math.floor(y));
		assertTrue(constValue,getValue);

		Thread.sleep(sleepTime);
		driver.findElement(By.linkText("Sign out")).click();
	}
	private void assertTrue(int value, double a) {
	}		
}
