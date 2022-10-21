package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
            default:
                return new ChromeDriver();
        }
    }

    public enum Browser {
        CHROME, FIREFOX
    }
}