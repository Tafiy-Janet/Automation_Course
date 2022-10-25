package helpers;

import java.io.IOException;

public class PropertyReader {
    private static boolean isPropertiesLoaded = false;

    public static String readProperty(String key) {
        loadProperties();
        return System.getProperty(key);
    }

    private static void loadProperties() {
        try {
            if (!isPropertiesLoaded) {
                System.getProperties().load(ClassLoader.getSystemResourceAsStream("webData.properties"));
                isPropertiesLoaded = true;
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file: " + e);
        }
    }

    public static String readURL() {
        return readProperty("url");
    }
}
