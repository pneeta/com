package comcast.test.app.testCases.userManagement.userRegistration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.app.common.userManagement.userRegistration.common.UserRegistrationFunction;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;

/**  
 * Class Name: RegisterToXidioApplicationUsingValidCredentials
 * Description: This test case validates user registration functionality in the Comcast application.
 * **/

public class RegisterToXidioApplicationUsingValidCredentials extends BaseTest{
	
  UserRegistrationFunction userRegFun=new UserRegistrationFunction();
  UserLoginFunctions userLogin=new UserLoginFunctions();
	
  @Test
  public void testRegisterToXidioApplicationUsingValidCredentials() throws Exception {
	  
	driver.get(DataServiceProperties.APPURL);
	
	Thread.sleep(sleepTime);	
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Register")).click();
    
    //This method is used to register new user into Comcast Application
    userRegFun.RegistrationDetails(driver,DataServiceProperties._FIRST_NAME,DataServiceProperties._LAST_NAME,DataServiceProperties._ADDRESS,DataServiceProperties._CITY,DataServiceProperties._STATE,DataServiceProperties._ZIP,DataServiceProperties._REG_PASSWORD);    
      
    driver.findElement(By.name("terms_conditions")).click();
    
    driver.findElement(By.linkText("Submit")).click();

    Thread.sleep(sleepTime);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click(); 
    
       
  }
}