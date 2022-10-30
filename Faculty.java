/***
 * Class to model the entity Faculty
 * @author Matthew Bergin
 * @version 0.1
 * Date of creation: August 24, 2022
 * Last Date Modified: August 24, 2022
 */
 public class Faculty extends Employee {
    // Data member
    private String rank;
    /***
	 * Default constructor
	 * No parameters
	 * Initializes name, address, phone, email, positon and rank to the string "none"
     * Initializes id to the integer 0
     * Initializes salary to the double 0.0
	 */
    public Faculty(){
        super();
        rank = "none";
    }
    /***
	 * Constructor with eight parameters
	 * @param	name for the name of a faculty
	 * @param	address for the address of a faculty
	 * @param	phone for the phone number of a faculty
	 * @param	email for the email address of a faculty
     * @param   id for the id number of a faculty
     * @param   position for the position of a faculty
     * @param   salary for the salary of a faculty
     * @param   rank for the rank of a faculty
	 */
    public Faculty(String name, String address, String phone,
                    String email, int id, String position, double salary, String rank){
        super(name, address, phone, email, id, position, salary);
        this.rank = rank;
    }
    /***
	 * Getter for the rank of a faculty
	 * @param	no parameters
	 * @return	the value of the data member rank
	 */
    public String getRank(){
        return rank;
    }
    /***
	 * Setter for the position of a faculty
	 * @param	rank to set the data member rank
	 * no return value
	 */
    public void setRank(String rank){
        this.rank = rank;
    }
    /***
	 * Method to get the Faculty information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        String str = super.toString();
        str += "Rank: " + rank + "\n";
        return str;
    }
 }