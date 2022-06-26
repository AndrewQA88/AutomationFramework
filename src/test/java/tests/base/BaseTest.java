package tests.base;


import configs.ResourceBundleFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tests.TestListener;
import utils.WebDriverManager;

@Listeners(TestListener.class)
public class BaseTest {

    private final String BASEURL = ResourceBundleFileReader.getProperty("baseUrl");
    protected WebDriver driver;
    private final Logger LOG = Logger.getLogger(BaseTest.class);

    public String getBaseUrl() {
        return BASEURL;
    }

    @BeforeMethod
    public void setUpDriver() {
        driver = WebDriverManager.getDriver();
        driver.get(getBaseUrl());
        LOG.info("URL " + getBaseUrl() + " is opened.");
        LOG.info("Window size is set to dimension (width 1920, height 1080).");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        WebDriverManager.close();
        LOG.info("Tests finished.");
    }
}

