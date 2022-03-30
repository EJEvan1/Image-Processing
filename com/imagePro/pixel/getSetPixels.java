//package com.imagePro.pixel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import com.imagePro.data.*;

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
  public void setRGBData(int[] RGB, int x, int y){
    int p = (RGB[0] << 24) | (RGB[1] << 16) | (RGB[2] << 8) | RGB[3]; 
    img.setRGB(x, y, p);
  }
  public int storedWidth(){
    return width;
  }
  public int storedHeight(){
    return height;
  }
  public BufferedImage getImage(){
    return img;
  }
  public Color getColor(int x, int y){
    return new Color(img.getRGB(x,y));
  }
  public void setColor(Color newColor, int x, int y){
   int p = newColor.getRGB();
    img.setRGB(x,y,p);
  }
  public int[][] getRawData(){
    int width = storedWidth();
    int height = storedHeight();
    
    int[][] rawData = new int[width * height][4];
    int count = 0;
    for (int i = 0; i < width; i++){
      for (int j = 0; j < height; j++){
        int[] RGB = getRGBData(i,j);
        rawData[count][0] = RGB[0];
        rawData[count][1] = RGB[1];
        rawData[count][2] = RGB[2];
        rawData[count][3] = RGB[3];
        count++;
      }
    }
    return rawData;
   }
}