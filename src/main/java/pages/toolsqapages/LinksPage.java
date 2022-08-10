package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LinksPage extends BasePage {

    @FindBy(linkText = "Home")
    private WebElement staticLink;

    @FindBy(partialLinkText = "Home")
    private WebElement dynamicLink;

    private static final Logger LOG = Logger.getLogger("LinksPage");

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnStaticLink() {
        LOG.info("Click on link.");
        staticLink.click();
    }

    public void clickOnDynamicLink() {
        LOG.info("Click on link.");
        dynamicLink.click();
    }
}
