import java.util.Iterator;
import java.util.ListIterator;
/**
 * Class ArrayList
 * @author Houria Oudghiri
 * Date of creation: October 10, 2021
 * Date of last modification: October 29, 2022
 */
public class ArrayList<E> implements Cloneable, List<E>{
   // data members
   private E[] elements;
   private int size;
   /***
    * Default Constructor
    * Sets elements to an empty array of length 10 and size to 0
    */
    //O(1)
   public ArrayList() {
	   elements = (E[]) new Object[10];
	   size = 0;
   }
   /***
    * Constructor with one parameter
    * @param  capacity for the length of the array
    * Initializes size to 0
    */
    //O(1)
   public ArrayList(int capacity) {
     elements = (E[]) new Object[capacity];
     size = 0;
   }
    /**
     * Method to add value to the list
     * @param value to be added
     * @return true if the addition was successful
     */
     //O(1)
    public boolean add(E item) {
		return add(size, item);
    }
    /**
     * Method to add value to the list at a specific index
     * @param index position where value is added
     * @param value to be added
     * @return true if the addition was successful
     */
     //O(n)
    public boolean add(int index, E item){
		if(index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		ensureCapacity();
		for(int i=size-1; i>=index; i--){
			elements[i+1] = elements[i];
        }
		elements[index] = item;
		size++;
		return true;
    }
    /**
     * Method to get the value from the list
     * @param index of the element to get
     * @return value of the element at index
     * throws an exception of type ArrayIndexOutOfBoundsExceptiont if index is invalid
     */
     //O(1)
    public E get(int index) {
		  checkIndex(index);
		  return elements[index];
    }
    /**
     * Method to modify the value of an element in the list
     * @param index of the element to be modified
     * @param value new value of the element at index
     * @return the old value of the element at index
     * throws an  exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
     //O(1)
    public E set(int index, E item) {
		  checkIndex(index);
		  E oldItem = elements[index];
		  elements[index] = item;
		  return oldItem;
    }
     /**
     * Method to get the number of elements in the list
     * @return size of the list
     */
     //O(1)
    public int size() { 
      return size; 
    }
    /**
     * Method to clear the list
     */
     //O(1)
    public void clear() { 
      size = 0; 
    }
    /**
     * Method to check if the list is empty
     * @return true if the list is empty
     */    
     //O(1)
     public boolean isEmpty() { 
      return (size == 0);
    }
    /**
     * Method to remove a value from the list
     * @param o value to find and remove from the list
     * @return true if o was found and removed, false otherwise
     */
     //O(n)
    public boolean remove(Object o) {
      E item = (E) o;
      for(int i=0; i<size; i++)
		    if(elements[i].equals(item)){
            remove(i);
            return true;
        }
      return false;
    }
    /**
     * Method to remove an element from the list
     * @param index of the element to remove
     * @return true if the element is removed successfully
     * throws an exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
     //O(n)
    public boolean remove(int index) {
      checkIndex(index);
      E item = elements[index];
      for(int i=index; i<size-1; i++)
			  elements[i] = elements[i+1];
      size--;
      return true;
    }
    /***
     * Method to shrink the list to its size
     * @param no parameters
     * no return value
     */
     //O(n)
    public void trimToSize() {
		  if (size != elements.length) {
			    E[] newElements = (E[]) new Object[size];// capacity = size
			    for(int i=0; i<size; i++)
				    newElements[i] = elements[i];
			    elements = newElements;
		  }
    }
    /***
     * Method to check if the list is big enough and grow it by a factor of 1.5 if not
     * @param  no parameters
     * no return value
     */
     //O(n)
    private void ensureCapacity() {
	    if(size >= elements.length) {
          int newCap = (int) (elements.length * 1.5);
		      E[] newElements = (E[]) new Object[newCap];
		      for(int i=0; i<size; i++)
				    newElements[i] = elements[i];
		      elements = newElements;
	    }
    }
    /***
     * Method to check if an index is valid
     * @param index for the index to be checked
     * no return value
     * throws a ArrayIndexOutOfBoundsException
     */
     //O(1)
    private void checkIndex(int index){
		  if(index < 0 || index >= size)
			    throw new ArrayIndexOutOfBoundsException(
              "Index out of bounds. Must be between 0 and "+(size-1));
    }
    /***
     * Method to return a String with the formatted values of the ArrayList
     * @param   no parameters
     * @return  a string with the formatted values of the ArrayList
     */
     //O(n)
    public String toString() {
		  String output = "[";
		  for(int i=0; i<size-1; i++)
			    output += elements[i] + " ";
		  output += elements[size-1] + "]";
		  return output;
    }
    /**
     * Method to get an iterator for the list
     * @return iterator object associated with this list
     */
     //O(1)
    public Iterator<E> iterator(){
		  return new ArrayIterator();
    }
    /***
     * Inner class to implement the interface Iterator
     * @author  Houria Oudghiri
     * Date of creation: October 10, 2021
     * Date of last modification: October 20, 2022
     */
    private class ArrayIterator implements Iterator<E>{
      //Data member
	    private int current = -1;
      /***
       * Method to check if there is another element after the current one
       * @param   no parameters
       * @return  a boolean value, true if there is another element
       */
       //O(1)
	    public boolean hasNext() { 
        return current < size-1; 
      }
      /***
       * Method to return the value of the next element
       * @param   no parameters
       * @return  the value of value of the next element
       */
       //O(1)
	    public E next() { 
        return elements[++current]; 
      }
    }
    /***
     * Method to return a deep copy of the ArrayList
     * @param no parameters
     * @return a deep copy of the ArrayList
     */
     //O(n)
    public Object clone(){
        ArrayList<E> copy = new ArrayList<>();
        for(int i=0; i<size; i++){
            copy.add(elements[i]);
        }
        return copy;
    }
    /**
     * Method to search for a value in the list
     * @param o value to be searched for
     * @return true if the value is found, false otherwise
     */
     //O(n)
    public boolean contains(Object o){
      E item = (E)o;
      Iterator iter = iterator();
      while(iter.hasNext()){
        if(iter.next().equals(item)){
          return true;
        }
      }
      return false;
    }
    /**
     * Method to search for another list in the list
     * @param otherList list to be searched for
     * @return true if all the elements in otherList are found in this list, false otherwise
     */
     //O(n^2)
    public boolean containsAll(List<E> otherList){
      Iterator iter = iterator();
      while(iter.hasNext()){
        if(!otherList.contains(iter.next())){
          return false;
        }
      }
      return true;
    }
     /**
     * Method to add another list to the list
     * @param otherList list to be added
     * @return true if all the elements in otherList were added to this list successfully
     */
     //O(n)
    public boolean addAll(List<E> otherList){
      Iterator iter = otherList.iterator();
      boolean returnValue = true;
      while(iter.hasNext()){
        E item = (E)iter.next();
        if(!add(item)){
          returnValue = false;
        }
      }
      return returnValue;
    }
    /**
     * Set difference
     * Method to remove the elements of otherList from the list if they are found in the list
     * @param otherList list to be removed from the list
     * @return true if the elements from otherList were removed from this list successfully
     */
     //O(n^2)
    public boolean removeAll(List<E> otherList){
      boolean returnValue = true;
      Iterator iter = otherList.iterator();
      while(iter.hasNext()){
        E item = (E)iter.next();
        if(!remove(item)){
          returnValue = false;
        }
      }
      return returnValue;
    }
    /**
     * Set intersection
     * Method to retain only the elements from otherList in the list
     * @param otherList list of elements to be retained in this list if found
     * @return true if the intersection was performed successfully
     */
     //O(n^2)
    public boolean retainAll(List<E> otherList){
      Iterator iter = iterator();
      while(iter.hasNext()){
        E item = (E)iter.next();
        if(!otherList.contains(item)){
          remove(item);
        }
      }
      return true;
    }
    /***
     * Inner class to implement the interface ListIterator
     * @author  Matthew Bergin
     * Date of creation: October 29, 2022
     * Date of last modification: October 29, 2022
     */
    private class LstItr implements ListIterator<E>{
      //Data Member
	    private int current = -1;
      /***
       * Default constructor
       * Sets current to -1
       */
       //O(1)
      public LstItr(){
        current = -1;
      }
      /***
       * Constructor with one parameter
       * @param index for the value of current
       * Throws an ArrayIndexOutOfBoundsException if the index is not valid
       */
       //O(1)
      public LstItr(int index){
        if(index > size || index < 0){
          throw new ArrayIndexOutOfBoundsException();
        }
        current = index;
      }
      public void add(Object o){
        throw new  UnsupportedOperationException();
      }
      public void set(Object o){
        throw new  UnsupportedOperationException();
      }
       public void remove(){
        throw new  UnsupportedOperationException();
      }
      /***
       * Method to check if there is another element after the current one
       * @param   no parameters
       * @return  a boolean value, true if there is another element
       */
       //O(1)
	    public boolean hasNext() { 
        return current < size-1; 
      }
      /***
       * Method to check if there is another element before the current one
       * @param   no parameters
       * @return  a boolean value, true if there is another element before
       */
       //O(1)
      public boolean hasPrevious(){
        return current > 0;
      }
      /***
       * Method to return the value of the next element
       * @param   no parameters
       * @return  the value of value of the next element
       */
       //O(1)
	    public E next() { 
        return elements[++current]; 
      }
      /***
       * Method to return the value of the previous element
       * @param   no parameters
       * @return  the value of value of the previous element
       */
       //O(1)
      public E previous(){
        return elements[--current];
      }
      public int nextIndex(){
        throw new  UnsupportedOperationException();
      }
      public int previousIndex(){
        throw new  UnsupportedOperationException();
      }
    }
    /**
     * Method to get a list iterator for the list
     * @return list iterator object associasted with this list 
     *         the iterator is positioned at the beginning of the list
     */
     //O(1)
    public LstItr listIterator(){
      return new LstItr();
    }
    /* Method to get a list iterator for the list at a specific position
     * @param index the position where the iterator should start
     * @return list iterator object associated with this list
     *         the iterator is positioned at index if the index is valid
     *         if index = size of the list, the iterator is positioned at the end of the list
     * throws an exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
     //O(1)
    public LstItr listIterator(int index){
      return new LstItr(index);
    }
    /**
     * Method to get the elements of the list as an array of type Object
     * @return array of type Object containing all the elements of this list
     */
     //O(n)
    public Object[] toArray(){
      this.trimToSize();
      return elements;
    }
}