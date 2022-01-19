package pages.googlepages;

import Utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[class='gLFyf gsfi']")
    private WebElement searchField;

    public void typeTextInSearchField(String searchText) {
        log.info("Wait for search field until present.");
        Waiters.waitUntilPresent(driver, 30, 5);
        searchField.sendKeys(searchText);
        log.info("Text is inserted into search field.");
    }
}
