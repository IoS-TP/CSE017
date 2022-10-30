/***
 * Class to model the entity airplane and its seats
 * CSE 017
 * @author Matthew Bergin
 * @version 0.1
 * Date of creation: August 31, 2022
 * Last Date Modified: September 02, 2022
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Airplane{
    // Data member
    private char[][] seatMap;
    /***
     * Default constructor
     * No parameters
     * Initializes a 9x8 seatMap to be full of dots
     */
    public Airplane(){
        seatMap = new char[9][8];
        for (int i = 0; i < seatMap.length; i++){
            for (int j = 0; j < seatMap[i].length; j++){
                seatMap[i][j] = '.';
            }
        }
    }
    /***
     * Constructor with one parameter
     * @param   filename to contain the location of the seatMap from which the program will copy information
     */
    public Airplane(String filename){
        seatMap = new char[9][8];
        readMap(filename);
    }
    /***
     * Method to initialize the seatMap withd data from a file or with dots
     * @param   filename for the name of the file from which the method will read
     * no return value
     */
    private void readMap(String filename){
        File file = new File(filename);
        try{
            Scanner readFile = new Scanner(file);
            for (int i = 0; i < seatMap.length; i++){
                for (int j = 0; j < seatMap[i].length; j++){
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            for (int i = 0; i < seatMap.length; i++){
                for (int j = 0; j < seatMap[i].length; j++){
                    seatMap[i][j] = '.';
                }
            }
        }
    }
    /***
     * Method to validate input for seat numbers while reserving and freeing seats
     * @param   seatNumber to hold the location the user wants to adjust
     * @return a boolean value, true if the value is a real seat or throws an error if not  
     */
    private boolean checkSeatNumber(String seatNumber) 
                    throws InvalidSeatException{
        if(seatNumber.matches("[1-9][A-H]")){
            return true;
        }
        else{
            throw new InvalidSeatException("Invalid seat number (row[1-9]column[A-H]");
        }

    }
    /***
     * Method to adjust the seatmap to reserve a seat
     * @param   seatNumber to hold the seat location that the user wants to reserve
     * @return  a boolean value, true if the seat can be reserved, false if it is already reserved
     */
    public boolean reserveSeat(String seatNumber) 
                    throws InvalidSeatException{
        if(checkSeatNumber(seatNumber)){ //valid seat number
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if(seatMap[row][col] == '.'){ //free
                seatMap[row][col] = 'X';
                return true;
            }
            else{ //already reserved
                return false;
            }
        }
        return false;
    }
    /***
     * Method to adjust the seatmap to free a seat 
     * @param   seatNumber ot hold the seat location that the user wants to free
     * @return  a boolean value, true if the seat can be freed, false if it is already free
     */
    public boolean freeSeat(String seatNumber)
                    throws InvalidSeatException{
        if(checkSeatNumber(seatNumber)){ //valid seat number
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if(seatMap[row][col] == 'X'){ // reserved
                seatMap[row][col] = '.';
                return true;
            }
            else{ //already free
                return false;
            }
        }
        return false;
    }
    /***
     * Method to save the updated seatmap to a text file
     * @param   filename to hold the file name where the seatmap will be saved to
     * no return value
     */
    public void saveMap(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile= new PrintWriter(file);
            for (int i = 0; i < seatMap.length; i++){
                for (int j = 0; j < seatMap[i].length; j++){
                    writeFile.print(seatMap[i][j] + " ");
                }
                writeFile.println();
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write to " + filename);
        }
        
    }
    /***
     * Method to get the seatMap information
     * no parameters
     * @return  formatted string containing the values in seatMap
     */
    public String toString(){
        String out = "\tA\tB\tC\tD\tE\t\tG\tH\n";
        for (int i = 0; i < seatMap.length; i++){
            out += (i+1) + "\t";
            for (int j = 0; j<seatMap[i].length; j++){
                out += seatMap[i][j] + "\t";
            }
            out += "\n";
        }
        return out;
    }
}