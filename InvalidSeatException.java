/***
 * Class to create an exception for invalid seats in the Airplane and SeatReservation classes
 * CSE 017
 * @author Matthew Bergin
 * @version 0.1
 * Date of creation: August 31, 2022
 * Last Date Modified: August 31, 2022
 */
public class InvalidSeatException extends Exception{
    /***
     * Default Constructor
     * No Parameters
     * Calls the super method with the String "Invalid Seat Number"
     */
    public InvalidSeatException(){
        super("Invalid Seat Number");
    }
    /***
     * Constructor with one parameter
     * @param   message for the message to be passed when this exception is thrown
     */
    public InvalidSeatException(String message){
        super(message);
    }
}