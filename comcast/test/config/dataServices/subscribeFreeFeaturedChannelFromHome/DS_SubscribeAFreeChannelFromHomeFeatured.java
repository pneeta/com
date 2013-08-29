package comcast.test.config.dataServices.subscribeFreeFeaturedChannelFromHome;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

public class DS_SubscribeAFreeChannelFromHomeFeatured extends BaseTest{

	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	@Test
	public void RegisterAndSubscribeAFreeChannelHomeFeatured() throws Exception {
		/* This Method is to register new user using Comcast application 
		* and to change a password. 
		*/
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		driver.findElement(By.linkText("HOME")).click();
		
	    driver.findElement(By.linkText("Trailer Mania")).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Trailer Mania[\\s\\S]*$"));

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Free[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("a.subscribe > span.translation_missing")).click();
	    
	    driver.findElement(By.cssSelector("fieldset > input[type=\"submit\"]")).click();
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You have been subscribed\\.[\\s\\S]*$"));

	    driver.findElement(By.linkText("Sign out")).click();
	  }
}
