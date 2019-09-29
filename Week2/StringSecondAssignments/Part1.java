
/**
 * Write a description of Part1 here.
 * Finding many Genes
 * @author Wei Gao
 * @version  09/04/2019
 */
import edu.duke.*;
public class Part1 {
    public int findStopCodon (String dna, int startIndex, String stopCodon){
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        if ((stopIndex-startIndex)%3==0) {
          return stopIndex;  
        }
        else {
          return dna.length(); 
        }
    }
    
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
        return "";
    }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = 0;
        if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)) {
    minIndex = tagIndex;
    } else {
    minIndex = taaIndex;
    }

    if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) {
    minIndex = tgaIndex;
    }

    if(minIndex == -1) {
    return "";
    }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    
    
    public void testFindStopCodon(){
       String dna = "xxxxxxxxTAAxxxxxx";
       String dnaa = "xxxxxxxxxTAAxxxx";
       String dnaaa = "xxxxxxxxTAAxxxxxxxTAA";
       
       System.out.println(findStopCodon(dna,0,"TAA"));
       System.out.println(findStopCodon(dnaa,0,"TAA"));
       System.out.println(findStopCodon(dnaaa,0,"TAA"));
    }
    
    public void testFindGene(){
        String dna = "xxxxxxxxxxxxxx";
        String dnaa = "xxxATGxxxTAAxxxx";
        String dnaaa = "ATGxxxxxxTAAxxxxxxTAA"; 
        String dnaaaa = "ATGxxxxxxxTAAxxxxxxTAA"; 
        System.out.println(dna);
        String gene = findGene(dna, 0);
        System.out.println(gene);
        System.out.println(dnaa);
        gene = findGene(dnaa, 0);
        System.out.println(gene);
        System.out.println(dnaaa);
        gene = findGene(dnaaa, 0);
        System.out.println(gene);
        System.out.println(dnaaaa);
        gene = findGene(dnaaaa, 0);
        System.out.println(gene);
    }
    
    public void printAllGenes(String dna, int startIndex){
        while (true) {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()){
            break;
            } 
            
            System.out.println(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
    }
    
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0; 
        while (true) {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()){
            break;
            } 
            geneList.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneList;
    }
    
    public void testSR(String dna){
        //dna = "ATGxxxxxxxTAAxxxATGxxxTAA";
        StorageResource genes = getAllGenes(dna);
        for (String g: genes.data()){
            System.out.println(g);
        }
        
    }
}
