package tests.toolsqatests;

import listeners.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.toolsqapages.TextBoxPage;
import tests.base.BaseTest;

@Listeners(CustomListeners.class)
public class TextBoxTests extends BaseTest {

    private final String userName = "Jane Samples";
    private final String userEmail = "notreal@email.com";
    private final String currentAddress = "1234 Anywhere Lane";
    private final String permanentAddress = "123 Main Street";

    @Test(enabled = true)
    public void fillTextBoxes() {
        TextBoxPage textBoxPages = new TextBoxPage(driver);
        textBoxPages.openTextBoxPage();
        textBoxPages.fillTextForm(userName, userEmail,
                currentAddress, permanentAddress);
        Assert.assertEquals(textBoxPages.getNameInCard(), "Name:" + userName, "User name from result do not match.");
        Assert.assertEquals(textBoxPages.getEmailInCard(), "Email:" + userEmail, "Email from result do not match.");
        Assert.assertEquals(textBoxPages.getCurrentAddressInCard(), "Current Address :" + currentAddress, "Current address from result do not match.");
        Assert.assertEquals(textBoxPages.getPermanentAddressInCard(), "Permananet Address :" + permanentAddress, "Permanent address from result do not match.");
    }
}