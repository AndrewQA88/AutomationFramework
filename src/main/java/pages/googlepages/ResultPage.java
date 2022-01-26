package pages.googlepages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ResultPage extends BasePage {

    private static final Logger log = Logger.getLogger(ResultPage.class);

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "result-stats")
    private WebElement results;

    private List<WebElement> listOfResults = driver.findElements(By.xpath("//*[@class='TbwUpd NJjxre']"));

    public int getListOfResults() {
        return listOfResults.size();
    }

    public void showResultNumber() {
        log.info(results.getText());
        log.info("Results on page: " + listOfResults.size());
    }
}
