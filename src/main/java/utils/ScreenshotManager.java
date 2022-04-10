package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenshotManager {

    public static  void failed(WebDriver driver, String testMethodName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("test-output/screenshots/" + "screenshot_" + testMethodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
