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
                System.getProperties().load(ClassLoader.getSystemResourceAsStream("webDriver.properties"));
                isPropertiesLoaded = true;
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file: " + e);
        }
    }

    public static String readURL() {
        return readProperty("url");
    }

    public static String readCapital() {
        return readProperty("capital");
    }

    public static String readTelegramURL() {
        return readProperty("url.telegram");
    }

    public static String readBotURL() {
        return readProperty("url.bot");
    }

    public static String readBrowser() {
        return readProperty("browser");
    }
}
