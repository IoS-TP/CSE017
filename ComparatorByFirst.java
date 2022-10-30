/***
 * Class to compare two Pairs by their first elements
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: September 26, 2022
 * Last Date Modified: September 26, 2022
 */
import java.util.Comparator;
public class ComparatorByFirst<E1 extends Comparable<E1>, E2> implements Comparator<Pair<E1,E2>>{
    /***
     * Method to compare the first elements of two Pairs
     * @param   p1 to hold the first Pair for comparison
     * @param   p2 to hold the second Pair for comparison
     * @return  an integer value, positive if the first pair is greater than the second, 0 if they are equal, and negative otherwise
     */
    public int compare(Pair<E1,E2> p1, Pair <E1, E2> p2){
        E1 f1 = p1.getFirst();
        E1 f2 = p2.getFirst();
        return f1.compareTo(f2);
    }
}