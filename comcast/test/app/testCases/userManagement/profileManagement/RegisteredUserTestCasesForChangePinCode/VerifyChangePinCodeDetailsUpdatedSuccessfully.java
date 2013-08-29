package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePinCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: VerifyChangePinCodeDetailsUpdatedSuccessfully
 * Description: This test case validates Pin Code Details are updated successfully
 * by logging registered user into Comcast application.
 * **/

public class VerifyChangePinCodeDetailsUpdatedSuccessfully extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
    @Test
    public void testVerifyChangePinCodeDetailsUpdatedSuccessfully() throws Exception {
    	
    	/* This Method is to register new user using Comcast application 
    	 * and to change a password. 
    	 */	
    	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);		
		driver.findElement(By.cssSelector("span.translation_missing")).click();
		
		driver.findElement(By.linkText("Change pin code")).click();
		
		//This method is used to validate Change Pin Code Fields
	    profMangScenarioFun.ValidateChangePinCodeFields(driver,DataServiceProperties._CC_PIN_CODE,DataServiceProperties._PASSWORD);
	   
		driver.findElement(By.name("commit")).click();
		
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
		driver.findElement(By.linkText("Sign out")).click();
	}
}
