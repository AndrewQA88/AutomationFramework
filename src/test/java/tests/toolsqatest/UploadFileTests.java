package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.DownloadUploadFilePage;
import tests.base.BaseTest;

import java.io.File;


public class UploadFileTests extends BaseTest {


    private static final String FILE_PATH = "C:" + File.separator + "Users" + File.separator + "a.hladkyi" + File.separator
            + "automation-framework" + File.separator + "src" + File.separator + "main" + File.separator
            + "resources" + File.separator + "uploadFile.jpg";
    private static final String EXPECTED_FILE_PATH = "C:" + File.separator + "fakepath" + File.separator + "uploadFile.jpg";
    private static final Logger LOG = Logger.getLogger(UploadFileTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/upload-download");
        LOG.info("URL https://demoqa.com/upload-download is opened");
    }

    @Test
    public void uploadFile() {
        DownloadUploadFilePage downloadFilePage = new DownloadUploadFilePage(driver);
        downloadFilePage.uploadFile(FILE_PATH);
        LOG.info(downloadFilePage.getUploadedFilePath());
        LOG.info(EXPECTED_FILE_PATH);
        Assert.assertEquals(downloadFilePage.getUploadedFilePath(), EXPECTED_FILE_PATH, "Uploaded file is not correct.");
    }
}
