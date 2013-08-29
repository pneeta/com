package comcast.test.app.common.userManagement.userRegistration.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;

/**
 * Class Name: UserRegistrationUsingComcast 
 * Description: This test case allows the user to register into Comcast application including
 * credit card details.
 **/

public class UserRegistrationFunction extends BaseTest{
	TestDataGenerator proUtil=new TestDataGenerator();
	/**
	 * Method: CreditCardDetials
	 * Description: This method is user to enter all credit card detail fields
	 * in Comcast Application.
	 * @param driver: Native browser driver
	 * @param ccNumber
	 * @param ccExpiryMonth
	 * @param ccSecurityCode
	 * @param ccPincode
	 */
	public void CreditCardDetials(WebDriver driver, String ccNumber,String ccExpiryMonth,String ccSecurityCode,String ccPincode) throws FileNotFoundException, IOException, InterruptedException
	{
		//driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(ccNumber);
	    new Select(driver.findElement(By.name("user[cc_expiration_month]"))).selectByVisibleText(ccExpiryMonth);
	    driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(ccSecurityCode);
	    driver.findElement(By.name("user[cc_pin_code]")).clear();
	    driver.findElement(By.name("user[cc_pin_code]")).sendKeys(ccPincode);
	}
	
	/**
	* Method: RegistrationDetails
	* Description: This method is user to register new user in 
	* in Comcast Application.
	* @param driver: Native browser driver
	**/
	public void RegistrationDetails(WebDriver driver,String firstName,String lastName,String address,String city,String state,String zipcode,String regPass) throws FileNotFoundException, IOException, InterruptedException
	{
		TestDataGenerator.modifyDataProperties();
		proUtil.load(new FileInputStream(new File("com/data.properties")));
		
		driver.findElement(By.name("user[first_name]")).clear();
	    driver.findElement(By.name("user[first_name]")).sendKeys(firstName);
	    driver.findElement(By.name("user[last_name]")).clear();
	    driver.findElement(By.name("user[last_name]")).sendKeys(lastName);
	    driver.findElement(By.name("user[address]")).clear();
	    driver.findElement(By.name("user[address]")).sendKeys(address);
	    driver.findElement(By.name("user[city]")).clear();
	    driver.findElement(By.name("user[city]")).sendKeys(city);
	    new Select(driver.findElement(By.name("user[state]"))).selectByVisibleText(state);
	    driver.findElement(By.name("user[zip]")).clear();
	    driver.findElement(By.name("user[zip]")).sendKeys(zipcode);
	    driver.findElement(By.name("user[email]")).clear();
	    driver.findElement(By.name("user[email]")).sendKeys(TestDataGenerator.emailId);
	    System.out.println("Email ID : "+TestDataGenerator.emailId);
	    
	    /*Below commented lines is to generate New Mobile Number if
	     * the number is Invalid or if the number is already exists.
	    */
/*	    boolean isPresent;
	    do
	    {
	    	isPresent=false;
	    	long MobileNumber=TestDataGenerator.mobileNumber;
	    	driver.findElement(By.name("user[mobile_number]")).clear();
		    driver.findElement(By.name("user[mobile_number]")).sendKeys(String.valueOf(MobileNumber));
	    	driver.findElement(By.name("user[password]")).clear();
	 	    driver.findElement(By.name("user[password]")).sendKeys(regPass);
	 	    
	 	    Thread.sleep(sleepTime);
	 	  isPresent=driver.findElements(By.xpath(".//*[@id='step-0']/fieldset[8]/div[2]/label/label")).size()>0;
	 	  if(isPresent==true)
	 		 TestDataGenerator.generateNewMobileNumber();	 	  
	    }
	    while(isPresent);*/
	    
	    driver.findElement(By.name("user[mobile_number]")).clear();
	    driver.findElement(By.name("user[mobile_number]")).sendKeys(String.valueOf(TestDataGenerator.mobileNumber));
	    driver.findElement(By.name("user[password]")).clear();
	    driver.findElement(By.name("user[password]")).sendKeys(regPass);
	    
	    TestDataGenerator.updateRegPasswordToPasswordDataPropertiesFields();
	}
}

