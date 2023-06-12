/**
 * A class with 13 methods and a main.
 * getPerimeter(Shape s) : returns the perimeter of a shape.
 * getNumPoints(Shape s) : returns the number of points in a shape.
 * getAverageLength(Shape s) : returns the average length of all of 
 *                             the shape's sides.
 * getLargestSide(Shape s) : returns the largest side of the shape.
 * getLargestX (Shape s) : returns the largest x coordinate of a shape.
 * getLargestPerimeterMultipleFiles() : returns the largest perimeter from 
 *                                      multiple files containing the x and y
 *                                      coordinates of the points of a shape.
 * getFileWithLargestPerimeter() : returns the title of the file with 
 *                                 the largest perimeter.
 * testPerimeter() : tests the methods getPerimeter, getNumPoints, 
 *                   getAverageLength, getLargestSide and getLargestX.
 * testPerimeterMultipleFiles() : tests the method 
 *                                getLargestPerimeterMultipleFiles.
 * testFileWithLargestPerimeter() : tests the getFileWithLargestPerimeter
 *                                  method.
 */
import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Initializes the numPoints variable to 0
        int numPoints = 0;
        // Iterate over the points of a shape
        for (Point pt : s.getPoints()) {
            // Increment the numPoints variable for each point in s
            numPoints++;
        }
        // numPoints is the answer
        return numPoints;
    }

    
    public double getAverageLength(Shape s) {
        // Initializes averageLength to the sum of all sides i.e the perimeter
        double averageLength = getPerimeter(s);
        // Division of the averageLength by the number of points which in this case
        // is the same as the number of sides
        averageLength /= getNumPoints(s);
        // averageLength is the answer
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Initilizes largestSide to 0
        double largestSide = 0.0;
        // gets the last point of the shape and assigns it
        // to prevPoint
        Point prevPoint = s.getLastPoint();
        // Iterate over the points of the shape
        for (Point currPoint : s.getPoints()) {
            // compare the distance between prevPoint and currPoint to
            // largestSide
            if (prevPoint.distance(currPoint) >= largestSide) {
                // if that distance is larger than largestSide
                // update the value of largestSide
                largestSide = prevPoint.distance(currPoint);
            }
            // Assign currPoint to prevPoint
            prevPoint = currPoint;
        }
        // The answer is largestSide
        return largestSide;
    }
    
    public double getLargestX (Shape s) {
        // Initialize largestX to 0
        double largestX = 0.0;
        // get the last point of the shape 
        Point pt = s.getLastPoint();
        // Assign the x coordinate of the last point of the shape
        // to largestX
        largestX = pt.getX();
        // Iterate over all points in the shape
        for (Point currPoint : s.getPoints()) {
            // compare largestX to the x coordinate of currPoint
            if (currPoint.getX() >= largestX) {
                // if the x coordinate of currPoint is larger that largestX
                // update the value of largestX
                largestX = currPoint.getX();
            }
        }
        // The answer is largestX
        return largestX;
    }
    
    public double getLargestPerimeterMultipleFiles () {
        // Initialize largestPerim to 0
        double largestPerim = 0.0;
        // Create a new DirectoryResource
        DirectoryResource dir = new DirectoryResource();
        // Iterate over dir using the .selectedFiles() method 
        for (File f : dir.selectedFiles()) {
            // Create a FileResource for each file in dir
            FileResource fr = new FileResource(f);
            // Create a shape for each FileResource Created
            Shape s = new Shape(fr);
            // Compare largestPerim to the perimeter of each Shape s
            if (getPerimeter(s) >= largestPerim) {
                // If the shape's perimeter is larger than largestPerim
                // update the value of largestPerim
                largestPerim = getPerimeter(s);
            }
        }
        // The answer is largestPerim
        return largestPerim;
    }
    
    public String getFileWithLargestPerimeter () {
        double largestPerim = getLargestPerimeterMultipleFiles();
        String fileName = "";
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (largestPerim == getPerimeter(s)) {
                fileName = f.getName();
                break;
            }
        }
        return fileName;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numPoints);
        System.out.println("The average length of all sides of the shape = " + averageLength);
        System.out.println("The largest side = " + largestSide);
        System.out.println("The largest x = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("The largest Perimeter found = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("The name of the file is: " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
