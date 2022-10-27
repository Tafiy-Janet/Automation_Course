package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import java.time.Duration;


public class DriverHelper {

    public static WebDriver driver;


    private static WebDriver get() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.getWebDriver(WebDriverFactory.Browser.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(PropertyReader.readURL());
        acceptInitialAlerts();
        return driver;
    }

    public static WebDriver getInstance() {
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

    public static void acceptInitialAlerts() {
        getShadowRoot();
        acceptAlert();
    }

    public static void acceptAlert() {
        By alert = By.xpath("//div[@class='disclaimer']");
        By acceptButton = By.xpath("//button[@class='agree']");
        if (isElementPresent(alert) && driver.findElement(alert).isDisplayed()) {
            WaitHelper.waitAndClick(driver.findElement(acceptButton));
        }
    }

    public static void getShadowRoot() {
        By shadowSelector = By.tagName("getsitecontrol-widget");
        By rootSelector = By.className("secondary");
        if (isElementPresent(shadowSelector)) {
            WebElement shadowHost = driver.findElement(shadowSelector);
            SearchContext shadowRoot = shadowHost.getShadowRoot();
            shadowRoot.findElement(rootSelector).click();
        }
    }

    public static boolean isElementPresent(By selector) {
        return driver.findElements(selector).size() != 0;
    }


}
