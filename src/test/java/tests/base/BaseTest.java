package tests.base;


import Utils.WebDriverManager;
import configs.ResourceBundleFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    private final Logger LOG = Logger.getLogger(BaseTest.class);
    private final String BASEURL = ResourceBundleFileReader.getProperty("baseUrl");
    protected WebDriver driver;

    public String getBaseUrl() {
        return BASEURL;
    }

    @BeforeTest
    public void setUpDriver() {
        driver = WebDriverManager.getDriver();
        driver.get(getBaseUrl());
        LOG.info("URL " + getBaseUrl() + " is opened.");
        LOG.info("Window size is set to dimension (width 1920, height 1080).");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
        LOG.info("Tests finished.");
    }
}

