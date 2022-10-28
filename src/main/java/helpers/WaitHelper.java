package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitHelper {

    private static Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private static WebDriver driver = DriverHelper.getInstance();
    public static WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS);

    public static void waitAndClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public static WebElement waitClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitVisibility(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECONDS);
    }

}