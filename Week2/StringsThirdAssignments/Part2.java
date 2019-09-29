
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part2 {
    public double cgRatio(String dna){
        int count = 0;
        for (int i = 0; i < dna.length(); i ++){
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                count ++;
            }
        }
        int total = dna.length();
        return (float)count/total;
    }
    
    public int countCTG(String dna){
        int count = 0;
        for (int i = 0; i <= dna.length()-2; i ++){
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                count ++;
            }
        }
        return count;
    }
    
    public void testcgRatio(){
        String dna = "ATGCCATAG";
        double cgR = cgRatio(dna);
        System.out.println(cgR);
        
    }
    
    public void processGenes(StorageResource sr){   
        int count = 0;
        for (String g: sr.data()){
            if (g.length() >9) {  
                System.out.println(g);
                count = count +1;
            }
        } 
        System.out.println(count);
        int count1 = 0;
        for (String g: sr.data()){
            double cgR = cgRatio(g);
            if (cgR >0.35) {  
                System.out.println(g);
                count1 = count1 +1;
            }
        } 
        System.out.println(count1);
        int length = 0; 
        String longestGene = "";
        for (String g: sr.data()){
            if (g.length()>length) {  
                length = g.length();
                longestGene = g;
            }
        } 
        System.out.println(longestGene);
    }
    
    public void testProcessGenes(){
        StorageResource sr = new StorageResource();
        sr.add("xxxxxxxxxx");
        sr.add("CCGCGxxxxx");
        sr.add("CGxxxxxxxx");
        sr.add("xxxxx");
        sr.add("xxxxxxxxxxxx");
        processGenes(sr);
    }
}
