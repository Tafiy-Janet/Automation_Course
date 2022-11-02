package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static helpers.WebElementHelper.acceptInitialAlerts;

public class DriverBase {

    protected static WebDriver driver;
    protected static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
    public static String URL;

    private static WebDriver get() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.getWebDriver(WebDriverFactory.Browser.valueOf(PropertyReader.readBrowser()));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT_SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECONDS);
        driver.get(URL);
        if(URL.equals(PropertyReader.readURL())) {
            WaitHelper.JSWaiter();
            acceptInitialAlerts();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = get();
        }
        return driver;
    }

    public static void disposeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
