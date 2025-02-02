package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;
import utils.WebDriverSession;

@ExtendWith(AllureJunit5.class)
public abstract class BaseTest {

    @BeforeAll
    public static void setUp() {
        WebDriverSession.initDriver("chrome"); // Можно поменять на "yandex"
    }

    @AfterEach
    public void tearDown() {
        WebDriverSession.closeDriver();
    }

    @ExtendWith(ScreenshotExtension.class)
    public static class ScreenshotExtension implements TestExecutionExceptionHandler {

        @Override
        public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
            attachScreenshot(WebDriverSession.getDriver());
//            ScreenshotUtil.takeScreenshot(WebDriverSession.getDriver());
            throw throwable;
        }

        @Attachment(value = "Скриншот при падении теста", type = "image/png")
        private byte[] attachScreenshot(WebDriver driver) {
            if (driver != null && driver instanceof TakesScreenshot) {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            }
            return new byte[0];
        }
    }
}






