package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForActivationCode.UserRegWithoutActivationCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** Class Name: RegisterUserWithoutActivationCode
 *  Description: This test case helps a new user to register to comcast application
 *  by Skipping Activation code
 * **/

public class RegisterUserWithoutActivationCode extends BaseTest{
	
	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
	
	@Test
	public void testRegisterUserWithoutActivationCode() throws Exception {
	
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
	    
	    driver.findElement(By.linkText("Next")).click();
	
	    driver.findElement(By.name("user[activation_code]")).clear();
	    driver.findElement(By.name("user[activation_code]")).sendKeys(DataServiceProperties._ACTIVATION_CODE);
	    
	    driver.findElement(By.linkText("Activate")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.name("user[activation_code]")).clear();
	    
	    driver.findElement(By.linkText("Activate")).click();
	    
	    Thread.sleep(sleepTime);
	    
	    driver.findElement(By.linkText("Skip activation, go to XIDIO")).click();
	
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
