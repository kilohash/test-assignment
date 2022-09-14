package pages;

import com.project.ui_tests.TestData;
import org.openqa.selenium.support.ui.Select;
import utils.Log4Test;


public class SignupPage extends GeneralPage {

    private String URL = "https://www.blueworkslive.com/signup/trial";
    private Select country;

    public boolean isOpened() {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void fillRegistationForm() {
        Log4Test.info("Starting to fill registration form");
        waitForPageLoaded(webDriver);
        Log4Test.info("Filling in the company name");
        elementIsLocated(getLocator("companyName")).sendKeys(TestData.companyName);
        Log4Test.info("Filling in the first name");
        elementIsLocated(getLocator("firstName")).sendKeys(TestData.firstName);
        Log4Test.info("Filling in the last name");
        elementIsLocated(getLocator("lastName")).sendKeys(TestData.lastName);
        Log4Test.info("Filling in the email address");
        elementIsLocated(getLocator("email")).sendKeys(TestData.email);
        Log4Test.info("Filling in the phone number");
        elementIsLocated(getLocator("phone")).sendKeys(TestData.phone);
        Log4Test.info("Filling in the job title");
        elementIsLocated(getLocator("jobTitle")).sendKeys(TestData.jobTitle);
        Log4Test.info("Selecting country or region");
        country = new Select(elementIsLocated(getLocator("countryOrRegion")));
        country.selectByValue(TestData.countryOrRegion);
        Log4Test.info("Accepting the Agreement and Terms");
        elementIsLocated(getLocator("acceptAgreementSaaS")).click();
        elementIsLocated(getLocator("acceptTermsBlueworks")).click();
        Log4Test.info("Finished filing in the required info");
    }

    public void submitRegInfo() {
        Log4Test.info("Submitting the provided information");
        elementIsLocated(getLocator("submitButton")).click();
        elementIsLocated(getLocator("createAccountButton")).click();
    }

}

