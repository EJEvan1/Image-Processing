import com.imagePro.*;
import com.imagePro.pixel.*;
import java.awt.image.BufferedImage;
class Main {
  public static void main(String[] args) {
    DrawImage display = new DrawImage("test.jpg");
    RandomImage rand = new RandomImage(250,250);
    Negative neg = new Negative();
    Rotate rot = new Rotate();
    Resize size = new Resize();
    BufferedImage img = display.readImage("test.jpg");
    getSetPixels landscapeImg = new getSetPixels(img);

    display.draw(size.resize(img, 0.05));
    //read out data 
    int red = 0;
    int green = 0;
    int blue = 0;
    for (int i = 0; i < landscapeImg.storedWidth(); i++){
      for (int j = 0; j < landscapeImg.storedHeight(); j++){
        int[] RGB = landscapeImg.getRGBData(i, j);
      //  System.out.println("Pixel at " + i + ", " + j);
       // System.out.println("Alpha: " + RGB[0]);
        //System.out.println("Red: " + RGB[1]);
        red += RGB[1];
        //System.out.println("Green: " + RGB[2]);
        green += RGB[2];
        //System.out.println("Blue: "  + RGB[3]);
        blue += RGB[3];
      }
      //System.out.println("\n");
    }
   red = (int) red / (landscapeImg.storedWidth() * landscapeImg.storedHeight());
    System.out.println("Red: " + red);
   green = (int) green / (landscapeImg.storedWidth() * landscapeImg.storedHeight());
    System.out.println("Green: " + green);
    blue = (int) blue / (landscapeImg.storedWidth() * landscapeImg.storedHeight());
    System.out.println("Blue: " + blue);
  }
}