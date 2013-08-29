package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForZipCode.UserRegWithInvalidZipCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/**
 * Class Name: RegisterToXidioApplicationByEnteringInValidZip 
 * Description: This test case registers to Xidio application by entering invalid Zip code.
 * **/

public class RegisterToXidioApplicationByEnteringInValidZip extends BaseTest{
	
	UserRegistrationValidationFuncitons userRegValidationFun=new UserRegistrationValidationFuncitons();
		
	@Test
	public void testRegisterToXidioApplicationByEnteringInValidZip() throws Exception {
		
		driver.get(DataServiceProperties.APPURL);
		
		driver.findElement(By.linkText("Register")).click();
    
		//This method is used to validate invalid zip code.
		userRegValidationFun.validateUserRegistrationFields(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._INVALID_ZIP,DataServiceProperties._REG_PASSWORD);
		
		driver.findElement(By.linkText("Submit")).click();
		
		Thread.sleep(sleepTime);		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter only digits in Zip[\\s\\S]*$"));

    }
}
