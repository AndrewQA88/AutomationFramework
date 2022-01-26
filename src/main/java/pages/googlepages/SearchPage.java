package pages.googlepages;

import Utils.Waiters;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class SearchPage extends BasePage {

    private static final Logger log = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(className = "gNO89b")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='SIvCob']/a[2]")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@class='uU7dJb']")
    private WebElement languageIndicator;


    public void checkLanguage() {
        log.info("Checking page language.");
        if (!languageIndicator.getText().equals("Ukraine")) {
            languageButton.click();
            log.info("Language is set to English.");
        } else
            log.info("Current language is English.");
    }

    public ResultPage typeTextInSearchField(String searchText) {
        checkLanguage();
        searchField.sendKeys(searchText);
        log.info("Text '" + searchText + "' is inserted into search field." );
        Waiters.waitUntilPresent(driver, searchButton, 30, 5);
        log.info("Click on search button.");
        searchButton.click();
        log.info("Result page is opened.");
        return new ResultPage(this.driver);
    }
}
