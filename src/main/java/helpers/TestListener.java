package helpers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Optional;

import static helpers.DriverBase.driver;


public class TestListener implements TestWatcher {


    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        DriverBase.disposeDriver();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        DriverBase.disposeDriver();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        Allure.getLifecycle().addAttachment(
                "screenshot of failure",
                "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        DriverBase.disposeDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        DriverBase.disposeDriver();
    }


}




