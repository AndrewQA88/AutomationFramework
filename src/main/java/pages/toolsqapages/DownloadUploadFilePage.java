package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.File;

public class DownloadUploadFilePage extends BasePage {

    File folder = new File("C:" + File.separator + "Users" + File.separator + "a.hladkyi" + File.separator
            + "automation-framework" + File.separator + "test-output" + File.separator + "default-download-location");
    File[] files = null;

    @FindBy(id = "downloadButton")
    private WebElement downloadButton;

    @FindBy(id = "uploadFile")
    private WebElement uploadButton;

    @FindBy(id = "uploadedFilePath")
    private WebElement uploadedFilePath;

    private static final Logger LOG = Logger.getLogger(DownloadUploadFilePage.class);

    public DownloadUploadFilePage(WebDriver driver) {
        super(driver);
    }

    public DownloadUploadFilePage downloadFile() {
        LOG.info("Press 'Download' button.");
        downloadButton.click();
        return this;
    }

    public void uploadFile(String filePath) {
        LOG.info("Press 'Upload' button.");
        uploadButton.sendKeys(filePath);
    }

    public boolean isFileInFolder() throws InterruptedException {
        Thread.sleep(1000);
        files = folder.listFiles();
        boolean match = false;
        for (File listOfFile : files) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                LOG.info("File name is " + listOfFile.getName());
                if (fileName.matches("sampleFile.jpeg")) {
                    LOG.info("File was downloaded.");
                    match = true;
                }
            }
        }
        return match;
    }

    public void cleanFolder() {
        files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                LOG.info("File: '" + file.getName() + "' deleted.");
                file.delete();
            }
        }
    }

    public String getUploadedFilePath() {
        return uploadedFilePath.getText();
    }
}
