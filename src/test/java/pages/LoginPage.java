package pages;

import com.project.ui_tests.TestData;
import org.openqa.selenium.Keys;
import utils.Log4Test;


public class LoginPage extends GeneralPage {

    private String URL = "https://www.blueworkslive.com/signup/login";

    public boolean isOpened() {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void fillLoginForm() {
        Log4Test.info("Filling in login credentials");
        elementIsLocated(getLocator("loginEmail")).sendKeys(TestData.emailLogin);
        elementIsLocated(getLocator("loginPassword")).sendKeys(TestData.emailLoginPass, Keys.RETURN);
        Log4Test.info("Logging in");
    }

}