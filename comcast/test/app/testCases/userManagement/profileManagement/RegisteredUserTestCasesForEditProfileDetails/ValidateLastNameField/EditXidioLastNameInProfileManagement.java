package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateLastNameField;

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
 * Class Name: EditXidioLastNameInProfileManagement
 * Description: This test case edits Xidio Last Name in Profile Management
 * by logging registered user into Comcast application.
 **/

public class EditXidioLastNameInProfileManagement extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
  @Test
  public void testEditXidioLastNameInProfileManagement() throws Exception {
	
	//This method is used to update the Last Name Data Properties fields
	 proUtil.updateLastNameDataPropertiesFields();
	 proUtil.load(new FileInputStream(new File("com/data.properties")));
		 
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	
    Thread.sleep(sleepTime);        
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.name("user[last_name]")).clear();
    driver.findElement(By.name("user[last_name]")).sendKeys(proUtil.getProperty("UPD_LAST_NAME"));
    
    driver.findElement(By.linkText("Save profile")).click();
             
    Thread.sleep(sleepTime);
    driver.findElement(By.cssSelector("span.translation_missing")).click(); 
	
    assertEquals(proUtil.getProperty("LAST_NAME"), driver.findElement(By.name("user[last_name]")).getAttribute("value"));
    
    Thread.sleep(sleepTime);
    driver.findElement(By.linkText("Sign out")).click();
    
  }
}
