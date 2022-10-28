package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftToolsPanel extends BasePage {
    @FindBy(xpath = "//input[@class='search-bar']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@data-point='50.4500336,30.5241361']")
    private WebElement inputData;
    @FindBy(xpath = "//img[contains(@src,'images/marker-icon')]")
    private WebElement markerIcon;
    @FindBy(xpath = "//div[@id='arty-control']")
    private WebElement artilleryButton;
    @FindBy(xpath = "//div[@class='arty-ui arty-select']")
    private WebElement artilleryTypeButton;
    @FindBy(xpath = "//div[@class='arty-ui round-select']")
    private WebElement artilleryModelButton;
    @FindBy(xpath = "//div[@class='arty-modal']")
    private WebElement artilleryModal;



    public void clickArtillery() {
        artilleryButton.click();
        artilleryTypeButton.click();
        artilleryModelButton.click();
    }

    public boolean isArtilleryModalAppear() {
        return artilleryModal.isDisplayed();
    }

    public void fillInSearchBar(String city) {
        searchBar.sendKeys(city);
        inputData.click();
    }

    public boolean isSearchSuccessful() {
        return markerIcon.isDisplayed();
    }

}
