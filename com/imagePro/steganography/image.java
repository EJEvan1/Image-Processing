import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import com.imagePro.pixel.*;

abstract public class image{
  public static BufferedImage embedImage(BufferedImage source, BufferedImage hide){
    getSetPixels imageSource = new getSetPixels(source);
    getSetPixels imageHide = new getSetPixels(hide);
  if (!canHide(imageSource, imageHide)) return imageHide.getImage();
    //int[][] sPixel = imageSource.getRawData();
    //int[][] hPixel = imageHide.getRawData();

    for (int i = 0; i < imageSource.storedWidth(); i++){
      for (int j = 0; j < imageSource.storedHeight(); j++){
        setLow(imageSource, imageHide.getColor(i,j), i, j);
      }
    }
    return imageSource.getImage();
  }

  public static BufferedImage revealImage(BufferedImage hidden){
  getSetPixels reveal = new getSetPixels(clone(hidden));
 getSetPixels org = new getSetPixels(hidden);
    
    for (int r = 0; r < reveal.storedWidth(); r++){
      for (int c = 0; c < reveal.storedHeight(); c++){
        Color col = org.getColor(r,c);
        Color newCol = new Color(col.getRed() % 4 * 64, col.getGreen() % 4 * 64, col.getBlue() % 4 * 64);
        reveal.setColor(newCol, r, c);
      }
    }
    return reveal.getImage();
  }
  private static void clearLow(getSetPixels source, int x, int y){
    Color oldColor = source.getColor(x,y);
    source.setColor(new Color(4* (oldColor.getRed()/4),4*(oldColor.getGreen() /4), 4*(oldColor.getBlue()/ 4)), x, y);
  }
  private static void setLow(getSetPixels source, Color c, int x, int y){
    clearLow(source, x, y);
    Color oldColor = source.getColor(x, y);
    int rAdd = c.getRed() / 64;
    int gAdd = c.getGreen() / 64;
    int bAdd = c.getBlue() / 64;
    source.setColor(new Color(oldColor.getRed() + rAdd, oldColor.getGreen() + gAdd, oldColor.getBlue() + bAdd ), x, y);
  }
  private static boolean canHide(getSetPixels img1, getSetPixels img2){
    return img1.storedWidth() == img2.storedWidth() && img1.storedHeight() == img2.storedHeight();
  }
  private static final BufferedImage clone(BufferedImage image) {
    BufferedImage clone = new BufferedImage(image.getWidth(),
            image.getHeight(), image.getType());
    Graphics2D g2d = clone.createGraphics();
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();
    return clone;
}
}