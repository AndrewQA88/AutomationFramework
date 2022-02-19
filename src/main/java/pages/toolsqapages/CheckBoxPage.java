package pages.toolsqapages;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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

    @FindBy(xpath = "//input[@id='tree-node-home']")
    private WebElement homeCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-desktop']")
    private WebElement desktopCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-notes']")
    private WebElement notesCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-commands']")
    private WebElement commandsCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-documents']")
    private WebElement documentsCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-workspace']")
    private WebElement workspaceCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-react']")
    private WebElement reactCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-angular']")
    private WebElement angularCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-veu']")
    private WebElement veuCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-office']")
    private WebElement officeCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-public']")
    private WebElement publicCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-private']")
    private WebElement privateCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-classified']")
    private WebElement classifiedCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-general']")
    private WebElement generalCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-downloads']")
    private WebElement downloadsCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-wordFile']")
    private WebElement wordFileCheckboxState;

    @FindBy(xpath = "//input[@id='tree-node-excelFile']")
    private WebElement excelFileCheckboxState;

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
        return homeCheckboxState.isSelected();
    }

    public boolean isDesktopCheckboxSelected() {
        return desktopCheckboxState.isSelected();
    }

    public boolean isNotesCheckboxSelected() {
        return notesCheckboxState.isSelected();
    }

    public boolean isCommandsCheckboxSelected() {
        return commandsCheckboxState.isSelected();
    }

    public boolean isDocumentsCheckboxSelected() {
        return documentsCheckboxState.isSelected();
    }

    public boolean isWorkSpaceSelected() {
        return workspaceCheckboxState.isSelected();
    }

    public boolean isReactCheckboxSelected() {
        return reactCheckboxState.isSelected();
    }

    public boolean isAngularCheckboxSelected() {
        return angularCheckboxState.isSelected();
    }

    public boolean isVeuCheckboxSelected() {
        return veuCheckboxState.isSelected();
    }

    public boolean isOfficeCheckboxSelected() {
        return officeCheckboxState.isSelected();
    }

    public boolean isPublicCheckboxSelected() {
        return publicCheckboxState.isSelected();
    }

    public boolean isPrivateCheckboxSelected() {
        return privateCheckboxState.isSelected();
    }

    public boolean isClassifiedCheckboxSelected() {
        return classifiedCheckboxState.isSelected();
    }

    public boolean isGeneralCheckboxSelected() {
        return generalCheckboxState.isSelected();
    }

    public boolean isDownloadsCheckboxSelected() {
        return downloadsCheckboxState.isSelected();
    }

    public boolean isWordFileCheckboxSelected() {
        return wordFileCheckboxState.isSelected();
    }

    public boolean isExcelFileCheckboxSelected() {
        return excelFileCheckboxState.isSelected();
    }
}
