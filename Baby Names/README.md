# MiniProject Exercise:

The "BabyNames" class provides various functionalities to analyze and manipulate CSV files containing baby names, their genders, and the number of births associated with each name in a given year. This code represents the solution to the mini project and final assignment for the "Java Programming Solving Problems With Software" course on Coursera. It is designed to work with a specific dataset of baby names in the USA from 1880 to 2014. You can find the .zip file containing all the CSV files used for this assignment by clicking [here](http://www.dukelearntoprogram.com/course2/data/us_babynames.zip).

## Code description:

The code includes the following methods:

- printNames(): This method iterates over the selected CSV files and prints the names, genders, and the number of babies with each name. It filters out names with a low number of births (less than or equal to 12000).

- totalBirths(FileResource fr): Given a specific CSV file, this method calculates the total number of babies born, as well as the number of girls and boys born in a given year.

- testingTotalBirths(): This method prompts the user to select a CSV file and calls the totalBirths() method to display the total number of babies, girls, and boys born.

- totalNamesPerGender(FileResource fr, String gender): Given a CSV file, this method calculates the total number of names for a specific gender.

- testTotalNamesPerGender(): This method prompts the user to enter a year, loads the corresponding CSV file, and displays the number of names for a given gender in that year.

- getFileName(int year): Given a year, this method returns the complete path to the corresponding CSV file. Note that the user needs to download the [CSV files](http://www.dukelearntoprogram.com/course2/data/us_babynames.zip) and modify the path to the location where the CSV files are stored on their device.

- getRank(int year, String name, String gender): Given a year, a name, and a gender, this method retrieves the rank of the name in the CSV file for that year.

- testGetRank(): This method tests the getRank() method by prompting the user to enter a year, a name, and a gender, and then displays the rank of the name in that year.

- getName(int year, int rank, String gender): Given a year, a rank, and a gender, this method retrieves the name corresponding to the given rank in the CSV file for that year.

- testGetName(): This method tests the getName() method by prompting the user to enter a year, a rank, and a gender, and then displays the name at that rank in the given year.

- whatIsNameInYear(String name, int year, int newYear, String gender): Given a name, a birth year, a target year, and a gender, this method determines what the given name would have been in the target year based on its rank in the birth year.

- testWhatIsNameInYear(): This method tests the whatIsNameInYear() method by prompting the user to enter a name, a birth year, a target year, and a gender, and then displays the corresponding name in the target year.

- extractYear(File f): Given a file, this method extracts the year from its name.

- yearOfHighestRank(String name, String gender): This method determines the year in which a given name and gender had the highest rank among all the available CSV files.

- testYearOfHighestRank(): This method tests the yearOfHighestRank() method by prompting the user to enter a name and a gender and then displays the year when that name was most popular.

- getAverageRank(String name, String gender): Given a name and a gender, this method calculates the average rank of the name across multiple CSV files.

- testGetAverageRank(): This method tests the getAverageRank() method by prompting the user to enter a name and a gender, and then displays the average rank of the name.

- getTotalBirthsRankedHigher(int year, String name, String gender): Given a year, a name, and a gender, this method calculates the total number of babies born with names ranked higher than the given name in that year.

- testTotal(): This method tests the getTotalBirthsRankedHigher() method by prompting the user to enter a name, a gender, and a year, and then displays the number of babies born with names ranked higher than the given name.

### Note: 
Before running the code, ensure that the CSV files are downloaded from [this link](http://www.dukelearntoprogram.com/course2/data/us_babynames.zip) and update the path in the getFileName() method to the location where the CSV files are stored on your device.

The assignment instructions for this mini-project can be found in [the accompanying PDF file](https://github.com/Assiminee/Java-Programming-Solving-Problems-with-Software/blob/main/Baby%20Names/MiniProject-ProgrammingExerciseGuide.pdf).
