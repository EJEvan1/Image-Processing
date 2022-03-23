//package com.imagePro;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Rotate {

  public BufferedImage rotate(BufferedImage img){
    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

    Graphics2D g2 = newImage.createGraphics();

    g2.rotate(Math.toRadians(90), width / 2, height / 2);
    g2.drawImage(img, null, 0 , 0);
    
    return newImage;
  }
  public BufferedImage rotate(String fileSet){
  try{
    BufferedImage img = ImageIO.read(new File(fileSet));

    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

    Graphics2D g2 = newImage.createGraphics();

    g2.rotate(Math.toRadians(90), width / 2, height / 2);
    g2.drawImage(img, null, 0 , 0);
    
    return newImage;
    }
    catch(IOException e){
      return null;
    }
  }
  public BufferedImage rotate(BufferedImage img, int rotationValue){
    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

    Graphics2D g2 = newImage.createGraphics();

    g2.rotate(Math.toRadians(rotationValue), width / 2, height / 2);
    g2.drawImage(img, null, 0 , 0);
    
    return newImage;
  }
  public BufferedImage rotate(String fileSet, int rotationValue) {
    try{
    BufferedImage img = ImageIO.read(new File(fileSet));

    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

    Graphics2D g2 = newImage.createGraphics();

    g2.rotate(Math.toRadians(rotationValue), width / 2, height / 2);
    g2.drawImage(img, null, 0 , 0);
    
    return newImage;
      }
    catch(IOException e){
      return null;
    }
  }
  }