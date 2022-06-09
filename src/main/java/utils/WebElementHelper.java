package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.HttpURLConnection;
import java.net.URL;

public class WebElementHelper {

    private static final Logger LOG = Logger.getLogger(WebElementHelper.class);

    public static void jsClick(WebDriver driver, WebElement element) {
        LOG.info("JS click is invoked for web element: " + element.getText());
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void isImageDisplayed(WebDriver driver, WebElement element) {
        try {
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", element);
            if (imageDisplayed) {
                LOG.info("DISPLAY - OK");
            } else {
                LOG.info("DISPLAY - BROKEN");
            }
        } catch (Exception e) {
            LOG.info("Error Occurred");
        }
    }

    public static void verifyLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                LOG.info("HTTP STATUS - " + httpURLConnection.getResponseCode() + " "
                        + httpURLConnection.getResponseMessage() + " :is a broken link.");
            } else {
                LOG.info("HTTP STATUS - " + httpURLConnection.getResponseCode() + " "
                        + httpURLConnection.getResponseMessage() + " :link is correct.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }
}
