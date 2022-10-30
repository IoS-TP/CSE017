/***
 * Abstract class to model the entity Shape 
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 07, 2022
 * Last Date Modified: September 10, 2022
 */
public abstract class Shape implements Comparable<Shape>, 
                                    Cloneable,
                                    Scalable{
    // Data member
    private String color;
    /***
     * Default Constructor
     * No parameters
     * Initializes color to the String "Black"
     */
    protected Shape(){color = "Black";}
    /***
     * Constructor with one parameter
     * @param   color for the color of the Shape
     */
    protected Shape(String c){color = c;}
    /***
     * Setter for the color of the Shape
     * @param   c to set the data member color
     * No return value
     */
    public void setColor(String c){color = c;}
    /***
     * Getter for the color of the Shape
     * @param   no parameters 
     * @return  the value of the data member color
     */
    public String getColor(){return color;}
    /***
     * Method to get the Shape information
     * no parameters
	 * @return formatted string containing the value of the data member
     */
    public String toString(){return String.format("%.15s", color);}
    /***
     * Abstract method to return the area of the Shape
     * @param   no parameters
     * @return  the double value containing the area of the shape
     */
    public abstract double getArea();
    /***
     * Abstract method to return the perimeter of the Shape
     * @param   no parameters
     * @return  the double value containing the perimeter of the Shape
     */
    public abstract double getPerimeter();
    /***
     * Method to compare different objects of type Shape
     * @param   s to hold the Shape that is being compared to
     * @return  a value 0, if they are equal, 1 if the area of the first shape is larger, and -1 if the area of the second shape is larger
     */
    public int compareTo(Shape s){
        if (this.getArea() == s.getArea()){
            return 0;
        }
        else if (this.getArea() > s.getArea()){
            return 1;
        }
        else {
            return -1;
        }
    }
    /***
     * Abstract method to return a clone of the Shape
     * @param   no parameters
     * @return  a new Shape object with the same values as the original
     */
    public abstract Object clone();
    /***
     * Abstract method to scale the size of a shape
     * @param   factor for the factor that each data member should be multiplied by
     * no return value
     */
    public abstract void scale(double factor);
    
}