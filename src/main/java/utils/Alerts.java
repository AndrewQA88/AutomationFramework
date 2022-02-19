package utils;

import org.openqa.selenium.WebDriver;

public class Alerts {


    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public static void sendKeysToAlert(WebDriver driver, String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
