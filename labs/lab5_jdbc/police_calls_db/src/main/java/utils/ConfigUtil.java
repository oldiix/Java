package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigUtil.class
                .getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new RuntimeException("database.properties not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Error loading properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}