package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.File;

public class DownloadUploadFilePage extends BasePage {

    public static File folder = new File("test-output" + File.separator + "default-download-location");

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

    public String getUploadedFilePath() {
        return uploadedFilePath.getText();
    }
}
