/***
 * Class to model the instance Customer
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: October 13, 2022
 * Last Date Modified: October 14, 2022
 */
public class Customer {
    //Data Members
    private int customerNo;
    private int arrivalTime;
    private int waitingTime;
    /***
     * Constructor with three parameters
     * @param   cn to initialize the data member customerNo
     * @param   at to initialize the data member arrivalTime
     * @param   wt to initialize the data member waitingTime
     */
    public Customer(int cn, int at, int wt) {
        customerNo=cn;
        arrivalTime=at;
        waitingTime=wt;
    }
    /***
     * Getter for the value of the data member customerNo
     * @param   no parameters
     * @return the value of the data member customerNo
     */
    public int getCustomerNo(){
        return customerNo;
    }
    /***
     * Getter for the value of the data member arrivalTime
     * @param   no parameters
     * @return the value of the data member arrivalTime
     */
    public int getArrivalTIme(){
        return arrivalTime;
    }
    /***
     * Getter for the value of the data member waitingTime
     * @param   no parameters
     * @return the value of the data member waitingTime
     */
    public int getWaitingTime(){
        return waitingTime;
    }
    /***
     * Setter for the data member customerNo
     * @param   cn for the new value of the customerNo
     * no return value
     */
    public void setCustomerNo(int cn){
        customerNo=cn;
    }
    /***
     * Setter for the data member arrivalTime
     * @param   cn for the new value of the arrivalTime
     * no return value
     */
    public void setArrivalTime(int at){
        arrivalTime=at;
    }
    /***
     * Setter for the data member waitingTime
     * @param   cn for the new value of the waitingTIme
     * no return value
     */
    public void setWaitingTime(int wt){
        waitingTime=wt;
    }
    /***
     * Method to increment the data member waitingTime
     * @param   no parameters
     * no return value
     */
    public void incrementWaitingTime(){
        waitingTime++;
    }
    /***
     * Method to return a formatted String containing the values of the data members customerNo and arrivalTime
     * @param   no parameters
     * @return  a formatted String containing the values of the data members customerNo and arrivalTime
     */
    public String toString(){
        return String.format("Customer number %d arrived at time %-7d", customerNo, arrivalTime);
    }
}