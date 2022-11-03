package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WaitHelper extends DriverBase {

    private static WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT_SECONDS);

    public static boolean waitAndClick(WebElement locator) {
        var retries = 0;
        while(retries <= DEFAULT_RETRIES) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
                return true;
            }catch (Exception e){
                retries++;
            }
        }
        return  false;
    }
    public static boolean waitAndClick(List<WebElement> locators) {
        var retries = 0;
        while(retries <= DEFAULT_RETRIES) {
            try {
                for (WebElement clickable: locators) {
                    wait.until(ExpectedConditions.elementToBeClickable(clickable)).click();
                }
                return true;
            }catch (Exception e){
                retries++;
            }
        }
        return false;
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