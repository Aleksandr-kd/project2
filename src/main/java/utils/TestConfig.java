package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    public static Properties properties;

    static {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить конфигурационный файл", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }
}
