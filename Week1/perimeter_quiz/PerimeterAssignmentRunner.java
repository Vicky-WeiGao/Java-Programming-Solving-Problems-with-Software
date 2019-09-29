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
        // Put code here
        int NumPoints = 0;
        for (Point Pt : s.getPoints()){
        NumPoints = NumPoints + 1;   
        }
        return NumPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double TotalLength = getPerimeter(s);
        double TotalPoints = (double)getNumPoints(s);
        double AvgLength = TotalLength / TotalPoints;
        return AvgLength;
    }

    public double getLargestSide(Shape s) {
        double LargestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
                if (currDist > LargestSide){
                    LargestSide=currDist;
                }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return LargestSide;
    }

    public double getLargestX(Shape s) {
        double LargestX = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currX = currPt.getX();
            // Update totalPerim by currDist
                if (currX > LargestX){
                    LargestX=currX;
                }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double LargestPerimeter = 0.0;
        for (File f: dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shp = new Shape(file);
            double LargePeri = getPerimeter(shp);
            if (LargePeri > LargestPerimeter) {
                LargestPerimeter = LargePeri;
            }
        }
        return LargestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double LargestPerimeter = 0.0;
        File LargestFile = null;
        for (File f: dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shp = new Shape(file);
            double LargePeri = getPerimeter(shp);
            if (LargePeri > LargestPerimeter) {
                LargestPerimeter = LargePeri;
                LargestFile = f;
            }
        }
        return LargestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int NumPoints = getNumPoints(s);
        double AvgLength = getAverageLength(s);
        double LargestSide = getLargestSide(s);
        double LargestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("the number of points = " + NumPoints);
        System.out.println("the average sides' length = " + AvgLength);
        System.out.println("the largest side = " + LargestSide);
        System.out.println("the largest X = " + LargestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double LargestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + LargestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String LargestFile = getFileWithLargestPerimeter();
        System.out.println("Largest file name = " + LargestFile);
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
    }
}
