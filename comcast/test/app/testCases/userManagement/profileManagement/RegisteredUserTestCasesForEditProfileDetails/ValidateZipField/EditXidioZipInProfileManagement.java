package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateZipField;

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
 * Class Name: EditXidioZipInProfileManagement
 * Description: This test case edit Xidio Zip field in Profile Management
 * by logging registered user into Comcast application.
 **/

public class EditXidioZipInProfileManagement extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
  @Test
  public void testEditXidioZipInProfileManagement() throws Exception {
	
	//This method is used to update the State Data Properties fields
	 proUtil.updateZipDataPropertiesFields();
	 proUtil.load(new FileInputStream(new File("com/data.properties")));
		 
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    assertEquals(DataServiceProperties._ZIP, driver.findElement(By.name("user[zip]")).getAttribute("value"));
    
    driver.findElement(By.name("user[zip]")).clear();
    driver.findElement(By.name("user[zip]")).sendKeys(proUtil.getProperty("UPD_ZIP"));
    
    driver.findElement(By.linkText("Save profile")).click();
    
    Thread.sleep(sleepTime);    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    assertEquals(proUtil.getProperty("ZIP"), driver.findElement(By.name("user[zip]")).getAttribute("value"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
