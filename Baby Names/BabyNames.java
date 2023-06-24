
import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.File;
public class BabyNames {
    // prints baby names in a CSV file
    public void printNames () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println("Names in file " + f.getName() + ":");
            FileResource fr = new FileResource(f);
            for (CSVRecord record : fr.getCSVParser(false)) {
                int numberOfBirths = Integer.parseInt(record.get(2));
                if (numberOfBirths <= 12000)
                    System.out.println("Name: " + record.get(0) + ". Gender: " + record.get(1) + ". Number of babies with the name: " + record.get(2));
            }
            System.out.println("\n");
        }
    }
    
    // Prints the total number of babies born and the total number of births per gender in a given year.
    public void totalBirths (FileResource fr) {
        int numGirls = 0;
        int numBoys = 0;
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBirthsRow = Integer.parseInt(rec.get(2));
            if (rec.get(1).equals("M"))
                numBoys += numBirthsRow;
            else
                numGirls += numBirthsRow;
        }
        totalBirths = numBoys + numGirls;
        System.out.print("Number of babies born: " + totalBirths + 
                         "\nNumber of girls born: " + numGirls + 
                         "\nNumber of boys born: " + numBoys);
    }
    
    public void testingTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    // Calculates the number of names per gender in a CSV file 
    public int totalNamesPerGender (FileResource fr, String gender) {
        int numGirls = 0;
        int numBoys = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBirthsRow = Integer.parseInt(rec.get(2));
            if (rec.get(1).equals("M"))
                numBoys++;
            else
                numGirls++;
        }
        if (gender.equals("M"))
            return numBoys;
        return numGirls;
    }
    
    public void testTotalNamesPerGender () {
        int year = 1905;
        String fileName = getFileName(year);
        FileResource fr = new FileResource(fileName);
        String gender = "M";
        System.out.println("Number of \"" + gender + "\" names in the year " + year + " was " + totalNamesPerGender(fr, gender));
    }
    
    // Gets the fulĺpath of the CSV file
    public String getFileName (int year) {
        return "C:\\path\\to\\CSV\\file\\on\\your\\machine\\yob" + Integer.toString(year) + ".csv";
    }
    
    // Gets the rank of a name in a CSV file of baby names of a given year
    public int getRank (int year, String name, String gender) {
        String fileName = getFileName(year);
        FileResource fr = new FileResource(fileName);
        int rank = 0;
        for (CSVRecord line : fr.getCSVParser(false)) {
            rank++;
            if (line.get(0).equals(name) && line.get(1).equals(gender)) {
                if (gender.equals("M")) {
                    int numGirlNames = totalNamesPerGender(fr, "F");
                    return rank - numGirlNames;
                }
                return rank;
            }
        }
        return -1;
    }
    
    public void testGetRank () {
        int year = 1971;
        String name = "Frank";
        String gender = "M";
        int rank = getRank(year, name, gender);
        System.out.println("The name " + name + " was ranked " + rank + " in the year " + year); 
    }
    
    // Gets the name at a given rank in a CSV file of baby names in a given year
    public String getName (int year, int rank, String gender) {
        int currentLineRank = 0;
        String name = "";
        String fileName = getFileName(year);
        FileResource fr = new FileResource(fileName);
        int numGirlNames = totalNamesPerGender(fr, "F");
        for (CSVRecord rec : fr.getCSVParser(false)) {
            currentLineRank++;
            if (gender.equals("F") && currentLineRank == rank) {
                return rec.get(0);
            }
            if (gender.equals("M")) {
                if ((currentLineRank - numGirlNames) == rank) {
                    return rec.get(0);
                }
            }
        }
        return "NO NAME";
    }
    
    public void testGetName () {
        int year = 1982;
        int rank = 450;
        String gender = "M";
        String name = getName(year, rank, gender);
        System.out.println("The name " + name + " was ranked " + rank + " in the year " + year); 
    }
    
    // Shows you what your name would be in a different year based on its rank during the year you were born
    public void whatIsNameInYear (String name, int year, int newYear, String gender) {
        int yearOfBirthRank = getRank(year, name, gender);
        String newYearName = getName(newYear, yearOfBirthRank, gender);
        System.out.println(name + " born in " + year + " would have been named " + newYearName + 
                           " if they were born in the year " + newYear);
    }
    
    public void testWhatIsNameInYear () {
        String name = "Owen";
        int year = 1974;
        int newYear = 2014;
        String gender = "M";
        whatIsNameInYear(name, year, newYear, gender);
    }
    
    // Extracts the year from the name of the file used
    public int extractYear (File f) {
        String fileName = f.getName();
        int yearIndex = fileName.indexOf("yob");
        return Integer.parseInt(fileName.substring(yearIndex + 3, yearIndex + 7));
    }
    
    // Returns the year where a given name of a given gender had the highest rank
    public int yearOfHighestRank (String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int yearWithHighestRank = 0;
        int highestRank = 0;
        for (File f : dr.selectedFiles()) {
            int currentYear = extractYear(f);
            int currentYearRank = getRank(currentYear, name, gender);
            if (highestRank == 0 || currentYearRank < highestRank) {
                highestRank = currentYearRank;
                yearWithHighestRank = currentYear;
            }
        }
        return yearWithHighestRank;
    }
    
    public void testYearOfHighestRank () {
        String name = "Mich";
        String gender = "M";
        int year = yearOfHighestRank(name, gender);
        System.out.println("The year when the name " + name + " was most popular is " + year);
    }
    
    // Gets the average rank of a given name of a given gender for a selection of years
    public double getAverageRank (String name, String gender) {
        int numOfFiles = 0;
        double totalRanking = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            int currentFileRank = getRank(extractYear(f), name, gender);
            if (currentFileRank != -1) {
                numOfFiles++;
                totalRanking += currentFileRank;
            }
        }
        if (totalRanking == 0.0)
            return -1.0;
        return totalRanking/numOfFiles;
    }
    
    public void testGetAverageRank () {
        String name = "Robert";
        String gender = "M";
        double averageRank = getAverageRank(name, gender);
        System.out.println("The average ranking of the name " + name + " is: " + averageRank);
    }
    
    // Gets the number of babies born in a given year that are ranked higher than a specific name
    public int getTotalBirthsRankedHigher (int year, String name, String gender) {
        int totalBirths = 0;
        int i = 1;
        String fileName = getFileName(year);
        FileResource fr = new FileResource(fileName);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                if (rec.get(0).equals(name)) {
                    break;
                }
                totalBirths += Integer.parseInt(rec.get(2));
            }
        }
        return totalBirths;
    }
    
    public void testTotal () {
        String name = "Drew";
        String gender = "M";
        int year = 1990;
        int totalBirths = getTotalBirthsRankedHigher(year, name, gender);
        System.out.println("The number of babies born with a name ranked higher than the name " + name +
                           " was: " + totalBirths);
    }
}
