package pages;

import helpers.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected Actions actions;

    public BasePage() {
        driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
}
