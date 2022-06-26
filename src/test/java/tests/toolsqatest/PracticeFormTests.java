package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.PracticeFormInformationPage;
import pages.toolsqapages.PracticeFormPage;
import tests.base.BaseTest;

import java.io.File;

public class PracticeFormTests extends BaseTest {

    private static final String FIRST_NAME = "Andrii";
    private static final String LAST_NAME = "Hladkyi";
    private static final String EMAIL = "hladkiy1500@gmail.com";
    private static final String GENDER = "Male";
    private static final String MOBILE_NUMBER = "0676754603";
    private static final String BIRTH_MONTH = "July";
    private static final String BIRTH_YEAR = "1988";
    private static final String BIRTH_DAY = "15";
    private static final String SUBJECT = "English";
    private static final String HOBBIES = "Sports, Music";
    private static final String FILE_PATH = "C:" + File.separator + "Users" + File.separator + "a.hladkyi" + File.separator
            + "automation-framework" + File.separator + "src" + File.separator + "main" + File.separator
            + "resources" + File.separator + "uploadFile.jpg";
    private static final String CURRENT_ADDRESS = "Robert Robertson, 1234 NW Bobcat Lane, St. Robert, MO 65584-5678";
    private static final String STATE = "NCR";
    private static final String CITY = "Delhi";

    private static final Logger LOG = Logger.getLogger(PracticeFormTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillTheForm() {
        LOG.info("Automation practice form is opened.");
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage
                .fillInTheName(FIRST_NAME, LAST_NAME)
                .fillInTheEmail(EMAIL)
                .setTheGender()
                .setMobileNumber(MOBILE_NUMBER)
                .setDateOfBirth(BIRTH_MONTH, BIRTH_YEAR, BIRTH_DAY)
                .setSubject(SUBJECT)
                .setHobbies()
                .uploadPicture(FILE_PATH)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setStateAndCity(STATE, CITY)
                .submitForm();

        PracticeFormInformationPage practiceFormInformationPage = new PracticeFormInformationPage(driver);

        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Student Name"), FIRST_NAME + " " + LAST_NAME, "Student name is not correct.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Student Email"), EMAIL, "Email is not correct.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Gender"), GENDER, "Gender is not correct.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Mobile"), MOBILE_NUMBER, "Mobile number is not correct.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Date of Birth"), BIRTH_DAY + " " + BIRTH_MONTH + "," + BIRTH_YEAR, "Subjects are not matched.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Subjects"), SUBJECT, "Subjects are not matched.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Hobbies"), HOBBIES, "Hobbies are not matched.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Picture"), "uploadFile.jpg", "Picture is not uploaded.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("Address"), CURRENT_ADDRESS, "Address is not correct.");
        Assert.assertEquals(practiceFormInformationPage.getColumnValue("State and City"), STATE + " " + CITY, "State or/and city are not correct.");
    }
}
