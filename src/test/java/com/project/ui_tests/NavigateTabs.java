package com.project.ui_tests;

import pages.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class NavigateTabs extends GeneralPage {
    HomePage homePage = new HomePage();
    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void setUpPreconditions() {
        homePage.open(TestData.blueworkslive_URL);
        assertTrue(homePage.isOpened(TestData.blueworkslive_URL));
        homePage.goToLoginPage();
        loginPage.isOpened();
        loginPage.waitForPageLoaded(webDriver);
        loginPage.fillLoginForm();
    }

    @Test(dependsOnMethods = {"setUpPreconditions"})

    public void NavigateTabsAndMeasureResponse() {
        accountPage.isOpened();
        accountPage.waitForPageLoaded(webDriver);
        accountPage.closePopup();
        accountPage.navigateTabsAndMeasure();
    }

}