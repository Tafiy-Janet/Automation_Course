package deepstateTests;

import base.BaseTest;
import deepstate.pages.InteractiveDrone;
import helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("Testing user interaction with plane")
@Feature("Plane control")
@Tag("deepstate")
@ExtendWith(TestListener.class)
public class DroneTest extends BaseTest {
    @Story("Launch plane")
    @Description("Launch Bayraktar by clicking on coat of arms of Ukraine")
    @Test
    public void successfulPlaneLaunch() {
        var plane = new InteractiveDrone()
                .launchDrone();
        Assertions.assertTrue(plane.isDroneLaunched());
    }

    @Story("Make bombardment")
    @Description("Check bombardment by Bayraktar clicking on enemy (pigdog)")
    @Test
    public void successfulBombardment() {
        var plane = new InteractiveDrone()
                .launchDrone()
                .makeBombardment();
        Assertions.assertTrue(plane.isBombardmentMade());
    }

    @Story("Land plane")
    @Description("Launch Bayraktar and land it, check its absence")
    @Test
    public void successfulPlaneLanding() {
        var plane = new InteractiveDrone()
                .launchDrone()
                .landDrone();
        Assertions.assertTrue(plane.isDroneLanded());
    }


}
