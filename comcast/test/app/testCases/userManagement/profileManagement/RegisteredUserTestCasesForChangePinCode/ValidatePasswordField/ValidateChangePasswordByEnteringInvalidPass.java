package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePinCode.ValidatePasswordField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateChangePinPasswordByEnteringInvalidPass
 * Description: This test case validates Password by entering invalid Password
 * by logging registered user into Comcast application.
 * **/

public class ValidateChangePasswordByEnteringInvalidPass extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword(); 
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	@Test
	public void testChangePasswordByEnteringInvalidPass() throws Exception {
	
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	    
	    Thread.sleep(sleepTime);	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change pin code")).click();
	    
	    //This method is used to validate Change Pin Code Fields
	    profMangScenarioFun.ValidateChangePinCodeFields(driver,DataServiceProperties._CC_PIN_CODE,DataServiceProperties._INVALID_PASSWORD_LENGTH);
	        
	    driver.findElement(By.name("commit")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Pin code has not been updated[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
