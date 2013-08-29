package comcast.test.app.testCases.videoManagement.videoPlay.videoStreamingTestCases.SeekFunctionalityTestCases;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.FlashObjectWebDriver;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class vpTestCaseToVerifyMultipleSeekToBackPositionChangeFunctionality extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVideoSeekWithMultipleNextPositions() throws Exception {
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "PlayerPlatformAPI");
		
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);		
		driver.findElement(By.linkText("My Dog Eve")).click();
		
		Thread.sleep(10000);
		String getEndPosition=flashApp.callFlashObject("getDuration");
		double endPosition=Float.parseFloat((getEndPosition));		
		double setPostion=Math.floor(endPosition/5);
		
		
		while(endPosition>setPostion)
		{
			double positon=endPosition;
			String clickOnPosition=Double.toString(positon);
			Thread.sleep(5000);
			flashApp.callFlashObject("setPosition",clickOnPosition);
			//Need to assert value using getPositon function.
			
			endPosition-=setPostion;			
		}		

		Thread.sleep(sleepTime);
		driver.findElement(By.linkText("Sign out")).click();
	}
}
