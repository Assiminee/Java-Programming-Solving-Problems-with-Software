import edu.duke.*;
import java.io.*;
/**
 * A class with 2 methods and a main
 * 
 * Method1: findSimpleGene(String dna, String startCodon, String endCodon)
 *          Checks if a DNA strand contains a valid sequence of DNA (starting in startCodon and ends in endCodon and its length
 *          is divisible by 3).
 *          If it is valid it returns the valid DNA sequence
 *          If not it returns an empty string.
 *          This method also accounts for case.
 * Method2: testSimpleGene()
 *          Test the findSimpleGene method.
 *
 * @author Yasmine ZNATNI
 * @version 1
 */
public class Part2 {
    public String findSimpleGene (String dna, String startCodon, String endCodon) {
        String result = "";
        startCodon = startCodon.toLowerCase();
        endCodon = endCodon.toLowerCase();
        int start = dna.indexOf(startCodon);
        if (start == -1) {
            startCodon = startCodon.toUpperCase();
            start = dna.indexOf(startCodon);
            if (start == -1)
                return "";
        }
        int end = dna.indexOf(endCodon, start + 3);
        if (end == -1) {
            endCodon = endCodon.toUpperCase();
            end = dna.indexOf(endCodon, start + 3);
            if (end == -1)
                return "";
        }
        result = dna.substring(start, end + 3);
        if (result.length() % 3 == 0) {
            return result;
        }
        return "";
    }
    public void testSimpleGene () {
        String DNAStrand = "AATGCGTAATATGGT";
        System.out.println("First DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "ATG", "TAA") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
        
        DNAStrand = "AATGCTAGGGTAATATGGT";
        System.out.println("Second DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "atg", "taa") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
        
        DNAStrand = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("Third DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "ATG", "TAA") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
        
        DNAStrand = "ATGTAA";
        System.out.println("Fourth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "ATG", "TAA") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
        
        DNAStrand = "ATGCGTAA";
        System.out.println("Fifth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "ATG", "TAA") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
            
        DNAStrand = "ATG";
        System.out.println("Sixth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "ATG", "TAA") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
            
        DNAStrand = "TAA";
        System.out.println("Seventh DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "ATG", "TAA") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
            
        DNAStrand = "agatgattgtgttttaaga";
        System.out.println("Eighth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand, "ATG", "TAA") == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand, "ATG", "TAA"));
    }
    
    public static void main (String[] args) {
        Part2 test = new Part2();
        test.testSimpleGene();
    }
}
