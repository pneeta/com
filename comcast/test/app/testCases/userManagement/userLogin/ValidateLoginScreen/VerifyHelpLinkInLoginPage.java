package comcast.test.app.testCases.userManagement.userLogin.ValidateLoginScreen;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** 
 * Class Name: VerifyHelpLinkWorksFine
 * Description: This test case is to verify whether 'Help' link works properly on login screen
 **/

public class VerifyHelpLinkInLoginPage extends BaseTest{

	@Test
	public void testVerifyHelpLinkWorksFine() {
		
		driver.get(DataServiceProperties.APPURL);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Help[\\s\\S]*$"));
		
		driver.findElement(By.linkText("Help")).click();
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Lorem ipsum dolor sit amet?[\\s\\S]*$"));
	}
	
}
