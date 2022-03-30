import com.imagePro.*;
import java.net.*;
//import com.imagePro.pixel.*;
import java.awt.image.BufferedImage;
import java.util.Random;
class Main {
  public static void main(String[] args) {
   drawImage s = new drawImage();
    Resize r = new Resize();
    Negative n = new Negative();
    BufferedImage negative = s.readImage("george.jpg");
    BufferedImage img = s.readImage("toEncode.jpg");
    Random t = new Random();
    getSetPixels test1, test2;
    img = r.resize(img, 2800, 1800); negative = r.resize(negative, 2800, 1800);
    BufferedImage embed = image.embedImage(negative, img);
  s.draw(embed);
  BufferedImage deembed = image.revealImage(embed);
    Comparison co = new Comparison(img, deembed);
    System.out.println(co.compare());
    //s.draw(deembed);
  //  BufferedImage decrypt = image.extractImage(embed, embed.getWidth(), embed.getHeight());
    save.toPNG(embed, "photos/", "embed.png");
    save.toPNG(deembed, "photos/", "test.png");
    //s.draw(decrypt);
  }
}