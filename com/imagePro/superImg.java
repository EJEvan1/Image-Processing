import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import com.imagePro.pixel.*;

//has call the ablities as the other methods and extends getSetPixels
//but cannot display other images besides it self
//use drawImage for that
public class superImg {
  private BufferedImage img;
  private String name = "Image";
  private boolean screenTest = true;
  private BufferedImage original;

  public superImg(BufferedImage input) {
    this.img = input;
    this.original = input;
  }

  public superImg(String path) {
    try {
      this.img = ImageIO.read(new File(path));
      this.name = path;
      this.original = ImageIO.read(new File(path));
    } catch (IOException e) {
      System.out.println("IO Error occurred within the constructor");
    }
  }

  public superImg(int width, int height) {
    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // generating values less than 256
        int a = (int) (Math.random() * 256);
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        // pixel
        int p = (a << 24) | (r << 16) | (g << 8) | b;
        img.setRGB(x, y, p);
      }
    }
  }
  public BufferedImage getImage(){
    return img;
  }
  public int getWidth() {
    return img.getWidth();
  }

  public int getHeight() {
    return img.getHeight();
  }

  // rotate stuff here
  public void rotate() {
    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

    Graphics2D g2 = newImage.createGraphics();

    g2.rotate(Math.toRadians(90), width / 2, height / 2);
    g2.drawImage(img, null, 0, 0);

    img = newImage;
  }

  public void rotate(int degrees) {
    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

    Graphics2D g2 = newImage.createGraphics();

    g2.rotate(Math.toRadians(degrees), width / 2, height / 2);
    g2.drawImage(img, null, 0, 0);
    g2.dispose();
    img = newImage;
  }

  // resize stuff here
  public void resize(int scaledWidth, int scaledHeight) {
    BufferedImage outImg = new BufferedImage(scaledWidth, scaledHeight, img.getType());

    Graphics2D g2d = outImg.createGraphics();
    g2d.drawImage(img, 0, 0, scaledWidth, scaledHeight, null);
    g2d.dispose();
    img = outImg;
  }

  public void resize(double percent) {
    int scaledWidth = (int) (img.getWidth() * percent);
    int scaledHeight = (int) (img.getHeight() * percent);
    resize(scaledWidth, scaledHeight);
  }

  // negative stuff here
  public void negative() {
    int width = img.getWidth();
    int height = img.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int p = img.getRGB(x, y);
        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;
        // subtract RGB from 255
        r = 255 - r;
        g = 255 - g;
        b = 255 - b;
        // set new RGB value
        p = (a << 24) | (r << 16) | (g << 8) | b;
        img.setRGB(x, y, p);
      }
    }
  }

  // crappy color filiters here
  public void gray() {
    int width = img.getWidth();
    int height = img.getHeight();

    // convert to greyscale
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int p = img.getRGB(x, y);

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

        // calculate time
        int avg = (r + g + b) / 3;

        p = (a << 24) | (avg << 16) | (avg << 8) | avg;
        img.setRGB(x, y, p);
      }
    }
  }

  // display thing randomly here for some reason
  //draw will automatically adjust the size of the image to match the enviorment(i.e. if the image is too big for the enviorment it will make the image smaller to fit the screen)
  public void draw() {
    //JFrame not being avalible gloablly might be diffcult for functionality
    JFrame frame = new JFrame(name);
    while (!screenCheck()) img = resize(img, 0.5);
    int width = img.getWidth();
    int height = img.getHeight();
    ImageIcon icon = new ImageIcon(img);
    frame.setLayout(new FlowLayout());
    frame.setSize(width + 25, height + 50);
    JLabel lbl = new JLabel();
    lbl.setIcon(icon);
    frame.add(lbl);
    frame.setVisible(true);
  }

  // getSetPixels data thing
  public void setRGBData(int[] RGB, int x, int y) {
    int p = (RGB[0] << 24) | (RGB[1] << 16) | (RGB[2] << 8) | RGB[3];
    img.setRGB(x, y, p);
  }

  public Color getColor(int x, int y) {
    return new Color(img.getRGB(x, y));
  }

  public void setColor(Color newColor, int x, int y) {
    int p = newColor.getRGB();
    img.setRGB(x, y, p);
  }

  public int[] getRGBData(int x, int y) {
    int[] RGB = new int[4];
    int p = img.getRGB(x, y);

    // alpha
    RGB[0] = (p >> 24) & 0xff;
    // red
    RGB[1] = (p >> 16) & 0xff;
    // green
    RGB[2] = (p >> 8) & 0xff;
    // blue
    RGB[3] = p & 0xff;

    return RGB;
  }
  public float compare(BufferedImage imageToCompare){
  return (float) 0;  
  }
  private boolean screenCheck(){
   if (!screenTest) return true;
    GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Rectangle bounds = environment.getMaximumWindowBounds();
    int screenWidth = (int) bounds.getWidth();
    int screenHeight = (int) bounds.getHeight();
    return img.getWidth() < screenWidth && img.getHeight() < screenHeight && (img.getWidth() * img.getHeight()) < screenHeight * screenWidth; 
  }
  private BufferedImage resize(BufferedImage temp, int scaledWidth, int scaledHeight) {
    BufferedImage outImg = new BufferedImage(scaledWidth, scaledHeight, temp.getType());

    Graphics2D g2d = outImg.createGraphics();
    g2d.drawImage(temp, 0, 0, scaledWidth, scaledHeight, null);
    g2d.dispose();
    return outImg;
  }
  private BufferedImage resize(BufferedImage temp, double percent) {
    int scaledWidth = (int) (temp.getWidth() * percent);
    int scaledHeight = (int) (temp.getHeight() * percent);
    BufferedImage outImg = resize(temp, scaledWidth, scaledHeight);
    return outImg;
  }
  public void disableScreenCheck(){
    screenTest = false;
  }
  public void enableScreenCheck(){
    screenTest = true;
  }
  //resets the image to it original state
  public void reset(){
    img = original;
  }
  
}
