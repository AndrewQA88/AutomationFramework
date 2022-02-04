package pages.toolsqapages;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CheckBoxPage extends BasePage {

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private WebElement homeItemCheckbox;

    @FindBy(xpath = "//button[@class='rct-option rct-option-expand-all']")
    private WebElement expandAll;

    @FindBy(xpath = "//button[@class='rct-option rct-option-collapse-all']")
    private WebElement collapseAll;

    @FindBy(xpath = "//span[@class='text-success']")
    private List<WebElement> items;

    private static final Logger LOG = Logger.getLogger(CheckBoxPage.class);

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public String getSelectedItems() {
        StringBuilder selectedItems = new StringBuilder();
        String space = StringUtils.SPACE;
        for (int i = 0; i < items.size(); i++) {
            selectedItems.append(items.get(i).getText()).append(space);
        }
        return selectedItems.toString();
    }

    public void markAllCheckBoxes() {
        LOG.info("URL https://demoqa.com/checkbox is opened.");
        driver.get("https://demoqa.com/checkbox");
        LOG.info("Expand directory tree.");
        expandAll.click();
        LOG.info("Clicking on root item (check all).");
        if (!isHomeCheckboxSelected()) {
            homeItemCheckbox.click();
        } else {
            LOG.info("Home checkbox is already selected");
        }

    }

    public boolean isHomeCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-home']")).isSelected();
    }

    public boolean isDesktopCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-desktop']")).isSelected();
    }

    public boolean isNotesCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-notes']")).isSelected();
    }

    public boolean isCommandsCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-commands']")).isSelected();
    }

    public boolean isDocumentsCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-documents']")).isSelected();
    }

    public boolean isWorkSpaceSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-workspace']")).isSelected();
    }

    public boolean isReactCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-react']")).isSelected();
    }

    public boolean isAngularCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-angular']")).isSelected();
    }

    public boolean isVeuCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-veu']")).isSelected();
    }

    public boolean isOfficeCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-office']")).isSelected();
    }

    public boolean isPublicCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-public']")).isSelected();
    }

    public boolean isPrivateCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-private']")).isSelected();
    }

    public boolean isClassifiedCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-classified']")).isSelected();
    }

    public boolean isGeneralCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-general']")).isSelected();
    }

    public boolean isDownloadsCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-downloads']")).isSelected();
    }

    public boolean isWordFileCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-wordFile']")).isSelected();
    }

    public boolean isExcelFileCheckboxSelected() {
        return driver.findElement(By.xpath("//input[@id='tree-node-excelFile']")).isSelected();
    }
}
