package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateFirstNameField;

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
 * Class Name: EditXidioFirstNameInProfileManagement
 * Description: This test case edits First Name field in Profile Management
 * by logging registered user into Comcast application.
 **/

public class EditXidioFirstNameInProfileManagement extends BaseTest {
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
	@Test
	public void testEditXidioFirstNameInProfileManagement() throws Exception {

		//This method is used to update the First Name Data Properties fields
		 proUtil.updateFirstNameDataPropertiesFields();
		 proUtil.load(new FileInputStream(new File("com/data.properties")));
		 
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

		driver.findElement(By.cssSelector("span.translation_missing")).click();

		driver.findElement(By.name("user[first_name]")).clear();
		driver.findElement(By.name("user[first_name]")).sendKeys(proUtil.getProperty("UPD_FIRST_NAME"));

		driver.findElement(By.linkText("Save profile")).click();
		
		Thread.sleep(sleepTime);
		driver.findElement(By.cssSelector("span.translation_missing")).click();
		
		try 
		{
	      assertEquals(proUtil.getProperty("FIRST_NAME"), driver.findElement(By.name("user[first_name]")).getAttribute("value"));
	    } 
		catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	
	  driver.findElement(By.linkText("Sign out")).click();
	}
}

