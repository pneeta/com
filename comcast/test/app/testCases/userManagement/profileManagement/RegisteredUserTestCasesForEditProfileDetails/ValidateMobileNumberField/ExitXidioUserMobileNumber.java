package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateMobileNumberField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: ExitXidioUserMobileNumber
 * Description: This test case exits Xidio user mobile number
 * by logging registered user into Comcast application.
 **/

public class ExitXidioUserMobileNumber extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
	@Test
	public void testEditXidioUserMobileNumber() throws Exception {
		
		proUtil.updateMobileNumberDataPropertiesFields();
		proUtil.load(new FileInputStream(new File("com/data.properties")));
		String _UPD_MOBILE_NUMBER=proUtil.getProperty("UPD_MOBILE_NUMBER");
		String _MOBILE_NUMBER=proUtil.getProperty("MOBILE_NUMBER");
		
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
		
	    Thread.sleep(sleepTime);		
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    		
		Thread.sleep(sleepTime);
	    
	    driver.findElement(By.name("user[mobile_number]")).clear();

	    driver.findElement(By.name("user[mobile_number]")).sendKeys(_UPD_MOBILE_NUMBER);
	    
	    driver.findElement(By.linkText("Save profile")).click();
	    
	    Thread.sleep(sleepTime);
	    driver.findElement(By.cssSelector("span.translation_missing")).click();

	    Thread.sleep(sleepTime);
	    assertEquals(_MOBILE_NUMBER, driver.findElement(By.name("user[mobile_number]")).getAttribute("value"));
	    
	    Thread.sleep(sleepTime);	    
	    driver.findElement(By.linkText("Sign out")).click();
	  }
}
