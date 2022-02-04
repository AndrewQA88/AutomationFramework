package tests.googletests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googlepages.ResultPage;
import pages.googlepages.SearchPage;
import tests.base.BaseTest;


public class GoogleTests extends BaseTest {

    @Test
    public void test() {
        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = searchPage.typeTextInSearchField("Skelia").printAmountOfResults();
        Assert.assertTrue( resultPage.getSizeOfList() >= 7 , "Expected number of results must be more than 6.");
    }
}
