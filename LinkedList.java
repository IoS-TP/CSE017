import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;
/**
 * Class LinkedList
 * @author Houria Oudghiri
 * Date of creation: October 10, 2021
 * Date of last modification: October 29, 2022
 */
public class LinkedList<E> implements Cloneable, List<E>{
     // Data members
	private Node head, tail;
	int size;
    /**
    * Inner class to model a node
    * @author Houria Oudghiri
    * Date of creation: October 10, 2021
    * Date of last modification: October 29, 2022
    */
	private class Node{
        //Data members
		E value;
		Node next;
        Node previous;
        /***
         * Constructor with one parameter
         * @param   initialValue for the initial value of the node
         * Sets next and previous null
         */
         //O(1)
		Node(E initialValue){
			value = initialValue; 
            next = null;
            previous = null;
		}
	}
    /***
    * Default Constructor
    * Sets head and tail to null and size to 0
    */
    //O(1)
	public LinkedList() {
		head = tail = null;
		size = 0;
	}

    /**
     * Method to add value to the head of the list
     * @param value to be added
     * @return true if the addition was successful
     */
     //O(1)
    public boolean addFirst(E item) {
		Node newNode = new Node(item);
		if(head == null) {
            head = tail = newNode; 
        }
		else { 
            head.previous = newNode;
            newNode.next = head;
			head = newNode;
		}
		size++; 
        return true;
    }
    /**
     * Method to add value to the tail of the list
     * @param value to be added
     * @return true if the addition was successful
     */
     //O(1)
    public boolean addLast(E item) {
		Node newNode = new Node(item);
		if(head == null) { 
            head = tail = newNode; 
        }
		else { 
            tail.next = newNode; 
            newNode.previous = tail;
            tail = newNode; 
        }
		size++; 
        return true;
    }
    /**
     * Method to add value to the tail of the list
     * @param value to be added
     * @return true if the addition was successful
     */
     //O(1)
    public boolean add(E item) {
		return addLast(item);
    }
    /**
     * Method to add value to an index of the list
     * @param value to be added
     * @param index for the index where the value should be added
     * @return true if the addition was successful
     */
     //O(n)
    public boolean add(int index, E value){
        Node newNode = head;
        Node node = new Node(value);
        if(index >=size){
            return false;
        }
        for(int i =0; i < index; i++){
            newNode = newNode.next;
        }
        Node nodeAfter = newNode.next;
        newNode.next = node;
        node.previous = newNode;
        node.next = nodeAfter;
        nodeAfter.previous = node;
        return true;
    }
    /**
     * Method to get the first value from the list
     * @return value of the element at index
     * throws an exception of type ArrayIndexOutOfBoundsExceptiont if index is invalid
     */
     //O(1)
    public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.value;
    }
    /**
     * Method to get the value from the end list
     * @return value of the element at index
     * throws an exception of type ArrayIndexOutOfBoundsExceptiont if index is invalid
     */
     //O(1)
    public E getLast() {
		if (head == null)
			throw new NoSuchElementException();
		return tail.value;
    } 
    /**
     * Method to get the value from the list
     * @param index of the element to get
     * @return value of the element at index
     * throws an exception of type ArrayIndexOutOfBoundsExceptiont if index is invalid
     */
     //O(n)
    public E get(int index){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index < size/2){
            Node node = head;
            for(int i =0; i < index; i++){
                node = node.next;
            }
            return node.value;
        }
        Node node = tail;
        for(int i =size-1; i > index; i--)
        {
            node = node.previous;
        }
        return node.value;
    }
    /**
     * Method to remove the first element from the list
     * @return true if the element is removed successfully
     * throws an exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
     //O(1)
    public boolean removeFirst() {
		if (head == null) 
            throw new NoSuchElementException();
		head = head.next;
        head.previous = null;
		if(head == null)
            tail = null;
		size--; 
        return true;
    }
    /**
     * Method to remove the last element from the list
     * @return true if the element is removed successfully
     * throws an exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
     //O(1)
    public boolean removeLast() {
		if (head == null) 
            throw new NoSuchElementException();
		if(size == 1) 
            return removeFirst();
		tail = tail.previous;
        tail.next = null;
		size--; 
        return true;
    } 
    /***
     * Method to return a String with the formatted values of the ArrayList
     * @param   no parameters
     * @return  a string with the formatted values of the ArrayList
     */
     //O(n)
    public String toString() {
		String output = "[";
		Node node = head;
		while(node != null) {
			output += node.value + " ";
			node = node.next;
		}
		output += "]";
		return output;
    }
    /**
     * Method to clear the list
     */
     //O(1)
    public void clear() {
        head = tail = null; 
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
     * Method to get the number of elements in the list
     * @return size of the list
     */
     //O(1)
    public int size() {
        return size; 
    } 
    /**
     * Method to get an iterator for the list
     * @return iterator object associated with this list
     */
     //O(1)
    public Iterator<E> iterator(){
		  return new LinkedListIterator();
    }
    /***
     * Inner class to implement the interface Iterator
     * @author  Houria Oudghiri
     * Date of creation: October 10, 2021
     * Date of last modification: October 20, 2022
     */
    private class LinkedListIterator implements Iterator<E>{
        //Data member
		private Node current = head;
        /***
        * Method to check if there is another element after the current one
        * @param   no parameters
        * @return  a boolean value, true if there is another element
        */
        //O(1)
		public boolean hasNext() {
			return (current != null);
		}
        /***
        * Method to return the value of the next element
        * @param   no parameters
        * @return  the value of value of the next element
        */
        //O(1)
	    public E next() {
            if(current == null)
			  throw new NoSuchElementException();
			E value = current.value;
			current = current.next; 
            return value;
		}
    }
    /***
     * Method to return a deep copy of the LinkedList
     * @param no parameters
     * @return a deep copy of the LinkedList
     */
     //O(n)
    public Object clone(){
        LinkedList<E> copy = new LinkedList<>();
        for(Node node = head; node!=null; node = node.next){
            copy.add(node.value);
        }
        return copy;
    }
    /**
     * Method to modify the value of an element in the list
     * @param index of the element to be modified
     * @param value new value of the element at index
     * @return the old value of the element at index
     * throws an  exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
     //O(n)
    public E set(int index, E value){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index < size/2){
            Node node = head;
            for(int i =0; i < index; i++){
                node = node.next;
            }
           
            E value2 = node.value;
            node.value = value;
            return value2;
        }
        Node node = tail;
        for(int i =size-1; i > index; i--)
        {
            node = node.previous;
        }
        E value2 = node.value;
        node.value = value;
        return value2;

    }
    /**
     * Method to remove a value from the list
     * @param o value to find and remove from the list
     * @return true if o was found and removed, false otherwise
     */
     //O(n)
    public boolean remove(Object o){
        E item = (E) o;
        Node node = head;
        Node previous= null;
        while(node != null){
            if(node.value.equals(item)){
                break;
            }
            previous = node;
            node = node.next;
        }
        if(node!=null){ //found
            if(node==head){
                removeFirst();
            }
            else{
                Node next = node.next;
                next.previous = previous;
                previous.next=next;
                size--;
            }
            
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
    public boolean remove(int index){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        Node previous= null;
        for (int i =0; i < index; i++){
            previous = node;
            node = node.next;
        }
        if(node==head){
            removeFirst();
            size--;
        }
        else if (node == tail){
            removeLast();
            size--;
        }
        else{
            Node next = node.next;
            next.previous = previous;
            previous.next=next;
            size--;
        }
        
        return true;
    }
    /**
     * Method to search for a value in the list
     * @param o value to be searched for
     * @return true if the value is found, false otherwise
     */
     //O(n)
    public boolean contains (Object o){ 
        E item = (E) o;
        Iterator<E> iter = iterator();
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
        boolean returnValue = add(otherList.get(0));
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
      Iterator iter = otherList.listIterator();
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
        //Data member
	    private Node current = head;
        /***
         * Default constructor
         * Sets current to a node pointing to head
         */
         //O(1)
        public LstItr(){
            Node temp = new Node(null);
            temp.next = head;
            temp.previous = null;
            current = temp;
        }
        /***
         * Constructor with one parameter
         * @param index for the value of current
         * Throws an ArrayIndexOutOfBoundsException if the index is not valid
         */
         //O(n)
        public LstItr(int index){
            if(index > size){
                throw new ArrayIndexOutOfBoundsException();
            }
            if(index == size){
                Node temp = new Node(null);
                temp.next = null;
                temp.previous = tail;
                current = temp;
            }
            else{
                for(int i =0; i<index; i++){
                current = current.next;
                }   
            }
            
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
            return current.next != null; 
        }
        /***
         * Method to check if there is another element before the current one
         * @param   no parameters
         * @return  a boolean value, true if there is another element
         */
         //O(1)
        public boolean hasPrevious(){
            return current.previous != null;
        }
        /***
         * Method to return the value of the next element
         * @param   no parameters
         * @return  the value of value of the next element
         */
         //O(1)
       public E next() { 
            current = current.next;
            return current.value; 
        }
        /***
         * Method to return the value of the previous element
         * @param   no parameters
         * @return  the value of value of the previous element
         */
         //O(1)
        public E previous(){
            current = current.previous;
            return current.value;
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
    /**
     * Method to get a list iterator for the list at a specific position
     * @param index the position where the iterator should start
     * @return list iterator object associated with this list
     *         the iterator is positioned at index if the index is valid
     *         if index = size of the list, the iterator is positioned at the end of the list
     * throws an exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
     //O(n)
    public LstItr listIterator(int index){
      return new LstItr(index);
    }
    /**
     * Method to get the elements of the list as an array of type Object
     * @return array of type Object containing all the elements of this list
     */
     //O(n)
    public Object[] toArray(){
        Object[] ansArray = new Object[size];
        Node node = head;
        ansArray[0] = head.value;
        for (int i =1; i < size; i++){
            node = node.next;
            ansArray[i] = node.value;
        }
        return ansArray;
    }
}