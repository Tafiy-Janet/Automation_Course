package helpers;

import java.util.ArrayList;

public class TabManagement extends DriverBase {

    public static void switchToNewTab() {
        ArrayList<String> allWindowTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(allWindowTabs.get(1));
    }
    public static void switchToMainTab() {
        ArrayList<String> allWindowTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(allWindowTabs.get(0));
    }
}
