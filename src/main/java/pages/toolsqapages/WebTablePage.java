package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND;

public class WebTablePage extends BasePage {

    private WebElement rowText = driver.findElement(By.xpath(String.format("//*[@id='customers']/tbody/tr[2]/td[%s]", getColumnIndex("Country"))));

    private static final Logger LOG = Logger.getLogger(WebTablePage.class);

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public int getColumnIndex(String columnName) {
        List<WebElement> columnHeaders = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/th"));
        for (int i = 0; i <= columnHeaders.size(); i++) {
            if (columnHeaders.get(i).getText().equals(columnName)) {
                return i + 1;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public String getCellText() {
        return rowText.getText();
    }
}
