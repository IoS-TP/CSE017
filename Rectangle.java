/***
 * Class to model the entity Rectangle 
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 07, 2022
 * Last Date Modified: September 10, 2022
 */
public class Rectangle extends Shape{
    // Data members
    private double length, width;
    /***
     * Default Constructor
     * No parameters
     * Initializes color to the String "Black" and length and width to 1.0
     */
    public Rectangle(){super(); length=width= 1.0;}
    /***
     * Constructor with three parameters
     * @param   c for the color of the Rectangle
     * @param   l for the length of the Rectangle
     * @param   w for the width of the Rectangle
     */
    public Rectangle(String c, double l, double w){super(c); length = l; width = w;}
    /***
     * Getter for the length of the Rectangle
     * @param   no parameters 
     * @return  the value of the data member length
     */
    public double getLength(){return length;}
    /***
     * Getter for the width of the Rectangle
     * @param   no parameters 
     * @return  the value of the data member width
     */
    public double getWidth(){return width;}
    /***
     * Setter for the length of the Rectangle
     * @param   l to set the data member length
     * No return value
     */
    public void setLength(double l){length = l;}
    /***
     * Setter for the width of the Rectangle
     * @param   w to set the data member width
     * No return value
     */
    public void setWidth(double w){width = w;}
    /***
     * Method to get the Rectangle's information
     * no parameters
	 * @return formatted string containing the value of the data members
     */
    public String toString(){
        String shapeString = super.toString();
        return String.format("%-13s%-15s%-10.2f%-20.2f%-10.2f%-10.2f", "Rectangle", shapeString, length, width, getArea(), getPerimeter());
        }
    /***
     * Method to return the area of the Rectangle
     * @param   no parameters
     * @return  the double value containing the area of the Rectangle
     */
    public double getArea(){
        return length * width;
    }
    /***
     * Method to return the perimeter of the Rectangle
     * @param   no parameters
     * @return  the double value containing the perimeter of the Rectangle
     */
    public double getPerimeter(){
        return 2 * (length + width);
    }
    /***
     * Method to return a clone of the Rectangle
     * @param   no parameters
     * @return  a deep copy of the Rectangle object with the same values as the original
     */
    public Object clone(){
        return new Rectangle(getColor(), length, width);
    }
    /***
     * Method to scale the size of a Rectangle
     * @param   factor for the factor that each data member should be multiplied by
     * no return value
     */
    public void scale(double factor){
        length *= factor;
        width *= factor;
    }
}