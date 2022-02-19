package listeners;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.base.BaseTest;
import utils.ScreenshotManager;
import utils.WebDriverManager;


public class CustomListeners extends BaseTest implements ITestListener {

    private static final Logger LOG = Logger.getLogger(CustomListeners.class);

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("Test Failed");
        ScreenshotManager screenshotManager = new ScreenshotManager();
        screenshotManager.failed(WebDriverManager.getDriver(), result.getMethod().getMethodName());
    }
}
