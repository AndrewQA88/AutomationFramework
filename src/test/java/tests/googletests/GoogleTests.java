package tests.googletests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.googlepages.ResultPage;
import pages.googlepages.SearchPage;
import tests.base.BaseTest;


public class GoogleTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(GoogleTests.class);

    @Test
    public void test() {
        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = searchPage.typeTextInSearchField("Skelia").printAmountOfResults();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultPage.getNumberOfResultsOnPage() >= 7, "Expected number of results must be more than 6.");
        softAssert.assertAll();
    }

    @Test
    public void compareResultsOnDifferentTabs() {
        SearchPage searchPage = new SearchPage(driver);
        int resultsOnFirstTab = searchPage.typeTextInSearchField("Skelia").getNumberOfResultsOnPage();
        LOG.info(String.format("About '%s' results on page.", resultsOnFirstTab));
        int resultsOnSecondTab = searchPage.openNewTabAndSwitch().typeTextInSearchField("Skelia").getNumberOfResultsOnPage();
        LOG.info(String.format("About '%s' results on page.", resultsOnSecondTab));
        ResultPage.compareSearchResults(resultsOnFirstTab, resultsOnSecondTab);
    }
}
