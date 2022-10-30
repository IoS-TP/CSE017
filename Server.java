/***
 * Class to model the instance Server
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: October 13, 2022
 * Last Date Modified: October 14, 2022
 */
public class Server {
    //Data Members
    private Customer currentCustomer;
    private boolean status;
    private int serviceTime;
    /*** 
     * Default constructor
     * No parameters
     * Initializes status to true and serviceTime to 0
     */
    public Server(){
        currentCustomer = null;
        status=true;
        serviceTime=0;
    }
    /***
     * Method to check if a server is free
     * @param   no parameters
     * @return a boolean value, true if the server is free, false if the server is busy
     */
    public boolean isFree(){
        return status;
    }
    /***
     * Method to set the status of the server to be busy(false)
     * @param   no parameters
     * no return value
     */
    public void setBusy(){
        status=false;
    }
    /***
     * Method to set the status of the server to be free(true)
     * @param   no parameters
     * no return value
     */
    public void setFree(){
        status=true;
    }
    /***
     * Getter for the data member serviceTime
     * @param   no parameters
     * @return the value of the data member serviceTime
     */
    public int getServiceTime(){
        return serviceTime;
    }
    /***
     * Setter for the data member serviceTime
     * @param   sTime for the new value of the serviceTime
     * no return value
     */
    public void setServiceTime(int sTime){
        serviceTime=sTime;
    }
    /***
     * Method to decrement the value of the data member ServiceTime
     * @param   no parameters
     * no return value
     */
    public void decrementServiceTime(){
        serviceTime--;
    }
    /***
     * Setter for the data member currentCustomer
     * @param   c for the new value of the data member currentCustomer
     * no return value
     */
    public void setCurrentCustomer(Customer c){
        currentCustomer = c;
    }
    /***
     * Getter for the data member currentCustomer
     * @param   no parameters
     * @return the value of the data member currentCustomer
     */
    public Customer getCurrentCustomer(){
        return currentCustomer;
    }
    /***
     * Method to return a formatted String containing the values of the data members serviceTime and status
     * @param   no parameters
     * @return  a formatted String containing the values of the data members serviceTime and status
     */
    public String toString(){
        return String.format("%-7d%-7s", serviceTime, status);
    }
}