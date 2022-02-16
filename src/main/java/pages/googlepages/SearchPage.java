package pages.googlepages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.Waiters;
import utils.WebElementHelper;

import java.util.ArrayList;


public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchField;

    @FindBy(className = "gNO89b")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='SIvCob']/a[2]")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@class='uU7dJb']")
    private WebElement languageIndicator;

    private static final Logger LOG = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage typeTextInSearchField(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, Waiters.getExplicitlyWaitTimeOutInSeconds());
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchText);
        LOG.info(String.format("Text '%s' is inserted into search field.", searchText));
        Waiters.waitUntilPresent(driver, searchButton, Waiters.getExplicitlyWaitTimeOutInSeconds(), Waiters.getPollingInSeconds());
        LOG.info("Click on search button.");
        searchButton.click();
        LOG.info("Result page is opened.");
        return new ResultPage(this.driver);
    }

    public SearchPage openNewTabAndSwitch() {
        WebElementHelper.openNewWindow(driver, "https://www.google.com");
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new SearchPage(this.driver);
    }

}