package comcast.test.testSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationUsingDigits;
import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationUsingInValidPassword;
import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationUsingInValidUserName;
import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationUsingJavaScript;
import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationUsingSQLKeyWords;
import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationUsingSQLStatement;
import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationUsingSpecialCharacters;
import comcast.test.app.testCases.userManagement.userLogin.ValidateUserLoginUsingInValidCredentials.LoginToXidioApplicationWithInValidCredentials;
import comcast.test.config.configServices.utils.TestDataGenerator;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    LoginToXidioApplicationUsingInValidUserName.class,
    LoginToXidioApplicationUsingInValidPassword.class,
    LoginToXidioApplicationWithInValidCredentials.class,
	LoginToXidioApplicationUsingDigits.class,
	LoginToXidioApplicationUsingJavaScript.class,
	LoginToXidioApplicationUsingSpecialCharacters.class,
	LoginToXidioApplicationUsingSQLKeyWords.class,
	LoginToXidioApplicationUsingSQLStatement.class
})
public class runATFRegression {
	
    @AfterClass
    public static void tearDown() throws FileNotFoundException, IOException, InterruptedException {
		// Changes the browser for multiple browser execution.
		// @Note: Comment if single browser
		TestDataGenerator.ChangeBrowser();
    }
}
