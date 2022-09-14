package core;

import com.project.ui_tests.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Log4Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    @BeforeSuite
    public static void setUp() throws IOException

    {
        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);

        wait = new WebDriverWait(webDriver, 60);

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(180, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown()

    {
        Log4Test.info("Test run finished. Quitting");
        webDriver.quit();
    }

}