package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.WebTablePage;
import tests.base.BaseTest;

public class WebTableTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(WebTableTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
    }

    @Test
    public void getRowTextFromSpecificColumnHeader() {
        WebTablePage webTablePage = new WebTablePage(driver);
        LOG.info(webTablePage.getCellText());
    }
}
