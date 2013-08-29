package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePinCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ChangePinCode
 * Description: This test case validates user pin code updation feature
 * by logging registered user into Comcast application.
 * **/

public class ChangePinCode extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	@Test
	public void testChangePinCode() throws Exception {
		
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
    
    Thread.sleep(sleepTime);	    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
	
    driver.findElement(By.linkText("Change pin code")).click();

    //This method is used to validate password filed by entering invalid password
    profMangScenarioFun.ValidateChangePinCodeFields(driver,DataServiceProperties._INVALID_CC_PIN_CODE,DataServiceProperties._INVALID_PASSWORD);
    
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Pin code has not been updated[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
	}
}
