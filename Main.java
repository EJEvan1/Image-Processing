import com.imagePro.*;
//import com.imagePro.pixel.*;
import java.awt.image.BufferedImage;
import java.util.Random;
class Main {
  public static void main(String[] args) {
    DrawImage display = new DrawImage("test.jpg");
    RandomImage rand = new RandomImage(192,108);
    Negative neg = new Negative();
    Rotate rot = new Rotate();
    Resize size = new Resize();
    BufferedImage img = display.readImage("oldman.jpg");
    BufferedImage img2 = display.readImage("test.jpg");
    img = size.resize(img, 300, 250);
    img2 = size.resize(img2, 300, 250);
    getSetPixels shoreImg = new getSetPixels(img);
    getSetPixels testImg = new getSetPixels(img2);
    rawData raw = new rawData();
    Random r = new Random();
    
    //  testImg = new getSetPixels(img2);
      //shoreImg = new getSetPixels(img);
    for (int i = 0; i < 300; i++){
      for (int j = 0; j < 250; j++ ){
        if (r.nextBoolean()){
          int[] newData = shoreImg.getRGBData(i, j);
         testImg.setRGBData(newData, i, j);
        }
      }
    }
    //display.draw(testImg.getImage());
    display.draw(testImg.getImage());
    try{Thread.sleep(500);}
    catch(Exception e){}
  //  display.hideImage();
      Comparison test = new Comparison(testImg.getImage(), shoreImg.getImage());
    System.out.println("Difference: " + test.compare() + "%");
  }
}