/***
 * Class to model the entity Checking
 * CSE 017
 * @author Matthew Bergin
 * @version 0.2
 * Date of creation: August 27, 2022
 * Last Date Modified: September 04, 2022
 */
public class Checking extends BankAccount{
    /***
     * Constructor with two parameters
     * @param	owner for the owner of a Checking account
	 * @param	balance for the balance of a Checking account
     */
    public Checking(String owner, double balance){
        super(owner, balance);
    }
    /***
     * Constructor with three parameters
     * @param	owner for the owner of a Checking account
	 * @param	balance for the balance of a Checking account
     * @param   number for the number of a Checking account
     */
    public Checking(long number, String owner, double balance){
        super(number, owner, balance);
    }
    /***
     * Method to get the Checking information
     * @param   no parameters
     * @return  formatted string containing the values of the data members of the superclass and the type of account
     */
    public String toString(){
        return String.format("%-15s", "Checking")+super.toString();
    }
    /***
     * Method to return a formatted string with the attributes to be used to write to a file
     * @param   no parameters
     * @return formatted string containing the value of the data members
     */
     public String simpleString(){
        return String.format("%s|", "Checking")+super.simpleString();
     }
}
