package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowHelper {

    private static final Logger LOG = Logger.getLogger(WindowHelper.class);

    public static void openNewTab(WebDriver driver, String pageUrl) {
        LOG.info("JS opens new window with URL: " + pageUrl);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.open('" + pageUrl + "');");
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public static void switchToTab(WebDriver driver) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}
