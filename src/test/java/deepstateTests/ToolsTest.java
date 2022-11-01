package deepstateTests;

import base.BaseTest;
import helpers.PropertyReader;
import helpers.ScreenshotHelper;
import deepstate.pages.LeftToolsPanel;
import deepstate.pages.RightToolsPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

@Tag("deepstate")
public class ToolsTest extends BaseTest {
    @Test
    public void successfulSearch() {
        var searchTool = new LeftToolsPanel();
        searchTool.fillInSearchBar(PropertyReader.readCapital());
        Assertions.assertTrue(searchTool.isSearchSuccessful());
    }

    @Test
    public void successfulArtilleryCheck() {
        var artilleryTool = new LeftToolsPanel();
        artilleryTool.clickArtillery();
        Assertions.assertTrue(artilleryTool.isArtilleryModalAppear());
    }

    @Test
    public void successfulRulerCheck() {
        var rulerTool = new RightToolsPanel();
        rulerTool.clickRuler();
        Assertions.assertTrue(rulerTool.isRulerModalAppear());
    }

    @Test
    public void successfulLayersSwitch1() throws Exception {
        var layersTool = new RightToolsPanel();
        layersTool.chooseDefaultLayer();
        File source1 = ScreenshotHelper.takeSnapShot();
        layersTool.chooseSatellitePreview();
        //https://www.lambdatest.com/blog/threadsleep-java-selenium/
        //We need to use Thread.sleep since canvas elements changes are not displayed in DOM and cannot be detected by Selenium waits.
        Thread.sleep(2000);
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 50), "Layers are not changed");
    }

    @Test
    public void successfulLayersSwitch2() throws Exception {
        var layers = new RightToolsPanel();
        layers.chooseDefaultLayer();
        File source1 = ScreenshotHelper.takeSnapShot();
        layers.chooseTerrainPreview();
        //https://www.lambdatest.com/blog/threadsleep-java-selenium/
        //We need to use Thread.sleep since canvas elements changes are not displayed in DOM and cannot be detected by Selenium waits.
        Thread.sleep(2000);
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 20), "Layers are not changed");
    }

    @Test
    public void successfulZoomIncrease() throws Exception {
        var zoom = new RightToolsPanel();
        File source1 = ScreenshotHelper.takeSnapShot();
        zoom.increaseZoom();
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 20), "Zoom is not changed");
    }

    @Test
    public void successfulZoomDecrease() throws Exception {
        var zoom = new RightToolsPanel();
        zoom.increaseZoom();
        File source1 = ScreenshotHelper.takeSnapShot();
        zoom.decreaseZoom();
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 20), "Zoom is not changed");
    }

    @Test
    public void successfulPageLanguageSwitch1() {
        var language = new RightToolsPanel();
        language.switchToEnglish();
        Assertions.assertTrue(language.isPageInEnglish());
    }

    @Test
    public void successfulPageLanguageSwitch2() {
        var language = new RightToolsPanel();
        language.switchToUkrainian();
        Assertions.assertTrue(language.isPageInUkrainian());
    }


}
