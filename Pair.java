/***
 * Class to model the entity Pair, which contains two elements
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: September 26, 2022
 * Last Date Modified: September 26, 2022
 */
public class Pair<E1, E2> {
    //Data members
    private E1 first;
    private E2 second;
    /***
     * Constructor with two parameters
     * @param   first for the first element to be held in the pair
     * @param   second for the second element to be held in the pair
     */
    public Pair(E1 first, E2 second) {
        this.first = first;
        this.second = second;
    }
    /***
     * Setter for the first element in the Pair
     * @param   first for the new value for the first element
     * no return value
     */
    public void setFirst(E1 first) {
        this.first = first;
    }
    /***
     * Setter for the second element in the Pair
     * @param   second for the new value for the second element
     * no return value
     */
    public void setSecond(E2 second) {
        this.second = second;
    }
    /***
     * Getter for the first element in the Pair
     * @param   no parameters
     * @return  the value of the data member first
     */
    public E1 getFirst() {
        return first;
    }
    /***
     * Getter for the second element in the Pair
     * @param   no parameters
     * @return  the value of the data member second
     */
    public E2 getSecond() {
        return second;
    }
    /***
     * Method to get the Pair information
     * @param   no parameters
     * @return  a formatted String with the values of the data members
     */
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
    /***
     * Method to test if two Pair objects are equal
     * @param   obj to hold the object the Pair is being compared against
     * @return  a boolean value, true if the Pairs are equal, false if not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Pair){
            Pair<E1, E2> p = (Pair<E1, E2>) obj;
            boolean eq1 = p.getFirst().equals(first);
            boolean eq2 = p.getSecond().equals(second);
            return eq1 && eq2;
        }
        return false;
    }
}