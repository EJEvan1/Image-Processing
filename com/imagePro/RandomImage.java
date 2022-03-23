package com.imagePro;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RandomImage{
  private int width;
  private int height;

  public RandomImage(int width, int height){
    this.width = width;
    this.height = height;
  }

  public BufferedImage create(){
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

  for (int y = 0; y < height; y++)
      {
        for (int x = 0; x < width; x++)
         {
          // generating values less than 256
          int a = (int)(Math.random()*256);
          int r = (int)(Math.random()*256);
          int g = (int)(Math.random()*256); 
          int b = (int)(Math.random()*256); 
          //pixel
          int p = (a<<24) | (r<<16) | (g<<8) | b; 
          img.setRGB(x, y, p);
          }
        }
    return img;
  }

  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
}
