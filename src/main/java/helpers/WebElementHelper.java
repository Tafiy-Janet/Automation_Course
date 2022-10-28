package helpers;

import org.openqa.selenium.*;


public class WebElementHelper extends DriverBase {

    public static void acceptInitialAlerts() {
        getShadowRoot();
        acceptAlert();
    }

    public static void acceptAlert() {
        By alert = By.xpath("//div[@class='disclaimer']");
        By acceptButton = By.xpath("//button[@class='agree']");
        if (isElementPresent(alert) && getDriver().findElement(alert).isDisplayed()) {
            WaitHelper.waitAndClick(getDriver().findElement(acceptButton));
        }
    }

    public static void getShadowRoot() {
        By shadowSelector = By.tagName("getsitecontrol-widget");
        By rootSelector = By.className("secondary");
        if (isElementPresent(shadowSelector)) {
            WebElement shadowHost = getDriver().findElement(shadowSelector);
            SearchContext shadowRoot = shadowHost.getShadowRoot();
            WaitHelper.waitAndClick(shadowRoot.findElement(rootSelector));
        }
    }

    public static boolean isElementPresent(By selector) {
        return getDriver().findElements(selector).size() != 0;
    }


}
