package pages;

import utils.Log4Test;


public class HomePage extends GeneralPage {

    public void open(String URL) {

        webDriver.get(URL);

        Log4Test.info("Opening " + URL);
    }

    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void goToSignupPage() {
        Log4Test.info("Starting the sign up procedure...");
        waitForPageLoaded(webDriver);
        elementIsLocated(getLocator("signupPage")).click();
    }

    public void goToLoginPage() {
        Log4Test.info("Starting the login procedure...");
        waitForPageLoaded(webDriver);
        elementIsLocated(getLocator("loginPage")).click();
    }

}