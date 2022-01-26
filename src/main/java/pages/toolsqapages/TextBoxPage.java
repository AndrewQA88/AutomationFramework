package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class TextBoxPage extends BasePage {

    private static final Logger log = Logger.getLogger(TextBoxPage.class);

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(xpath = "//*[@id='name']")
    private WebElement nameInCard;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailInCard;

    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']/p[@id='currentAddress']")
    private WebElement currentAddressInCard;

    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']/p[@id='permanentAddress']")
    private WebElement permanentAddressInCard;

    public String getNameInCard() {
        return nameInCard.getText();
    }

    public String getEmailInCard() {
        return emailInCard.getText();
    }

    public String getCurrentAddressInCard() {
        return currentAddressInCard.getText();
    }

    public String getPermanentAddressInCard() {
        return permanentAddressInCard.getText();
    }

    public void openTextBoxPage() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fillTextForm(String userName, String userEmail, String currentAddress, String permanentAddress) {
        log.info("Type full name: " + userName);
        this.userName.sendKeys(userName);
        log.info("Type email: " + userEmail);
        this.userEmail.sendKeys(userEmail);
        log.info("Type current address: " + currentAddress);
        this.currentAddress.sendKeys(currentAddress);
        log.info("Type permanent address: " + permanentAddress);
        this.permanentAddress.sendKeys(permanentAddress);
        log.info("Press submit");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", submit);
    }
}