package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForCity.UserRegWithNoCity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/** Class Name: RegisterToXidioApplicationWithoutEnteringCity
 *  Description: This test case is for user registration to comcast application
 *  Without Entering City
 * **/

public class RegisterToXidioApplicationWithoutEnteringCity extends BaseTest{
	
	UserRegistrationValidationFuncitons userRegValidationFun=new UserRegistrationValidationFuncitons();
		
	@Test
	public void testRegisterToXidioApplicationWithoutEnteringCity() throws Exception {
	  
	    driver.get(DataServiceProperties.APPURL);
	    
	    driver.findElement(By.linkText("Register")).click();
	    
	    //This method is used to verify City field in registration page
	    userRegValidationFun.validateUserRegistrationFields(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,"",DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	    
	    driver.findElement(By.linkText("Submit")).click();
	    
	    Thread.sleep(sleepTime);	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*City is required[\\s\\S]*$"));
	}
}
