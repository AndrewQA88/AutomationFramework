package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileHelper {

    private final static Logger LOG = Logger.getLogger(FileHelper.class);

    public static File folder = new File("test-output" + File.separator + "default-download-location");

    public static boolean isFileInFolder(WebDriver driver, String expectedFileName) {
        Waiters.waitUntilFilePresentInDirectory(driver, folder, expectedFileName);
        return true;
    }

    public static void cleanFolder() {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                LOG.info("File: '" + file.getName() + "' deleted.");
                file.delete();
            }
        }
    }


}
