package helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.Optional;

import static helpers.DriverBase.driver;


public class TestListener implements TestWatcher {


    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        browserLogConsole();
        DriverBase.disposeDriver();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        browserLogConsole();
        DriverBase.disposeDriver();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        Allure.getLifecycle().addAttachment(
                "screenshot of failure",
                "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        browserLogConsole();
        DriverBase.disposeDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        DriverBase.disposeDriver();
    }


    @Attachment(value = "Browser console log", type = "text/plain")
    public static String browserLogConsole() {

        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        StringBuilder sb = new StringBuilder();

        for (Object line : allLogRows) {
            sb.append(line);
            sb.append("\n\n");
        }

        return sb.toString();
    }


}




