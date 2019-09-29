
/**
 * Write a description of Part2 here.
 * Finding a Gene - Using the Simplified Algorithm Reorganized
 * @author Wei Gao
 * @version 09/03/2019
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String Gene = "";
        if (Character.isUpperCase(dna.charAt(0))){
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int StartInd = dna.indexOf(startCodon);
        if (StartInd == -1) { //if cannot find "ATG"
            return "";
        }
        int EndInd = dna.indexOf(stopCodon,StartInd);
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
        String dnaf = "aatatgagttgagtataagat";
        System.out.println("DNA Strand is " + dnaa);
        String gene = findSimpleGene(dnaa, "ATG","TAA");
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnab);
        gene = findSimpleGene(dnab,"ATG","TAA");
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnac);
        gene = findSimpleGene(dnac,"ATG","TAA");
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnad);
        gene = findSimpleGene(dnad,"ATG","TAA");
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnae);
        gene = findSimpleGene(dnae,"ATG","TAA");
        System.out.println("Gene is " + gene);
        
        System.out.println("DNA Strand is " + dnaf);
        gene = findSimpleGene(dnaf,"ATG","TAA");
        System.out.println("Gene is " + gene);
    }
}
