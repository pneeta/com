package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePaymentInfo.ValidateExpiryMonthField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: VerifyPaymentInfoExpiryMonthUpdatedSuccessfully
 * Description: This test case validates whether Payment Info Expiry Month is updated successfully 
 * By logging registered user into Comcast application.
 * **/

public class VerifyPaymentInfoExpiryMonthUpdatedSuccessfully extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	UserRegistrationValidationFuncitons userRegValFun=new UserRegistrationValidationFuncitons();
	
	@Test
	public void testVefiryChangePaymentInfoDetailsUpdatedSuccessfully() throws Exception {
		
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

	driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change payment info")).click();
    
    //This month is used to update Expiry month of credit card
    userRegValFun.UpdateCCDetials(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._UPD_CC_EXPIRY_MONTH,DataServiceProperties._CC_YEAR,DataServiceProperties._CC_PIN_CODE);
    
    //driver.findElement(By.name("commit")).click();
    
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
