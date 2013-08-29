package comcast.test.config.configServices.utils;

/**
 * Company: Valtech
 * Author:
 * Description: Class include the methods
 * setUp(): Initiate the browser type.
 * tearDown(): Close/Quit the browser once test has run.
 * captureScreenshot(): Capture the application screenshot.
 */

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {

	public static WebDriver driver;
	public String baseUrl;
	public StringBuffer verificationErrors = new StringBuffer();
	public long sleepTime=2500;
	public long sleepTimeForVideoPlay=30000;
	
	/**
	 * Method Name: setUp
	 * Description: Initiate the respective browser which is set at
	 * "data.properties" file.
	 */
	@Before
	public void setUp() throws Exception {

		TestDataGenerator proUtil = new TestDataGenerator();
		  proUtil.load(new FileInputStream(new File("com/data.properties")));
		  //String Browser = DataServiceProperties.BROWSER;
		  String Browser = proUtil.getProperty("BROWSER");
		
		if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		} else if (Browser.equalsIgnoreCase("InternetExplorer")){
			System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			//System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver=new ChromeDriver();

		} else if (Browser.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else
			driver = new FirefoxDriver();
		
		//driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Method Name: tearDown
	 * Description: Quit the browser instance once the test case/test scenario
	 * has finished.
	 */
	@After
	public void tearDown() throws Exception {
		// refresh the browser.
		//driver.navigate().refresh();
				
		// Quit the initiated browser.
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
			
			TestDataGenerator proUtil = new TestDataGenerator();
			proUtil.setProperty("BROWSER", "firefox");
			proUtil.store(new FileOutputStream(new File(
					"com/data.properties")), null);
		}

		// Changes the browser for multiple browser execution.
		// @Note: Comment if single browser
		//TestDataGenerator.ChangeBrowser();
	}

	/**
	 * Method: captureScreenshot
	 * Description:Capture the screenshot of the application at runtime and stores at "screenshots"
	 * folder with className/timeStamp.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void captureScreenshot() throws IOException, InterruptedException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		DateFormat stringDate = new SimpleDateFormat("ddMMyyhhmmss");
		String cdate = stringDate.format(date);
		String ClassName = this.getClass().getName();

		String c = getClass().getName(); // prints Package name + class name.
		String d = getClass().getSimpleName(); // prints only class name.
		String e = getClass().getCanonicalName(); // prints Package name + class name.

		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

		FileUtils.copyFile(scrFile, new File("./screenshots\\" + ClassName
				+ "_" + cdate + ".jpg"));
		Thread.sleep(2000);
	}
	
	public boolean captureScreen(String fileName) throws IOException, AWTException
	{
		Robot robot = new Robot();

		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		return ImageIO.write(screenShot, "JPG", new File(fileName));
	}
}
