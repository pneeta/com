package comcast.test.config.dataServices.userRegistration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/** 
 * Class Name: UserRegistrationUsingComcast
 *  Description: This DataService Registers new user using Comcast application
 *  @param <driver>: Native browser driver
 **/

public class UserRegistrationUsingComcast extends BaseTest{
	
	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
  
	@Test
	public void testUserRegistrationUsingComcast(WebDriver driver) throws Exception 
	{	
		driver.get(DataServiceProperties.APPURL);
		
		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Register")).click();
	    
	    //This method is user to enter registration fields details
	    userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);
	   	    
	    driver.findElement(By.name("terms_conditions")).click();
	    
	    driver.findElement(By.linkText("Submit")).click();
	    
	    //This method is user to enter Credit Card field Details 
	    
	    //Below code is committed because currently it has been removed from Application.
	    /* userRegFun.CreditCardDetials(driver,DataServiceProperties._CC_NUMBER,DataServiceProperties._CC_EXPIRY_MONTH,DataServiceProperties._CC_SECURITY_CODE,DataServiceProperties._CC_PIN_CODE);;;
	    
	    driver.findElement(By.cssSelector("a.btn.submit")).click();
	    
	    driver.findElement(By.linkText("Skip activation, go to XIDIO")).click();

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));*/
	    
	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

	    driver.findElement(By.linkText("Sign out")).click();  
	}
}

