package com.project.ui_tests;

import pages.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class Login extends GeneralPage {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void setUpPreconditions() {
        homePage.open(TestData.blueworkslive_URL);
        assertTrue(homePage.isOpened(TestData.blueworkslive_URL));
    }

    @Test(dependsOnMethods = {"setUpPreconditions"})

    public void LoginAndLogout() {
        homePage.waitForPageLoaded(webDriver);
        homePage.goToLoginPage();
        loginPage.isOpened();
        loginPage.waitForPageLoaded(webDriver);
        loginPage.fillLoginForm();
        accountPage.isOpened();
        accountPage.waitForPageLoaded(webDriver);
        accountPage.closePopup();
        accountPage.logout();
    }

}
