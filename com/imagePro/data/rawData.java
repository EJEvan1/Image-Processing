//package com.imagePro.data;
//import com.imagePro.pixel;
import com.imagePro.pixel.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class rawData{
  public int[][] getRawData (getSetPixels objectToGet){
    int width = objectToGet.storedWidth();
    int height = objectToGet.storedHeight();
    
    int[][] rawData = new int[width * height][4];
    int count = 0;
    for (int i = 0; i < width; i++){
      for (int j = 0; j < height; j++){
        int[] RGB = objectToGet.getRGBData(i,j);
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