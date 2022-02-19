package tests.toolsqatests;

import listeners.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.toolsqapages.RadioButtonPage;
import tests.base.BaseTest;

@Listeners(CustomListeners.class)
public class RadioButtonTests extends BaseTest {

    @Test
    public void selectYes() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.selectRadioButtonYes();
        Assert.assertTrue(radioButtonPage.isRadioButtonYesSelected() , "Radio button 'Yes' is not selected.");
    }
}
