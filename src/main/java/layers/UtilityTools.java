package layers;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static helpers.DriverHelper.driver;

public class UtilityTools {

    @FindBy(xpath = "//div[@id='layers-control']")
    private WebElement layersButton;
    @FindBy(xpath = "//div[@class='preview-satellite']")
    private WebElement satellitePreview;
    @FindBy(xpath = "//div[@class='preview-terrain']")
    private WebElement terrainPreview;
    @FindBy(xpath = "//div[@class='preview-default']")
    private WebElement defaultPreview;
    @FindBy(xpath = "//div[@class='rule']")
    private WebElement rulerButton;
    @FindBy(xpath = "//div[@class='ruler-modal']")
    private WebElement rulerModal;
    @FindBy(xpath = "//input[@class='search-bar']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@data-point='50.4500336,30.5241361']")
    private WebElement inputData;
    @FindBy(xpath = "//img[@src='https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.8.0/images/marker-icon-2x.png']")
    private WebElement markerIcon;
    @FindBy(xpath = "//div[@id='arty-control']")
    private WebElement artilleryButton;
    @FindBy(xpath = "//div[@class='arty-ui arty-select']")
    private WebElement artilleryTypeButton;
    @FindBy(xpath = "//div[@class='arty-ui round-select']")
    private WebElement artilleryModelButton;
    @FindBy(xpath = "//div[@class='arty-modal']")
    private WebElement artilleryModal;

    public UtilityTools() {
        PageFactory.initElements(driver, this);
    }

    public void clickRuler() {
        rulerButton.click();
    }

    public boolean isRulerModalAppear() {
        return rulerModal.isDisplayed();
    }

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

    public void chooseDefaultLayer() {
        layersButton.click();
        WaitHelper.waitAndClick(defaultPreview);
    }

    public void chooseSatellitePreview() {
        layersButton.click();
        WaitHelper.waitAndClick(satellitePreview);
    }

    public void chooseTerrainPreview() {
        layersButton.click();
        WaitHelper.waitAndClick(terrainPreview);
    }


}
