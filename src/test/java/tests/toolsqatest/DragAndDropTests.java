package tests.toolsqatest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolsqapages.DragAndDropPage;
import tests.base.BaseTest;


public class DragAndDropTests extends BaseTest {

    private static final Logger LOG = Logger.getLogger(DragAndDropTests.class);

    @BeforeMethod
    public void getPage() {
        driver.get("https://demoqa.com/droppable");
    }

    @Test
    public void simpleDragAndDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.simpleDragAndDropTest();
        Assert.assertEquals(dragAndDropPage.getDropPlaceTitle(), "Dropped!", "Element was not dragged and dropped");
    }
}
