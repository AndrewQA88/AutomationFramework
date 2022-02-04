package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class RadioButtonPage extends BasePage {

    @FindBy(xpath = "//label[@for='yesRadio']")
    WebElement radioButtonYes;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    WebElement impressiveRadioButton;

    @FindBy(xpath = "//label[@for='noRadio']")
    WebElement noRadioButton;

    private static final Logger LOG = Logger.getLogger(RadioButtonPage.class);

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public void getPage() {
        driver.get("https://demoqa.com/radio-button");
    }

    public void selectRadioButtonYes() {
        LOG.info("Open page: Radio Button");
        getPage();
        LOG.info("Select radio button 'YES'");
        if (!isRadioButtonYesSelected()) {
            radioButtonYes.click();
        } else {
            LOG.info("Radio button 'YES' is already selected");
        }
    }

    public boolean isRadioButtonYesSelected() {
        return driver.findElement(By.id("yesRadio")).isSelected();
    }
}
