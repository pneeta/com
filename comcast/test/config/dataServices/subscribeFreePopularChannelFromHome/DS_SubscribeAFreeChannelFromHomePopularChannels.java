package comcast.test.config.dataServices.subscribeFreePopularChannelFromHome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;

import comcast.test.config.configServices.utils.BaseTest;
import comcast.test.config.configServices.utils.restAPIServices;
import comcast.test.config.dataServices.registerToXidioApplicationAndChangeAPassword.RegisterToXidioApplicationAndChangeAPassword;
import comcast.test.config.dataServices.vo.VideoDetails;

public class DS_SubscribeAFreeChannelFromHomePopularChannels extends BaseTest{

	RegisterToXidioApplicationAndChangeAPassword RegUserAndChangePass=new RegisterToXidioApplicationAndChangeAPassword();
	@Test
	public void RegisterAndSubscribeAFreeChannelFromHomePopularChannels() throws Exception {
		
		Map<String, List<VideoDetails>> videoDetails=restAPIServices.HomePopularChannelDetailsAPIs();
		List<VideoDetails> showList=videoDetails.get("show");
		
		/* This Method is to register new user using Comcast application 
		* and to change a password. 
		*/
		RegUserAndChangePass.RegisterToComcastAppAndChangePassword(driver);
		
		Thread.sleep(sleepTime);
	    driver.findElement(By.linkText(showList.get(0).getTitle())).click();

	    Thread.sleep(sleepTime);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+showList.get(0).getTitle()+"[\\s\\S]*$"));

	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Free[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("a.subscribe > span.translation_missing")).click();
	    
	    driver.findElement(By.cssSelector("fieldset > input[type=\"submit\"]")).click();
	    
	    Thread.sleep(sleepTime);
	    assertEquals("You have been subscribed.", driver.findElement(By.xpath(".//*[@id='cluetip']/div[1]/div/div[2]/div")).getText());
	    
	    driver.findElement(By.linkText("Sign out")).click();
	  }
}
