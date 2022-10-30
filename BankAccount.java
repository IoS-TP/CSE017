/***
 * Class to model the entity BankAccount
 * CSE 017
 * @author Matthew Bergin
 * @version 0.3
 * Date of creation: August 27, 2022
 * Last Date Modified: September 10, 2022
 */
import java.lang.Math;
public abstract class BankAccount implements Comparable<BankAccount>, Closable{
    // Data members
    private long number;
    private String owner;
    protected double balance;
    /***
	 * Constructor with two parameters
	 * @param	owner for the owner of a BankAccount
	 * @param	balance for the balance of a BankAccount
	 */
    protected BankAccount(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
        number = (long)(Math.random()*10000000000.0);
        if(number < (long)1000000000){
                number += 1000000000;
            }
        }
    /***
	 * Constructor with three parameters
	 * @param	owner for the owner of a BankAccount
	 * @param	balance for the balance of a BankAccount
     * @param   number for the number of a BankAccount
	 */
    protected BankAccount(long number, String owner, double balance){
        this.owner = owner;
        this.balance = balance;
        this.number = number;
    }
    /***
     * Getter for the account number of a BankAccount
     * @param   no parameters 
     * @return  the value of the data member number
     */
    public long getNumber(){
        return number;
    }
    /***
     * Getter for the name of the owner of a BankAccount
     * @param   no parameters
     * @return  the value of the data member owner
     */
    public String getOwner(){
        return owner;
    }
    /***
     * Getter for the balance of a BankAccount
     * @param   no parameters
     * @return  the value of the datamember balance
     */
    public double getBalance(){
        return balance;
    }
    /***
     * Adds to the balance of a BankAccount
     * @param   amount to define the amount to add to a BankAccount
     * no return value
     */
    public void deposit(double amount){
        balance += amount;
    }
    /***
     * Removes money from the balance of a BankAccount if it is possible
     * @param   amount to define the amount to remove from a BankAccount
     * @return  a boolean value for whether it is possible to withdraw amount
     */
    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
    /***
     * Method to get the BankAccount information
     * @param   no parameters
     * @return  formatted string containing the value of the data members
     */
    public String toString(){
        return String.format("%-10d\t%-30s\t%-10.2f", number, owner, balance);

    }
    /***
     * Method to return a formatted string with the attributes to be used to write to a file
     * @param   no parameters
     * @return formatted string containing the value of the data members
     */
     public String simpleString(){
        return String.format("%d|%s|%.2f", number, owner, balance);
     }
    /***
     * Method to compare two BankAccount objects based on balance
     * @param   ba for the BankAccount to compare with
     * @return  an integer value, 1 if the original balance is bigger, 0 if they are the same, and -1 otherwise 
     */
     public int compareTo(BankAccount ba){
        if (balance > ba.getBalance()){return 1;}
        else if (balance == ba.getBalance()){return 0;}
        else{return -1;}
     }
     /***
      * Method to tell if a BankAccount can be closed(if its balance is below 200)
      * @param  no parameters
      * @return a boolean value, true if the BankAccount can be closed, false if not
      */
    public boolean isCloseable(){
        if (balance < 200) {return true;}
        else{return false;}
    }
}