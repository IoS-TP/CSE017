/***
 * Interface to group scalable objects
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 07, 2022
 * Last Date Modified: September 07, 2022
 */
public interface Scalable{
    /***
     * Abstract method to scale the size an object
     * @param   factor for the factor that each data member should be multiplied by
     * no return value
     */
    public void scale(double factor);
}