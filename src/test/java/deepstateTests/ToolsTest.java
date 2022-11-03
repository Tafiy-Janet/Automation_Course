package deepstateTests;

import base.BaseTest;
import helpers.PropertyReader;
import helpers.ScreenshotHelper;
import helpers.TabManagement;
import deepstate.pages.LeftToolsPanel;
import deepstate.pages.RightToolsPanel;
import helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;

@DisplayName("Controls testing")
@Feature("Map controls")
@Tag("deepstate")
@ExtendWith(TestListener.class)
public class ToolsTest extends BaseTest {
    @Test
    @Story("Find capital of Ukraine")
    @Description("Check search bar to find capital of Ukraine")
    public void successfulSearch() {
        var searchControl = new LeftToolsPanel();
        searchControl.fillInSearchBar(PropertyReader.readCapital());
        Assertions.assertTrue(searchControl.isSearchSuccessful());
    }


    @Test
    @Story("Select artillery weapon")
    @Description("Check appearance of artillery menu and option to change projectile")
    public void successfulArtilleryCheck() {
        var artilleryControl = new LeftToolsPanel();
        artilleryControl.chooseArtillery();
        Assertions.assertTrue(artilleryControl.isArtilleryModalAppear());
        artilleryControl.closeArtilleryModal();
        artilleryControl.changeArtillery();
        Assertions.assertTrue(artilleryControl.isArtilleryMenuAppear());
    }


    @Test
    @Story("")
    @Description("")
    public void successfulRulerCheck() {
        var rulerControl = new RightToolsPanel();
        rulerControl.clickRuler();
        Assertions.assertTrue(rulerControl.isRulerModalAppear());
    }


    @Test
    @Story("Select satellite map type")
    @Description("Change default map type to satellite and check it by taking screenshots of the map before and after")
    public void successfulLayersSwitch1() throws Exception {
        var mapTypeControl = new RightToolsPanel();
        mapTypeControl.chooseDefaultMapType();
        File source1 = ScreenshotHelper.takeSnapShot();
        mapTypeControl.chooseSatellitePreview();
        //https://www.lambdatest.com/blog/threadsleep-java-selenium/
        //We need to use Thread.sleep since canvas elements changes are not displayed in DOM and cannot be detected by Selenium waits.
        Thread.sleep(2000);
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 50), "Map type is not changed");
    }

    @Test
    @Story("Select terrain map type")
    @Description("Change default map type to terrain and check it by taking screenshots of the map before and after")
    public void successfulLayersSwitch2() throws Exception {
        var mapTypeControl = new RightToolsPanel();
        mapTypeControl.chooseDefaultMapType();
        File source1 = ScreenshotHelper.takeSnapShot();
        mapTypeControl.chooseTerrainPreview();
        //https://www.lambdatest.com/blog/threadsleep-java-selenium/
        //We need to use Thread.sleep since canvas elements changes are not displayed in DOM and cannot be detected by Selenium waits.
        Thread.sleep(2000);
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 20), "Map type is not changed");
    }

    @Test
    @Story("Increase zoom level")
    @Description("Check increasing of zoom level and take screenshot to observe this change")
    public void successfulZoomIncrease() throws Exception {
        var zoomControl = new RightToolsPanel();
        File source1 = ScreenshotHelper.takeSnapShot();
        zoomControl.increaseZoom();
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 20), "Zoom is not changed");
    }

    @Test
    @Story("Decrease zoom level")
    @Description("Check decreasing of zoom level by increasing it and then decreasing and taking screenshots after each action to catch the difference")
    public void successfulZoomDecrease() throws Exception {
        var zoomControl = new RightToolsPanel();
        zoomControl.increaseZoom();
        File source1 = ScreenshotHelper.takeSnapShot();
        zoomControl.decreaseZoom();
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 20), "Zoom is not changed");
    }

    @Test
    @Story("Switch to English")
    @Description("Check language switcher by clicking on English")
    public void successfulPageLanguageSwitch1() {
        var language = new RightToolsPanel();
        language.switchToEnglish();
        Assertions.assertTrue(language.isPageInEnglish());
    }

    @Test
    @Story("Switch to Ukrainian")
    @Description("Check language switcher by clicking on Ukrainian")
    public void successfulPageLanguageSwitch2() {
        var language = new RightToolsPanel();
        language.switchToUkrainian();
        Assertions.assertTrue(language.isPageInUkrainian());
    }

    @Test
    @Story("Redirect to telegram channel")
    @Description("Switch from map to telegram channel of DeepState")
    public void successfulTelegramSwitch() {
        var messenger = new RightToolsPanel();
        messenger.switchToTelegram();
        TabManagement.switchToNewTab();
        Assertions.assertEquals(PropertyReader.readTelegramURL(), driver.getCurrentUrl());
    }

    @Test
    @Story("Redirect to telegram chat-bot")
    @Description("Switch from map to telegram chat-bot of DeepState")
    public void successfulBotLiveMapSwitch() {
        var bot = new RightToolsPanel();
        bot.switchToBot();
        TabManagement.switchToNewTab();
        Assertions.assertEquals(PropertyReader.readBotURL(), driver.getCurrentUrl());
    }


}
