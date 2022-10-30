/***
 * Class to implement various recursive algorithms for looking through files
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of creation: September 14, 2022
 * Last Date Modified: September 14, 2022
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Recursion{
    /***
     * Method to run the program and test the methods
     * @param   args to hold the command line arguments
     * no return value
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a path");
        String path = keyboard.nextLine();
        System.out.println("Enter a word");
        String word = keyboard.nextLine();
        findWord(path, word);

        //test getSize
        System.out.println("Enter a path");
        path = keyboard.nextLine();
        double size = getSize(path);
        String unit = "bytes";
        if (size > 1000000000){ //convert to giga
            size /= 1000000000.0;
            unit = "GB";
        }
        else if(size > 1000000){ //convert to mega
            size /= 1000000.0;
            unit = "MB";
        }
        else if (size > 1000){ //convert to kilo
            size /= 1000.0;
            
            unit = "KB";
        }
        System.out.printf("%s: %.2f %s", path, size, unit);
        System.out.println();

    }
    /***
     * Method to print how many times a word is found in every file in a folder and its subfolders
     * @param   folder to hold the location for the program to start searching for the word
     * @param   word to hold the word for the method to search for
     * no return value
     */
    public static void findWord(String folder, String word){
        File file = new File(folder);
        if(file.isFile()){//open file and search for the word
            int count = countWord(file, word);
            if (count != 0){
                System.out.println(word + " was found " + count + " times in " + file.getAbsolutePath());
            }
        }
        else if(file.isDirectory()){ //go deeper
            File[] files = file.listFiles(); //get contents of the folder
            for (File f : files){
                findWord(f.getAbsolutePath(), word);
            }
        }
        
    }
    /***
     * Method to return how many times a word appears in a given file
     * @param   file to hold the location for the search for the word
     * @param   word to hold the word for the method to search for
     * @return  an integer value of the amount of times a word appears in a file
     */
    public static int countWord(File file, String word){
        int count = 0;
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                int index = line.indexOf(word);
                while(index != -1){
                    count++;
                    index = line.indexOf(word, index+1);
                }
            }
            read.close();
        }
        catch(FileNotFoundException e){
            
        }
        return count;
    }
    /***
     * Method to return the size of a file or folder
     * @param   path to hold the location of the folder/file
     * @return  a long value holding the size of the file/folder
     */
    public static long getSize(String path){
        long size = 0;
        File file = new File(path);
        if(file.isFile()){//open file, get its size
            size = file.length();//size of file in bytes
        }
        else if(file.isDirectory()){ //go deeper
            File[] files = file.listFiles(); //get contents of the folder
            for (File f : files){
                size += getSize(f.getAbsolutePath());
            }
            
        }
        else{//not a file or folder

        }
        return size;
    }
}