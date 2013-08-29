package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForPassword.UserRegWithNonDigitPassword;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationValidationFuncitons;

/**
 * Class Name: RegisterToXidioApplicationByEnteringNonDigitPassword 
 * Description: This test case registers to Xidio application by entering non digit password.
 * **/

public class RegisterToXidioApplicationByEnteringNonDigitPassword extends BaseTest{
	
  UserRegistrationValidationFuncitons userRegValidationFun=new UserRegistrationValidationFuncitons();
  
  @Test
  public void testRegisterToXidioApplicationByEnteringInValidPassword() throws Exception {
	  
	  driver.get(DataServiceProperties.APPURL);
	  
	  driver.findElement(By.linkText("Register")).click();
    
	  //This method is used to validate non digit password.
	  userRegValidationFun.validateUserRegistrationFields(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._NONDIGIT_PASSWORD);
	  
	  driver.findElement(By.linkText("Submit")).click();
	
	  Thread.sleep(sleepTime);    
	  assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Password should contain at least one digit.[\\s\\S]*$"));

  }
}
