
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
public class Part1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //String info = countryInfo(parser, "Nauru");
	//System.out.println(info);
	//listExportersTwoProducts(parser, "cotton","flowers");
	//int count = numberOfExporters(parser, "cocoa");
	//System.out.println(count);
	bigExporters(parser, "$999,999,999,999");
    }
    
    
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord record: parser){
            String wantedCountry = record.get("Country");
            if (wantedCountry.contains(country)){          
                String exports = record.get("Exports");
                String values = record.get("Value (dollars)");
                String info = wantedCountry + ": " + exports+ ": "+values;
                return info;
                }
            }
        return "Nothing";
    }
        
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record: parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record: parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem)){
                count += 1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record: parser){
            String value = record.get("Value (dollars)");
            if (value.length()>amount.length()){
                String country = record.get("Country");
                System.out.println(country+" "+value);
            }
        }
    }
}
