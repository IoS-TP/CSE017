/***
 * Class to model the entity PrintRequest
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: October 05, 2022
 * Last Date Modified: October 05, 2022
 */
public class PrintRequest implements Comparable<PrintRequest>{
    //Data members
    private int userID;
    private String group; //root, admin, user, batch
    private double size;
    private static String[] groups = {"root", "admin", "user", "batch"};
    /***
     * Constructor with three parameters
     * @param   id for the userID
     * @param   gr for the group
     * @param   s for the size
     */
    public PrintRequest(int id, String gr, double s){
        userID = id; group = gr; size = s;
    }
    /***
     * Getter for the user ID of a PrintRequest
     * @param   no parameters
     * @return  the value of the data member userID
     */
    public int getUserId(){
        return userID;
    }
    /***
     * Getter for the group of a PrintRequest
     * @param   no parameters
     * @return  the value of the data member group
     */
    public String getGroup(){
        return group;
    }
    /***
     * Getter for the size of a PrintRequest
     * @param   no parameters
     * @return  the value of the data member size
     */
    public double getSize(){
        return size;
    }
    /***
     * Setter for the user ID of a PrintRequest
     * @param   id for the new value of the user ID
     * no return value
     */
    public void setUserId(int id){
        userID = id;
    }
    /***
     * Setter for the group of a PrintRequest
     * @param   gr for the new value of the group
     * no return value
     */
    public void setGroup(String gr){
        group = gr;
    }
    /***
     * Setter for the size of a PrintRequest
     * @param   sz for the new value of the size
     * no return value
     */
    public void setSize(double sz){
        size = sz;
    }
    /***
     * Method to format and return a String with the values of the data members
     * @param   no parameters
     * @return  a formatted String containing the values of the datamembers
     */
    public String toString(){
        String outputSize = "";
        if (size < 1000){
            outputSize = String.format("%-4.1f", size) + "B";
        }
        else if (size < 1000000){
            outputSize = String.format("%-4.1f", size/1000) + "KB";
        }
        else if (size < 1000000000){
            outputSize = String.format("%-4.1f", size/1000000) + "MB";
        }
        else if (size < 1000000000000.0){
            outputSize = String.format("%-4.1f", size/1000000000) + "GB";
        }
        return String.format("%-10d\t%-5s\t\t%-8s", userID, group, outputSize);
    }
    /***
     * Helper method for the compareTo method giving each group name an integer value based on priority
     * @param   gr for the group name
     * @return  an integer value for the group name based on priority
     */
    private int getGroupValue(String gr){
        for (int i =0; i < groups.length; i++){
            if(gr.equals(groups[i])){
                return i;
            }
        }
        return -1;
    }
    /***
     * Method to compare different objects of type PrintRequest
     * @param   pr for the PrintRequest object which the method will compare against
     * @return  an integer value, 0 if the two are equal, 1 if the first is greater, and -1 if the second is greater
     */
    public int compareTo(PrintRequest pr){
        int gr1 = getGroupValue(this.group);
        int gr2 = getGroupValue(pr.group);
        return gr1-gr2;
    }
}