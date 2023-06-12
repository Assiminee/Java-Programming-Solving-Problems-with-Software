# Perimeter Assignment Introduction/Code Review
## Calculating information about shapes
In this assignment, you will complete the PerimeterAssignmentRunner class to calculate lots of interesting facts about shapes. This class has been started for you in the BlueJ project called PerimeterAssignmentRunner (go to [http://www.dukelearntoprogram.com/course2/files.php](http://www.dukelearntoprogram.com/course2/files.php) and download the Quiz - Calculating the Perimeter of a Shape BlueJ project). 
This project also contains several data files. In addition, you will need to look at the documentation for the Shape class and the Point class.

The PerimeterAssignmentRunner class already includes the following complete methods:
1. The getPerimeter method has one parameter s of type Shape. Given a shape, this method returns the perimeter of the shape.
2. The testPerimeter method has no return value, hence its return type is void. This method is used to select a data file by using the FileResource class, create a shape based on the points from that data file, and then calculate the perimeter of the shape and output its value.
3. The triangle method has no return value and creates a triangle that you can use to test the methods you will create in this assignment.
4. The printFileNames method, which we will discuss in a future lesson.
5. The main method.

For this assignment, you will add or modify several methods in the PerimeterAssignmentRunner class.

## Part 1:
Our goals for this exercise are to: 

1a. Complete writing the method getNumPoints that has one parameter s that is of type Shape. This method returns an integer that is the number of points in Shape s. 

1b. Add code in the method testPerimeter to call getNumPoints and to print the result.

2a. Complete writing the method getAverageLength that has one parameter s that is of type Shape. This method returns a number of type double that is the calculated average of all the sides’ lengths in the Shape S.

2b. Add code in the method testPerimeter to call the method getAverageLength and to print out the result. 
