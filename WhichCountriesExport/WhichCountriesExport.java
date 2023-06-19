import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExport {
    public void listExporters (String exportOfInterest, CSVParser parser) {
        System.out.println("Countries that export " + exportOfInterest);
        for (CSVRecord record : parser) {
            String exportCol = record.get("Exports");
            if (exportCol.contains(exportOfInterest)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public String countryInfo (CSVParser parser, String country) {
        String countryInfo = "";
        for (CSVRecord record : parser) {
            String countryCol = record.get("Country");
            if (countryCol.equals(country)){
                countryInfo += countryCol + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
                return countryInfo;
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters (CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }
    
    public void bigExporters (CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String countryAmount = record.get("Value (dollars)");
            if (countryAmount.length() > amount.length()) {
                System.out.print(record.get("Country") + " ");
                System.out.println(record.get("Value (dollars)"));
            }
        }
    }
    
    public static void main (String[] args) {
        WhichCountriesExport wce = new WhichCountriesExport();
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // Which Countries Export "gold":
        wce.listExporters("gold", parser);
        
        // Which Countries Export Both "gold" and "diamonds":
        parser = fr.getCSVParser();
        System.out.println("\nCountries that Export Both gold and diamonds:");
        wce.listExportersTwoProducts(parser, "gold", "diamonds");
        
        // How many countries export "sugar":
        parser = fr.getCSVParser();
        int numberOfExporters = wce.numberOfExporters(parser, "sugar");
        System.out.println("\nNumber of Countries That Export sugar:");
        System.out.println(numberOfExporters);
        
        // Print the information of the country "Nauru" to the console:
        parser = fr.getCSVParser();
        String countryInfo = wce.countryInfo(parser, "Germany");
        System.out.println("\nGermany Information:");
        System.out.println(countryInfo);
        
        // List the countries whose export value is higher than "$999,999,999,999":
        parser = fr.getCSVParser();
        System.out.println("\nList of countries whose export value is higher than $999,999,999,999:");
        wce.bigExporters(parser, "$999,999,999,999");
    }
}
