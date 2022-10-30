/**
 * Class to create an exception for invalid account numbers inputted in the Test class
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 03, 2022
 * Last Date Modified: September 03, 2022
 */
 import java.util.InputMismatchException;
public class InvalidAccountNumberException extends InputMismatchException{
    /***
     * Default Constructor 
     * No parameters
     * Calls the super method with the String "Invalid bank account number (must be 10 digits)."
     */
    public InvalidAccountNumberException(){
        super("Invalid bank account number (must be 10 digits).");
    }
    /***
     * Constructor with one parameter
     * @param   message for the message to be passed when this exception is thrown
     */
    public InvalidAccountNumberException(String message){
        super(message);
    }
}