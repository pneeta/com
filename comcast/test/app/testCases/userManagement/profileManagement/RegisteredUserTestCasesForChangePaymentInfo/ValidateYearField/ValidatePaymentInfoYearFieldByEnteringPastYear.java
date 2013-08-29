package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePaymentInfo.ValidateYearField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.profileManagement.common.ProfileManagementScenarioBasedFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: ValidatePaymentInfoYearFieldByEnteringPastYear
 * Description: This test case validates payment Details Year field By entering Past Year
 * By logging registered user into Comcast application.
 * **/

public class ValidatePaymentInfoYearFieldByEnteringPastYear extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();

	@Test
	public void testYearFieldByEnteringPastYear() throws Exception {
		
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	Thread.sleep(sleepTime);		
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change payment info")).click();
    
    //This method is used to validate the year field by entering past year
    profMangScenarioFun.ValidateInvalidCreditCardDetials(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._CC_EXPIRY_MONTH,DataServiceProperties._PAST_YEAR,DataServiceProperties._CC_SECURITY_CODE);
    
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(sleepTime);		
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter Expiration Year greater than or equal to "+DataServiceProperties._CURRENT_YEAR+".[\\s\\S]*$"));
   
    driver.findElement(By.linkText("Sign out")).click();  
  }
}

