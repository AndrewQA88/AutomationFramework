package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WindowHelper;


public class BrowserWindowsPage extends BasePage {

    @FindBy(id = "tabButton")
    private WebElement tabButton;

    @FindBy(id = "windowButton")
    private WebElement windowButton;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingOnNewTab;

    private static final Logger LOG = Logger.getLogger(BrowserWindowsPage.class);

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void openNewTab() {
        tabButton.click();
        WindowHelper.switchToTab(driver);
    }

    public void openNewWindow() {
        windowButton.click();
        WindowHelper.switchToTab(driver);
    }

    public String getSampleHeadingText() {
        return sampleHeadingOnNewTab.getText();
    }
}
