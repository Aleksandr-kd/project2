package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.DropdownSteps;
import utils.TestConfig;
import utils.WebDriverSession;

public class DropdownTest extends BaseTest {

    @Story("Базовый сценарий Dropdown")
    @DisplayName("Проверка базового Dropdown")
    @Description("Тест проверяет стандартный сценарий выбора 1 и 2")
    @Test
    @ExtendWith(BaseTest.ScreenshotExtension.class)
    public void testSelectOption() {
        WebDriverSession.getDriver().get(TestConfig.getBaseUrl() + "/dropdown");

        DropdownSteps dropdownSteps = new DropdownSteps();
        String optionText = "Option 1";
        dropdownSteps.selectOption(optionText);
        dropdownSteps.verifySelectedOption(optionText);

        optionText = "Option 2";
        dropdownSteps.selectOption(optionText);
        dropdownSteps.verifySelectedOption(optionText);
    }
}
