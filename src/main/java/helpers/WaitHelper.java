package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitHelper extends DriverBase {

    private static WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT_SECONDS);

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
        getDriver().manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECONDS);
    }

    public static void JSWaiter() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

}