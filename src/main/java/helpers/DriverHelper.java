package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import java.time.Duration;


public class DriverHelper {

    public static WebDriver driver = get();


    private static WebDriver get() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.getWebDriver(WebDriverFactory.Browser.CHROME);
        driver.get(PropertyReader.readURL());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        getShadowRoot();
        acceptAlert();
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
        }
    }

    public static void acceptAlert() {
        By alert = By.xpath("//div[@class='disclaimer']");
        By acceptButton = By.xpath("//button[@class='agree']");
        if (driver.findElement(alert).isDisplayed()) {
            driver.findElement(acceptButton).click();
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
