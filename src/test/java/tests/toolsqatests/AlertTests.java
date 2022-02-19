package tests.toolsqatests;

import listeners.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.toolsqapages.AlertsPage;
import tests.base.BaseTest;

@Listeners(CustomListeners.class)
public class AlertTests extends BaseTest {


    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/alerts");
    }

    @Test
    public void handleInformationAlert() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.handleInformationAlert();
    }

    @Test
    public void handleTimerAlert() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.handleTimerAlert();
    }

    @Test
    public void handleConfirmationBox() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.confirmAction();
        Assert.assertEquals(alertsPage.getConfirmationResultText(), "You selected Ok", "Expected message is not matched with actual.");
        alertsPage.dismissAction();
        Assert.assertEquals(alertsPage.getConfirmationResultText(), "You selected Cancel", "Expected message is not matched with actual.");
    }

    @Test
    public void handlePromptBox() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.handlePromptBox();
        Assert.assertEquals(alertsPage.getPromptResultText(), "You entered Andrew", "Expected message is not matched with actual.");
    }
}
