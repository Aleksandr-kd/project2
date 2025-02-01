package steps;


// Для JUnit 5:
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import pageobjects.DropdownPage;

public class DropdownSteps {
    private final DropdownPage dropdownPage = new DropdownPage();

    public void selectOption(String optionText) {
        dropdownPage.selectByVisibleText(optionText);
    }

    public void verifySelectedOption(String expectedText) {
        String actualText = dropdownPage.getSelectedOptionText();
        Assertions.assertEquals(actualText, expectedText, "Выбранное значение в выпадающем списке не соответствует ожидаемому");
    }
}
