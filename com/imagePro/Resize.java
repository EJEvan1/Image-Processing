//package com.imagePro;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Resize {

  public BufferedImage resize(BufferedImage img, int scaledWidth, int scaledHeight) {
    BufferedImage outImg = new BufferedImage(scaledWidth, scaledHeight, img.getType());

    Graphics2D g2d = outImg.createGraphics();
    g2d.drawImage(img, 0, 0, scaledWidth, scaledHeight, null);
    g2d.dispose();
    return outImg;
  }
  public BufferedImage resize(BufferedImage img, double percent) {
    int scaledWidth = (int) (img.getWidth() * percent);
    int scaledHeight = (int) (img.getHeight() * percent);
    BufferedImage outImg = resize(img, scaledWidth, scaledHeight);
    return outImg;
  }
  public BufferedImage resize(String inputImagePath, int scaledWidth, int scaledHeight) {
    try{BufferedImage img = ImageIO.read(new File(inputImagePath));
    return resize(img, scaledWidth, scaledHeight);}
    catch(IOException e){
      return null;
    }
  }
  public BufferedImage resize(String inputImagePath, double percent) {
    try{
      BufferedImage img = ImageIO.read(new File(inputImagePath)); 
    return resize(img, percent);
      }
    catch (IOException e){
      return null;
    }
  }
}