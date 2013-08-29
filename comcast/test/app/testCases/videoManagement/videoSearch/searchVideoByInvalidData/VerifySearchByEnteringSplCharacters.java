package comcast.test.app.testCases.videoManagement.videoSearch.searchVideoByInvalidData;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import comcast.test.config.configServices.DataServiceProperties;
import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.app.common.userManagement.userLogin.common.UserLoginFunctions;

/**
 * Class Name: VerifySearchByEnteringSplCharacters 
 * Description: This test case is used to validate whether search channel store 
 * working  for special characters by logging registered user into Comcast
 * application.
 * **/

public class VerifySearchByEnteringSplCharacters extends BaseTest{
 
  UserLoginFunctions userLogin=new UserLoginFunctions();
 
  @Test
  public void testVerifySearchByEnteringSplCharacters() throws Exception 
  {
	driver.get(DataServiceProperties.APPURL);
	
	//This method is used to enter user name and password credential
	userLogin.UserLoginCredentials(driver);
    
	driver.findElement(By.id("user_login")).click();
	
    driver.findElement(By.id("search-query")).clear();
    driver.findElement(By.id("search-query")).sendKeys(DataServiceProperties._SEARCH_VIDEO_BY);
    
    driver.findElement(By.id("go-search")).click();
    
    Thread.sleep(sleepTime);
    
    try {
      assertTrue(isElementPresent(By.linkText("Norcal Publishing")));
    } 
    catch (Error e) 
    {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Sign out")).click();
  }

  private boolean isElementPresent(By by) 
  {
    try 
    {
      driver.findElement(by);
      return true;
    } 
    catch (NoSuchElementException e) 
    {
      return false;
    }
  }
}
