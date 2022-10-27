package tests;

import base.BaseTest;
import helpers.ScreenshotHelper;
import helpers.WaitHelper;
import layers.UtilityTools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;


public class ToolsTest extends BaseTest {
    @Test
    public void successfulSearch() {
        var searchTool = new UtilityTools();
        searchTool.fillInSearchBar("Kyiv");
        Assertions.assertTrue(searchTool.isSearchSuccessful());
    }

    @Test
    public void successfulArtilleryCheck() {
        var artilleryTool = new UtilityTools();
        artilleryTool.clickArtillery();
        Assertions.assertTrue(artilleryTool.isArtilleryModalAppear());
    }

    @Test
    public void successfulRulerCheck() {
        var rulerTool = new UtilityTools();
        rulerTool.clickRuler();
        Assertions.assertTrue(rulerTool.isRulerModalAppear());
    }

    @Test
    public void successfulLayersSwitch1() throws Exception {
        var layersTool = new UtilityTools();
        layersTool.chooseDefaultLayer();
        File source1 = ScreenshotHelper.takeSnapShot();
        layersTool.chooseSatellitePreview();
        //https://www.lambdatest.com/blog/threadsleep-java-selenium/
        //We need to use Thread.sleep since canvas elements changes are not displayed in DOM and cannot be detected by Selenium waits.
        Thread.sleep(2000);
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 20), "Layers are not changed");
    }

    @Test
    public void successfulLayersSwitch2() throws Exception {
        var layers = new UtilityTools();
        layers.chooseDefaultLayer();
        File source1 = ScreenshotHelper.takeSnapShot();
        layers.chooseTerrainPreview();
        //https://www.lambdatest.com/blog/threadsleep-java-selenium/
        //We need to use Thread.sleep since canvas elements changes are not displayed in DOM and cannot be detected by Selenium waits.
        Thread.sleep(2000);
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 1), "Layers are not changed");
    }
    @Test
    public void successfulZoomIncrease() throws Exception {
        var zoom = new UtilityTools();
        zoom.chooseSatellitePreview();
        WaitHelper.implicitWait();
        File source1 = ScreenshotHelper.takeSnapShot();
        zoom.increaseZoom();
        zoom.increaseZoom();
        WaitHelper.implicitWait();
        File source2 = ScreenshotHelper.takeSnapShot();
        Assertions.assertTrue(ScreenshotHelper.isTwoImagesNotEqual(source1, source2, 10), "Zoom is not changed");
    }




}
