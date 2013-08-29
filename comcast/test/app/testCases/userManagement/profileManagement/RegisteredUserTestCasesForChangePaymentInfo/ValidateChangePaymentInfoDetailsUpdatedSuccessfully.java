package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePaymentInfo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidateChangePaymentInfoDetailsUpdatedSuccessfully
 * Description: This test case validates Change Payment Info details are updated successfully by
 * logging registered user into Comcast application.
 * **/

public class ValidateChangePaymentInfoDetailsUpdatedSuccessfully extends BaseTest{
	
	  RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	  UserRegistrationValidationFuncitons userRegValFun=new UserRegistrationValidationFuncitons();

	  @Test
	  public void testUserProfileChanges() throws Exception {
		  
		try{
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change payment info")).click();
	    
	    //This method is used to update credit card details
	    userRegValFun.UpdateCCDetials(driver,DataServiceProperties._UPD_CC_NUMBER,DataServiceProperties._UPD_CC_EXPIRY_MONTH,DataServiceProperties._UPD_CC_YEAR,DataServiceProperties._UPD_CC_PIN_CODE);
	        
	    driver.findElement(By.name("commit")).click();
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    //To Ensure Credit Card Details Change saved successfully, Its displaying blank fields.
	    
	    driver.findElement(By.linkText("Sign out")).click();
	    
		}
		catch(Exception e){			
			captureScreenshot();
		}
}
}

