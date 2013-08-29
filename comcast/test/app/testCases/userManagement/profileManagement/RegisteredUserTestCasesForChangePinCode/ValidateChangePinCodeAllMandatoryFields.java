package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePinCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateChangePinCodeAllMandatoryFields
 * Description: This test case validates All Mandatory Fields for Change Pin Code Feature
 * by logging registered user into Comcast application.
 * **/

public class ValidateChangePinCodeAllMandatoryFields extends BaseTest{

	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
 
	@Test
	public void testChangePinCodeAllMandatoryFields() throws Exception {
	
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
    
    Thread.sleep(sleepTime);	    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change pin code")).click();
    
    driver.findElement(By.name("commit")).click();
    
    assertEquals("This field is required.",driver.findElement(By.xpath(".//*[@id='step-0']/fieldset[1]/div[2]/label/label")).getText());
   
    assertEquals("This field is required.",driver.findElement(By.xpath(".//*[@id='step-0']/fieldset[2]/div[2]/label/label")).getText());
    
    driver.findElement(By.linkText("Sign out")).click();
	}
}
