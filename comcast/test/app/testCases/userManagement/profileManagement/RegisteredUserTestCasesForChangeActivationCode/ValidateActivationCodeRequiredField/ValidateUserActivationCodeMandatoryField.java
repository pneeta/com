package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangeActivationCode.ValidateActivationCodeRequiredField;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateUserActivationCodeMandatoryField
 * Description: This test case validates if user activation code is the mandatory field
 * by logging registered user into Comcast application.
 * **/

public class ValidateUserActivationCodeMandatoryField extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
		
	@Test
	public void testUserActivationCodeMandatoryField() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);		
		driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change activation code")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("Activate")).click();
	  
	    Thread.sleep(sleepTime);
	    assertEquals("Activation code is required",driver.findElement(By.xpath("//*[@id='step-2']/fieldset[1]/div[2]/label/label")).getText());
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
