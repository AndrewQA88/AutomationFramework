package tests.toolsqatest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.toolsqapages.RadioButtonPage;
import tests.base.BaseTest;

public class RadioButtonTests extends BaseTest {

    @Test
    public void selectYes() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.selectRadioButtonYes();
        Assert.assertTrue(radioButtonPage.isRadioButtonYesSelected(), "Radio button 'Yes' is not selected.");
    }
}
