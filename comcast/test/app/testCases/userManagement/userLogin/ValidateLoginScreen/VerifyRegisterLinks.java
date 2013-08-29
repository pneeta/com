package comcast.test.app.testCases.userManagement.userLogin.ValidateLoginScreen;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** 
 * Class Name: VerifyRegisterLinkWorksFine
 * Description: This test case is to verify whether 'Register' link works properly on login screen
 **/

public class VerifyRegisterLinks extends BaseTest{
	
	@Test
	public void testVerifyRegisterLinkWorksFine() {
		
		driver.get(DataServiceProperties.APPURL);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Register[\\s\\S]*$"));
		
		driver.findElement(By.linkText("Register")).click();
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Personal info[\\s\\S]*$"));
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Payment[\\s\\S]*$"));
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Enter Activation Code[\\s\\S]*$"));
	}

}
