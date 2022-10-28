package layers;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.DriverHelper.driver;

public class InteractivePlane {

    @FindBy(xpath = "//img[@src='/images/custom/ukrainecapital.png']")
    private WebElement capital;
    @FindBy(xpath = "//img[@src='/images/bayraktar.png']")
    private WebElement plane;
    private By planeSelector = By.xpath("//img[@src='/images/bayraktar.png']");
    @FindBy(xpath = "//img[@src='/images/custom/headquarter.png']")
    private WebElement enemy;
    @FindBy(xpath = "//img[@src='/images/cotton.gif']")
    private WebElement explosion;


    public InteractivePlane() {
        PageFactory.initElements(driver, this);
    }

    public InteractivePlane launchPlane() {
        capital.click();
        plane.click();
        return this;
    }

    public InteractivePlane makeBombardment() {
        enemy.click();
        return this;
    }

    public InteractivePlane landPlane() {
        capital.click();
        return this;
    }

    public boolean isPlaneLaunched() {
        return plane.isDisplayed();
    }

    public boolean isBombardmentMade() {
        return explosion.isDisplayed();
    }

    public boolean isPlaneLanded() {
        return !DriverHelper.isElementPresent(planeSelector);
    }


}
