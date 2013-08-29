package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegWithInvalidCCNumber;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** Class Name: RegisterToXidioApplicationWithInvalidCreditCardNumber
 *  Description: This test case is for user registration to comcast application
 *  by entering invalid credit card number
 * **/

public class RegisterToXidioApplicationWithInvalidCreditCardNumber extends BaseTest {
	
	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
		
	@Test
	public void testRegisterToXidioApplicationWithInvalidCreditCardNumber() throws Exception {
	
		driver.get(DataServiceProperties.APPURL);
		Thread.sleep(sleepTime);
		
	    driver.findElement(By.linkText("Register")).click();
	    Thread.sleep(sleepTime);
	    
	    //This method is used to enter registration fields details
	    userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	    
	    driver.findElement(By.name("terms_conditions")).click();
	    
	    driver.findElement(By.linkText("Next")).click();
	    
	    Thread.sleep(sleepTime);
	    
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(DataServiceProperties._INVALID_CC_NUMBER);  
	      
	    driver.findElement(By.linkText("Next")).click();
	    
	    Thread.sleep(sleepTime);
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter a valid credit card number[\\s\\S]*$"));
	    
/*	    try{
	    	String AssertCCError="Please enter a valid credit card number";
	    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*'"+AssertCCError+"'[\\s\\S]*$"));
	    }
	    catch(Exception e){
	    }*/
	  }
}
