/***
 * Class to test the classes ArrayList and LinkedList
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: October 19, 2022
 * Last Date Modified: October 21, 2022
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class AnimalList {
    /***
     * Method to run the program and test the classes
     * @param   args for the command line arguments
     * no return value
     */
    public static void main(String[] args){
        File file = new File("animals.txt");
        ArrayList<String> animalAL = new ArrayList<>();
        LinkedList<String> animalLL = new LinkedList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String animal = reader.nextLine();
                animalAL.add(animal);
                animalLL.add(animal);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Could not find the file");
            System.exit(0);
        }
        testSearch(animalAL, animalLL);
        testRemove(animalAL, animalLL);
        testAdd(animalAL, animalLL);        
    }
    /***
     * Method to test the contains methods and display their iterations
     * @param   AL for the ArrayList of animal names
     * @param   LL for the LinkedList of animal names
     * no return value
     */
    public static void testSearch(ArrayList<String> AL, LinkedList<String>LL){
        System.out.println("\n\nComparing the methods contains(Object)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations(AL)", "Iterations(LL)");
        int totalAL=0, totalLL=0;
        for(int i =0; i < 20; i++){
            int randomIndex = (int)(Math.random() * AL.size());
            String randomName=AL.get(randomIndex);
            int ALIterations = AL.contains(randomName);
            int LLIterations = LL.contains(randomName);
            totalAL+=ALIterations;
            totalLL += LLIterations;
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, ALIterations, LLIterations);
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);

    }
    /***
     * Method to test the add methods and display their iterations
     * @param   AL for the ArrayList of animal names
     * @param   LL for the LinkedList of animal names
     * no return value
     */
    public static void testAdd(ArrayList<String> AL, LinkedList<String>LL){
        System.out.println("\n\nComparing the methods add(Object)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations(AL)", "Iterations(LL)");
        int totalAL=0, totalLL=0;
        for(int i =0; i < 20; i++){
            int randomIndex = (int)(Math.random() * AL.size());
            String randomName= AL.get(randomIndex);
            int ALIterations = AL.add(randomIndex, randomName);
            int LLIterations = LL.add(randomIndex, randomName);
            totalAL+=ALIterations;
            totalLL += LLIterations;
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, ALIterations, LLIterations);
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);
    }
    /***
     * Method to test the remove methods and display their iterations
     * @param   AL for the ArrayList of animal names
     * @param   LL for the LinkedList of animal names
     * no return value
     */
    public static void testRemove(ArrayList<String> AL, LinkedList<String>LL){
        System.out.println("\n\nComparing the methods remove(Object)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations(AL)", "Iterations(LL)");
        int totalAL=0, totalLL=0;
        for(int i =0; i < 20; i++){
            int randomIndex = (int)(Math.random() * AL.size());
            String randomName=AL.get(randomIndex);
            int ALIterations = AL.remove(randomName);
            int LLIterations = LL.remove(randomName);
            totalAL+=ALIterations;
            totalLL += LLIterations;
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, ALIterations, LLIterations);
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);
    }
}