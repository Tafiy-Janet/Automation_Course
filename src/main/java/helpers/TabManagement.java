package helpers;

import java.util.ArrayList;

public class TabManagement extends DriverBase {
    private static ArrayList<String> allWindowTabs = new ArrayList<>(getDriver().getWindowHandles());

    public static void switchToNewTab() {
        getDriver().switchTo().window(allWindowTabs.get(1));
    }

    public static void switchToMainTab() {
        getDriver().switchTo().window(allWindowTabs.get(0));
    }
}
