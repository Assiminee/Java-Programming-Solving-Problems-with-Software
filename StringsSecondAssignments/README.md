# Programming Exercise: Finding Many Genes
This Java program finds all the genes in a DNA strand. It has three methods:

- findStopCodon: This method takes in a DNA strand, a start index and a stop codon and returns the index of the first occurrence of the stop codon that appears after the start index and is a multiple of 3 away from the start index. If there is no such stop codon, it returns -1.
    
- findGene: This method takes in a DNA strand and a start index and returns the gene that starts at the start index and ends with the nearest stop codon that appears after the start index and is a multiple of 3 away from the start index. If there is no such gene, it returns an empty string.
    
- printAllGenes: This method takes in a DNA strand and prints all the genes in the DNA strand along with their count. If there are no genes in the DNA strand, it prints “No genes found”.
