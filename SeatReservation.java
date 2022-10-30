/***
 * Class to allow the user to reserve or free seats of the Airplane
 * CSE 017
 * @author Matthew Bergin
 * @version 0.1
 * Date of creation: August 31, 2022
 * Last Date Modified: September 01, 2022
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class SeatReservation{
    /***
    * Method to allow the user to reserve and free seats in the calss Airplane
    * @param    args to hold command line arguments
    * no return value
     */
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Airplane myAirplane = new Airplane("seatsmap.txt");
        int operation = 0;
        do{
            System.out.println(myAirplane);
            System.out.println("Select an operation: ");
            System.out.println("1: reserve a seat");
            System.out.println("2: free a seat");
            System.out.println("3: quit");
            try{
                operation = keyboard.nextInt();
                String seatNumber;
                switch(operation){
                    case 1: //reserve
                        System.out.println("Enter a seat number: ");
                        seatNumber = keyboard.next();
                        if(myAirplane.reserveSeat(seatNumber)){
                            System.out.println(seatNumber + " successfully reserved");
                        }
                        else{//already reserved
                            System.out.println(seatNumber + " already reserved");
                        }
                        break;
                    case 2: //free
                        System.out.println("Enter a seat number: ");
                        seatNumber = keyboard.next();
                        if(myAirplane.freeSeat(seatNumber)){
                            System.out.println(seatNumber + " successfully freed");
                        }
                        else{//already freed
                            System.out.println(seatNumber + " already freed");
                        }
                        break;
                    case 3: //quit
                        myAirplane.saveMap("seatsmap.txt");
                        break;
                    default:
                        System.out.println("Invalid operation(1 to 3)");
                }
            }
            catch(InvalidSeatException e){
                System.out.println(e.getMessage());
            }
            catch(InputMismatchException e){
                System.out.println("Invalid inpput operation");
                keyboard.next();
            }
        } while(operation != 3);
        System.out.println("Thank you for using my airplane seat reservation program");
    }
}