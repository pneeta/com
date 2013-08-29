package comcast.test.app.common.helpHeaderFooterLinks.userRegTestCasesForHelpLink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/** 
 * Class Name: VerifyHelpLink
 * Description: This test case validates Help Link by
 * logging registered user into Comcast application.
 * **/

public class VerifyHomePageAllLinks extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
	@Test
	public void testHelpLink() throws Exception {
		
		//This method is used to GET update Data Properties fields
		 proUtil.load(new FileInputStream(new File("com/data.properties")));
		 
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Help[\\s\\S]*$"));
	    
	    String Hellomsg=driver.findElement(By.xpath(".//*[@id='top_menu']/ul/li[2]/a/span[1]")).getText();
	    
		String msg=driver.findElement(By.xpath(".//*[@id='top_menu']/ul/li[2]/a/span[2]")).getText();
		
		String WelcomeMsg = Hellomsg+" "+msg;
		String RegisteredUserName=Hellomsg+" "+proUtil.getProperty("USER_NAME");
		
		boolean Compare=WelcomeMsg.equalsIgnoreCase(RegisteredUserName);
		
		if(Compare==false)
		assertEquals(Hellomsg+" "+proUtil.getProperty("USER_NAME"),WelcomeMsg);
		else
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign out[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*STORE[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*SUBSCRIPTIONS[\\s\\S]*$"));
	    	    
	    driver.findElement(By.linkText("Sign out")).click();
	}

}
