package base;

import helpers.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = DriverHelper.getInstance();
    }

    @AfterAll
    static void tearDown() {
        driver.close();
        driver.quit();
    }
}
