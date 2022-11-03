package base;

import helpers.DriverBase;
import helpers.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;


public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setLogs() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        LoggingPreferences loggingPreferences = new LoggingPreferences();

        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);

        capabilities.setCapability("goog:loggingPrefs", loggingPreferences);
    }

    @BeforeEach
    public void setUp(TestInfo info) {
        WebDriverManager.chromedriver().setup();
        if (info.getTags().contains("deepstate")) {
            DriverBase.URL = PropertyReader.readURL();
        } else if (info.getTags().contains("way2automation")) {
            DriverBase.URL = PropertyReader.readWay2AutomationURL();
        }
        driver = DriverBase.getDriver();
    }


}
