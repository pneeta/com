package comcast.test.app.testCases.videoManagement.videoHomeManagement.UpNextCategoryTestCases.PaginationTestCases;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: VerifyNextAndPreviousLinksForUpNextVideoCategory
 * Description: This test case validates whether previous and next links present under Up Next section
 * works fine in Home page by logging registered user into Comcast application.
 * **/

public class VerifyNextAndPreviousLinksForUpNextVideoCategory extends BaseTest{
	
	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	  
	 @Test
	  public void testVerifyNextAndPrevoisLinksForUpNext() throws Exception {
		 
		/* This Method is to register new user using Comcast application 
		* and to change a password. 
		*/
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Up Next[\\s\\S]*$"));
	    
	    boolean present;
	    int count=0;
	     do{
	    	try {
	 	    	driver.findElement(By.xpath(".//*[@id='next_up_next']/span"));
	 	    	present = true;
	 	    	count++;
	 	    	} catch (NoSuchElementException e) {
	 	    		present = false;
	 	    }
		    if(present==true)
	    	driver.findElement(By.xpath(".//*[@id='next_up_next']/span")).click();
		    Thread.sleep(sleepTime);
	    }
	    while(present == true && count<3);
 	
	     do{
		    	try {
		 	    	driver.findElement(By.xpath(".//*[@id='prev_up_next']/span"));
		 	    	present = true;
		 	    	count--;
		 	    	} catch (NoSuchElementException e) {
		 	    		present = false;
		 	    }
			    if(present==true)
			    	driver.findElement( By.xpath(".//*[@id='prev_up_next']/span") ).click();
			    Thread.sleep(sleepTime);
		    }
		    while(present == true && count>0);
	     
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("Sign out")).click();
	    
	 }
}
