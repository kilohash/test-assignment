package com.project.ui_tests;

import pages.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class CreateAccount extends GeneralPage {
    HomePage homePage = new HomePage();
    SignupPage signupPage = new SignupPage();

    @Test
    public void setUpPreconditions() {
        homePage.open(TestData.blueworkslive_URL);
        assertTrue(homePage.isOpened(TestData.blueworkslive_URL));
    }

    @Test (dependsOnMethods = {"setUpPreconditions"})

    public void CreateNewAccount() {
        homePage.goToSignupPage();
        signupPage.isOpened();
        signupPage.fillRegistationForm();
        signupPage.submitRegInfo();
        assertTrue(elementIsLocated(getLocator("orderComplete")).isDisplayed());
    }

}