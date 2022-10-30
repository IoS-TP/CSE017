/***
 * Class to model the entity Triangle
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 07, 2022
 * Last Date Modified: September 10, 2022
 */
public class Triangle extends Shape{
    // Data members
    private double side1, side2, side3;
    /***
     * Default Constructor
     * No parameters
     * Initializes color to the String "Black" and side1, side2, and side3 to 1.0
     */
    public Triangle(){super(); side1=side2=side3=1.0;}
    /***
     * Constructor with three parameters
     * @param   side1 for the first side of the Triangle
     * @param   side2 for the second side of the Triangle
     * @param   side3 for the third side of the Triangle
     */
    public Triangle(String c, double s1, double s2, double s3){super(c); side1 = s1; side2=s2; side3 = s3;}
    /***
     * Getter for the first side length of the Triangle
     * @param   no parameters 
     * @return  the value of the data member side1
     */
    public double getSide1(){return side1;}
    /***
     * Getter for the second side length of the Triangle
     * @param   no parameters 
     * @return  the value of the data member side2
     */
    public double getSide2(){return side2;}
    /***
     * Getter for the third side length of the Triangle
     * @param   no parameters 
     * @return  the value of the data member side3
     */
    public double getSide3(){return side3;}
    /***
     * Setter for the first side length of the Triangle
     * @param   s1 to set the data member side1
     * No return value
     */
    public void setSide1(double s1){side1=s1;}
    /***
     * Setter for the second side length of the Triangle
     * @param   s2 to set the data member side2
     * No return value
     */
    public void setSide2(double s2){side2=s2;}
    /***
     * Setter for the third side length of the Triangle
     * @param   s2 to set the data member side2
     * No return value
     */
    public void setSide3(double s3){side3=s3;}
    /***
     * Method to get the Triangle's information
     * no parameters
	 * @return formatted string containing the value of the data members
     */
    public String toString(){
        String shapeString = super.toString();
        return String.format("%-13s%-15s%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f", "Triangle", shapeString, side1, side2, side3, getArea(), getPerimeter());
        }
    /***
     * Method to return the area of the Triangle
     * @param   no parameters
     * @return  the double value containing the area of the Triangle
     */
    public double getArea(){
        double p = getPerimeter() /2;
        double a = Math.sqrt(p*(p-side1) * (p-side2)* (p-side3));
        return a;
    }
    /***
     * Method to return the perimeter of the Triangle
     * @param   no parameters
     * @return  the double value containing the perimeter of the Triangle
     */
    public double getPerimeter(){
        return side1 + side2+ side3;
    }
    /***
     * Method to return a clone of the Triangle
     * @param   no parameters
     * @return  a deep copy of the Triangle object with the same values as the original
     */
    public Object clone(){
        return new Triangle(getColor(), side1, side2, side3);
    }
    /***
     * Method to scale the size of a Triangle
     * @param   factor for the factor that each data member should be multiplied by
     * no return value
     */
    public void scale(double factor){
        side1 *= factor;
        side2 *= factor;
        side3 *= factor;
    }
}