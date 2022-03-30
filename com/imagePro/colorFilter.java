import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


abstract public class colorFilter{
  public static BufferedImage grey(BufferedImage bufferedImage){
    BufferedImage img = bufferedImage;
    try{

      int width = img.getWidth();
      int height = img.getHeight();

      //convert to greyscale
      for (int y = 0; y < height; y++){
        for (int x = 0; x < width; x++){
          int p = img.getRGB(x,y);

          int a = (p>>24)&0xff;
          int r = (p>>16)&0xff;
          int g = (p>>8)&0xff;
          int b = p&0xff;

          //calculate time
          int avg = (r+g+b)/3;

          p = (a<<24) | (avg << 16) | (avg << 8) | avg;
          img.setRGB(x, y, p);
        }
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return img;
  }
  public static BufferedImage blue(BufferedImage bufferedImage){
    BufferedImage img = bufferedImage;
    try{

      int width = img.getWidth();
      double percentWidth = width * 0.5;
      int height = img.getHeight();
      double percentHeight = height * 0.5;

     
      for (int y = (int) percentHeight ; y < height ; y++){
        for (int x = 0; x < width /2 ; x++){
          int p = img.getRGB(x,y);

          int a = (p>>24)&0xff;
          int r = (p>>16)&0xff;
          int g = (p>>8)&0xff;
          int b = p&0xdf;

         
          int avg = (r+g+b)/3;

          p = (a<<1) | (avg << 1) | (avg << 8) | avg;
          img.setRGB(x, y, p);
        }
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return img;
  }
  public static BufferedImage green(BufferedImage bufferedImage){
     BufferedImage img = bufferedImage;
    try{

      int width = img.getWidth();
      double percentWidth = width * 0.5;
      int height = img.getHeight();
      double percentHeight = height * 0.5;

      
      for (int y = 0; y < height /2; y++){
        for (int x = (int) percentWidth; x < width ; x++){
          int p = img.getRGB(x,y);

          int a = (p>>24)&0xff;
          int r = (p>>16)&0xff;
          int g = (p>>8)&0xff;
          int b = p&0xff;

          
          int avg = (r+g+b)/3;

          p = (a<<8) | (avg << 1) | (avg << 9) | avg;
          img.setRGB(x, y, p);
        }
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return img;
  }
  public static BufferedImage red(BufferedImage bufferedImage){
    BufferedImage img = bufferedImage;
    try{

      int width = img.getWidth();
      double percentWidth = width * 0.5;
      int height = img.getHeight();
      double percentHeight = height * 0.5;

     
      for (int y = 0 ; y < height ; y++){
        for (int x = 0; x < width ; x++){
          int p = img.getRGB(x,y);

          int a = (p>>24)&0xff;
          int r = (p>>16)&0xff;
          int g = (p>>8)&0xff;
          int b = p&0xff;

         
          int avg = (r+g+b)/3;

          p = (a<<16) | (avg << 1) | (avg << 8) | avg;
          img.setRGB(x, y, p);
        }
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return img;
  }
  }