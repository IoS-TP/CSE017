/***
 * Interface to group classes that are closable
 * CSE017
 * @author  Matthew Bergin
 * @version 0.1
 * Date created: September 10, 2022
 * Last date modified: September 10, 2022
 */
public interface Closable{
    /***
     * Abstract method to return whether or not an object is closeable
     * @param no parameters
     * @return a boolean value, true if the object is closeable, false if not
     */
    boolean isCloseable();
}