package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverSession;

public class DropdownPage {
    @FindBy(id = "dropdo1wn")
    private WebElement dropdownElement;

    public DropdownPage() {
        PageFactory.initElements(WebDriverSession.getDriver(), this);
    }

    public void selectByVisibleText(String text) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
    }

    public String getSelectedOptionText() {
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }
}
