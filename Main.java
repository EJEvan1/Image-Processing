import com.imagePro.*;
import java.awt.image.BufferedImage;
class Main {
  public static void main(String[] args) {
    DrawImage display = new DrawImage("test.jpg");
    RandomImage rand = new RandomImage(250,250);
    Negative neg = new Negative();
    Rotate rot = new Rotate();
    Resize size = new Resize();

    //display.draw(neg.toNeg(rand.create()));
   // System.out.println(rand.getWidth() + rand.getHeight());
    BufferedImage img = display.readImage("landscape.jpg");
    try{  img = size.resize(img, 0.5);
      img = size.resize(img, 0.5);
     }
    catch (Exception e){}
   display.draw(img);
     //rand.create();
    //display.draw();
  }
}