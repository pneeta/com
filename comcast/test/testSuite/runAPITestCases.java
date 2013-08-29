package comcast.test.testSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comcast.test.app.testCases.userManagement.profileManagement.RegisteredUserTestCasesForChangePassword.ValidateCurrentUserPassWhileChangingPass.ValidateCurrentPasswordWhenChangingPassword;
import comcast.test.app.testCases.userManagement.userRegistration.UserRegistrationTestCasesForFirstName.UserRegWithNoFirstName.RegisterToXidioApplicationWithoutEnteringFirstName;
import comcast.test.config.configServices.utils.TestDataGenerator;
import comcast.test.restAPI.restAPITestCaseToVerifyRowShowAndVideos;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	restAPITestCaseToVerifyRowShowAndVideos.class
	
})
public class runAPITestCases {
	
    @AfterClass
    public static void tearDown() throws FileNotFoundException, IOException, InterruptedException {
		// Changes the browser for multiple browser execution.
		// @Note: Comment if single browser
		TestDataGenerator.ChangeBrowser();
    }
}
