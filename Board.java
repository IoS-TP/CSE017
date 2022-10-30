/***
 * Class to model a sudoku board and solve it
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: October 1, 2022
 * Last Date Modified: October 2, 2022
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Board{
    //Data Members
    ArrayList<ArrayList<Integer>> board = new ArrayList<>();
    ArrayList<Integer> availableNumbers = new ArrayList<>();
    final int EMPTY = 0;
    /***
     * Constructor with one parameter
     * @param   filename for the location of the file with which the board will be initialized
     */
    public Board(String filename){
        for (int i = 0; i < 9; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 9; j++){
                temp.add(EMPTY);
            }
            board.add(temp);
            availableNumbers.add(9);
        }
        
        readBoard(filename);
    }
    /***
     * Method to initialize the board with values from a file
     * @param   filename for the location of the file with which the board will be initialized
     * no return value
     */
    private void readBoard(String filename) throws IllegalArgumentException{
        try{
            File file = new File(filename);
            Scanner input = new Scanner(file);
            int cnt = 0;
            while(input.hasNextLine()){
                String[] numbers = input.nextLine().split(" ");
                for(int i =0; i < numbers.length; i++){
                    int num = Integer.parseInt(numbers[i]);
                    if(num > 0 && num <=9 && isAvailable(num)){
                         board.get(cnt).set(i, num);
                         availableNumbers.set(num-1, availableNumbers.get(num-1)-1);
                    }
                    else if (num == 0){
                        board.get(cnt).set(i, num);
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                        
                }
                    cnt++;
            }
                
            input.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    /***
     * Method to tell if all nine of a digit have been placed on the board
     * @param   digit for the number to be checked for having been placed nine times
     * @return  a boolean value, true if fewer than nine of the digit have been placed, false otherwise
     */
    private boolean isAvailable(int digit){
        if(availableNumbers.get(digit-1) > 0){
            return true;
        }
        return false;
    }
    /***
     * Method to check if every digit has been placed nine times on the board
     * @param   no parameters
     * @return  a boolean value, true if every digit has been placed nine times, false otherwise
     */
    private boolean noNumbersLeft(){
        for(int num : availableNumbers){
            if (num != 0){
                return false;
            }
        }
        return true;
    }
    /***
     * Method to check if a placement is legal by the rules of sudoku
     * @param   row for the row number of the placement
     * @param   col for the column number of the placement
     * @return  a boolean value, true if a move is legal, false if not
     */
    public boolean checkMove(int row, int col){
        int digit = board.get(row).get(col);
        int rowAdd = 0;
        int colAdd = 0;
        if (row >= 3 && row < 6){
            rowAdd = 3;
        }
        else if(row >= 6){
            rowAdd = 6;
        }
        if (col >= 3 && col < 6){
            colAdd = 3;
        }
        else if(col >= 6){
            colAdd = 6;
        }
        for (int i = 0; i < 9; i++){
            if(board.get(row).get(i) == digit && i != col){
                return false;
            }
            if (board.get(i).get(col) == digit && row != i){
                return false;
            }
            if(rowAdd+i/3 != row && colAdd + i%3 != col){
                if (board.get(rowAdd+i/3).get(colAdd+i%3) == digit){
                    
                    return false;
                }
            }
        }
        return true;
    }
    /***
     * Recursive method to solve a sudoku puzzle in the Board
     * @param   no parameters
     * @return  a boolean value, true if the board is solvable, false if not
     */
    public boolean solve(){
        boolean continues = true;
        for(int i =0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board.get(i).get(j) == 0){
                    continues = false;
                    for (int k = 1; k <= 9; k++){
                        board.get(i).set(j, k);
                        if(checkMove(i, j)){
                            availableNumbers.set(k-1, availableNumbers.get(k-1)-1);
                            //System.out.println(board);
                            if (!solve()){
                                board.get(i).set(j, EMPTY);
                                availableNumbers.set(k-1, availableNumbers.get(k-1)+1);
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            board.get(i).set(j, EMPTY);
                        }
                    }
                    break;
                } 
                if (!continues){
                    break;
                }
            }
            if (!continues){
                break;
            }
        }
        return noNumbersLeft();
    }
    /***
     * Method to return a formatted String containing the values of the Board
     * @param   no parameters
     * @return  a formatted String containing the values of the Board
     */
    public String toString(){
        String ans = "";
        for (ArrayList<Integer> row : board){
            for (int value : row){
                ans += value + " ";
            }
            ans+= "\n";
        }
        return ans;
    }
}