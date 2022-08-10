package utils;

import configs.ResourceBundleFileReader;
import enums.Browsers;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebDriverManager {

    private static final String BROWSER = ResourceBundleFileReader.getProperty("browser");
    private static final String WINDOW_WIDTH = ResourceBundleFileReader.getProperty("windowWidth");
    private static final String WINDOW_HEIGHT = ResourceBundleFileReader.getProperty("windowHeight");
    private static final String DOWNLOAD_DEFAULT_DIRECTORY = "download.default_directory";
    private static final String LOCATION_PATH = "test-output" +File.separator + "default-download-location";

    private static final Logger LOG = Logger.getLogger(WebDriverManager.class);

    private static WebDriver driver;

    private WebDriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if (BROWSER.equals(Browsers.CHROME.getBrowserName())) {
                LOG.info("Getting new chrome WebDriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--disable-notifications");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put(DOWNLOAD_DEFAULT_DIRECTORY, LOCATION_PATH);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments(String.format("--window-size=%s,%s", WINDOW_WIDTH, WINDOW_HEIGHT));
                options.addArguments("--lang=en-GB");
                System.setProperty("webdriver.chrome.driver", ResourceBundleFileReader.getProperty("chromeDriverPath"));
                driver = new ChromeDriver(options);
            } else if (BROWSER.equals(Browsers.FIREFOX.getBrowserName())) {
                LOG.info("Getting new firefox WebDriver");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", "en-GB");
                profile.setPreference(DOWNLOAD_DEFAULT_DIRECTORY, LOCATION_PATH);
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                options.addArguments("-private");
                options.addArguments(String.format("--width=%s", WINDOW_WIDTH));
                options.addArguments(String.format("--height=%s", WINDOW_HEIGHT));
                System.setProperty("webdriver.gecko.driver", ResourceBundleFileReader.getProperty("firefoxDriverPath"));
                driver = new FirefoxDriver(options);
            }
            LOG.info(String.format("%s is unsupported browser. Only 'chrome' and 'firefox' are supported by tests.", BROWSER));
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
