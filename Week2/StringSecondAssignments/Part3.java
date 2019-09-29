
/**
 * Write a description of Part3 here.
 * How Many Genes?
 * @author Wei Gao
 * @version 09/04/2019
 */
import edu.duke.*;
public class Part3 {
    public int findStopCodon (String dna, int startIndex, String stopCodon){
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        if ((stopIndex-startIndex)%3==0) {
          return stopIndex;  
        }
        else {
          return dna.length(); 
        }
    }
    
    public String findGene(String dna) {
    int startIndex = dna.indexOf("ATG");
    if (startIndex == -1) {
        return "";
    }
    else {
        int stopIndex = findStopCodon(dna, startIndex, "TAA");
            if (stopIndex == -1) {
             return "";   
            }
            else{
                return dna.substring(startIndex, stopIndex + 3);
            }
    }   
    }
    
    public void printAllGenes(String dna){
        while (true) {
            String gene = findGene(dna);
            if (gene.isEmpty()){
            break;
            } 
            else {
                System.out.println(gene);
            }
        }
    }

    public int countGenes(String dna){
        int count = 0;
        while (true) {
            String gene = findGene(dna);
            if (gene.isEmpty()){
            break;
            } 
            else {
                count = count +1;
            }
        }
        return count;
    }
    
    public void testCountGenes(){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString(); 
        dna = dna.toUpperCase();
        System.out.println(countGenes(dna));
    }
}
