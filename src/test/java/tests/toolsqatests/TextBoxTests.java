package tests.toolsqatests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.toolsqapages.TextBoxPage;
import tests.base.BaseTest;

public class TextBoxTests extends BaseTest {

    private String userName = "Jane Samples";
    private String userEmail = "notreal@email.com";
    private String currentAddress = "1234 Anywhere Lane";
    private String permanentAddress = "123 Main Street";

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