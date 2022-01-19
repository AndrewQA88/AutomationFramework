package tests.base;

import configs.ResourceBundleFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.File;


public class BaseTest {

    protected WebDriver driver;
    String baseUrl = ResourceBundleFileReader.getProperty("baseUrl");
    public static Logger log = Logger.getLogger("baseTest");


    @BeforeTest
    public void setUpChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("download.default_directory", "test-output" + File.pathSeparator + "default-download-location");
        System.setProperty("webdriver.chrome.driver", ResourceBundleFileReader.getProperty("chromeDriverPath"));
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        log.info("URL " + baseUrl + " is opened.");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().getSize();
        log.info("Window size is set to dimension (width 1920, height 1080).");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.close();
        log.info("Process finished.");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

