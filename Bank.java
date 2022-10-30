/***
 * Class to model a Bank object and use the BankAccount class and its related classes/interfaces
 * CSE017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 11, 2022
 * Last Date Modified: September 17, 2022
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Bank{
    //Data members
    private BankAccount[] accounts = new BankAccount[100];
    private int count = 0;
    /***
     * Constructor with one parameter
     * @param   filename for the location of the file holding the BankAccounts' information
     */
    public Bank(String filename){
        readAccounts(filename);
    }
    /***
     * Method to read the information from the file and put the BankAccount objects in the Bank list
     * @param   filename for the location of the file holding the BankAccounts' information
     * no return value
     */
    private void readAccounts(String filename){
        try{
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()){
                String accountProperties[] = fileReader.nextLine().split("\\|");
                if(accountProperties[0].equals("Checking")){
                    accounts[count] = new Checking(Long.parseLong(accountProperties[1]), accountProperties[2], 
                                                        Double.parseDouble(accountProperties[3]));
                }
                else if (accountProperties[0].equals("Investment")){
                    accounts[count] = new Investment(Long.parseLong(accountProperties[1]), accountProperties[2],
                                                         Double.parseDouble(accountProperties[3]), accountProperties[4]);
                }
                else{
                    accounts[count] = new Savings(Long.parseLong(accountProperties[1]), accountProperties[2], 
                                                        Double.parseDouble(accountProperties[3]), Double.parseDouble(accountProperties[4]));
                }
                count++;
            }
            fileReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Could not open " + filename);
        }
    }
    /***
     * Method to find a BankAccount object in the Bank list based on the account number
     * @param   number for the account number of the desired BankAccount
     * @return  the BankAccount object with the matching account number or null if it is not found
     */
    public BankAccount find(long number){
        for (int i = 0; i < count; i++){
            if (accounts[i].getNumber() == number)
            {
                return accounts[i];
            }
        }
        return null;
    }
    /***
     * Method to add a new BankAccount object to the Bank list of BankAccounts
     * @param   ba for the BankAccount that is to be added to the list
     * @return  a boolean value, true if the account is successfully added, false if the Bank list was already full
     */
    public boolean add(BankAccount ba){
        if(count < 100){
            accounts[count] = ba;
            count++;
            return true;
        }
        else {return false;}
        
    }
    /***
     * Method to remove a BankAccount object from the Bank list
     * @param   number for the number of the BankAccount that the method attempts to remove
     * @return  a boolean value, true if the account was removed, false if it is not in the list and thus was not removed
     */
    public boolean remove(long number){
        int loc = -1;
        for(int i = 0; i < count; i++){
            if (accounts[i].getNumber() == number){
                loc = i;
            }
        }
        if (loc != -1){
            try{
                for (int i = loc; i < count; i++){
                    accounts[i] = accounts[i+1];
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                accounts[99] = null;
            }
            count--;
            return true; 
        }
        else{
            System.out.println("Account number not found.");
            return false;
        }
    }
    /***
     * Method to view all of the BankAccounts in the Bank list in a neat, tabular way
     * @param no parameters
     * no return value
     */
    public void viewAll(){
        String header = String.format("%-15s%-10s\t%-30s\t%-10s\t%10s","Type", "Number", "Owner", "Balance", "Interest/Investment type");
        System.out.println(header);
        for (int i = 0; i < count; i++){
            System.out.println(accounts[i].toString());
        }
    }
    /***
     * Method to view all of the closable BankAccounts in the Bank list in a neat, tabular way
     * @param no parameters
     * no return value
     */
    public void viewClosable(){
        String header = String.format("%-15s%-10s\t%-30s\t%-10s\t%10s","Type", "Number", "Owner", "Balance", "Interest/Investment type");
        int amt = 0;
        System.out.println(header);
        for (int i = 0; i < count; i++){
            if(accounts[i].isCloseable()){
                System.out.println(accounts[i].toString());
                amt++;
            }
        }

        System.out.println();
        System.out.println(amt + " closeable accounts found.");
    }
    /***
     * Method to sort the BankAccounts in the Bank list
     * @param   no parameters
     * no return value
     */
    public void sort(){
        java.util.Arrays.sort(accounts, 0, count);
    }
    /***
     * Method to save the information of the BankAccounts in the Bank list back to the file
     * @param   filename for the location of the file the information will be saved to
     * no return value
     */
    public void saveAccounts(String filename){
        try{
            File file = new File("accounts.txt");
            PrintWriter saver = new PrintWriter(file);
            for (int i = 0; i < count; i++){
                saver.println(accounts[i].simpleString());
            }
            saver.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Could not write to this file");
        }
        
    }
}