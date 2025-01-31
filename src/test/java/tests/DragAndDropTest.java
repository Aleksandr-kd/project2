package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.DragAndDropSteps;
import utils.TestConfig;
import utils.WebDriverSession;

public class DragAndDropTest extends BaseTest {

    @Story("Базовый сценарий перетаскивания")
    @DisplayName("Проверка базового Drag and Drop")
    @Description("Тест проверяет стандартный сценарий перетаскивания элемента A на элемент B")
    @Test
    public void testDragAndDrop() {
        WebDriverSession.getDriver().get(TestConfig.getBaseUrl() + "/drag_and_drop");

        DragAndDropSteps dragAndDropSteps = new DragAndDropSteps();
        dragAndDropSteps.moveDraggableToDroppable();
        dragAndDropSteps.verifyDroppableText("A");
    }
}
