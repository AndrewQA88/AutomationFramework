package tests.toolsqatest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.toolsqapages.CheckBoxPage;
import tests.base.BaseTest;

public class CheckBoxTests extends BaseTest {

    @Test
    public void selectAllCheckboxes() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.markAllCheckBoxes();
        Assert.assertTrue(checkBoxPage.isHomeCheckboxSelected(), "Checkbox 'Home' is not selected.");
        Assert.assertTrue(checkBoxPage.isDesktopCheckboxSelected(), "Checkbox 'Desktop' is not selected.");
        Assert.assertTrue(checkBoxPage.isNotesCheckboxSelected(), "Checkbox 'Notes' is not selected.");
        Assert.assertTrue(checkBoxPage.isCommandsCheckboxSelected(), "Checkbox 'Commands' is not selected.");
        Assert.assertTrue(checkBoxPage.isDocumentsCheckboxSelected(), "Checkbox 'Documents' is not selected.");
        Assert.assertTrue(checkBoxPage.isWorkSpaceSelected(), "Checkbox 'WorkSpace' is not selected.");
        Assert.assertTrue(checkBoxPage.isReactCheckboxSelected(), "Checkbox 'React' is not selected.");
        Assert.assertTrue(checkBoxPage.isAngularCheckboxSelected(), "Checkbox 'Angular' is not selected.");
        Assert.assertTrue(checkBoxPage.isVeuCheckboxSelected(), "Checkbox 'Veu' is not selected.");
        Assert.assertTrue(checkBoxPage.isOfficeCheckboxSelected(), "Checkbox 'Office' is not selected.");
        Assert.assertTrue(checkBoxPage.isPublicCheckboxSelected(), "Checkbox 'Public' is not selected.");
        Assert.assertTrue(checkBoxPage.isPrivateCheckboxSelected(), "Checkbox 'Private' is not selected.");
        Assert.assertTrue(checkBoxPage.isClassifiedCheckboxSelected(), "Checkbox 'Classified' is not selected.");
        Assert.assertTrue(checkBoxPage.isGeneralCheckboxSelected(), "Checkbox 'General' is not selected.");
        Assert.assertTrue(checkBoxPage.isDownloadsCheckboxSelected(), "Checkbox 'Downloads' is not selected.");
        Assert.assertTrue(checkBoxPage.isWordFileCheckboxSelected(), "Checkbox 'Word.file' is not selected.");
        Assert.assertTrue(checkBoxPage.isExcelFileCheckboxSelected(), "Checkbox 'Excel.file' is not selected.");
        Assert.assertEquals(checkBoxPage.getSelectedItems(),
                "home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile "
                , "Mismatching between selected and printed items.");
    }
}