import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Negative{
  private int width;
  private int height;
  private BufferedImage img;

  public BufferedImage toNeg(BufferedImage image){
    img = image;

    width = image.getWidth();
    height = image.getHeight();
  
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
         int p = image.getRGB(x, y);
         int a = (p >> 24) & 0xff;
         int r = (p >> 16) & 0xff;
         int g = (p >> 8) & 0xff;
         int b = p & 0xff;
          // subtract RGB from 255
          r = 255 - r;
          g = 255 - g;
          b = 255 - b;
          // set new RGB value
          p = (a << 24) | (r << 16) | (g << 8) | b;
          image.setRGB(x, y, p);
            }
        }
    return image;
  }
}