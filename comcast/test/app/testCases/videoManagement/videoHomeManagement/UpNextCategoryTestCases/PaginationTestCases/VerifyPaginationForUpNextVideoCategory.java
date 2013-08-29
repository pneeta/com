package comcast.test.app.testCases.videoManagement.videoHomeManagement.UpNextCategoryTestCases.PaginationTestCases;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;

/**
 * Class Name: VerifyPaginationForUpNextVideoCategory
 * Description: This test case validates whether pagination feature under Up Next section 
 * works fine in Home page by logging registered user into Comcast application.
 * **/

public class VerifyPaginationForUpNextVideoCategory extends BaseTest{
	
	 RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	  
	 @Test
	 public void testVerifyPaginationForUpNextVideoCategory() throws Exception {
		 
		/* This Method is to register new user using Comcast application 
		* and to change a password. 
		*/
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);

		Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Up Next[\\s\\S]*$"));
	    
	    boolean present;
	    int count=0;
	    int page=2;
	     do{
	    	try {
	 	    	present=driver.findElements(By.xpath(".//*[@id='pagination_up_next']/a["+page+"]")).size()>0;
	 	    	count++;
	 	    	} catch (NoSuchElementException e) {
	 	    		present = false;
	 	    }
		    if(present==true)
	    	driver.findElement(By.xpath(".//*[@id='pagination_up_next']/a["+page+"]")).click();
		    page++;
	    }
	    while(present == true && count<4);
 	
	     do{
		    	try {
		    		present=driver.findElements(By.xpath(".//*[@id='pagination_up_next']/a["+page+"]")).size()>0;
		 	    	count++;
		 	    	} catch (NoSuchElementException e) {
		 	    		present = false;
		 	    }
			    if(present==true)
			    	driver.findElement( By.xpath(".//*[@id='pagination_up_next']/a["+page+"]") ).click();
			    page--;
		    }
		    while(present == true && count>=1);
	     
	    Thread.sleep(sleepTime);
	    driver.findElement(By.linkText("Sign out")).click();
	    
	 }
}
