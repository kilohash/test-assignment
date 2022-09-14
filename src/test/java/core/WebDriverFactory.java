package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;


public class WebDriverFactory {

    public static WebDriver getWebDriver(BrowserTypes browserType) throws IOException {


        switch (browserType) {

            case FIRE_FOX:
                return new FirefoxDriver();

            case CHROME:
                return new ChromeDriver();

            case IE:
                return new InternetExplorerDriver();

            default:
                throw new IllegalArgumentException("Browser is not supported" + browserType);

        }
    }

}
