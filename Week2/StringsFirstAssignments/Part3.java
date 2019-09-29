
/**
 * Write a description of Part3 here.
 * Problem Solving with Strings
 * @author Wei Gao
 * @version 09/03/2019
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int pos1 = stringb.indexOf(stringa);
        if (pos1 == -1) {
            return false;
        }
        else {
            int pos2 = stringb.indexOf(stringa,pos1+1);
            if (pos2 == -1) {
             return false;   
            }
            else{
                return true;
            }
        }
    }
    
    public String lastPart(String stringa, String stringb){
        int pos1 = stringb.indexOf(stringa);
        if (pos1 == -1) {
            return stringb;
        }
        else {
            return stringb.substring(pos1+stringa.length());
        }
        
        
    }
    
    public void testing(){
    String testa = "a";
    String testb = "apple";
    String testaa = "p";
    String testaaa = "v";
    Boolean test1 = twoOccurrences(testa,testb);
    System.out.println("Answer is " + test1);
    Boolean test2 = twoOccurrences(testaa,testb);
    System.out.println("Answer is " + test2);
    Boolean test3 = twoOccurrences(testaaa,testb);
    System.out.println("Answer is " + test3);
    }
    
    public void testinglastPart(){
    String testa = "an";
    String testb = "banana";
    String testaa = "zoo";
    String testab = "forest";
    String test1 = lastPart(testa,testb);
    System.out.println("Answer is " + test1);
    String test2 = lastPart(testaa,testab);
    System.out.println("Answer is " + test2);
    }
}
