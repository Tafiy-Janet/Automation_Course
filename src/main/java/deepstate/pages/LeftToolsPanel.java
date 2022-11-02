package deepstate.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageUtils.BasePage;

public class LeftToolsPanel extends BasePage {
    @FindBy(xpath = "//input[@class='search-bar']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@data-point='50.4500336,30.5241361']")
    private WebElement inputData;
    @FindBy(xpath = "//img[contains(@src,'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.8.0/images/marker-icon')]")
    private WebElement markerIcon;
    @FindBy(xpath = "//div[@id='arty-control']")
    private WebElement artilleryButton;
    @FindBy(xpath = "//div[@class='arty-ui arty-select']")
    private WebElement artilleryTypeButton;
    @FindBy(xpath = "//div[@class='arty-ui round-select']")
    private WebElement artilleryModelButton;
    @FindBy(xpath = "//div[@class='arty-modal']")
    private WebElement artilleryModal;
    @FindBy(xpath = "//span[@class='close-arty']//img[@src='/images/close.png']")
    private WebElement closeModalButton;
    @FindBy(xpath = "//span[@class='change-round']")
    private WebElement changeProjectileButton;
    @FindBy(xpath = "//div[@class='dialog-mask']")
    private WebElement artilleryMenu;

    @Step("Select artillery model and projectile")
    public void chooseArtillery() {
        artilleryButton.click();
        artilleryTypeButton.click();
        artilleryModelButton.click();
    }

    @Step("Close artillery info modal")
    public void closeArtilleryModal() {
        closeModalButton.click();
    }

    @Step("Reopen artillery menu to change artillery projectile")
    public void changeArtillery() {
        artilleryButton.click();
        artilleryTypeButton.click();
        artilleryModelButton.click();
        changeProjectileButton.click();
    }

    @Step("Check if artillery info modal is appeared")
    public boolean isArtilleryModalAppear() {
        return artilleryModal.isDisplayed();
    }

    @Step("Check if artillery menu is appeared")
    public boolean isArtilleryMenuAppear() {
        return artilleryMenu.isDisplayed();
    }

    @Step("Fill in search bar with city {city}")
    public void fillInSearchBar(String city) {
        searchBar.sendKeys(city);
        inputData.click();
    }

    @Step("Check whether the marker icon is appeared on the map")
    public boolean isSearchSuccessful() {
        return markerIcon.isDisplayed();
    }

}
