package comcast.test.app.testCases.videoManagement.videoStoreManagement.StorePageTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/** 
 * Class Name: EnsureStoreIsSelectedAsDefault
 * Description: This test case is to verify that 'Store' is selected as default
 * by logging into Comcast application.
 */

public class EnsureStoreIsSelectedAsDefault extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
 
    @Test
    public void testEnsureStoreIsSelectedAsDefault() throws Exception {
	  
		/* This Method is to register new user using Comcast application 
		 * and to change a password. 
		 */
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		    
		assertEquals("Featured",driver.findElement(By.xpath(".//*[@id='featured']/section/header/h1")).getText());
	    
		assertEquals("Popular",driver.findElement(By.xpath(".//*[@id='popular_channels']/section/header/h1")).getText());
		
	    driver.findElement(By.linkText("Sign out")).click();
    }
}
