package comcast.test.app.common.userManagement.userLogin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** 
 * Class Name: LoginFunctions
 * Description: This calss provides all login module function. 
 * in Comcast application
 * **/
public class LoginFunctions {

	  /**
      * Method Name: LoginToXidioApplication
      * Description: Enter Invaliad UserName and Password.
      * @param driver: Native browser driver
      * @param userName: Comcast application user name
      * @param password: Comcast application password
      */
     public void LoginToXidioApplication(WebDriver driver,String userName,String password) 
     {
         driver.findElement(By.name("user[user_name]")).clear();
         driver.findElement(By.name("user[user_name]")).sendKeys(userName);
         driver.findElement(By.name("user[password]")).clear();
         driver.findElement(By.name("user[password]")).sendKeys(password);
     }
}
