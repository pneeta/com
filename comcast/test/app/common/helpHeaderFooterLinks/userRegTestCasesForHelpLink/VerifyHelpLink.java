package comcast.test.app.common.helpHeaderFooterLinks.userRegTestCasesForHelpLink;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.internal.selenesedriver.TakeScreenshot;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/** 
 * Class Name: VerifyHelpLink
 * Description: This test case validates Help Link by
 * logging registered user into Comcast application.
 * **/

public class VerifyHelpLink extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testHelpLink() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Help")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Lorem ipsum dolor sit amet?[\\s\\S]*$"));
	    	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
	

