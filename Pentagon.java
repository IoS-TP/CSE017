/***
 * Class to model the entity Pentagon
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 07, 2022
 * Last Date Modified: September 10, 2022
 */
public class Pentagon extends Shape{
    // Data members
    private double side;
    /***
     * Default Constructor
     * No parameters
     * Initializes color to the String "Black" and side to 1.0
     */
    public Pentagon(){super(); side = 1.0;}
    /***
     * Constructor with two parameters
     * @param   c for the color of the Pentagon
     * @param   s for the side of the Pentagon
     */
    public Pentagon(String c, double s){super(c); side = s;}
    /***
     * Getter for the side length of the Pentagon
     * @param   no parameters 
     * @return  the value of the data member side
     */
    public double getSide(){return side;}
    /***
     * Setter for the side length of the Pentagon
     * @param   s to set the data member side
     * No return value
     */
    public void setSide(double s){side = s;}
    /***
     * Method to get the Pentagon's information
     * no parameters
	 * @return formatted string containing the value of the data members
     */
    public String toString(){
        String shapeString = super.toString();
        return String.format("%-13s%-15s%-30.2f%-10.2f%-10.2f", "Pentagon", shapeString, side, getArea(), getPerimeter());
        }
    /***
     * Method to return the area of the Pentagon
     * @param   no parameters
     * @return  the double value containing the area of the Pentagon
     */
    public double getArea(){
        double a = Math.sqrt(5* (5 + 2*Math.sqrt(5)));
        a *= (side * side);
        a /= 4;
        return a;
    }
    /***
     * Method to return the perimeter of the Pentagon
     * @param   no parameters
     * @return  the double value containing the perimeter of the Pentagon
     */
    public double getPerimeter(){
        return 5 * side;
    }
    /***
     * Method to return a clone of the Pentagon
     * @param   no parameters
     * @return  a deep copy of the Pentagon object with the same values as the original
     */
    public Object clone(){
        return new Pentagon(getColor(), side);
    }
    /***
     * Method to scale the size of a Pentagon
     * @param   factor for the factor that each data member should be multiplied by
     * no return value
     */
    public void scale(double factor){
        side *= factor;
    }
}