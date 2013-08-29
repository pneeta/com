package comcast.test.app.common.userManagement.userRegistration.common;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.TestDataGenerator;

/**
 * Class Name: UserRegistrationValidationFuncitons 
 * Description: This class file provides all Registration field related function.
 **/
public class UserRegistrationValidationFuncitons extends BaseTest{
	
	/**
	* Method: validateFirstName
	* Description: This method is used to validate First Name field
	* in registration page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void validateUserRegistrationFields(WebDriver driver,String firstName,String lastName,String address,String city,String state,String zipcode,String regPass) throws FileNotFoundException, IOException, InterruptedException
	{	
		TestDataGenerator.modifyDataProperties();
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
	    driver.findElement(By.name("user[mobile_number]")).clear();
	    driver.findElement(By.name("user[mobile_number]")).sendKeys(String.valueOf(TestDataGenerator.mobileNumber));
	    driver.findElement(By.name("user[password]")).clear();
	    driver.findElement(By.name("user[password]")).sendKeys(regPass);
	    driver.findElement(By.id("terms_conditions")).click();
	    Thread.sleep(sleepTime);
	}


	/**
	* Method: validateEmail
	* Description: This method is used to validate Email Id field
	* in registration page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void validateEmail(WebDriver driver,String firstName,String lastName,String address,String city,String state,String zipcode,String regPass) throws FileNotFoundException, IOException, InterruptedException
	{	
		TestDataGenerator.modifyDataProperties();
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
	    driver.findElement(By.name("user[mobile_number]")).clear();
	    driver.findElement(By.name("user[mobile_number]")).sendKeys(String.valueOf(TestDataGenerator.mobileNumber));
	    driver.findElement(By.name("user[password]")).clear();
	    driver.findElement(By.name("user[password]")).sendKeys(regPass);
	    driver.findElement(By.id("terms_conditions")).click();
	    Thread.sleep(sleepTime);
	}
	
	/**
	* Method: validateMobileNumber
	* Description: This method is used to validate Mobile Number field
	* in registration page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void validateMobileNumber(WebDriver driver,String firstName,String lastName,String address,String city,String state,String zipcode,String regPass) throws FileNotFoundException, IOException, InterruptedException
	{	
		TestDataGenerator.modifyDataProperties();
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
	    driver.findElement(By.name("user[password]")).clear();
	    driver.findElement(By.name("user[password]")).sendKeys(regPass);
	    driver.findElement(By.id("terms_conditions")).click();
	    Thread.sleep(sleepTime);
	}
	
	/**
	* Method: validateInvalidMobileNumber
	* Description: This method is used to validate Invalid mobile number
	* in registration page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void validateInvalidMobileNumber(WebDriver driver,String firstName,String lastName,String address,String city,String state,String zipcode,String mobileNumber,String regPass) throws InterruptedException, FileNotFoundException, IOException
	{	
		TestDataGenerator.modifyDataProperties();
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
	    driver.findElement(By.name("user[mobile_number]")).clear();
	    driver.findElement(By.name("user[mobile_number]")).sendKeys(mobileNumber);
	    driver.findElement(By.name("user[password]")).clear();
	    driver.findElement(By.name("user[password]")).sendKeys(regPass);
	    driver.findElement(By.id("terms_conditions")).click();
	    Thread.sleep(sleepTime);
	}
	
	/**
	* Method: validateInvalidZipEmail
	* Description: This method is used to validate Invalid Email
	* in registration page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void validateInvalidEmail(WebDriver driver,String firstName,String lastName,String address,String city,String state,String zipcode,String emailId,String regPass) throws InterruptedException, FileNotFoundException, IOException
	{		
		TestDataGenerator.modifyDataProperties();
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
	    driver.findElement(By.name("user[email]")).sendKeys(emailId);
	    driver.findElement(By.name("user[mobile_number]")).clear();
	    driver.findElement(By.name("user[mobile_number]")).sendKeys(String.valueOf(TestDataGenerator.mobileNumber));
	    driver.findElement(By.name("user[password]")).clear();
	    driver.findElement(By.name("user[password]")).sendKeys(regPass);
	    driver.findElement(By.id("terms_conditions")).click();
	    Thread.sleep(sleepTime);
	}
	
	/**
	* Method: UpdateCCDetials
	* Description: This method is used to update credit card details
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void UpdateCCDetials(WebDriver driver,String ccNumber,String ccExpiryMonth,String ccYear,String ccPincode) throws FileNotFoundException, IOException, InterruptedException
	{	
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(ccNumber);
	    new Select(driver.findElement(By.name("user[cc_expiration_month]"))).selectByVisibleText(ccExpiryMonth);
	    new Select(driver.findElement(By.name("user[cc_expiration_year]"))).selectByVisibleText(ccYear);
	    
	    //Below line are committed because of Requirement change.
	    /*driver.findElement(By.name("user[cc_expiration_month]")).sendKeys(ccExpiryMonth);
	    driver.findElement(By.name("user[cc_expiration_year]")).clear();
	    driver.findElement(By.name("user[cc_expiration_year]")).sendKeys(ccYear);*/
	    
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(ccPincode);
	}
	
	/**
	* Method: ValidateCreditCardNumberMandatoryField
	* Description: This method is used to valildate Credit Card number mandatory field
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void ValidateCreditCardNumberMandatoryField(WebDriver driver,String ccExpiryMonth,String ccYear,String ccSecurityCode,String ccPincode) throws FileNotFoundException, IOException, InterruptedException
	{		
		new Select(driver.findElement(By.name("user[cc_expiration_month]"))).selectByVisibleText(ccExpiryMonth);
	    driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
	    new Select(driver.findElement(By.name("user[cc_expiration_year]"))).selectByVisibleText(ccYear);
	    driver.findElement(By.cssSelector("option[value=\"2019\"]")).click();
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(ccSecurityCode);
	    driver.findElement(By.name("user[cc_pin_code]")).clear();
	    driver.findElement(By.name("user[cc_pin_code]")).sendKeys(ccPincode);
	}
	
	/**
	* Method: ValidateSecurityCodeMandatoryField
	* Description: This method is used to valildate Security code mandatory field
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void ValidateSecurityCodeMandatoryField(WebDriver driver,String ccNumber, String ccPinCode) throws FileNotFoundException, IOException, InterruptedException
	{	
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(ccNumber);
	    /*new Select(driver.findElement(By.name("user[cc_expiration_month]"))).selectByVisibleText(DataServiceProperties._CC_EXPIRY_MONTH);
	    driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
	    new Select(driver.findElement(By.name("user[cc_expiration_year]"))).selectByVisibleText(DataServiceProperties._CC_YEAR);
	    driver.findElement(By.cssSelector("option[value=\"2019\"]")).click();*/
	    driver.findElement(By.name("user[cc_pin_code]")).clear();
	    driver.findElement(By.name("user[cc_pin_code]")).sendKeys(ccPinCode);
	}
	
	/**
	* Method: ValidateInvalidSecurityCodeNumber
	* Description: This method is used to valildate Invalid Security code
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void ValidateInvalidSecurityCodeNumber(WebDriver driver,String ccNumber,String ccInvalidSecCode,String ccPincode) throws FileNotFoundException, IOException, InterruptedException
	{	
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(ccNumber);
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(ccInvalidSecCode);
	    driver.findElement(By.name("user[cc_pin_code]")).clear();
	    driver.findElement(By.name("user[cc_pin_code]")).sendKeys(ccPincode);
	}
	
	/**
	* Method: ValidateInvalidPinCodeCharLength
	* Description: This method is used to valildate Invalid pin code length
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void ValidateInvalidPinCodeCharLength(WebDriver driver,String ccNumber,String ccSecurityCode,String ccInvalidPincode) throws FileNotFoundException, IOException, InterruptedException
	{	
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(ccNumber);
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(ccSecurityCode);
	    driver.findElement(By.name("user[cc_pin_code]")).clear();
	    driver.findElement(By.name("user[cc_pin_code]")).sendKeys(ccInvalidPincode);
	}
	
	/**
	* Method: ValidateSecurityCodeLength
	* Description: This method is used to valildate Security code length
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void ValidateSecurityCodeLength(WebDriver driver,String ccNumber,String ccExpiryMonth,String ccYear,String ccInvalidSecurityCode,String ccPincode) throws FileNotFoundException, IOException, InterruptedException
	{	
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(ccNumber);
	    new Select(driver.findElement(By.name("user[cc_expiration_month]"))).selectByVisibleText(ccExpiryMonth);
	    driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
	    new Select(driver.findElement(By.name("user[cc_expiration_year]"))).selectByVisibleText(ccYear);
	    driver.findElement(By.cssSelector("option[value=\"2019\"]")).click();
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(ccInvalidSecurityCode);
	    driver.findElement(By.name("user[cc_pin_code]")).clear();
	    driver.findElement(By.name("user[cc_pin_code]")).sendKeys(ccPincode);
	}

	/**
	* Method: ValidatePinCodeMandatoryField
	* Description: This method is used to valildate pin code mandatory field
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void ValidatePinCodeMandatoryField(WebDriver driver,String ccNumber, String ccSecurityCode) throws FileNotFoundException, IOException, InterruptedException
	{	
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(ccNumber);
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(ccSecurityCode);
	}
	
	/**
	* Method: ValidateInvalidCreditCardNumber
	* Description: This method is used to valildate Invalid Credit Card number
	* in registration credit card details page using Comcast Application.
	* @param driver: Native browser driver
	**/
	public void ValidateInvalidCreditCardNumber(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException
	{	
		driver.findElement(By.name("user[cc_number]")).clear();
	    driver.findElement(By.name("user[cc_number]")).sendKeys(DataServiceProperties._INVALID_CC_NUMBER);
	    new Select(driver.findElement(By.name("user[cc_expiration_month]"))).selectByVisibleText(DataServiceProperties._CC_EXPIRY_MONTH);
	    driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
	    new Select(driver.findElement(By.name("user[cc_expiration_year]"))).selectByVisibleText(DataServiceProperties._CC_YEAR);
	    driver.findElement(By.cssSelector("option[value=\"2019\"]")).click();
	    driver.findElement(By.name("user[cc_security_code]")).clear();
	    driver.findElement(By.name("user[cc_security_code]")).sendKeys(DataServiceProperties._CC_SECURITY_CODE);
	    driver.findElement(By.name("user[cc_pin_code]")).clear();
	    driver.findElement(By.name("user[cc_pin_code]")).sendKeys(DataServiceProperties._CC_PIN_CODE);
	}
}
