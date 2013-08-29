package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangeActivationCode.ChangeActivationCodeWithInValidAC;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/** Class Name: ValidateUserActivationCodeByEnteringInvalidCode
 *  Description: This test case validates Activation code by entering invalid code
 *  by logging registered user into Comcast application.
 * **/

public class ValidateUserActivationCodeByEnteringInvalidCode extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	
	@Test
	public void testActivationCodeByEnteringInvalidCode() throws Exception {
	
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
		Thread.sleep(sleepTime);
		driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change activation code")).click();
	    
	    driver.findElement(By.name("user[activation_code]")).clear();
	    driver.findElement(By.name("user[activation_code]")).sendKeys(DataServiceProperties._INVALID_ACTIVATION_CODE);
	    
	    driver.findElement(By.linkText("Activate")).click();
	  
	    Thread.sleep(sleepTime);
	    assertEquals("Activation code "+DataServiceProperties._INVALID_ACTIVATION_CODE+" is invalid", driver.findElement(By.cssSelector("label.error")).getText());
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
