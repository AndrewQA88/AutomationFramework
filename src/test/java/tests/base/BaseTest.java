package tests.base;

import configs.PropertyFileReader;
import configs.ResourceBundleFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BaseTest {

    String fileSeparator = File.separator;
    String pathSeparator = File.pathSeparator;
    protected WebDriver driver;
    private final PropertyFileReader propertyFileReader = new PropertyFileReader();

    @BeforeTest
    public void setUpChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("download.default_directory", "D" + pathSeparator + fileSeparator + "default-download-location");
        String test = System.setProperty("webdriver.chrome.driver", "src" + fileSeparator + "main" + fileSeparator +
                "resources" + fileSeparator + "driver" + fileSeparator + "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get(propertyFileReader.getProperty("baseUrl"));
        //driver.get(ResourceBundleFileReader.getProperty("baseUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
