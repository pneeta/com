package comcast.test.app.testCases.videoManagement.videoPlay.videoStreamingTestCases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.FlashObjectWebDriver;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class vpTestCaseToVerifyEndPosition extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testVideoPlayFunctionality() throws Exception {
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "PlayerPlatformAPI");
		
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(5000);		
		driver.findElement(By.linkText("My Dog Eve")).click();
		
		Thread.sleep(10000);
		flashApp.callFlashObject("pause");

		String getEndPosition=flashApp.callFlashObject("getEndPosition");
		String getDuration=flashApp.callFlashObject("getDuration");
		
		String endPosition=driver.findElement(By.xpath(".//*[@id='duration']")).getText();
				
		//Response and UI values are in different format Need Clarification from client.
		assertEquals("0:00:54", driver.findElement(By.id("duration")).getText());
	    
		Thread.sleep(sleepTime);
		driver.findElement(By.linkText("Sign out")).click();
		
	}
	
}
