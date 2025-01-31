package steps;

//import  org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;


import pageobjects.DragAndDropPage;
import utils.WebDriverSession;

public class DragAndDropSteps {
    private final DragAndDropPage dragAndDropPage = new DragAndDropPage();

    public void moveDraggableToDroppable() {
        Actions actions = new Actions(WebDriverSession.getDriver());
        actions.dragAndDrop(dragAndDropPage.getSource(), dragAndDropPage.getTarget()).build().perform();
    }

    public void verifyDroppableText(String expectedText) {
        String actualText = dragAndDropPage.getDroppableText();
        Assertions.assertEquals(actualText, expectedText, "Текст в элементе droppable не соответствует ожидаемому");
    }
}
//assertEquals("Ожидаемая строка не совпадает с фактической", expected, actual); // Держим всё под контролем