package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForZipCode.UserRegWithInvalidZipCodeLength;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/**
 * Class Name: RegisterToXidioApplicationByEnteringInValidZipLength 
 * Description: This test case registers to Xidio application by entering invalid Zip code length.
 * **/

public class RegisterToXidioApplicationByEnteringInValidZipLength extends BaseTest{
	
  UserRegistrationValidationFuncitons userRegValidationFun=new UserRegistrationValidationFuncitons();
	 
  @Test
  public void testRegisterToXidioApplicationByEnteringInValidZipLength() throws Exception {
	  
	driver.get(DataServiceProperties.APPURL);
	
    driver.findElement(By.linkText("Register")).click();
    
    //This method is used to validate invalid zip code length.
    userRegValidationFun.validateUserRegistrationFields(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._INVALID_ZIP_LENGTH,DataServiceProperties._REG_PASSWORD);
    
    driver.findElement(By.linkText("Submit")).click();
    
    Thread.sleep(sleepTime);    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter Zip code 5 characters long[\\s\\S]*$"));
  }
}

