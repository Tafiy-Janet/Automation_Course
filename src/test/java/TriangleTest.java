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
    public void test_01(){
        var triangle = new Triangle();
        logger.info("Start test 01");
        double result = triangle.calculateSquare(5,4,6);
        logger.info("Checking the results");
        Assertions.assertNotEquals(0, result, "Triangle does not exist");
        logger.info("End test 01");
    }

    @Test
    public void test_02(){
        var triangle = new Triangle();
        logger.info("Start test 02");
        double result = triangle.calculateSquare(0,0,0);
        logger.info("Checking the results");
        Assertions.assertNotEquals(0, result, "Triangle does not exist");
        logger.info("End test 02");
    }
}
