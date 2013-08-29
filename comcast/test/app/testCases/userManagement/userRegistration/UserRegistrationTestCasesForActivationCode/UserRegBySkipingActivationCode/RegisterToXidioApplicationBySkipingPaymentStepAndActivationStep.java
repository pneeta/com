package comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForActivationCode.UserRegBySkipingActivationCode;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;

/** Class Name: RegisterToXidioApplicationBySkipingPaymentStepAndActivationStep
 *  Description: This test case helps a new user to register to comcast application
 *  by Skipping Payment Step and Activation Step
 * **/

public class RegisterToXidioApplicationBySkipingPaymentStepAndActivationStep extends BaseTest{
	
	UserRegistrationFunction userReg=new UserRegistrationFunction();
	
	@Test
    public void testRegistrationToXidioApplicationBySkipingPaymentStepAndActivationStep() throws Exception {
		
		driver.get(DataServiceProperties.APPURL);
		
		driver.findElement(By.linkText("Register")).click();
		
		//This method is used to enter registration fields details
	    userReg.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	    
	    driver.findElement(By.name("terms_conditions")).click();
	    
	    driver.findElement(By.linkText("Submit")).click();
	    
	    Thread.sleep(sleepTime);
	    
	    //driver.findElement(By.id("terms_conditions_accept")).click();
	    
	    driver.findElement(By.linkText("Skip this step")).click();
	    
	    Thread.sleep(sleepTime);
	    
	    driver.findElement(By.linkText("Skip activation, go to XIDIO")).click();
	    
	    Thread.sleep(sleepTime);	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
