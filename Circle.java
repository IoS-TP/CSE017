/***
 * Class to model the entity Circle
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 07, 2022
 * Last Date Modified: September 10, 2022
 */
public class Circle extends Shape{
    // Data member
    private double radius;
    /***
     * Default Constructor
     * No parameters
     * Initializes color to the String "Black" and radius to 1.0
     */
    public Circle(){super(); radius = 1.0;}
    /***
     * Constructor with two parameters
     * @param   c for the color of the Circle
     * @param   r for the radius of the Circle
     */
    public Circle(String c, double r){super(c); radius = r;}
    /***
     * Getter for the radius of the Circle
     * @param   no parameters 
     * @return  the value of the data member radius
     */
    public double getRadius(){return radius;}
    /***
     * Setter for the radius of the Circle
     * @param   r to set the data member radius
     * No return value
     */
    public void setRadius(double r){radius = r;}
    /***
     * Method to get the Circle's information
     * no parameters
	 * @return formatted string containing the value of the data members
     */
    public String toString(){
        String shapeString = super.toString();
        return String.format("%-13s%-15s%-30.2f%-10.2f%-10.2f", "Circle", shapeString, radius, getArea(), getPerimeter());
    }
    /***
     * Method to return the area of the Circle
     * @param   no parameters
     * @return  the double value containing the area of the Circle
     */
    public double getArea(){
        return Math.PI * radius * radius;
    }
    /***
     * Method to return the perimeter of the Circle
     * @param   no parameters
     * @return  the double value containing the perimeter of the Circle
     */
    public double getPerimeter(){
        return Math.PI * 2 * radius;
    }
    /***
     * Method to return a clone of the Circle
     * @param   no parameters
     * @return  a deep copy of the Circle object with the same values as the original
     */
    public Object clone(){
        return new Circle(getColor(), radius);
    }
    /***
     * Method to scale the size of a Circle
     * @param   factor for the factor that each data member should be multiplied by
     * no return value
     */
    public void scale(double factor){
        radius *= factor;
    }
}