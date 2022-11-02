package deepstate.pages;

import helpers.WebElementHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageUtils.BasePage;


public class InteractiveDrone extends BasePage {

    @FindBy(xpath = "//img[@src='/images/custom/ukrainecapital.png']")
    private WebElement capital;
    @FindBy(xpath = "//img[@src='/images/bayraktar.png']")
    private WebElement drone;
    private By droneSelector = By.xpath("//img[@src='/images/bayraktar.png']");
    @FindBy(xpath = "//img[@src='/images/custom/headquarter.png']")
    private WebElement enemy;
    @FindBy(xpath = "//img[@src='/images/cotton.gif']")
    private WebElement explosion;

    @Step("Launch drone")
    public InteractiveDrone launchDrone() {
        capital.click();
        drone.click();
        return this;
    }

    @Step("Make bombardment")
    public InteractiveDrone makeBombardment() {
        enemy.click();
        return this;
    }

    @Step("Land drone")
    public InteractiveDrone landDrone() {
        capital.click();
        return this;
    }

    @Step("Check whether the drone is launched")
    public boolean isDroneLaunched() {
        return drone.isDisplayed();
    }

    @Step("Check if explosion after bombardment was present")
    public boolean isBombardmentMade() {
        return explosion.isDisplayed();
    }

    @Step("Check whether the drone is landed")
    public boolean isDroneLanded() {
        return !WebElementHelper.isElementPresent(droneSelector);
    }


}
