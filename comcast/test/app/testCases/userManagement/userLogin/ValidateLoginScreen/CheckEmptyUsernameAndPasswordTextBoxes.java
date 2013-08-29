package comcast.test.app.testCases.userManagement.userLogin.ValidateLoginScreen;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** 
 * Class Name: CheckEmptyUsernameAndPasswordTextBoxes
 * Description: This test case is used to validate empty Username and Password textboxes in camcast application.
 * **/

public class CheckEmptyUsernameAndPasswordTextBoxes extends BaseTest{
	
	@Test
	public void testToCheckEmptyUsernameAndPasswordTextBoxes() {
		
		driver.get(DataServiceProperties.APPURL);
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Username[\\s\\S]*$"));
		
		assertEquals("", driver.findElement(By.name("user[user_name]")).getAttribute("value"));
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Password[\\s\\S]*$"));
		
		assertEquals("", driver.findElement(By.name("user[password]")).getAttribute("value"));
		
		assertEquals("Log in", driver.findElement(By.id("user_login")).getText());
		
	}	
}
