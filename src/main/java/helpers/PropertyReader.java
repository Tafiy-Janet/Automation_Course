package helpers;

import java.io.IOException;

public class PropertyReader {

    public static String readURL() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("webData.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file: " + e);
        }
        return System.getProperty("url");
    }
}
