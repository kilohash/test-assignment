package pages;

import com.project.ui_tests.TestData;
import org.apache.commons.lang3.time.StopWatch;
import utils.Log4Test;


public class AccountPage extends GeneralPage {

    private String URL = "https://ams001.blueworkslive.com/scr/home#!library:spaces.followed";
    StopWatch tabLoad = new StopWatch();

    public boolean isOpened() {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void closePopup() {
        elementIsLocated(getLocator("closePopupButton")).click();
        }

    public void navigateTabsAndMeasure() {
        tabLoad.start();
        elementIsLocated(getLocator("workTab")).click();
        waitForPageLoaded(webDriver);
        tabLoad.stop();
        Log4Test.info("Work tab load time: " + tabLoad.getTime() + " milliseconds");
        assert (tabLoad.getTime() <= TestData.expectedTabLoadTime);

        tabLoad.reset();
        tabLoad.start();
        elementIsLocated(getLocator("communityTab")).click();
        waitForPageLoaded(webDriver);
        tabLoad.stop();
        Log4Test.info("Community tab load time: " + tabLoad.getTime() + " milliseconds");
        assert (tabLoad.getTime() <= TestData.expectedTabLoadTime);

        tabLoad.reset();
        tabLoad.start();
        elementIsLocated(getLocator("libraryTab")).click();
        waitForPageLoaded(webDriver);
        tabLoad.stop();
        Log4Test.info("Library tab load time: " + tabLoad.getTime() + " milliseconds");
        assert (tabLoad.getTime() <= TestData.expectedTabLoadTime);
    }

    public void logout() {
        elementIsLocated(getLocator("logoutButton")).click();
        Log4Test.info("Logging out");
    }

}