package base;

import helpers.DriverBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected static WebDriver driver;
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = DriverBase.getDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverBase.disposeDriver();
    }
}
