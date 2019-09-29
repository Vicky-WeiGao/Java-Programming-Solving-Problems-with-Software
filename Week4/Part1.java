
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Part1 {
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalName = 0;
        int totalBoyName = 0;
        int totalGirlName = 0;
        for (CSVRecord rec: fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            totalName += 1;
            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
                totalBoyName += 1;
            }
            else {
                totalGirls += numBorn;
                totalGirlName += 1;
            }
        }
        System.out.println("total birth = "+totalBirths);
        System.out.println("total girls = "+totalGirls);
        System.out.println("total boys = "+totalBoys);
        System.out.println("total names = "+totalName);
        System.out.println("total boys names = "+totalBoyName);
        System.out.println("total girl names= "+totalGirlName);
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public int getRank (int year, String name, String gender){
        int rank = 0;
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        for (CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                rank += 1;
                if (rec.get(0).equals(name)){
                    int nameRank = rank;
                    return nameRank;
                }
            }
        }
        return -1;
    }
    
    public void testGetRank(){
        int rank = getRank(1971, "Frank", "M");
        System.out.println(rank);
    }
    
    public String getName(int year, int rank ,String gender){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        int manyRanks = 0;
        for (CSVRecord rec: fr.getCSVParser(false)){
            manyRanks = getRank(year, rec.get(0), gender);
            if (manyRanks == rank){
                return rec.get(0);
            }
        }
        return "NO NAME";
    }
    
    public void testGetName(){
        String name = getName(2012, 2, "M");
        System.out.println(name);
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear + ".");
    }
    
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Isabella", 2012, 2014, "F");
    }
    
    public int yearOfHighestRank(String name, String gender){
        int currRank = 0;
        int nameRank = -1;
        String fileName = "";
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            int rank = 0;
            for (CSVRecord rec: fr.getCSVParser(false)){
                if(rec.get(1).equals(gender)){
                    rank += 1;
                    //System.out.println(rec.get(0));
                    if (rec.get(0).equals(name)){
                        nameRank = rank;
                    }
                }
            }
            //System.out.println(nameRank);
            if (currRank == 0 && nameRank == -1){
                currRank = 0;
            }
            else if(currRank == 0 && nameRank != -1){
                currRank = nameRank;
                fileName = f.getName();
            }
            else {
                if (nameRank < currRank){
                    currRank = nameRank;
                    fileName = f.getName();
                }
            }
        }
        //file name only contains year as number
        fileName = fileName.replaceAll("[^\\d]", "");
        int highestYear = Integer.parseInt(fileName);
        return highestYear;
    }
    
    public void testYearOfHighestRank(){
        int year = yearOfHighestRank("Mason", "M");
        System.out.println(year);
    }
    
    public double getAverageRank(String name, String gender){
        int totalRank = 0;
        int nameRank = -1;
        int count = 0;
        String fileName = "";
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            int rank = 0;
            for (CSVRecord rec: fr.getCSVParser(false)){
                if(rec.get(1).equals(gender)){
                    rank += 1;
                    //System.out.println(rec.get(0));
                    if (rec.get(0).equals(name)){
                        nameRank = rank;
                    }
                }
            }
            
            totalRank = totalRank + nameRank;
            count += 1;
            //System.out.println(totalRank);
        }
        double avgRank = (double)totalRank/count;
        return avgRank;
    }
    
    public void testGetAverageRank(){
        double rank = getAverageRank("Jacob", "M");
        System.out.println(rank);
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int totalBirthsRank = 0;
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        for (CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if (!rec.get(0).equals(name)){
                    totalBirthsRank = totalBirthsRank + Integer.parseInt(rec.get(2));
                }
                if (rec.get(0).equals(name)){
                    return totalBirthsRank;
                }
            }
        }
        return -1;
    }
    
    public void testGetTotalBirthsRankedHigher(){
        int births = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        System.out.println(births);
    }   
}
