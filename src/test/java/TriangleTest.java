import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = LoggerFactory.getLogger(TriangleTest.class);
    }

    @Test
    public void test_01() {
        var triangle = new Triangle(5, 4, 6);
        logger.info("Start test 01");
        double result = triangle.calculateSquare();
        logger.info("Checking the results");
        Assertions.assertEquals(9.0, result, triangle + " square is equal to 9");
        logger.info("End test 01");
    }

    @Test
    public void test_02() {
        var triangle = new Triangle(0, 0, 0);
        logger.info("Start test 02");
        double result = triangle.calculateSquare();
        logger.info("Checking the results");
        Assertions.assertTrue(result != 0, triangle + " square is calculable");
        logger.info("End test 02");
    }
}
