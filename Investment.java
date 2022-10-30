/***
 * Class to model the entity BankAccount
 * CSE 017
 * @author Matthew Bergin
 * @version 0.2
 * Date of creation: August 27, 2022
 * Last Date Modified: September 04, 2022
 */
import java.lang.Math;
public class Investment extends BankAccount{
    // Data member
    private String type;
    /***
     * Constructor with three parameters
     * @param   owner for the owner of an Investment
     * @param   balance for the balance of an Investment
     * @param   type for the type of an Investment
     */
    public Investment(String owner, double balance, String type){
        super(owner, balance);
        this.type = type;
    }
    /***
     * Constructor with four parameters
     * @param   owner for the owner of an Investment
     * @param   balance for the balance of an Investment
     * @param   type for the type of an Investment
     * @param   number for the number of an Investment account
     */
    public Investment(long number, String owner, double balance, String type){
        super(number, owner, balance);
        this.type = type;
    }
    /***
     * Getter for the type of Investment
     * @param   no parameters
     * @return  the value of the data member type
     */
    public String getType(){
        return type;
    }
    /***
     * Setter for the type of Investment
     * @param   type to set the data member type
     * no return value
     */
    public void setType(String type){
        this.type = type;
    }
    /***
     * Method to apply the risk of an Investment, either adding or subtracting from the balance at random
     * @param   no parameters
     * @return the amount added or removed from the data member balance
     */
    public double applyRisk(){
        double risk = Math.random();
        if (risk < 0.5){
            balance -= balance * (risk/10);
            return balance * (risk/-10);
        }
        else{
            balance += balance * ((1-risk)/10);
            return balance * ((1-risk)/10);
        }
    }
    /***
     * Method to get the Investment information
     * @param   no parameters
     * @return formatted string containing the values of the data members and the type of account
     */
    public String toString(){
        return String.format("%-15s", "Investment")+super.toString() + String.format("\t%-10s", type);
    }
    /***
     * Method to return a formatted string with the attributes to be used to write to a file
     * @param   no parameters
     * @return formatted string containing the value of the data members
     */
     public String simpleString(){
        return String.format("%s|", "Investment")+super.simpleString() + "|" + type;
     }
}
