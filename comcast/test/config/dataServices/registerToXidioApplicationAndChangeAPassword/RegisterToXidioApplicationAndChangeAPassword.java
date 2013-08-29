package comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.userRegistration.UserRegistrationUsingComcast;

/** 
 * Class Name: RegisterToXidioApplicationAndChangeAPassword
 *  Description: This DataService Registers new user using Comcast application
 *  and change the password
 *  @param <driver>: Native browser driver
 **/

public class RegisterToXidioApplicationAndChangeAPassword extends BaseTest{
	
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	
	@Test
	public void RegisterToComcastAppAndChangePassword(WebDriver driver) throws Exception 
	{	
		//This method is used to register new user into Comcast Application
		//userReg.testUserRegistrationUsingComcast(driver);
		
		driver.get(DataServiceProperties.APPURL);
		
		//This method is used to enter user name and password credential
		Thread.sleep(sleepTime);
		userLogin.UserLoginCredentials(driver);
		
		driver.findElement(By.id("user_login")).click();
		Thread.sleep(sleepTime);
		    
		//This method is used to Change Password
	    //userLogin.ChangePassword(driver,DataServiceProperties._PASSWORD,DataServiceProperties._RESET_PASSWORD,DataServiceProperties._CONFIRM_PASSWORD);
	    
	    //driver.findElement(By.name("commit")).click();
	}
}

