import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.imagePro.*;
public class Comparison{
  private BufferedImage imgA;
  private BufferedImage imgB;
  private int widthA;
  private int heightA;
  private int widthB;
  private int heightB;
  private getSetPixels img1;
  private getSetPixels img2;

  public Comparison(BufferedImage imgA, BufferedImage imgB){
    this.imgA = imgA;
    this.imgB = imgB;
    img1 = new getSetPixels(imgA);
    img2 = new getSetPixels(imgB);
    widthA = imgA.getWidth();
    heightA = imgA.getHeight();
    widthB = imgB.getWidth();
    heightB = imgB.getHeight();
  }

  public float compare(){
    if (widthA != widthB || heightA != heightB){
      System.out.println("Image dimension mismatch");
      return (float) 0;
    }
    else{
      long difference = 0;
      for (int y = 0; y < heightA; y++){
        for (int x = 0; x < widthA; x++){
          int[] rgbA = img1.getRGBData(x, y);
          int[] rgbB = img2.getRGBData(x, y);
          difference += Math.abs(rgbA[1] - rgbB[1]);
          difference += Math.abs(rgbA[2] - rgbB[2]);
          difference += Math.abs(rgbA[3] - rgbB[3]);
        }
      }
      double total_pixels = widthA * heightA * 3;
      double avg_different_pixels = difference / total_pixels;
      double percentage = (avg_different_pixels / 255) * 100;
      return (float) percentage;
    }
  }
}