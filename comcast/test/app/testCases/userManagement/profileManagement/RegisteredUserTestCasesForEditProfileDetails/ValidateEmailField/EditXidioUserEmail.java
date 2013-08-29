package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateEmailField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: EditXidioUserEmail
 * Description: This test case edits Xidio UserEmail field value  by
 * logging registered user into Comcast application.
 * **/

public class EditXidioUserEmail extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
	@Test
	 public void testEditXidioUserEmail() throws Exception {
	   
		//This method is used to update the Email Data Properties fields
		 proUtil.updateEmailDataPropertiesFields();
		 proUtil.load(new FileInputStream(new File("com/data.properties")));
		 
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
		
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
		
		Thread.sleep(sleepTime);		
	    driver.findElement(By.name("user[email]")).clear();
	    driver.findElement(By.name("user[email]")).sendKeys(proUtil.getProperty("UPD_EMAIL"));
	    
	    driver.findElement(By.linkText("Save profile")).click();
		
	    Thread.sleep(sleepTime);
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
		
	    Thread.sleep(sleepTime);	    
	    assertEquals(proUtil.getProperty("EMAIL"), driver.findElement(By.name("user[email]")).getAttribute("value"));
	    
	    try {
	    	
	    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	      } 
	    catch (Error e) {
	    	
	        verificationErrors.append(e.toString());
	      }
	    driver.findElement(By.linkText("Sign out")).click();
	  }

}
