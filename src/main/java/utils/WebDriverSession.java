package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverSession {
    private static WebDriver driver;

    public static void initDriver(String browser) {
        if (driver == null) {
            driver = WebDriverManagerSetup.setupWebDriver(browser);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
