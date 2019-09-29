
/**
 * Write a description of Part4 here.
 * Finding Web Links
 * @author Wei Gao
 * @version 09/03/2019
 */
import edu.duke.*;

public class Part4 {
   public void Findyoutube () {
     URLResource res = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
     for (String word : res.words()){
         int pos = word.toLowerCase().indexOf("youtube.com");
         if (pos != -1) {
             int startPos = word.lastIndexOf("\"",pos);
             int lastPos = word.indexOf("\"",pos+1);
             System.out.println(word.substring(startPos+1,lastPos));
            }
            
        }
    }
}
