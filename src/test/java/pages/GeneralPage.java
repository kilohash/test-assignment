package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.Properties;
import static org.testng.AssertJUnit.assertFalse;


public class GeneralPage extends core.TestBase {

    protected WebElement elementIsLocated(By element)

    {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (NoSuchElementException ele) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
    }


    public void waitForPageLoaded(WebDriver driver)

    {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        try {
            wait.until(expectation);
        } catch (Throwable error) {
            assertFalse("Timeout waiting for Page Load Request to complete.", true);
        }
    }

    public By getLocator(String logicalElementName)

    {
        Properties properties = new Properties();

        try {
            properties.load(GeneralPage.class.getResourceAsStream("/object.map.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String locator = properties.getProperty(logicalElementName);

        String locatorType = locator.split(">")[0];

        String locatorValue = locator.split(">")[1];

        if (locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);

        else if ((locatorType.toLowerCase().equals("classname")) ||
                (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);

        else if ((locatorType.toLowerCase().equals("cssselector")) ||
                (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);

        else if (locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);

        else
            try {
                throw new Exception("Locator type '" + locatorType + "' not defined!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

}