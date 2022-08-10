package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.AlertHelper;

public class AlertsPage extends BasePage {

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmBoxButton;

    @FindBy(id = "promtButton")
    private WebElement promptButton;

    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmResult;

    @FindBy(xpath = "//span[@id='promptResult']")
    private WebElement promptResult;

    private static final Logger LOG = Logger.getLogger(AlertsPage.class);

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationResultText() {
        return confirmResult.getText();
    }

    public String getPromptResultText() {
        return promptResult.getText();
    }

    public void handleInformationAlert() {
        LOG.info("Click button to information alert");
        alertButton.click();
        LOG.info("Alert text is: " + AlertHelper.getAlertText(driver));
        LOG.info("Accept alert.");
        AlertHelper.acceptAlert(driver);
    }

    public void handleTimerAlert() {
        LOG.info("Click on button.");
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        LOG.info("Alert text is: " + AlertHelper.getAlertText(driver));
        LOG.info("Accept alert.");
        AlertHelper.acceptAlert(driver);
    }

    public void confirmAction() {
        LOG.info("Click on button");
        confirmBoxButton.click();
        LOG.info("Alert text is: " + AlertHelper.getAlertText(driver));
        LOG.info("Confirm alert.");
        AlertHelper.acceptAlert(driver);
    }

    public void dismissAction() {
        LOG.info("Click on button");
        confirmBoxButton.click();
        LOG.info("Alert text is: " + AlertHelper.getAlertText(driver));
        LOG.info("Dismiss alert.");
        AlertHelper.dismissAlert(driver);
    }

    public void handlePromptBox() {
        LOG.info("Click on button");
        promptButton.click();
        LOG.info("Type the name and accept alert.");
        AlertHelper.sendKeysToAlert(driver, "Andrew");
        AlertHelper.acceptAlert(driver);
    }
}