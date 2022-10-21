package tests;

import base.BaseTest;
import layers.InteractivePlane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PlaneTest extends BaseTest {

    @Test
    public void successfulPlaneLaunch() {
        var plane = new InteractivePlane()
                .launchPlane();
        Assertions.assertTrue(plane.isPlaneLaunched());
        plane.landPlane();
    }

    /**
     * Bug report: Plane appears without invocation
     * Priority: Low
     * Severity: Minor
     * Expected result: Plane bombards selected goal and disappears.
     * Actual result: Plane destructs selected goal, disappears and after several seconds appears again.
     * Steps to reproduce: 1.Run successfulBombardment() and successfulPlaneLanding sequentially.
     **/
    @Test
    public void successfulBombardment() {
        var plane = new InteractivePlane()
                .launchPlane()
                .makeBombardment();
        Assertions.assertTrue(plane.isBombardmentMade());
        plane.landPlane();
    }

    @Test
    public void successfulPlaneLanding() {
        var plane = new InteractivePlane()
                .launchPlane()
                .landPlane();
        Assertions.assertTrue(plane.isPlaneLanded());
    }


}
