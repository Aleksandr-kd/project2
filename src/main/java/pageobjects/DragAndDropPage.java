package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverSession;

public class DragAndDropPage {
    @FindBy(id = "column-4a")
    private WebElement source;

    @FindBy(id = "column-b")
    private WebElement target;

    public DragAndDropPage() {
        PageFactory.initElements(WebDriverSession.getDriver(), this);
    }

    public WebElement getSource() {
        return source;
    }

    public WebElement getTarget() {
        return target;
    }

    public String getDroppableText() {
        return target.getText();
    }
}
