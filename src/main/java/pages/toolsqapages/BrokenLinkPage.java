package pages.toolsqapages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WebElementHelper;

import java.util.List;

public class BrokenLinkPage extends BasePage {

    @FindBy(tagName = "img")
    private List<WebElement> images;

    private static final Logger LOG = Logger.getLogger(BrokenLinkPage.class);

    public BrokenLinkPage(WebDriver driver) {
        super(driver);
    }

    public void checkImagesOnPage() {
        for (int index = 0; index < images.size(); index++) {
            WebElement image = images.get(index);
            String imageUrl = image.getAttribute("src");
            if (imageUrl.equals("https://demoqa.com/images/Toolsqa_1.jpg")
                    || imageUrl.equals("https://demoqa.com/images/Toolsqa.jpg")) {
                LOG.info("URL of image  is: " + imageUrl);
                WebElementHelper.verifyLink(imageUrl);
                WebElementHelper.checkImageDisplayed(driver, image);
            }
        }
    }
}
