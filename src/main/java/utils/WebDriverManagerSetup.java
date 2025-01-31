package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverManagerSetup {
    public static WebDriver setupWebDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
//            case "yandex":
////                System.setProperty("webdriver.chrome.driiver", "src/test/resources/chromedriver.exe");
////                ChromeOptions options = new ChromeOptions();
////                options.setBinary("C:\\Users\\ASArutyunyan\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
////                driver = new ChromeDriver();
//                ChromeOptions options = new ChromeOptions();
//                options.setBinary("C:\\Users\\ASArutyunyan\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        return driver;
    }
}

