package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegToCheckDiplayPasswordCheckboxWorks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;

/** Class Name: RegisterToXidioApplicationWithCheckingDisplayPasswordCheckbox
 *  Description: This test case is for user registration to comcast application
 *  by checking Display Password Checkbox
 * **/

public class RegisterToXidioApplicationWithCheckingDiplayPasswordCheckbox extends BaseTest{
	
	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
	
	@Test
	public void testRegisterToXidioApplicationWithCheckingDisplayPasswordCheckbox() throws Exception {
	  
		TestDataGenerator.modifyDataProperties();
		
		Thread.sleep(sleepTime);
		
		driver.get(DataServiceProperties.APPURL);
		Thread.sleep(sleepTime);
		
	    driver.findElement(By.linkText("Register")).click();
	    Thread.sleep(sleepTime);
	    
	    //This method is used to enter registration fields details
	    userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	    
	    driver.findElement(By.cssSelector("input.change_input_type")).click();
	    
	    Thread.sleep(sleepTime);
	    
	    assertEquals(DataServiceProperties._REG_PASSWORD, driver.findElement(By.name("user[password]")).getAttribute("value"));	        
	    
	 }
}
