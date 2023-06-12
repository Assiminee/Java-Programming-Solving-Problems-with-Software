import edu.duke.*;
import java.io.*;
/**
 * A class with 2 methods and a main
 * 
 * Method1: findSimpleGene(String dna)
 *          Checks if a DNA strand has a valid DNA sequence (starting with ATG and ending in TAA)
 *          Returns the sequence if it exists of an empty string if it doesn't
 * Method2: testSimpleGene()
 *          Tests the findSimpleGene method
 *
 * @author Yasmine Znatni
 * @version 1 08/06/2023
 */
public class Part1 {
    public String findSimpleGene (String dna) {
        String result = "";
        int start = dna.indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int end = dna.indexOf("TAA", start + 3);
        if (end == -1) {
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
        if (findSimpleGene(DNAStrand) == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand));
        
        DNAStrand = "AATGCTAGGGTAATATGGT";
        System.out.println("Second DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand) == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand));
        
        DNAStrand = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("Third DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand) == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand));
        
        DNAStrand = "ATGTAA";
        System.out.println("Fourth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand) == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand));
        
        DNAStrand = "ATGCGTAA";
        System.out.println("Fourth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand) == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand));
            
        DNAStrand = "ATG";
        System.out.println("Fourth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand) == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand));
            
        DNAStrand = "TAA";
        System.out.println("Fourth DNA strand is: " + DNAStrand);
        if (findSimpleGene(DNAStrand) == "")
            System.out.println("No Protein Found");
        else
            System.out.println("Protein Found is: " + findSimpleGene(DNAStrand));
    }
    
    public static void main (String[] args) {
        Part1 test = new Part1();
        test.testSimpleGene();
    }
}
