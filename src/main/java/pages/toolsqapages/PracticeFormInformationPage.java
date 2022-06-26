package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class PracticeFormInformationPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(PracticeFormInformationPage.class);

    public PracticeFormInformationPage(WebDriver driver) {
        super(driver);
    }

    public String getColumnValue(String columnValue) {
        List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
        for (int i = 1; i <= tableRows.size(); i++) {
            WebElement label = driver.findElement(By.xpath(String.format("//tbody/tr[%s]/td[1]", i)));
            WebElement values = driver.findElement(By.xpath(String.format("//tbody/tr[%s]/td[2]", i)));
            if (label.getText().equals(columnValue)) {
                return values.getText();
            }
        }
        return "Column value is not found.";
    }
}



