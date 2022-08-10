package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.LinksPage;
import tests.base.BaseTest;

public class LinkTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(LinkTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/links");
    }

    @Test
    public void clickOnStaticLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.clickOnStaticLink();
    }

    @Test
    public void clickOnDynamicLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.clickOnDynamicLink();
    }

}
