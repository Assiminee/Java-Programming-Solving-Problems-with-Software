# Programming Exercise: Parsing Export Data
The WhichCountriesExport Java program is designed to analyze and provide information about countries and their exports based on a given CSV (Comma-Separated Values) dataset. It includes several methods to extract and display specific information from the dataset.

The key methods in this class are as follows:

- listExporters: This method takes as input a specific export item and a CSVParser object. It lists the countries that export the given item by iterating over the records in the CSV dataset and checking if the "Exports" column contains the export item of interest.

- countryInfo: This method retrieves detailed information about a specific country by searching for its name in the CSV dataset. It takes a CSVParser object and the name of the country as input and returns a string containing the country's name, exports, and value in dollars.

- listExportersTwoProducts: This method finds countries that export two specific items simultaneously. It takes a CSVParser object and two export items as input. It iterates over the dataset, checking if the "Exports" column contains both of the specified items.

- numberOfExporters: This method counts the number of countries that export a particular item. It takes a CSVParser object and an export item as input and returns the count of countries exporting that item.

- bigExporters: This method lists the countries whose export value exceeds a specified amount. It takes a CSVParser object and a string representing the amount as input. It iterates over the dataset, comparing the length of the export value with the specified amount length.

The main method demonstrates the usage of these methods by creating an instance of the WhichCountriesExport class, loading a CSV file using the FileResource class, and obtaining a CSVParser object. It then calls each of the methods with different parameters to perform specific queries on the dataset.

This Java program can be used to explore and analyze CSV datasets containing information about countries and their exports. It provides functionalities to retrieve country-specific information, identify countries with specific exports, count the number of exporters for a given item, and find countries with high export values.

Please note that the code provided here assumes the presence of the necessary external libraries (such as Apache Commons CSV) for parsing the CSV file.

The CSV datasets used for testing are included in this directory.
