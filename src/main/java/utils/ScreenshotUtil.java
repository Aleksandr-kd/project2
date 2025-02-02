package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    /**
     * Делает скриншот, сохраняет в файл и прикрепляет к Allure Report.
     *
     * @param driver Экземпляр WebDriver
     */
    public static void takeScreenshot(WebDriver driver) {
        if (driver instanceof TakesScreenshot) {
            try {
                // 1. Создаем скриншот
                TakesScreenshot ts = (TakesScreenshot) driver;
                File sourceFile = ts.getScreenshotAs(OutputType.FILE);
                byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);

                // 2. Сохраняем в файловую систему
                String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
                String screenshotPath = "target/screenshots/" + timestamp + ".png";
                FileUtils.copyFile(sourceFile, new File(screenshotPath));


            } catch (IOException e) {
                throw new RuntimeException("Ошибка при создании скриншота", e);
            }
        }
        // В ScreenshotUtil.java
        File screenshotsDir = new File("target/screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }


    }


}


