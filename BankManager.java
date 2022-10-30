/***
 * Class to model a BankManager and test the Bank and other classes
 * CSE017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 11, 2022
 * Last Date Modified: September 11, 2022
 */
 import java.util.Scanner;
 import java.util.InputMismatchException;
public class BankManager{
    /***
     * Method to run the program and test the Bank and BankAccount classes, as well as the subclasses
     * @param   args[] to hold the command line arguments
     * no return value
     */
    public static void main(String args[]){
        Bank test = new Bank("accounts.txt");
        boolean continues = true;
        Scanner keyboard = new Scanner(System.in);
        while(continues){
            System.out.println("Select an operation: ");
            System.out.println("1: view all accounts");
            System.out.println("2: manage account");
            System.out.println("3: add new account");
            System.out.println("4: remove account");
            System.out.println("5: sort accounts by balance");
            System.out.println("6: view closable accounts");
            System.out.println("7: exit");

            try{
                int input = keyboard.nextInt();
                switch (input){
                    case 1:
                        test.viewAll();
                        break;
                    case 2:
                        System.out.println("Please input account number:");
                        try{
                            long accountNum = keyboard.nextLong();
                            checkAccountNumber(accountNum);
                            BankAccount manage = test.find(accountNum);
                            if (manage == null){
                                System.out.println("Account number not found.");
                                System.out.println();
                            }
                            else{
                                boolean loops = true;
                                while(loops){
                                    System.out.println();
                                    System.out.println("Select an operation");
                                    System.out.println("1: view balance");
                                    System.out.println("2: withdraw");
                                    System.out.println("3: deposit");
                                    System.out.println("4: apply monthly interest");
                                    System.out.println("5: apply investment risk");
                                    System.out.println("6: return to main menu");
                                    int choice = keyboard.nextInt();
                                    switch (choice){
                                        case 1:
                                            System.out.printf("Balance = %.2f",manage.getBalance());
                                            System.out.println();
                                            break;
                                        case 2:
                                            System.out.println("Enter the amount: ");
                                            double withdrawal = keyboard.nextDouble();
                                            if(manage.withdraw(withdrawal)){
                                                System.out.println("Successful withdrawal. New Balance = "+ manage.getBalance());
                                            }
                                            else{
                                                System.out.println("Withdrawal failed. You do not have a high enough balance.");
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter the amount: ");
                                            double depositAmt = keyboard.nextDouble();
                                            manage.deposit(depositAmt);
                                            System.out.println("New Balance = "+ manage.getBalance());
                                            break;
                                        case 4:
                                            if (manage instanceof Savings){
                                                double amount = ((Savings)manage).applyInterest();
                                                System.out.printf("Interest rate applied. The amount $%.2f added to your balance.", amount);
                                            }
                                            else{
                                                System.out.println("Invalid operation. Your account is not a savings account");
                                            }
                                            break;
                                        case 5:
                                            if (manage instanceof Investment){
                                                double amount = ((Investment)manage).applyRisk();
                                                System.out.println("Risk applied successfully.");
                                                if (amount < 0){
                                                    System.out.printf("The amount $%.2f was withdrawn from your account", -amount);
                                                }
                                                else{
                                                    System.out.printf("The amount $%.2f was added to your account", amount);
                                                }
                                                System.out.println();
                                            }
                                            else{
                                                System.out.println("Invalid operation. Your account is not an investment account");
                                            }
                                            break;
                                        case 6:
                                            loops = false;
                                            System.out.println();
                                            break;
                                        default:
                                            System.out.println("Please input a number 1-6");
                                            break;
                                    }
                                }
                            }

                        }
                        catch (InvalidAccountNumberException e){
                            System.out.println(e.getMessage());
                            System.out.println();
                        }
                        catch (InputMismatchException e){
                            keyboard.next();
                            System.out.println("Please input a number");
                        }
                        
                        break;
                    case 3:
                        try{
                            System.out.println("What type of account would you like to add? ");
                            String type = keyboard.next();
                            if (type.equals("Checking")){
                                System.out.println("Owner name: ");
                                keyboard.nextLine();
                                String owner = keyboard.nextLine();
                                System.out.println("Balance: ");
                                double balance = keyboard.nextDouble();
                                Checking newAccount = new Checking(owner, balance);
                                if (test.add(newAccount)){
                                    System.out.println("Account successfully added");
                                }
                                else{
                                    System.out.println("Account cannot be added, bank is full.");
                                }
                            }
                            else if (type.equals("Savings")){
                                System.out.println("Owner name: ");
                                keyboard.nextLine();
                                String owner = keyboard.nextLine();
                                System.out.println("Balance: ");
                                double balance = keyboard.nextDouble();
                                System.out.println("Yearly Interest Rate: ");
                                double rate = keyboard.nextDouble();
                                Savings newAccount = new Savings(owner, balance, rate);
                                if (test.add(newAccount)){
                                    System.out.println("Account successfully added");
                                }
                                else{
                                    System.out.println("Account cannot be added, bank is full.");
                                }
                            }
                            else if (type.equals("Investment")){
                                System.out.println("Owner name: ");
                                keyboard.nextLine();
                                String owner = keyboard.nextLine();
                                System.out.println("Balance: ");
                                double balance = keyboard.nextDouble();
                                System.out.println("Type: ");
                                String typeOfInvest = keyboard.nextLine();
                                Investment newAccount = new Investment(owner, balance, typeOfInvest);
                                if (test.add(newAccount)){
                                    System.out.println("Account successfully added");
                                }
                                else{
                                    System.out.println("Account cannot be added, bank is full.");
                                }
                            }
                            else{
                                System.out.println("Invalid account type");
                            }
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invalid input");
                            keyboard.next();
                        }
                        break;
                    case 4:
                        try{
                            System.out.println("Enter account number.");
                            long toBeDeleted = keyboard.nextLong();
                            checkAccountNumber(toBeDeleted);
                            if(test.remove(toBeDeleted)){
                                System.out.println("Account removed successfully");
                            }
                        }
                        catch (InvalidAccountNumberException e){
                            System.out.println("Please enter a 10 digit account number.");
                            System.out.println();
                        }
                        catch(InputMismatchException e){
                            keyboard.next();
                            System.out.println("Please enter a 10 digit account number.");
                            System.out.println();
                        }
                        
                        break;
                    case 5:
                        test.sort();
                        test.viewAll();
                        System.out.println();
                        break;
                    case 6:
                        test.viewClosable();
                        System.out.println();
                        break;
                    case 7:
                        System.out.println("Thank you for using my program!");
                        test.saveAccounts("accounts.txt");
                        continues = false;
                        break;
                    default:
                        System.out.println("Please enter an number between 1 and 7");
                        break;
                }

            }
            catch(InputMismatchException e){
                keyboard.next();
                System.out.println("Please enter a number between 1-7");
            }
        }
        //test.viewAll();
    }
     /***
     * Method to validate the user inputted account number
     * @param   number to hold the inputted account number to be checked
     * @return  a boolean value, true if the number is valid or else throw an exception
     */
     public static boolean checkAccountNumber(long number)
                            throws InvalidAccountNumberException{
            String accountNumber = Long.toString(number);
            if(accountNumber.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
                return true;
            }
            throw new InvalidAccountNumberException();
        }
}