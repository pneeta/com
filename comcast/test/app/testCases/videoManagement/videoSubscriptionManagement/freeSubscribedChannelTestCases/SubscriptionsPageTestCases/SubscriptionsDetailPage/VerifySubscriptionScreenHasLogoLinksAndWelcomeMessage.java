package comcast.test.app.testCases.videoManagement.videoSubscriptionManagement.freeSubscribedChannelTestCases.SubscriptionsPageTestCases.SubscriptionsDetailPage;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class VerifySubscriptionScreenHasLogoLinksAndWelcomeMessage extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
		
	@Test
	public void testSubscriptionScreenHasLinksAndWelcomeMessage() throws Exception 
	{
		
		//This method is used to get update Data Properties fields
		 proUtil.load(new FileInputStream(new File("com/data.properties")));
			 
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
								
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*SUBSCRIPTIONS[\\s\\S]*$"));
		
		driver.findElement(By.linkText("SUBSCRIPTIONS")).click();
		
		assertEquals("", driver.findElement(By.cssSelector("a.logo")).getText());
		
		assertEquals("Xidio", driver.getTitle());
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Help[\\s\\S]*$"));
		
		String Hellomsg=driver.findElement(By.xpath(".//*[@id='top_menu']/ul/li[2]/a/span[1]")).getText();
		String msg=driver.findElement(By.xpath(".//*[@id='top_menu']/ul/li[2]/a/span[2]")).getText();
		
		String WelcomeMsg = Hellomsg+" "+msg;
		String RegisteredUserName=Hellomsg+" "+proUtil.getProperty("USER_NAME");
		
		boolean Compare=WelcomeMsg.equalsIgnoreCase(RegisteredUserName);
		
		if(Compare==false)
		assertEquals(Hellomsg+" "+proUtil.getProperty("USER_NAME"),WelcomeMsg);
		else
		    driver.findElement(By.linkText("Sign out")).click();
		
	}
	
}
