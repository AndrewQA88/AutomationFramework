package tests.googletests;

import org.testng.annotations.Test;
import pages.googlepages.SearchPage;
import tests.base.BaseTest;

public class GoogleTests extends BaseTest {

    @Test
    public void test() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.typeText();
    }
}
