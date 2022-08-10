package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.ButtonsPage;
import tests.base.BaseTest;

public class ButtonTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(ButtonTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void doubleClickOnButton() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.doubleClickOnButton();
        Assert.assertEquals(buttonsPage.getDoubleClickMessageText(), "You have done a double click", "Actual message is not equals with expected");
    }

    @Test
    public void rightClickOnButton() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.rightClickOnButton();
        Assert.assertEquals(buttonsPage.getRightClickMessageText(), "You have done a right click", "Actual message is not equals with expected");
    }

    @Test
    public void clickOnButtonWithDynamicId() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickOnButtonWithDynamic();
        Assert.assertEquals(buttonsPage.getClickMeMessageText(), "You have done a dynamic click", "Actual message is not equals with expected");
    }
}
