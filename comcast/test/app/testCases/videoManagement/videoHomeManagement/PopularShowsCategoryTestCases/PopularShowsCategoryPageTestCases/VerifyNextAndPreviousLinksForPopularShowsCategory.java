package comcast.test.app.testCases.videoManagement.videoHomeManagement.PopularShowsCategoryTestCases.PopularShowsCategoryPageTestCases;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: VerifyNextAndPreviousLinksForPopularShowsCategory
 * Description: This test case validates whether previous and next links present under Popular Shows section
 * works fine in Home page by logging registered user into Comcast application.
 * **/

public class VerifyNextAndPreviousLinksForPopularShowsCategory extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	  
	 @Test
	  public void testVerifyNextAndPrevoisLinksForPopularShowsCategory() throws Exception {
		 
		/* This Method is to register new user using Comcast application 
		* and to change a password. 
		*/
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
	
		driver.findElement(By.linkText("HOME")).click();

		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Popular Shows[\\s\\S]*$"));
	    
	    boolean present;
	    int count=0;
	     do{
	    	try {
	 	    	driver.findElement(By.xpath(".//*[@id='next_popular_shows']/span"));
	 	    	present = true;
	 	    	count++;
	 	    	} 
	    	catch (NoSuchElementException e) {
	 	    		present = false;
	 	        }
		    if(present==true)
	    	driver.findElement(By.xpath(".//*[@id='next_popular_shows']/span")).click();
	     }
	    while(present == true && count<2);
 	
	     do{
		    try {
		 	     driver.findElement(By.xpath(".//*[@id='prev_popular_shows']/span"));
		 	     present = true;
		 	     count++;
		 	    } catch (NoSuchElementException e) {
		 	    		present = false;
		 	    }
			    if(present==true)
			    	driver.findElement( By.xpath(".//*[@id='prev_popular_shows']/span") ).click();
		    }
		    while(present == true && count<2);
	     
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("Sign out")).click();
	 }
}
