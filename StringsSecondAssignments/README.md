# Programming Exercise: Finding Many Genes
The FindAllGenes class is a Java program that provides various methods for gene analysis in DNA sequences. It includes methods to find stop codons, extract genes, calculate the CG ratio, count occurrences of the CTG codon, and process a collection of genes.

The key methods in this class are as follows:

- findStopCodon: This method searches for a specific stop codon (provided as an input) in a given DNA sequence starting from a specified index. It returns the index of the stop codon if found, or -1 if not found.

- findGene: This method finds a gene within a DNA sequence starting from a specified index. It uses the findStopCodon method to identify the stop codons (TAA, TGA, and TAG) and returns the gene as a substring. If no valid gene is found, it returns an empty string.

- getAllGenes: This method searches for all possible genes within a DNA sequence. It iteratively finds genes starting from the "ATG" codon and adds them to a StorageResource object. It returns the collection of genes found.

- printGeneList: This method prints the list of genes found in a DNA sequence. It uses the getAllGenes method to retrieve the genes and displays them on the console.

- cgRatio: This method calculates the CG ratio of a DNA sequence. It counts the occurrences of the nucleotides 'C' and 'G' and divides it by the total length of the DNA sequence. The result is returned as a float value representing the ratio.

- countCTG: This method counts the number of occurrences of the "CTG" codon in a DNA sequence. It returns the count as an integer value.

- processGenes: This method processes a collection of genes obtained from the getAllGenes method. If the collection is empty, it displays a message stating that there are no genes to process.

The code also includes a StorageResource class (which is a part of the edu.duke java package) that provides a data structure to store and manipulate gene sequences.

This Java program can be used to analyze DNA sequences and perform basic gene-related computations. It can serve as a helpful tool for bioinformatics researchers, geneticists, and anyone interested in exploring genetic data.

Please note that the code provided here is a snippet and may require additional implementation or integration with other classes and methods to function correctly in a complete program.

## Test Cases:
### First Test Case:

ATCGTATACTGAAAACAGCTTTGAGATTGTTAAACACCGAAGAGTTATGATTTTCAGCGTTGAGGTCTAACCACTCAGCGATTATAGATGTGGAGGGTCTCTTCGCTGTAAGCATACGACGGTCTAGAGCTGGGATGAGGCCCGAACACTGTTATGGGTACGGTTGTAAGTCTTGAAACGTCTTGGAGGGTGGGCCGCCCAAGTACTTGTCCCAGGCGCGGGGTACCCGTATGCTTATCTTAAGGAGACGCGGTGAGAGTGGTCCGAAAGCCCTGGATTCATCTTAGCATGCGGGAAATCCGAAGTTGGAAGGTGAGGGACAGGAAACAATCTGATATGACCCTGTAGATCAACTCTGAACCCCGACATGTCCGAGCGATACCGACTCTACACGGGTGATGCATATCGTTGCGCTCTCTTTATAGAGATGATGCTGAATGGAAGAAAACCGCCACCCATCTCTAAGCGAACAGATTCAATAATGGAACCGGCCGAACTATTTCATAGAATGCAACGACGTTTGACAAATAATGGCGTTCTATCCACTCAAATCTCCGTATACTAGCGTTATCACAGTCGCATAATTAAACGCCAAAAACAAAACGTATATGGCGTTGTAACGCTGCACATTACCCGACATCGTACAGTGCATCATTCTCCGGGAACCAAGCACAATGACTACTAAGCATTACCAGGGAACGCAGATGTCTATCAGCACACCCGTTTTGATTGAGAGACAGCTTAATGTACGCAATTTGAGTAATACACCCTTCATGGTAGGGGACATGGAAGCCATACTGCAACCCTAGTATCACCTTAGAACGGCTACACACATTCGCACTTTCTCCTACGCGGCAACTTGTCGACGTTCTTGAGACGCTGTCGAGTGTTCCCAGCTAGCCTGGTCGGGACAATTATGACAACGGCAGTCCAGCATCATATGCCGCGAGCCGCACATTGGCTCCGTGTCACGCGCGATTGCTAGATCCGGGCA
