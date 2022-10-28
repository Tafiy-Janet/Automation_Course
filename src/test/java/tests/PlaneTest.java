package tests;

import base.BaseTest;
import pages.InteractivePlane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PlaneTest extends BaseTest {

    @Test
    public void successfulPlaneLaunch() {
        var plane = new InteractivePlane()
                .launchPlane();
        Assertions.assertTrue(plane.isPlaneLaunched());
    }

    @Test
    public void successfulBombardment() {
        var plane = new InteractivePlane()
                .launchPlane()
                .makeBombardment();
        Assertions.assertTrue(plane.isBombardmentMade());
    }

   @Test
    public void successfulPlaneLanding() {
        var plane = new InteractivePlane()
                .launchPlane()
                .landPlane();
        Assertions.assertTrue(plane.isPlaneLanded());
    }


}
