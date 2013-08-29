package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateAddressField;

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
 * Class Name: EditXidioAddressInProfileManagement
 * Description: This test case edits the Xidio Address field in Profile Management by
 * logging registered user into Comcast application.
 * **/

public class EditXidioAddressInProfileManagement extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword(); 
	TestDataGenerator proUtil=new TestDataGenerator();
	
	@Test
	public void testEditXidioAddressInProfileManagement() throws Exception {
	
	//This method is used to update the Address Data Properties fields
	 proUtil.updateAddressDataPropertiesFields();
	 proUtil.load(new FileInputStream(new File("com/data.properties")));
		 
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

	driver.findElement(By.cssSelector("span.translation_missing")).click();
   
    driver.findElement(By.name("user[address]")).clear();
    driver.findElement(By.name("user[address]")).sendKeys(proUtil.getProperty("UPD_ADDRESS"));
    
    driver.findElement(By.linkText("Save profile")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

    Thread.sleep(sleepTime);
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    assertEquals(proUtil.getProperty("ADDRESS"), driver.findElement(By.name("user[address]")).getAttribute("value"));
    
    Thread.sleep(sleepTime);
    driver.findElement(By.linkText("Sign out")).click();
 
  }
}
