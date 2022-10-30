/***
 * Class to model the entity Savings
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.2
 * Date of Creation: August 27, 2022
 * Last Date Modified: September 04, 2022
 */
public class Savings extends BankAccount{
    // Data member
    private double YearlyInterestRate;
    /***
     * Constructor with three parameters
     * @param   owner for the owner of a Savings account
     * @param   balance for the balance of a Savings account
     * @param   yInterestRate for the yearly interest rate of a Savings account
     */
    public Savings(String owner, double balance, double yInterestRate){
        super(owner, balance);
        YearlyInterestRate = yInterestRate;
    }
    /***
     * Constructor with four parameters
     * @param   owner for the owner of a Savings account
     * @param   balance for the balance of a Savings account
     * @param   yInterestRate for the yearly interest rate of a Savings account
     * @param   number for the number of a Savings account
     */
    public Savings(long number, String owner, double balance, double yInterestRate){
        super(number, owner, balance);
        YearlyInterestRate = yInterestRate;
    }
    /***
     * Getter for the yearly interest rate of a Savings Account
     * @param   no parameters
     * @return the value of the data member YearlyInterestRate
     */
    public double getYearlyInterest(){
        return YearlyInterestRate;
    }
    /***
     * Getter for the monthly interest rate of a Savings account
     * @param   no parameters
     * @return the value of the monthly interest rate of a Savings account
     */
    public double getMonthlyInterest(){
        return (YearlyInterestRate/12);
    }
    /***
     * Setter for the yearly interst rate of a Savings account
     * @param   y to set the data member YearlyInterestRate
     * no return value
     */
    public void setYearlyInterest(double y){
        YearlyInterestRate = y;
    }
    /***
     * Method to add monthly interest to a Savings account
     * @param   no parameters
     * @return  the amount added in interest to a Savings account
     */
    public double applyInterest(){
        double amount = ((YearlyInterestRate / 12) / 100) * balance;
        balance += amount;
        return amount;
    }
    /***
     * method to get the Savings information
     * @param   no parameters
     * @return  formatted string containing the values of the data members and the type of account
     */
    public String toString(){
        return String.format("%-15s", "Savings")+super.toString() + String.format("\t%-10.2f", YearlyInterestRate);
    }
    /***
     * Method to return a formatted string with the attributes to be used to write to a file
     * @param   no parameters
     * @return formatted string containing the value of the data members
     */
     public String simpleString(){
        return String.format("%s|", "Savings")+super.simpleString() + "|" + YearlyInterestRate;
     }
}
