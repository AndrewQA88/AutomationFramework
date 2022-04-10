package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class WebTablePage extends BasePage {

    WebElement rowText = driver.findElement(By.xpath(String.format("//*[@id='customers']/tbody/tr[2]/td[%s]", getColumnIndex())));

    private static final Logger LOG = Logger.getLogger(WebTablePage.class);

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public int getColumnIndex() {
        List<WebElement> columnHeaders = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/th"));
        for (int i = 1; i <= columnHeaders.size(); i++) {
            WebElement columnHeader = driver.findElement(By.xpath(String.format("//*[@id='customers']/tbody/tr/th[%s]", i)));
            if (columnHeader.getText().equals("Country")) {
                return i;
            }
        }
        return -1;
    }

    public String getCellText() {
        return rowText.getText();
    }
}
