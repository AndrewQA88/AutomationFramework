package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "droppableExample-tab-simple")
    private WebElement simpleTestTab;

    @FindBy(id = "draggable")
    private WebElement dragElement;

    @FindBy(id = "droppable")
    private WebElement dropPlace;

    private static final Logger LOG = Logger.getLogger(DragAndDropPage.class);

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public String getDropPlaceTitle() {
        return dropPlace.getText();
    }

    public void simpleDragAndDropTest() {
        LOG.info("Select simple test tab.");
        simpleTestTab.click();
        LOG.info("Drag and drop element.");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropPlace).build().perform();
    }
}
