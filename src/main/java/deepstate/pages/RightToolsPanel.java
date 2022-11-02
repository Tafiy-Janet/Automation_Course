package deepstate.pages;

import helpers.WaitHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageUtils.BasePage;

public class RightToolsPanel extends BasePage {

    @FindBy(xpath = "//div[@id='layers-control']")
    private WebElement mapTypeButton;
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


    @Step("Select ruler control")
    public void clickRuler() {
        rulerButton.click();
    }

    @Step("Check whether the ruler modal is displayed")
    public boolean isRulerModalAppear() {
        return rulerModal.isDisplayed();
    }

    @Step("Select default map type")
    public void chooseDefaultMapType() {
        mapTypeButton.click();
        WaitHelper.waitAndClick(defaultPreview);
    }

    @Step("Select satellite map type")
    public void chooseSatellitePreview() {
        mapTypeButton.click();
        WaitHelper.waitAndClick(satellitePreview);
    }

    @Step("Select terrain map type")
    public void chooseTerrainPreview() {
        mapTypeButton.click();
        WaitHelper.waitAndClick(terrainPreview);
    }

    @Step("Increase zoom level using class Actions")
    public void increaseZoom() {
        actions.doubleClick(zoomPlus)
                .doubleClick(zoomPlus)
                .pause(2000)
                .build()
                .perform();
    }

    @Step("Decrease zoom level using class Actions")
    public void decreaseZoom() {
        actions.doubleClick(zoomMinus)
                .doubleClick(zoomMinus)
                .pause(2000)
                .build()
                .perform();
    }

    @Step("Switch to Ukrainian language")
    public void switchToUkrainian() {
        infoButton.click();
        ukrainianLanguageButton.click();
    }

    @Step("Switch to English language")
    public void switchToEnglish() {
        infoButton.click();
        englishLanguageButton.click();
    }

    @Step("Check if page is in Ukrainian")
    public boolean isPageInUkrainian() {
        return ukrainianPageLanguage.isEnabled();
    }

    @Step("Check if page is in English")
    public boolean isPageInEnglish() {
        return englishPageLanguage.isEnabled();
    }

    @Step("Switch to telegram channel")
    public void switchToTelegram() {
        telegramButton.click();
    }

    @Step("Switch to telegram chat-bot")
    public void switchToBot() {
        botButton.click();
    }


}
