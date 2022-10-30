/***
 * Class to simulate the arrival of serving of customers and test the classes
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: October 13, 2022
 * Last Date Modified: October 14, 2022
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class Simulation {
    /***
     * Method to actually run the simulation and test the classes
     * @param   args for the command line arguments
     * no return value
     */
    public static void main(String[] args){
        int simulationTime = 0;
        int serverAmt = 0;
        int arrivalRate= 0;
        int serviceTime=0;
        boolean rightInput=false;
        Scanner keyboard = new Scanner(System.in);
        while(!rightInput){
            try{
                System.out.println("Enter the simulation parameters");
                System.out.print("Simulation time in minutes: ");
                simulationTime = keyboard.nextInt();
                System.out.print("Number of servers: ");
                serverAmt = keyboard.nextInt();
                System.out.print("Customer arrivalrate (customers/hour): ");
                arrivalRate = keyboard.nextInt();
                System.out.print("Service time in minutes: ");
                serviceTime = keyboard.nextInt();
                rightInput=true;
            }
            catch(InputMismatchException e){
                System.out.println("Please only enter integer values");
                keyboard.next();
            }
        }
        

        int totalWaitingTime=0;
        int customerAmt=0;
        CustomerQueue customers = new CustomerQueue();
        ServerList servers = new ServerList(serverAmt);
        //System.out.println(servers);

        for (int clock =0; clock < simulationTime; clock++){
            servers.updateServiceTime();
            customers.updateWaitingTime();
            double p = Math.random();
            if (p < arrivalRate/60.0){
                customerAmt++;
                Customer upNext = new Customer(customerAmt, clock, 0);
                customers.addCustomer(upNext);
                System.out.println(upNext);
            }
            if(!customers.isEmpty() && servers.getFreeServer() != -1){
                Customer next = customers.getNextCustomer();
                totalWaitingTime += next.getWaitingTime();
                System.out.println("Customer  "+ next.getCustomerNo() + " assinged to server "+ servers.getFreeServer() + " at time "+ clock);
                servers.setServerBusy(servers.getFreeServer(), next, serviceTime);
            }
        }
        int inQueue = customers.size();
        int beingServed = servers.getBusyServers();
        int served = customerAmt-inQueue-beingServed;
        System.out.println("\nThe simulation ran for " + simulationTime + " minutes");
        System.out.println("Number of servers: " + serverAmt);
        System.out.println("Average service time: " + serviceTime);
        System.out.println("Average number of customers (customers/hour): " + arrivalRate);
        System.out.println("\n\nTotal amount of customers: " + customerAmt);
        System.out.println("Number of customers served: "+ served);
        System.out.println("Number of customers left in queue: " + inQueue);
        System.out.println("Number of Customers being served: " + beingServed);
        System.out.println("\nTotal waiting time: "+totalWaitingTime + " minutes");
        System.out.printf("Average waiting time: %.2f minutes\n", (totalWaitingTime/(customerAmt*1.0)));
    }
}