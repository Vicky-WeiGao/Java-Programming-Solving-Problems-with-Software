
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.*;
public class Part2 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestRow = null;
        for (CSVRecord currentRow: parser){
            coldestRow = getColderOfTwo(currentRow, coldestRow);
        }
        return coldestRow;
    }
    
    public CSVRecord getColderOfTwo(CSVRecord currentRow, CSVRecord coldestRow){
        if (coldestRow == null){
                coldestRow = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestRow.get("TemperatureF"));
                if (currentTemp < coldestTemp && currentTemp>-100){
                    coldestRow = currentRow;
                }
            }
        return coldestRow;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestRow = coldestHourInFile(parser);
        System.out.println(coldestRow.get("TemperatureF") + ": " + coldestRow.get("DateUTC"));
    }
    
    public String fileWithColdestTemperature(){
        File filename = null;
        CSVRecord coldestRow = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (coldestRow == null){
                coldestRow = currentRow;
                filename = f;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestRow.get("TemperatureF"));
                if (currentTemp < coldestTemp && currentTemp>-100){
                    coldestRow = currentRow;
                    filename = f;
                }
            }
        }
        return filename.getPath();
    }
    
    public void testFileWithColdestTemperature(){
        String file = fileWithColdestTemperature();
        File f = new File(file);
        String fileName = f.getName();
        System.out.println("Coldest day was in file "+fileName);
        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestRow = coldestHourInFile(parser);
        System.out.println("Coldest temperature on that day was "+ coldestRow.get("TemperatureF"));;
        System.out.println("All the temperature on the coldest day were:");
        CSVParser parser2 = fr.getCSVParser();
        for (CSVRecord record: parser2){
            String Date = record.get("DateUTC");
            String Temp = record.get("TemperatureF");
            System.out.println(Date + ": " + Temp);
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestRow = null;
        for (CSVRecord currentRow: parser){
                if (lowestRow == null){
                    lowestRow = currentRow;
                }
                else {
                    if (!currentRow.get("Humidity").equals("N/A") && !lowestRow.get("Humidity").equals("N/A")){
                        double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                        double coldestTemp = Double.parseDouble(lowestRow.get("Humidity"));
                        if (currentTemp < coldestTemp){
                            lowestRow = currentRow;
                        }
                    }
                }
        }
        return lowestRow;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " +csv.get("DateUTC")); 
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        File filename = null;
        CSVRecord lowestRow = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            System.out.println(f.getName());
            String currentHum = currentRow.get("Humidity");
            if (currentHum != "N/A"){
                if (lowestRow == null){
                    lowestRow = currentRow;
                }
                else {
                   if (!currentRow.get("Humidity").equals("N/A") && !lowestRow.get("Humidity").equals("N/A")){
                        double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                        double coldestTemp = Double.parseDouble(lowestRow.get("Humidity"));
                        if (currentTemp < coldestTemp){
                            lowestRow = currentRow;
                        }
                    }
                }
            }
        } 
        return lowestRow;
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord record = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + record.get("Humidity") + " at " +record.get("DateUTC")); 
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        double totalTemp = 0;
        int count = 0;
        for (CSVRecord currentRow: parser){
            totalTemp = totalTemp + Double.parseDouble(currentRow.get("TemperatureF"));
            count += 1;
        }
        double averageTemp = totalTemp/count;
        return averageTemp;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + avgTemp);
    }
        
   
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double totalTemp = 0;
        int count = 0;
        for (CSVRecord currentRow: parser){
            if (Integer.parseInt(currentRow.get("Humidity"))>=value){
                totalTemp = totalTemp + Double.parseDouble(currentRow.get("TemperatureF"));
                count += 1;
            }
        }
        double averageTemp = totalTemp/count;
        if (totalTemp == 0){
            averageTemp = 0;
        }
        return averageTemp;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureWithHighHumidityInFile(parser, 80);
        if (avgTemp != 0) {
            System.out.println("Average temperature in file is " + avgTemp);
        }
        else {
            System.out.println("No temperatures with that humidity");
        }
    }
}


