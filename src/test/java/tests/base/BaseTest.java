package tests.base;

import configs.ResourceBundleFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.File;


public class BaseTest {

    protected WebDriver driver;
    String baseUrl = ResourceBundleFileReader.getProperty("baseUrl");
    private static final Logger log = Logger.getLogger(BaseTest.class);


    @BeforeTest
    public void setUpChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("download.default_directory", "test-output" + File.pathSeparator + "default-download-location");
        options.addArguments("--window-size=1920,1080");
        System.setProperty("webdriver.chrome.driver", ResourceBundleFileReader.getProperty("chromeDriverPath"));
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        log.info("URL " + baseUrl + " is opened.");
        log.info("Window size is set to dimension (width 1920, height 1080).");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.close();
        log.info("Tests finished.");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

