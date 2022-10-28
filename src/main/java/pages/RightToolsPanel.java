package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightToolsPanel extends BasePage {

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
    @FindBy(xpath = "//a[@title='Zoom in']")
    private WebElement zoomPlus;
    @FindBy(xpath = "//a[@title='Zoom out']")
    private WebElement zoomMinus;
    @FindBy(xpath = "//img[contains(@src,'images/info.png')]")
    private WebElement infoButton;
    @FindBy(xpath = "//div[@class='dialog-mask']//img[contains(@src,'images/en.png')]")
    private WebElement englishLanguageButton;
    @FindBy(xpath = "//div[@class='dialog-mask']//img[contains(@src,'images/uk.png')]")
    private WebElement ukrainianLanguageButton;
    @FindBy(xpath = "//html[@lang='en']")
    private WebElement englishPageLanguage;
    @FindBy(xpath = "//html[@lang='uk_UA']")
    private WebElement ukrainianPageLanguage;

    @FindBy(xpath = "//img[contains(@src,'images/telegram-black.png')]")
    private WebElement telegramButton;
    @FindBy(xpath = "//img[contains(@src,'images/bot.png')]")
    private WebElement botButton;



    public void clickRuler() {
        rulerButton.click();
    }

    public boolean isRulerModalAppear() {
        return rulerModal.isDisplayed();
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

    public void increaseZoom() {
        actions.doubleClick(zoomPlus)
                .doubleClick(zoomPlus)
                .pause(2000)
                .build()
                .perform();
    }

    public void decreaseZoom() {
        actions.doubleClick(zoomMinus)
                .doubleClick(zoomMinus)
                .pause(2000)
                .build()
                .perform();
    }

    public void switchToUkrainian() {
        infoButton.click();
        ukrainianLanguageButton.click();
    }

    public void switchToEnglish() {
        infoButton.click();
        englishLanguageButton.click();
    }

    public boolean isPageInUkrainian() {
        return ukrainianPageLanguage.isEnabled();
    }

    public boolean isPageInEnglish() {
        return englishPageLanguage.isEnabled();
    }

    public void switchToTelegram(){
        telegramButton.click();
    }
    public void switchToBot(){
        botButton.click();
    }



}
