//package com.imagePro;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DrawImage extends Canvas {
  public String fileName;
  private JFrame frame;
  private int width;
  private int height;
  private static BufferedImage globalImg;
  public static BufferedImage img;

  public DrawImage(String filePath) {
    this.fileName = filePath;
  }

  public void draw() {
    try {
      frame = new JFrame("Image");
     img = ImageIO.read(new File(fileName));
      width = img.getWidth();
      height = img.getHeight();
      ImageIcon icon = new ImageIcon(img);
      frame.setLayout(new FlowLayout());
      frame.setSize(width + 25, height + 50);
      JLabel lbl = new JLabel();
      lbl.setIcon(icon);
      frame.add(lbl);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void drawSaved() {
    try {
      width = globalImg.getWidth();
      height = globalImg.getHeight();
      ImageIcon icon = new ImageIcon(globalImg);
      frame.setLayout(new FlowLayout());
      frame.setSize(width + 25, height + 50);
      JLabel lbl = new JLabel();
      lbl.setIcon(icon);
      frame.add(lbl);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void draw(BufferedImage bufferedImage) {
    try {
      frame = new JFrame("Image");
       img = bufferedImage;
      width = img.getWidth();
      height = img.getHeight();
      ImageIcon icon = new ImageIcon(img);
      frame.setLayout(new FlowLayout());
      frame.setSize(width + 25, height + 50);
      JLabel lbl = new JLabel();
      lbl.setIcon(icon);
      frame.add(lbl);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setImage(String fileSet) {
    fileName = fileSet;
  }

  public void setImage(BufferedImage img) {
    globalImg = img;
  }

  public BufferedImage savedImage() {
    return globalImg;
  }

  public void hideImage() {
    frame.setVisible(false);
    frame.getContentPane().repaint();
    frame.dispose();
  }

  public String imageName() {
    return fileName;
  }
  public void repaint(){
    frame.repaint();
  }

  public void splitImage(BufferedImage img) throws IOException {

    int rows = 1;
    int columns = 2;

    BufferedImage spilt[] = new BufferedImage[(rows * columns)];

    int subimage_Width = img.getWidth() / columns;
    int subimage_Height = img.getHeight() / rows;

    int current_img = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        spilt[current_img] = new BufferedImage(subimage_Width, subimage_Height, img.getType());
        Graphics2D img_creator = spilt[current_img].createGraphics();

        int src_first_x = subimage_Width * j;
        int src_first_y = subimage_Height * i;

        int dst_corner_x = subimage_Width * j + subimage_Width;
        int dst_corner_y = subimage_Height * i + subimage_Height;

        img_creator.drawImage(img, 0, 0, subimage_Width, subimage_Height, src_first_x, src_first_y, dst_corner_x,
            dst_corner_y, null);
        current_img++;
      }

    }
    for (int i = 0; i < (rows * columns); i++) {
      File outputFile = new File("img" + i + ".jpg");
      ImageIO.write(spilt[i], "jpg", outputFile);
    }
  }

  public BufferedImage splitImage(BufferedImage img, int rows, int columns, int return_row, int return_column)
      throws IOException {

    BufferedImage spilt[] = new BufferedImage[(rows * columns)];
    // Spilt the image into the rows and columns
    int subimage_Width = img.getWidth() / columns;
    int subimage_Height = img.getHeight() / rows;

    int current_img = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        spilt[current_img] = new BufferedImage(subimage_Width, subimage_Height, img.getType());
        Graphics2D img_creator = spilt[current_img].createGraphics();

        int src_first_x = subimage_Width * j;
        int src_first_y = subimage_Height * i;

        int dst_corner_x = subimage_Width * j + subimage_Width;
        int dst_corner_y = subimage_Height * i + subimage_Height;

        img_creator.drawImage(img, 0, 0, subimage_Width, subimage_Height, src_first_x, src_first_y, dst_corner_x,
            dst_corner_y, null);
        current_img++;
      }
    }
    try {
      if (return_row * return_column > rows * columns || return_row * return_column <= 0) {
        int crashtemp = 1 / 0;
      } else {
        return spilt[(return_row * return_column) - 1];
      }
    } catch (Exception e) {
      System.out.println(
          "return_row and return_column not in bounds of set rows and columns. \nSystem will return with original image. ");
      return img;
    }
    return img;
  }

  public BufferedImage combineImage(BufferedImage imgOne, BufferedImage imgTwo, String combinationType)
      throws IOException {

    BufferedImage combinedImage;
    combinationType = combinationType.toLowerCase();
    try {
      int maxHeight;
      if (imgOne.getHeight() < imgTwo.getHeight()) {
        maxHeight = imgTwo.getHeight();
      } else {
        maxHeight = imgOne.getHeight();
      }

      if (combinationType.equals("side")) {
        combinedImage = new BufferedImage((imgOne.getWidth() + imgTwo.getWidth()), maxHeight,
            BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = combinedImage.createGraphics();
        g.drawImage(imgOne, 0, 0, null);
        g.drawImage(imgTwo, imgOne.getWidth(), 0, null);
        g.dispose();
        return combinedImage;
      }
    } catch (Exception e) {
      System.out.println(
          "Image Combination Failure. \nPlease check for the correct paraimeters and arguments. \nMethod will now return original first image ");
      return imgOne;
    }
    return imgOne;
  }
  public BufferedImage readImage(String fileName){
    try{
      img = ImageIO.read(new File(fileName));
      return img;
    }
    catch(IOException e){
      System.out.println("File not Found");
      return null;
    }
  }
}