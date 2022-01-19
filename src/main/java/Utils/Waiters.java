package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;


public class Waiters {

    public static final Logger log = Logger.getLogger("baseTest");

    public static void waitUntilPresent(WebDriver driver, int timeout, int polling) {
        log.info("Fluent waiter is working.");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is not found on page.");

        WebElement ToDoExpense = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                driver.navigate().refresh();
                return driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
            }
        });
    }
}


