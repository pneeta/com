package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangeActivationCode.ChangeActivationCodeWithValidAC;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateUserActivationCodeUpdatesSuccessfully
 * Description: This test case validates activation code is updated successfully
 * by logging registered user into Comcast application.
 * **/

public class ValidateUserActivationCodeUpdatesSuccessfully extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	ProfileManagementScenarioBasedFunctions profManagementScenario=new ProfileManagementScenarioBasedFunctions();
		
	@Test
	public void testUserActivationCodeUpdatesSuccessfully() throws Exception {
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);		
		driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change activation code")).click();
	    
	    //This method is used to update activation code
	    profManagementScenario.UpdateActivationCode(driver,DataServiceProperties._UPD_ACTIVATION_CODE);
	    	    
	    driver.findElement(By.linkText("Activate")).click();
	  
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

	    //Ensuring the updated Activation code is pending.
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
