package comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePinCode.ValidatePasswordField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**  
 * Class Name: VerifyEnteredPasswordIsVisibleWhenUserClicksOnDisplayPass
 * Description: This test case Verifies Entered Password is Visible when user clicks on Display Password
 * by logging registered user into Comcast application.
 * **/

public class VerifyEnteredPasswordIsVisibleWhenUserClicksOnDisplayPass extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
		
	@Test
	public void testEnteredPasswordIsVisibleWhenUserClicksOnDisplayPass() throws Exception {
	
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */	
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	    
	    Thread.sleep(sleepTime);	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change pin code")).click();
	    
		driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(DataServiceProperties._PASSWORD);
	    
	    driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	    
	    assertEquals(DataServiceProperties._PASSWORD, driver.findElement(By.name("password")).getAttribute("value"));
	    
	    Thread.sleep(sleepTime);
	    
	    driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	    Thread.sleep(sleepTime);
	        
	    driver.findElement(By.linkText("Sign out")).click();
	}
}
