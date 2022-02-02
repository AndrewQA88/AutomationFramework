package tests.toolsqatests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.toolsqapages.CheckBoxPage;
import tests.base.BaseTest;

public class CheckBoxTests extends BaseTest {

    @Test
    public void checkBoxTest() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.markAllCheckBoxes();
        Assert.assertEquals(checkBoxPage.getSelectedItems(),
                "home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile "
                , "Mismatching between selected and printed items.");
        Assert.assertTrue(checkBoxPage.isHomeCheckboxSelected());
    }
}