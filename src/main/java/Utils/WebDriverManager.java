package Utils;

import configs.ResourceBundleFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class WebDriverManager {


    private static final String WINDOW_WIDTH = ResourceBundleFileReader.getProperty("windowWidth");
    private static final String WINDOW_HEIGHT = ResourceBundleFileReader.getProperty("windowHeight");
    private static final Logger LOG = Logger.getLogger(WebDriverManager.class);

    public static WebDriver getDriver() {
        if (ResourceBundleFileReader.getProperty("browser").equals("chrome")) {
            LOG.info("Getting new chrome WebDriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("download.default_directory", "test-output" + File.pathSeparator + "default-download-location");
            options.addArguments(String.format("--window-size=%s,%s", WINDOW_WIDTH, WINDOW_HEIGHT));
            options.addArguments("--lang=en-GB");
            System.setProperty("webdriver.chrome.driver", ResourceBundleFileReader.getProperty("chromeDriverPath"));
            return new ChromeDriver(options);
        } else if (ResourceBundleFileReader.getProperty("browser").equals("firefox")) {
            LOG.info("Getting new firefox WebDriver");
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("intl.accept_languages", "en-GB");
            profile.setPreference("download.default_directory", "test-output" + File.pathSeparator + "default-download-location");
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            options.addArguments("-private");
            options.addArguments(String.format("--width=%s", WINDOW_WIDTH));
            options.addArguments(String.format("--height=%s", WINDOW_HEIGHT));
            System.setProperty("webdriver.gecko.driver", ResourceBundleFileReader.getProperty("firefoxDriverPath"));
            return new FirefoxDriver(options);
        }
        LOG.fatal("Unsupported browser. Only 'chrome' and 'firefox' are supported by tests.");
        return null;
    }
}
