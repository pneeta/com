package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateStateField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: EditXidioStateInProfileManagement
 * Description: This test case edit Xidio state field in Profile Management
 * by logging registered user into Comcast application.
 **/

public class EditXidioStateInProfileManagement extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	TestDataGenerator proUtil=new TestDataGenerator();
	
  @Test
  public void testEditXidioStateInProfileManagement() throws Exception {
	
	//This method is used to update the State Data Properties fields
	 proUtil.updateStateDataPropertiesFields();
	 proUtil.load(new FileInputStream(new File("com/data.properties")));
	 
	/* This Method is to register new user using Comcast application 
	 * and to change a password. 
	 */	
	RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    new Select(driver.findElement(By.name("user[state]"))).selectByVisibleText(proUtil.getProperty("UPD_STATE"));
    
    driver.findElement(By.cssSelector("option[value=\"AL\"]")).click();
    
    driver.findElement(By.linkText("Save profile")).click();
        
    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();

    Select sportDropdown = new Select(driver.findElement(By.name("user[state]")));
    sportDropdown.selectByVisibleText(proUtil.getProperty("UPD_STATE"));
    assertEquals(sportDropdown.getFirstSelectedOption().getText(), proUtil.getProperty("STATE"));
    
    driver.findElement(By.linkText("Sign out")).click();

  }
}

