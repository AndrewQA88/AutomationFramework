package pages.googlepages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ResultPage extends BasePage {

    @FindBy(id = "result-stats")
    private WebElement results;

    @FindBy(xpath = "//*[@class='TbwUpd NJjxre']")
    private List<WebElement> listOfResults;

    private static final Logger LOG = Logger.getLogger(ResultPage.class);

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfResultsOnPage() {
        return listOfResults.size();
    }

    public ResultPage printAmountOfResults() {
        LOG.info(results.getText());
        LOG.info("Results on page: " + getNumberOfResultsOnPage());
        return new ResultPage(driver);
    }
}
