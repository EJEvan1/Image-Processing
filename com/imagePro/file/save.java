import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

abstract public class save{
  public static void toPNG(BufferedImage img, String path, String fileName){
    try{
      File loc = new File(path+fileName);
      ImageIO.write(img, "png", loc);
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
  public static void toGIF(BufferedImage img, String path, String fileName){
    try{
      File loc = new File(path+fileName);
      ImageIO.write(img, "gif", loc);
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
  public static void toJPG(BufferedImage img, String path, String fileName){
    try{
      File loc = new File(path+fileName);
      ImageIO.write(img, "jpg", loc);
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}