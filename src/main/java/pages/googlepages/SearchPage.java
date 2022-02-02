package pages.googlepages;

import Utils.Waiters;
import configs.ResourceBundleFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;


public class SearchPage extends BasePage {

    int timeout = Integer.parseInt(ResourceBundleFileReader.getProperty("explicitlyWaitTimeOut"));

    WebDriverWait wait = new WebDriverWait(driver,30);

    private static final Logger LOG = Logger.getLogger(SearchPage.class);

    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchField;

    @FindBy(className = "gNO89b")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='SIvCob']/a[2]")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@class='uU7dJb']")
    private WebElement languageIndicator;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage typeTextInSearchField(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchText);
        LOG.info("Text '" + searchText + "' is inserted into search field.");
        Waiters.waitUntilPresent(driver, searchButton, timeout, 5);
        LOG.info("Click on search button.");
        searchButton.click();
        LOG.info("Result page is opened.");
        return new ResultPage(this.driver);
    }
}
