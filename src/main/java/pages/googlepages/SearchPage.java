package pages.googlepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement searchInput() {
        return driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
    }

    public WebElement searchButton() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
    }
}
