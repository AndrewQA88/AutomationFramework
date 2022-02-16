package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

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
        Alert alert = driver.switchTo().alert();
        LOG.info("Alert text is: " + alert.getText());
        LOG.info("Accept alert.");
        alert.accept();
    }

    public void handleTimerAlert() {
        LOG.info("Click on button.");
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        LOG.info("Alert text is: " + alert.getText());
        LOG.info("Accept alert.");
        alert.accept();
    }

    public void confirmAction() {
        LOG.info("Click on button");
        confirmBoxButton.click();
        Alert alert = driver.switchTo().alert();
        LOG.info("Alert text is: " + alert.getText());
        LOG.info("Confirm alert.");
        alert.accept();
    }

    public void dismissAction() {
        LOG.info("Click on button");
        confirmBoxButton.click();
        Alert alert = driver.switchTo().alert();
        LOG.info("Alert text is: " + alert.getText());
        LOG.info("Dismiss alert.");
        alert.dismiss();
    }

    public void handlePromptBox() {
        LOG.info("Click on button");
        promptButton.click();
        Alert alert = driver.switchTo().alert();
        LOG.info("Type the name and accept alert.");
        alert.sendKeys("Andrew");
        alert.accept();
    }
}