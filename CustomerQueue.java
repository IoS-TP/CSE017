/***
 * Class to model the instance CustomerQueue
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: October 13, 2022
 * Last Date Modified: October 14, 2022
 */
import java.util.LinkedList;
import java.util.Queue;
public class CustomerQueue {
    //Data Member
    private Queue<Customer> customers;
    /***
     * Default constructor
     * No parameters
     * Initializes customers to a new LinkedList
     */
    public CustomerQueue(){
        customers = new LinkedList<>();
    }
    /***
     * Method to remove and return the next customer from the queue
     * @param   no parameters
     * @return  the next customer from the queue
     */
    public Customer getNextCustomer(){
        return customers.poll();
    }
    /***
     * Method to increment the waitingTime for all of the customers still in the queue
     * @param   no parameters
     * no return value
     */
    public void updateWaitingTime(){
        for (Customer customer : customers){
            customer.incrementWaitingTime();
        }
    }
    /***
     * Method to add a new customer to the queue
     * @param   c for the new customer to be added to the queue
     * no return value
     */
    public void addCustomer(Customer c){
        customers.offer(c);
    }
    /***
     * Method to return whether or not the CustomerQueue is empty
     * @param   no parameters
     * @return  a boolean value, true if the CustomerQueue is empty, false if not
     */
    public boolean isEmpty(){
        return customers.isEmpty();
    }
    /***
     * Method to get the amount of customers in the CustomerQueue
     * @param   no parameters
     * @return  the amount of customers in the CustomerQueue
     */
    public int size(){
        return customers.size();
    }
    /***
     * Method to return a formatted String containing the values of the customers held in the queue
     * @param   no parameters
     * @return  a formatted String containing the values of the customer held in the queue
     */
    public String toString(){
        String ans ="";
        for (Customer customer : customers){
            ans+= customer.toString() + "\n";
        }
        return ans;
    }
}