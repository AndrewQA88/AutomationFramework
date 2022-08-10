package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.DownloadUploadFilePage;
import tests.base.BaseTest;
import utils.FileHelper;

public class DownloadFileTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(DownloadFileTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/upload-download");
        LOG.info("URL https://demoqa.com/upload-download is opened");
    }

    @Test
    public void downloadFile() {
        DownloadUploadFilePage downloadFilePage = new DownloadUploadFilePage(driver);
        downloadFilePage.downloadFile();
        boolean fileIsPresentInFolder = FileHelper.isFileInFolder(driver, "sampleFile.jpeg");
        Assert.assertTrue(fileIsPresentInFolder, "Downloaded file is not found.");
    }

    @AfterMethod(description = "Clean folder with files.")
    public void cleanFolder() {
        FileHelper.cleanFolder();
    }
}
