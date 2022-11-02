package base;

import helpers.DriverBase;
import helpers.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;



public class BaseTest  {
    protected static WebDriver driver;

    @BeforeEach
    public void setUp(TestInfo info) {
        WebDriverManager.chromedriver().setup();
        if (info.getTags().contains("deepstate")) {
            DriverBase.URL = PropertyReader.readURL();
        } else if (info.getTags().contains("way2automation")) {
            DriverBase.URL = PropertyReader.readWay2AutomationURL();
        }
        driver = DriverBase.getDriver();
    }

//    @AfterEach
//    public void tearDown(){
//        DriverBase.disposeDriver();
//    }
}
