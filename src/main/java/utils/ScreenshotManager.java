package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenshotManager {

    public static void takeScreenshot(WebDriver driver, String testMethodName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(String.format("test-output/screenshots/screenshot_%s.png", testMethodName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
