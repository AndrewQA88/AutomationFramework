package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;


public class PracticeFormPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(PracticeFormPage.class);

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(xpath = "//label[contains(text(),'Male')]")
    private WebElement genderMale;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    private WebElement datePicker;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement birhtMonth;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement birhtYear;

    @FindBy(xpath = "//div[contains(text(),'15')]")
    private WebElement birthDay;

    @FindBy(xpath = "//*[@id='subjectsContainer']/div")
    private WebElement subjectField;

    @FindBy(xpath = "//*[@id='react-select-2-option-0']")
    private WebElement subject;

    @FindBy(xpath = "//label[contains(text(),'Sports')]")
    private WebElement checkboxSports;

    @FindBy(xpath = "//label[contains(text(),'Music')]")
    private WebElement checkboxMusic;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "react-select-3-input")
    WebElement stateInputField;

    @FindBy(id = "react-select-4-input")
    WebElement cityInputField;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage fillInTheName(String fName, String lName) {
        LOG.info("Fill in the 'First Name' field.");
        firstName.sendKeys(fName);
        LOG.info("Fill in the 'Last Name' field.");
        lastName.sendKeys(lName);
        return this;
    }

    public PracticeFormPage fillInTheEmail(String emailAddress) {
        LOG.info("Fill in the 'Email' field.");
        userEmail.sendKeys(emailAddress);
        return this;
    }

    public PracticeFormPage setTheGender() {
        LOG.info("Set 'Gender'.");
        genderMale.click();
        return this;
    }

    public PracticeFormPage setMobileNumber(String mobileNumber) {
        LOG.info("Set 'Mobile number'.");
        userNumber.sendKeys(mobileNumber);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String birthdayMonth, String birthdayYear, String birthdayDay) {
        LOG.info("Set 'Birthday'.");
        datePicker.click();
        Select selectMonth = new Select(birhtMonth);
        selectMonth.selectByVisibleText(birthdayMonth);
        Select selectYear = new Select(birhtYear);
        selectYear.selectByVisibleText(birthdayYear);
        driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", birthdayDay))).click();
        return this;
    }

    public PracticeFormPage setSubject(String tag) {
        LOG.info("Set 'Subject'.");
        Actions actions = new Actions(driver);
        actions.click(subjectField).sendKeys(tag).build().perform();
        subject.click();
        return this;
    }

    public PracticeFormPage setHobbies() {
        LOG.info("Set hobby: 'Sport'.");
        checkboxSports.click();
        LOG.info("Set hobby: 'Music'.");
        checkboxMusic.click();
        return this;
    }

    public PracticeFormPage uploadPicture(String filePath) {
        LOG.info("Uploading picture.");
        uploadPicture.sendKeys(filePath);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        LOG.info("Set current address.");
        currentAddress.sendKeys(address);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        LOG.info("Set state.");
        stateInputField.sendKeys(state);
        stateInputField.sendKeys(Keys.ENTER);
        LOG.info("Set city.");
        cityInputField.sendKeys(city);
        cityInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormInformationPage submitForm() {
        LOG.info("Submitting form.");
        submitButton.submit();
        return new PracticeFormInformationPage(driver);
    }
}
