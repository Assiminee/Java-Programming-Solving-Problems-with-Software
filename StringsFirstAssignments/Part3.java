
import edu.duke.*;
import java.io.*;
/**
 * A class with 3 methods.
 * 
 * Method1: twoOccurrences(String stringa, String stringb)
 *          Checks if stringa occurs at least twice in stringb
 * Method2: lastPart(String stringa, String stringb)
 *          Returns the part of stringb following the first occurence of stringa
 *          Returns stringb in its entirety if stringa doesn't occur in stringb
 * Method3: testing()
 *          Tests the two methods
 *
 * @author Yasmine Znatni
 * @version 1 08/06/2023
 */
public class Part3 {
    public boolean twoOccurrences (String stringa, String stringb) {
        int firstOccurenceIndex = stringb.indexOf(stringa);
        if (firstOccurenceIndex == -1) {
            return false;
        }
        int secondOccurenceIndex = stringb.indexOf(stringa, firstOccurenceIndex + stringa.length());
        if (secondOccurenceIndex != -1) {
            return true;
        }
        return false;
    }
    
    public String lastPart (String stringa, String stringb) {
        int stringaIndex = stringb.indexOf(stringa);
        if (stringaIndex != -1) {
            return stringb.substring(stringaIndex + stringa.length(), stringb.length());
        }
        return stringb;
    }
    
    public void testing () {
        // First test case: 
        String stringa = "by";
        String stringb = "Abby is sitting by the fireplace";
        System.out.println("stringa: \"" + stringa + "\"");
        System.out.println("stringb: \"" + stringb + "\"");
        System.out.println("\"" + stringa + "\" appears at least twice in " + "\"" + stringb + "\": " + twoOccurrences(stringa, stringb));
    
        // Second test case: 
        stringa = "i";
        stringb = "Abby is sitting by the fireplace";
        System.out.println("\n");
        System.out.println("stringa: \"" + stringa + "\"");
        System.out.println("stringb: \"" + stringb + "\"");
        System.out.println("\"" + stringa + "\" appears at least twice in " + "\"" + stringb + "\": " + twoOccurrences(stringa, stringb));
    
        // Third test case: 
        stringa = "h";
        stringb = "Abby is sitting by the fireplace";
        System.out.println("\n");
        System.out.println("stringa: \"" + stringa + "\"");
        System.out.println("stringb: \"" + stringb + "\"");
        System.out.println("\"" + stringa + "\" appears at least twice in " + "\"" + stringb + "\": " + twoOccurrences(stringa, stringb));
        
        // Fourth test case:
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println("\n");
        System.out.println("stringa: \"" + stringa + "\"");
        System.out.println("stringb: \"" + stringb + "\"");
        System.out.println("\"" + stringa + "\" appears at least twice in " + "\"" + stringb + "\": " + twoOccurrences(stringa, stringb));
        
        // Testing lastPart method:
        stringa = "an";
        stringb = "banana";
        System.out.println("\n");
        System.out.println("stringa: \"" + stringa + "\"");
        System.out.println("stringb: \"" + stringb + "\"");
        System.out.println("The part of the string after \"" + stringa + "\"" + "in \"" + stringb + "\" is: " + lastPart(stringa, stringb));
        
        stringa = "zoo";
        stringb = "animal";
        System.out.println("\n");
        System.out.println("stringa: \"" + stringa + "\"");
        System.out.println("stringb: \"" + stringb + "\"");
        System.out.println("The part of the string after \"" + stringa + "\"" + "in \"" + stringb + "\" is: " + lastPart(stringa, stringb));
        
        stringa = "and";
        stringb = "I am a 12 year old boy and";
        System.out.println("\n");
        System.out.println("stringa: \"" + stringa + "\"");
        System.out.println("stringb: \"" + stringb + "\"");
        System.out.println("The part of the string after \"" + stringa + "\"" + "in \"" + stringb + "\" is: " + lastPart(stringa, stringb));
    }
}
