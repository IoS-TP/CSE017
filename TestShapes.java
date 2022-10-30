/***
 * Class to test the class Shape, its sub classes, and its interfaces
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 07, 2022
 * Last Date Modified: September 10, 2022
 */
public class TestShapes{
    /***
     * Method to run the program and test the classes
     * @param   args to hold the command line arguments
     * no return value
     */
    public static void main (String[] args){
        Shape[] shapes = new Shape[8];
        shapes[0] = new Circle("Black", 2.5);
        shapes[1] = new Triangle("Green", 6.0,6.0,6.0);
        shapes[2] = new Rectangle("Red", 5.0, 3.0);
        shapes[3] = new Pentagon("Yellow", 4.0);

        shapes[4] = (Circle)shapes[0].clone();
        shapes[5] = (Triangle)shapes[1].clone();
        shapes[6] = (Rectangle)shapes[2].clone();
        shapes[7] = (Pentagon)shapes[3].clone();

        shapes[4].scale(2.0);
        shapes[5].setColor("Orange");
        ((Rectangle)shapes[6]).setLength(10.0);
        ((Pentagon)shapes[7]).setSide(7.0);

        System.out.println("Before Sorting: ");
        System.out.printf("%-13s%-10s%15s%24s%15s", "Shape", "Color", "Dimensions", "Area", "Perimeter");
        System.out.println();
        for (Shape shape : shapes){System.out.println(shape.toString());}
        java.util.Arrays.sort(shapes);

        System.out.println();
        System.out.println("After Sorting: ");
        System.out.printf("%-13s%-10s%15s%24s%15s", "Shape", "Color", "Dimensions", "Area", "Perimeter");
        System.out.println();
        for (Shape shape : shapes){System.out.println(shape.toString());}
        System.out.println();
        System.out.println("Average Perimeter = " + String.format("%.2f", getAveragePerimeter(shapes)));
    }
    /***
     * Method to get the average perimeter of all the shapes in the array
     * @param   list to hold all the shapes whose perimeters will contribute to the average
     * @return  a double value of the average perimeter of the shapes in the list
     */
    public static double getAveragePerimeter(Shape[] list){
        double avgPerimeter = 0.0;
        for (Shape shape : list){
            avgPerimeter += shape.getPerimeter();
        }
        avgPerimeter /= list.length;
        return avgPerimeter;
    }
}