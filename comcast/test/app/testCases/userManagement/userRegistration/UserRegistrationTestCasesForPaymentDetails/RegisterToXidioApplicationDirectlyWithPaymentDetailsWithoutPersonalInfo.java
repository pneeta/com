package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForPaymentDetails;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;

/**
 * Class Name: RegisterToXidioApplicationDirectlyWithPaymentDetailsWithoutPersonalInfo 
 * Description: This test case registers to Xidio application by directly entering payment 
 * details without entering personal information.
 * **/

public class RegisterToXidioApplicationDirectlyWithPaymentDetailsWithoutPersonalInfo extends BaseTest{
	
  UserRegistrationFunction useRegFun=new UserRegistrationFunction();
	
  @Test
  public void testRegisterToXidioApplicationDirectlyWithPaymentDetailsWithoutPersonalInfo() throws Exception {
		
	driver.get(DataServiceProperties.APPURL);
	
	driver.findElement(By.linkText("Register")).click();
    
    //driver.findElement(By.linkText("Payment")).click();
    
    //This method is used to enter credit card details
    //useRegFun.CreditCardDetials(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._CC_EXPIRY_MONTH,DataServiceProperties._CC_SECURITY_CODE,DataServiceProperties._CC_PIN_CODE);;
    
    //driver.findElement(By.cssSelector("a.btn.submit")).click();
    
    //driver.findElement(By.linkText("Personal info")).click();
    
	driver.findElement(By.linkText("Submit")).click();
	
    Thread.sleep(sleepTime);    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*First name is required[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Last name is required[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Address is required[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*City is required[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Zip is required[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Email is required[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Mobile number is required[\\s\\S]*$"));

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Password is required[\\s\\S]*$"));

  }
}
