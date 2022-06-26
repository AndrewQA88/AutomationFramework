package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.BrokenLinkPage;
import tests.base.BaseTest;

public class BrokenLinkTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(BrokenLinkTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/broken");
    }

    @Test
    public void checkImages() {
        BrokenLinkPage brokenLinkPage = new BrokenLinkPage(driver);
        brokenLinkPage.checkImagesOnPage();
    }
}
