package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.BrowserWindowsPage;
import tests.base.BaseTest;

public class BrowserWindowsTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(BrowserWindowsTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/browser-windows");
    }

    @Test
    public void handleNewTab() {
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage.openNewTab();
        Assert.assertEquals(browserWindowsPage.getSampleHeadingText(), "This is a sample page", "Heading Text is not correct.");
    }

    @Test
    public void handleNewWindow() {
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage.openNewWindow();
        Assert.assertEquals(browserWindowsPage.getSampleHeadingText(), "This is a sample page", "Heading Text is not correct.");
    }
}
