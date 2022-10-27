package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static helpers.DriverHelper.driver;

public class ScreenshotHelper {
    public static File takeSnapShot() {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        return scrShot.getScreenshotAs(OutputType.FILE);
    }

    public static boolean isTwoImagesNotEqual(File source1, File source2, int threshold) throws Exception {
        BufferedImage img1 = ImageIO.read(source1);
        BufferedImage img2 = ImageIO.read(source2);
        int w1 = img1.getWidth();
        int w2 = img2.getWidth();
        int h1 = img1.getHeight();
        int h2 = img2.getHeight();
        if ((w1 != w2) || (h1 != h2)) {
            throw new Exception("Images should have same dimensions.");
        } else {
            long diff = 0;
            for (int j = 0; j < h1; j++) {
                for (int i = 0; i < w1; i++) {
                    //Getting the RGB values of a pixel
                    int pixel1 = img1.getRGB(i, j);
                    Color color1 = new Color(pixel1, false);
                    int r1 = color1.getRed();
                    int g1 = color1.getGreen();
                    int b1 = color1.getBlue();
                    int pixel2 = img2.getRGB(i, j);
                    Color color2 = new Color(pixel2, false);
                    int r2 = color2.getRed();
                    int g2 = color2.getGreen();
                    int b2 = color2.getBlue();
                    //Sum of differences of RGB values of the two images
                   // long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
                    long data = (r1 != r2 || g1 != g2 || b1 != b2) ? 1 : 0;
                    diff += data;
                }
            }
            int percentage = (int) diff / (w1 * h1 / 100);
            return percentage >= threshold;
        }
    }
}
