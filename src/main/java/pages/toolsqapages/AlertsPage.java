package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.Alerts;

public class AlertsPage extends BasePage {

    @FindBy(id = "alertButton")
    WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmBoxButton;

    @FindBy(id = "promtButton")
    WebElement promptButton;

    @FindBy(xpath = "//span[@id='confirmResult']")
    WebElement confirmResult;

    @FindBy(xpath = "//span[@id='promptResult']")
    WebElement promptResult;

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
        LOG.info("Alert text is: " + Alerts.getAlertText(driver));
        LOG.info("Accept alert.");
        Alerts.acceptAlert(driver);
    }

    public void handleTimerAlert() {
        LOG.info("Click on button.");
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        LOG.info("Alert text is: " + Alerts.getAlertText(driver));
        LOG.info("Accept alert.");
        Alerts.acceptAlert(driver);
    }

    public void confirmAction() {
        LOG.info("Click on button");
        confirmBoxButton.click();
        LOG.info("Alert text is: " + Alerts.getAlertText(driver));
        LOG.info("Confirm alert.");
        Alerts.acceptAlert(driver);
    }

    public void dismissAction() {
        LOG.info("Click on button");
        confirmBoxButton.click();
        LOG.info("Alert text is: " + Alerts.getAlertText(driver));
        LOG.info("Dismiss alert.");
        Alerts.dismissAlert(driver);
    }

    public void handlePromptBox() {
        LOG.info("Click on button");
        promptButton.click();
        LOG.info("Type the name and accept alert.");
        Alerts.sendKeysToAlert(driver, "Andrew");
        Alerts.acceptAlert(driver);
    }
}