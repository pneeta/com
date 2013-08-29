package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangeActivationCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/** 
 * Class Name: ChangeUserActivationCode
 * Description: This test case allows to make change in user activation code
 * by logging registered user into Comcast application.
 * **/

public class ChangeUserActivationCode extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
		
	@Test
	public void testChangeUserActivationCode() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);		
		driver.findElement(By.cssSelector("span.translation_missing")).click();
				
	    //driver.findElement(By.linkText(DataServiceProperties._USER_NAME)).click();
	    
	    driver.findElement(By.linkText("Change activation code")).click();
	    
	    driver.findElement(By.name("user[activation_code]")).clear();
	    driver.findElement(By.name("user[activation_code]")).sendKeys(DataServiceProperties._ACTIVATION_CODE);
	    
	    driver.findElement(By.linkText("Activate")).click();
	    
	    Thread.sleep(sleepTime);		
	    driver.findElement(By.name("user[activation_code]")).clear();
	    
	    driver.findElement(By.linkText("Activate")).click();
	    
	    Thread.sleep(sleepTime);		
	    driver.findElement(By.linkText("Skip activation, go to XIDIO")).click();
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
