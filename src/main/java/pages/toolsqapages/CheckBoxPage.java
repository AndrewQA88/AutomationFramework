package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CheckBoxPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(CheckBoxPage.class);

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private WebElement homeItemCheckbox;

    @FindBy(xpath = "//button[@class='rct-option rct-option-expand-all']")
    private WebElement expandAll;

    @FindBy(xpath = "//button[@class='rct-option rct-option-collapse-all']")
    private WebElement collapseAll;

    @FindBy(xpath = "//span[@class='text-success']")
    private List<WebElement> items;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public String getSelectedItems() {
        StringBuilder selectedItems = new StringBuilder();
        String space = " ";
        for (int i = 0; i < items.size(); i++) {
            selectedItems.append(items.get(i).getText());
            selectedItems.append(space);
        }
        return selectedItems.toString();
    }

    public boolean isHomeCheckboxSelected(){
        return driver.findElement(By.xpath("//input[@id='tree-node-home']")).isSelected();
    }

    public void markAllCheckBoxes() {
        LOG.info("URL https://demoqa.com/checkbox is opened.");
        driver.get("https://demoqa.com/checkbox");
        LOG.info("Expand directory tree.");
        expandAll.click();
        LOG.info("Clicking on root item (check all).");
        homeItemCheckbox.click();
    }
}
