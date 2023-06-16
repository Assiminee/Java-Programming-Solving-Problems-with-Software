
/**
 * Décrivez votre classe FindAllGenes ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class FindAllGenes {
    public int findStopCodon (String DNA, int startIndex, String stopCodon) {
        int endIndex = DNA.indexOf(stopCodon, startIndex + 3);
        while (endIndex != -1) {
            int diff = endIndex - startIndex;
            if ((diff % 3) == 0) {
                return endIndex;
            }
            endIndex = DNA.indexOf(stopCodon, endIndex + 1);
        }
        return -1;
    }
    
    public String findGene(String DNA, int startIndex) {
        int taaIndex = findStopCodon(DNA, startIndex, "TAA");
        int tgaIndex = findStopCodon(DNA, startIndex, "TGA");
        int tagIndex = findStopCodon(DNA, startIndex, "TAG");
        int endIndex = taaIndex;
        if (endIndex == -1 || tgaIndex < endIndex) {
            endIndex = tgaIndex;
        }
        if (endIndex == -1 || tagIndex < endIndex) {
            endIndex = tagIndex;
        }
        if (endIndex == -1) {
            return "";
        }
        return DNA.substring(startIndex, endIndex + 3);
    }
    
    public void printAllGenes (String DNA) {
        int startIndex = DNA.indexOf("ATG");
        int geneCount = 0;
        if (startIndex == -1) {
            System.out.println("No genes found");
            return;
        }
        while (startIndex != -1) {
            String gene = findGene(DNA, startIndex);
            if (gene.isEmpty()) {  
                break;
            }
            System.out.println(gene);
            geneCount++;
            startIndex = DNA.indexOf("ATG", startIndex + gene.length());
        }
        if (geneCount != 0) {
            System.out.println("Number of genes found: " + geneCount);
        }
        else
            System.out.println("No genes found");
    }
    public static void main (String[] args) {
        FindAllGenes test = new FindAllGenes();
        String DNA = "ATCGTATACTGAAAACAGCTTTGAGATTGTTAAACACCGAAGAGTTATGATTTTCAGCGTTGAGGTCTAACCACTCAGCGATTATAGATGTGGAGGGTCTCTTCGCTGTAAGCATACGACGGTCTAGAGCTGGGATGAGGCCCGAACACTGTTATGGGTACGGTTGTAAGTCTTGAAACGTCTTGGAGGGTGGGCCGCCCAAGTACTTGTCCCAGGCGCGGGGTACCCGTATGCTTATCTTAAGGAGACGCGGTGAGAGTGGTCCGAAAGCCCTGGATTCATCTTAGCATGCGGGAAATCCGAAGTTGGAAGGTGAGGGACAGGAAACAATCTGATATGACCCTGTAGATCAACTCTGAACCCCGACATGTCCGAGCGATACCGACTCTACACGGGTGATGCATATCGTTGCGCTCTCTTTATAGAGATGATGCTGAATGGAAGAAAACCGCCACCCATCTCTAAGCGAACAGATTCAATAATGGAACCGGCCGAACTATTTCATAGAATGCAACGACGTTTGACAAATAATGGCGTTCTATCCACTCAAATCTCCGTATACTAGCGTTATCACAGTCGCATAATTAAACGCCAAAAACAAAACGTATATGGCGTTGTAACGCTGCACATTACCCGACATCGTACAGTGCATCATTCTCCGGGAACCAAGCACAATGACTACTAAGCATTACCAGGGAACGCAGATGTCTATCAGCACACCCGTTTTGATTGAGAGACAGCTTAATGTACGCAATTTGAGTAATACACCCTTCATGGTAGGGGACATGGAAGCCATACTGCAACCCTAGTATCACCTTAGAACGGCTACACACATTCGCACTTTCTCCTACGCGGCAACTTGTCGACGTTCTTGAGACGCTGTCGAGTGTTCCCAGCTAGCCTGGTCGGGACAATTATGACAACGGCAGTCCAGCATCATATGCCGCGAGCCGCACATTGGCTCCGTGTCACGCGCGATTGCTAGATCCGGGCA";
        System.out.println("First Test Case:");
        test.printAllGenes(DNA);
        DNA = "ATCGTATACTGAAAACAGCTTTGAGATTGTTAAACACCGAAGAGTTATGATTTTCAGCGTTGAGGTCCCACTCAGCGATTATAGATGTGGAGGGTCTCTTCGCTGTAAGCATACGACGGTCTAGAGCTGGGATGAGGCCCGAACACTGTTATGGGTACGGTTGTAAGTCTTGAAACGTCTTGGAGGGTGGGCCGCCCAAGTACTTGTCCCAGGCGCGGGGTACCCGTATGCTTATCTTAAGGAGACGCGGTGAGAGTGGTCCGAAAGCCCTGGATTCATCTTAGCATGCGGGAAATCCGAAGTTGGAAGGTGAGGGACAGGAAACAATCTGATATGACCCTGTAGATCAACTCTGAACCCCGACATGTCCGAGCGATACCGACTCTACACGGGTGATGCATATCGTTGCGCTCTCTTTATAGAGATGATGCTGAATGGAAGAAAACCGCCACCCATCTCTAAGCGAACAGATTCAATAATGGAACCGGCCGAACTATTTCATAGAATGCAACGACGTTTGACAAATAATGGCGTTCTATCCACTCAAATCTCCGTATACTAGCGTTATCACAGTCGCATAATTAAACGCCAAAAACAAAACGTATATGGCGTTGTAACGCTGCACATTACCCGACATCGTACAGTGCATCATTCTCCGGGAACCAAGCACAATGACTACTAAGCATTACCAGGGAACGCAGATGTCTATCAGCACACCCGTTTTGATTGAGAGACAGCTTAATGTACGCAATTTGAGTAATACACCCTTCATGGTAGGGGACATGGAAGCCATACTGCAACCCTAGTATCACCTTAGAACGGCTACACACATTCGCACTTTCTCCTACGCGGCAACTTGTCGACGTTCTTGAGACGCTGTCGAGTGTTCCCAGCTAGCCTGGTCGGGACAATTATGACAACGGCAGTCCAGCATCATATGCCGCGAGCCGCACATTGGCTCCGTGTCACGCGCGATTGCTAGATCCGGGCA";
        System.out.println("Second Test Case:");
        test.printAllGenes(DNA);
        DNA = "ATCGTATACTGAAAACAGCTTTGAGATTGTTAAACACCGAAGAGTTATGATTTTCAGCGTTGAGGTCCCACTCAGCGATTATAGATGTGGAGGGTCTCTTCGCTGTAAGCATACGACGGTCAGCTGGGATGAGGCCCGAACACTGTTATGGGTACGGTTGTAAGTCTTGAAACGTCTTGGAGGGTGGGCCGCCCAAGTACTTGTCCCAGGCGCGGGGTACCCGTATGCTTATCTTAAGGAGACGCGGTGAGAGTGGTCCGAAAGCCCTGGATTCATCTTAGCATGCGGGAAATCCGAAGTTGGAAGGTGAGGGACAGGAAACAATCTGATATGACCCTGTAGATCAACTCTGAACCCCGACATGTCCGAGCGATACCGACTCTACACGGGTGATGCATATCGTTGCGCTCTCTTTATAGAGATGATGCTGAATGGAAGAAAACCGCCACCCATCTCTAAGCGAACAGATTCAATAATGGAACCGGCCGAACTATTTCATAGAATGCAACGACGTTTGACAAATAATGGCGTTCTATCCACTCAAATCTCCGTATACTAGCGTTATCACAGTCGCATAATTAAACGCCAAAAACAAAACGTATATGGCGTTGTAACGCTGCACATTACCCGACATCGTACAGTGCATCATTCTCCGGGAACCAAGCACAATGACTACTAAGCATTACCAGGGAACGCAGATGTCTATCAGCACACCCGTTTTGATTGAGAGACAGCTTAATGTACGCAATTTGAGTAATACACCCTTCATGGTAGGGGACATGGAAGCCATACTGCAACCCTAGTATCACCTTAGAACGGCTACACACATTCGCACTTTCTCCTACGCGGCAACTTGTCGACGTTCTTGAGACGCTGTCGAGTGTTCCCAGCTAGCCTGGTCGGGACAATTATGACAACGGCAGTCCAGCATCATATGCCGCGAGCCGCACATTGGCTCCGTGTCACGCGCGATTGCTAGATCCGGGCA";
        System.out.println("Third Test Case:");
        test.printAllGenes(DNA);
        DNA = "ATCGTATACTGAAAACAGCTTTGAGATTGTTAAACACCGAAGAGTTATTTTCAGCGTTGAGGTCCCACTCAGCGATTATAGTGGAGGGTCTCTTCGCTGTAAGCATACGACGGTCAGCTGGGAGGCCCGAACACTGTTGGTACGGTTGTAAGTCTTGAAACGTCTTGGAGGGTGGGCCGCCCAAGTACTTGTCCCAGGCGCGGGGTACCCGTCTTATCTTAAGGAGACGCGGTGAGAGTGGTCCGAAAGCCCTGGATTCATCTTAGCCGGGAAATCCGAAGTTGGAAGGTGAGGGACAGGAAACAATCTGATACCCTGTAGATCAACTCTGAACCCCGACTCCGAGCGATACCGACTCTACACGGGTGCATATCGTTGCGCTCTCTTTATAGAGCTGAGAAGAAAACCGCCACCCATCTCTAAGCGAACAGATTCAATAGAACCGGCCGAACTATTTCATAGACAACGACGTTTGACAAATAGCGTTCTATCCACTCAAATCTCCGTATACTAGCGTTATCACAGTCGCATAATTAAACGCCAAAAACAAAACGTCGTTGTAACGCTGCACATTACCCGACATCGTACAGTGCATCATTCTCCGGGAACCAAGCACAACTACTAAGCATTACCAGGGAACGCAGTCTATCAGCACACCCGTTTTGATTGAGAGACAGCTTATACGCAATTTGAGTAATACACCCTTCGTAGGGGACGAAGCCATACTGCAACCCTAGTATCACCTTAGAACGGCTACACACATTCGCACTTTCTCCTACGCGGCAACTTGTCGACGTTCTTGAGACGCTGTCGAGTGTTCCCAGCTAGCCTGGTCGGGACAATTACAACGGCAGTCCAGCATCATCCGCGAGCCGCACATTGGCTCCGTGTCACGCGCGATTGCTAGATCCGGGCAF";
        System.out.println("Fourth Test Case:");
        test.printAllGenes(DNA);
        DNA = "ATCGTATACAAACAGCTTTGTACACCGAAGAGTTATTTTCAGCGTGGTCCCACTCAGCGATTGTGGAGGGTCTCTTCGCTGGCATACGACGGTCAGCTGGGAGGCCCGAACACTGTTATGGGTACGGTTGGTCCGTCTTGGAGGGTGGGCCGCCCAAGTACTTGTCCCAGGCGCGGGGTACCCGTATGCTTATCTGGAGACGCGGGAGTGGTCCGAAAGCCCTGGATTCATCTCATGCGGGAAATCCGAAGTTGGAAGGGGGACAGGAAACAATCTACCCTCAACTCACCCCGACATGTCCGAGCGATACCGACTCTACACGGGTGCATATCGTTGCGCTCTCTTGCATGGAAGAAAACCGCCACCCATCTCGCGAACAGATTCAATGGAACCGGCCGAACTATTTCAAATGCAACGACGTTCAAATGGCGTTCTATCCACTCAAATCTCCGTATACCGTTATCACAGTCGCATACGCCAAAAACAAAACGTATATGGCGTTGCGCTGCACATTACCCGACATCGTACAGTGCATCATTCTCCGGGAACCAAGCACAACTACGCATTACCAGGGAACGCAGATGTCTATCAGCACACCCGTTCAGCTTGTACGCAATTGTACACCCTTCATGGGGGACATGGAAGCCATACTGCAACCCTATCACCCGGCTACACACATTCGCACTTTCTCCTACGCGGCAACTTGTCGACGTTCCGCTGTCGAGTGTTCCCAGCCCTGGTCGGGACAATTACAACGGCAGTCCAGCATCATATGCCGCGAGCCGCACATTGGCTCCGTGTCACGCGCGATTGCATCCGGGCA";
        System.out.println("Fifth Test Case:");
        test.printAllGenes(DNA);
        DNA = "ATCGTATACTGAAAACAGCTTTGAGATTGTTAAACACCGAAGAGTTATGATTTTCAGCGTTGAGGTCCCACTCAGCGATTATAGATGTGGAGGGTCTCTTCGCTGTAAGCATACGACGGTCAGCTGGGATGAGGCCCGAACACTGTTATGGGTACGGTTGTAAGTCTTGAAACGTCTTGGAGGGTGGGCCGCCCAAGTACTTGTCCCAGGCGCGGGGTACCCGTATGCTTATCTTAAGGAGACGCGGTGAGAGTGGTCCGAAAGCCCTGGATTCATCTTAGCATGCGGGAAATCCGAAGTTGGAAGGTGAGGGACAGGAAACAATCTGATATGACCCTGTAGATCAACTCTGAACCCCGACATGTCCGAGCGATACCGACTCTACACGGGTGATGCATATCGTTGCGCTCTCTTTATAGAGATGATGCTGAATGGAAGAAAACCGCCACCCATCTCTAAGCGAACAGATTCAATAATGGAACCGGCCGAACTATTTCATAGAATGCAACGACGTTTGACAAATAATGGCGTTCTATCCACTCAAATCTCCGTATACTAGCGTTATCACAGTCGCATAATTAAACGCCAAAAACAAAACGTATATGGCGTTGTAACGCTGCACATTACCCGACATCGTACAGTGCATCATTCTCCGGGAACCAAGCACAATGACTACTAAGCATTACCAGGGAACGCAGATGTCTATCAGCACACCCGTTTTGATTGAGAGACAGCTTAATGTACGCAATTTGAGTAATACACCCTTCATGGTAGGGGACATGGAAGCCATACTGCAACCCTAGTATCACCTTAGAACGGCTACACACATTCGCACTTTCTCCTACGCGGCAACTTGTCGACGTTCTTGAGACGCTGTCGAGTGTTCCCAGCTAGCCTGGTCGGGACAATTATGACAACGGCAGTCCAGCATCATATGCCGCGAGCCGCACATTGGCTCCGTGTCACGCGCGATTGCTAGATCCGGGCAATGTGTAA";
        System.out.println("Sixth Test Case:");
        test.printAllGenes(DNA);
    }
}
