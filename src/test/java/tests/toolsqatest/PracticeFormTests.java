package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.PracticeFormPage;
import tests.base.BaseTest;

public class PracticeFormTests extends BaseTest {

    private static final String FIRST_NAME = "Andrii";
    private static final String LAST_NAME = "Hladkyi";
    private static final String EMAIL = "hladkiy1500@gmail.com";
    private static final String MOBILE_NUMBER = "0676754603";
    private static final String BIRTH_MONTH = "July";
    private static final String BIRTH_YEAR = "1988";
    private static final String BIRTH_DAY = "15";
    private static final String TAG = "English";
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
                .setSubject(TAG);
    }
}
