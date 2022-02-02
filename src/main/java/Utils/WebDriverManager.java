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


    private static final Logger LOG = Logger.getLogger(WebDriverManager.class);
    private static final String BROWSER = ResourceBundleFileReader.getProperty("browser");
    private static final String WINDOWSIZE = ResourceBundleFileReader.getProperty("windowSize");

    public static String getBrowser() {
        return BROWSER;
    }

    public static String getWindowSize() {
        return WINDOWSIZE;
    }

    public static WebDriver getDriver() {
        if (getBrowser().equals("chrome")) {
            LOG.info("Getting new chrome WebDriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("download.default_directory", "test-output" + File.pathSeparator + "default-download-location");
            options.addArguments(getWindowSize());
            options.addArguments("--lang=en-GB");
            System.setProperty("webdriver.chrome.driver", ResourceBundleFileReader.getProperty("chromeDriverPath"));
            return new ChromeDriver(options);
        } else if (getBrowser().equals("firefox")) {
            LOG.info("Getting new firefox WebDriver");
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("intl.accept_languages", "en-GB");
            profile.setPreference("download.default_directory", "test-output" + File.pathSeparator + "default-download-location");
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            options.addArguments("-private");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
            System.setProperty("webdriver.gecko.driver", ResourceBundleFileReader.getProperty("firefoxDriverPath"));
            return new FirefoxDriver(options);
        }
        return null;
    }
}
