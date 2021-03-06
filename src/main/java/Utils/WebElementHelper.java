package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {

    private static final Logger LOG = Logger.getLogger(WebElementHelper.class);

    public static void jsClick(WebDriver driver, WebElement element) {
        LOG.info("JS click is invoked for web element: " + element.getText());
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
}
