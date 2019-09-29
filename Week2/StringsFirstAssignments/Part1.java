
/**
 * Write a description of Part1 here.
 * Finding a Gene - Using the Simplified Algorithm
 * @author Wei Gao
 * @version 09/03/2019
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String Gene = "";
        int StartInd = dna.indexOf("ATG");
        if (StartInd == -1) { //if cannot find "ATG"
            return "";
        }
        int EndInd = dna.indexOf("TAA",StartInd);
        if (EndInd == -1) { //if cannot find "TAA"
            return "";
        }
        if ((EndInd - StartInd)%3==0){ //if not 3 condos
            return dna.substring(StartInd, EndInd +3);
        }
        else {
            return "";
        }
    }
    
    public void testSimpleGene(){
        String dnaa = "AAAGTAAGTTTGGAATAAGT";
        String dnab = "AAATGATTGTGGATA";
        String dnac = "AAAGTAAGTTTGGAATAGT";
        String dnad = "AATATGAGTTGAGTATAAGAT";
        String dnae = "AATATGAGTGAGTATAAGAT";
        System.out.println("DNA Strand is " + dnaa);
        String gene = findSimpleGene(dnaa);
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnab);
        gene = findSimpleGene(dnab);
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnac);
        gene = findSimpleGene(dnac);
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnad);
        gene = findSimpleGene(dnad);
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnae);
        gene = findSimpleGene(dnae);
        System.out.println("Gene is " + gene);
    }
}
