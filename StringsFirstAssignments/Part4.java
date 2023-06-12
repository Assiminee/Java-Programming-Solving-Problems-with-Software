import edu.duke.*;
import java.io.*;
/**
 * Find all youtube URLs in a web page
 *
 * @author Yasmine Znatni
 * @version 1 08/06/2023
 */
public class Part4 {
    public void URLPrinting () {
        URLResource url = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        String result = "";
        for (String urlString : url.words()) {
            String tempURL = urlString.toLowerCase();
            int ytIndex = tempURL.indexOf("youtube.com");
            if (ytIndex != -1) {
                int startingQTMIndex = urlString.lastIndexOf("\"", ytIndex);
                int endingQTMIndex = urlString.indexOf("\"", ytIndex);
                result = urlString.substring(startingQTMIndex + 1, endingQTMIndex);
                System.out.println(result);
            }
                
        }
    }
}
