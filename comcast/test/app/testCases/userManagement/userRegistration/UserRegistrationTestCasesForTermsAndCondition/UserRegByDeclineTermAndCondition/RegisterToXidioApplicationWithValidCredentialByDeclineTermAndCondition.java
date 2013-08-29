package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForTermsAndCondition.UserRegByDeclineTermAndCondition;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;

/**
 * Class Name: RegisterToXidioApplicationWithValidCredentialByDeclineTermAndCondition 
 * Description: This test case registers to Xidio application by entering valid credential without 
 * accepting Terms And Condition.
 * **/

public class RegisterToXidioApplicationWithValidCredentialByDeclineTermAndCondition extends BaseTest{
	
  UserRegistrationFunction userRegFun=new UserRegistrationFunction();
  UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
  
  @Test
  public void testRegistrationToXidioApplicationWithValidCredentialByDeclingTermAndCondition() throws Exception {
	
	driver.manage().deleteAllCookies();
 
	driver.get(DataServiceProperties.APPURL);
	
	driver.findElement(By.linkText("Register")).click();
    
	//This method is user to enter registration fields details
	userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
    
    driver.findElement(By.linkText("Submit")).click();
    
    driver.findElement(By.id("terms_conditions_decline")).click();
    
    Thread.sleep(sleepTime);    
    try {
    	
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You have to agree to terms and conditions[\\s\\S]*$"));
    } 
    catch (Error e) {
    	
      verificationErrors.append(e.toString());
    }
  }
}
