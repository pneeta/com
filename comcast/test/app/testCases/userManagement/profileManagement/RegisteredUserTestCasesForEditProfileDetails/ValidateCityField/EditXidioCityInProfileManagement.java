package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateCityField;

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
 * Class Name: EditXidioCityInProfileManagement
 * Description: This test case edits the Xidio City field in Profile Management by
 * logging registered user into Comcast application.
 * **/

public class EditXidioCityInProfileManagement extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
	@Test
    public void testEditXidioCityInProfileManagement() throws Exception {
	
	//This method is used to update the City Data Properties fields
	 proUtil.updateCityDataPropertiesFields();
	 proUtil.load(new FileInputStream(new File("com/data.properties")));
		 
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
	driver.findElement(By.cssSelector("span.translation_missing")).click();
           
    driver.findElement(By.name("user[city]")).clear();
    driver.findElement(By.name("user[city]")).sendKeys(proUtil.getProperty("UPD_CITY"));
    
    driver.findElement(By.linkText("Save profile")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	
    Thread.sleep(sleepTime);
	driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    assertEquals(proUtil.getProperty("CITY"), driver.findElement(By.name("user[city]")).getAttribute("value"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}
