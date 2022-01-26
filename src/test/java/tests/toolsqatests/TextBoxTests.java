package tests.toolsqatests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.toolsqapages.TextBoxPage;
import tests.base.BaseTest;

public class TextBoxTests extends BaseTest {

    @Test(enabled = true)
    public void fillTextBoxes() {
        TextBoxPage textBoxPages = new TextBoxPage(driver);
        textBoxPages.openTextBoxPage();
        textBoxPages.fillTextForm("Jane Samples", "notreal@email.com",
                "1234 Anywhere Lane", "123 Main Street");
        Assert.assertEquals(textBoxPages.getNameInCard(), "Name:Jane Samples");
        Assert.assertEquals(textBoxPages.getEmailInCard(), "Email:notreal@email.com");
        Assert.assertEquals(textBoxPages.getCurrentAddressInCard(), "Current Address :1234 Anywhere Lane");
        Assert.assertEquals(textBoxPages.getPermanentAddressInCard(), "Permananet Address :123 Main Street");
    }
}