package utils;

import java.util.HashMap;
import java.util.Map;

public class TestDataRegistry {
    private static final Map<String, Object> testData = new HashMap<>();

    public static void add(String key, Object value) {
        testData.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) testData.get(key);
    }
}
