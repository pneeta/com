package comcast.test.app.common.userManagement.userLogin.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import comcast.test.config.configServices.utils.TestDataGenerator;

/**
 * Class Name: UserLoginFunctions
 * Description: This class provides login module function.
 */
public class UserLoginFunctions {

	TestDataGenerator proUtil = new TestDataGenerator();
	
	/**
	 * Method: UserLoginCredentials
	 * Description: This method is used to login into comcast application.
	 * @param driver: Native browser driver.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void UserLoginCredentials(WebDriver driver) throws FileNotFoundException, IOException
	{
		proUtil.load(new FileInputStream(new File("com/data.properties")));
		String userName=proUtil.getProperty("USER_NAME");
		String regPassword=proUtil.getProperty("REG_PASSWORD");
		
		driver.findElement(By.name("user[user_name]")).clear();
	    driver.findElement(By.name("user[user_name]")).sendKeys(userName);
	    driver.findElement(By.name("user[password]")).clear();
	    driver.findElement(By.name("user[password]")).sendKeys(regPassword);
	    
	}
	
	/**
	 * Method: ChangePassword
	 * Description: This method is used to change password.
	 * @param driver: Native browser driver.
	 */
	public void ChangePassword(WebDriver driver,String password, String regPassword, String confPassword)
	{
	    /*driver.findElement(By.name("old_password")).clear();
	    driver.findElement(By.name("old_password")).sendKeys(password);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(regPassword);
	    driver.findElement(By.name("confirm_password")).clear();
	    driver.findElement(By.name("confirm_password")).sendKeys(confPassword);*/
	}
	
	public void ChangePasswordFromPM(WebDriver driver,String password, String regPassword, String confPassword)
	{
		driver.findElement(By.name("old_password")).clear();
	    driver.findElement(By.name("old_password")).sendKeys(password);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(regPassword);
	    driver.findElement(By.name("confirm_password")).clear();
	    driver.findElement(By.name("confirm_password")).sendKeys(confPassword);
	}
}
