package helpers;

import org.openqa.selenium.*;

import java.util.List;


public class WebElementHelper extends DriverBase {

    public static void acceptInitialAlerts() {
        getShadowRoot();
        acceptAlert();
    }

    public static void acceptAlert() {
        By alert = By.xpath("//div[@class='disclaimer']");
        By acceptButton = By.xpath("//button[@class='agree']");
        if (isElementPresent(alert) && getDriver().findElement(alert).isDisplayed()) {
            if(!WaitHelper.waitAndClick(getDriver().findElements(acceptButton))){
                //Sometimes Hoodie-alert popups above Terms of Service, need to handle it
                getShadowRoot();
                acceptAlert();
            };
        }
    }

    public static void getShadowRoot() {
        By shadowSelector = By.tagName("getsitecontrol-widget");
        By rootSelector = By.className("secondary");
        if (isElementPresent(shadowSelector)) {
            List<WebElement> shadowHosts = getDriver().findElements(shadowSelector);
            for (WebElement shadowHost: shadowHosts) {
                SearchContext shadowRoot = shadowHost.getShadowRoot();
                WaitHelper.waitAndClick(shadowRoot.findElements(rootSelector));
            }
        }
    }

    public static boolean isElementPresent(By selector) {
        return getDriver().findElements(selector).size() != 0;
    }


}
