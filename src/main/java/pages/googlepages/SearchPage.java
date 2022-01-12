package pages.googlepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[class='gLFyf gsfi']")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
    private WebElement searchButton;

    public void typeText() {
        searchInput.sendKeys("private WebElement searchInput;");
    }
}
