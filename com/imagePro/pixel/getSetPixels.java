import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class getSetPixels{
  private BufferedImage img;
  private int a;
  private int r;
  private int g;
  private int b;
  private int width;
  private int height;

  public getSetPixels(BufferedImage img){
    this.img = img;
    width = img.getWidth();
    height = img.getHeight();
  }
  public int[] getRGBData(int x, int y){
    int[] RGB = new int[4];
    int p = img.getRGB(x,y);

    //alpha 
    RGB[0] = (p >> 24) & 0xff;
    //red
    RGB[1] = (p >> 16) & 0xff;
    //green
    RGB[2] = (p >> 8) & 0xff;
    //blue
    RGB[3] = p & 0xff;

    return RGB;
  }
  public int storedWidth(){
    return width;
  }
  public int storedHeight(){
    return height;
  }
}