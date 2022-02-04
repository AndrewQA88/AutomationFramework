package Utils;

import configs.ResourceBundleFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;


public class Waiters {

    private static final Logger LOG = Logger.getLogger(Waiters.class);

    public static void waitUntilPresent(WebDriver driver, WebElement element, int timeoutInSeconds, int pollingInSeconds) {
        LOG.info("Fluent waiter is waiting " + timeoutInSeconds + " sec for element and polling every " +
                pollingInSeconds + " sec.");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingInSeconds))
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is not found on page.");
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitAndRefreshUntilPresent(WebDriver driver, WebElement element, int timeoutInSeconds, int pollingInSeconds) {
        LOG.info("Fluent waiter is waiting " + timeoutInSeconds + " sec for element and polling every " +
                pollingInSeconds + " sec.");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingInSeconds))
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is not found on page.");

        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                driver.navigate().refresh();
                return element.isDisplayed();
            }
        });
    }

    public static int getExplicitlyWaitTimeOutInSeconds(){
        return Integer.parseInt(ResourceBundleFileReader.getProperty("explicitlyWaitTimeOut"));
    }

    public static int getPollingInSeconds(){
        return Integer.parseInt(ResourceBundleFileReader.getProperty("pollingInSeconds"));
    }
}


