package tests;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotManager;
import utils.WebDriverManager;


public class TestListener implements ITestListener {

    private static final Logger LOG = Logger.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("Test failed.");
        ScreenshotManager.takeScreenshot(WebDriverManager.getDriver(), result.getName());
    }
}
