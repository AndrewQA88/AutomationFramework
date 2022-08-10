package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WebElementHelper;

public class ButtonsPage extends BasePage {

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessageText;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;

    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessageText;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement buttonWithDynamicId;

    @FindBy(id = "dynamicClickMessage")
    private WebElement clickMeMessageText;

    private static final Logger LOG = Logger.getLogger(ButtonsPage.class);

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public String getDoubleClickMessageText() {
        return doubleClickMessageText.getText();
    }

    public String getRightClickMessageText() {
        return rightClickMessageText.getText();
    }

    public String getClickMeMessageText() {
        return clickMeMessageText.getText();
    }

    public void doubleClickOnButton() {
        LOG.info("Double click on button.");
        WebElementHelper.doubleClick(driver, doubleClickButton);
    }

    public void rightClickOnButton() {
        LOG.info("Right click on button.");
        WebElementHelper.rightClick(driver, rightClickButton);
    }

    public void clickOnButtonWithDynamic() {
        LOG.info("Click on button with dynamic id.");
        buttonWithDynamicId.click();
    }
}
