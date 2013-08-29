package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegToCheckDiplayPinCheckboxWorks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** Class Name: RegisterToXidioApplicationWithCheckingDisplayPinCheckbox
 *  Description: This test case is for user registration to comcast application
 *  by checking Display Pin Checkbox
 * **/

public class RegisterToXidioApplicationWithCheckingDiplayPinCheckbox extends BaseTest{
	
	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
		
	@Test
	public void testRegisterToXidioApplicationWithCheckingDiplayPinCheckbox() throws Exception {
		
		driver.get(DataServiceProperties.APPURL);
		Thread.sleep(sleepTime);
		
	    driver.findElement(By.linkText("Register")).click();
	    Thread.sleep(sleepTime);
	    
	    //This method is used to enter registration fields details
	    userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	    
	    driver.findElement(By.name("terms_conditions")).click();
	    
	    driver.findElement(By.linkText("Submit")).click();	  
	    
	    //This method is used to enter user's credit card details
	    userRegFun.CreditCardDetials(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._CC_EXPIRY_MONTH,DataServiceProperties._CC_SECURITY_CODE,DataServiceProperties._CC_PIN_CODE);;
	   	      
	    driver.findElement(By.cssSelector("input.change_input_type.ignore")).click();
	    
	    assertEquals(DataServiceProperties._CC_PIN_CODE, driver.findElement(By.name("user[cc_pin_code]")).getAttribute("value"));
	    
	    driver.findElement(By.linkText("Next")).click();
	    
	 }
}
