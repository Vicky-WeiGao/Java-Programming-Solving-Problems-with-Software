
/**
 * Write a description of Part2 here.
 * HowMany - Finding Multiple Occurrences
 * @author (Wei Gao 
 * @version 09/04/2019
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int currIndex = stringb.indexOf(stringa);
        int times = 0;
        if (currIndex == -1) {
        return 0;   
        }
        else {
            while (currIndex < stringb.length()&&currIndex != -1){
                times = times +1;
                currIndex = stringb.indexOf(stringa, currIndex + stringa.length());
            }
            return times;
        }   
    }
    
    public void testHowMany() {
        String stringa = "TAA";
        String stringb = "TAAxxxxxxTAAxxxxTA";
        System.out.println(howMany(stringa, stringb));
    }
}
