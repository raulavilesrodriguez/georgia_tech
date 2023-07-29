import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /*Constructor methods*/
    public LinkedList(){
        head = null;  // the list starts off empty
        tail = null;
    }

    
    /** 
     * @param data
     * add data to the list
     */
    /*Methods*/
    public void add(T data){
        Node<T> newNode = new Node<T> (data, null);
        Node<T> current = head;
        if (isEmpty()){
            size = 0;
            tail = null;
            head = newNode;
        }
        else {
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    
    /** 
     * @param data
     * @param index
     * @throws IllegalArgumentException
     * Adds a node to the position specified by index
     */
    public void addAtIndex(T data, int index) throws IllegalArgumentException{
        Node<T> newNode = new Node<T> (data, null);
        if (isEmpty()){
            size = 0;
            tail = null;
        }
        if (index < 0 || index >= size()){
            throw new IllegalArgumentException("Your index is out of the list bounds" + "size: " + size);
        } else if(data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        } else if (index == 0){
            newNode.setNext(head);
            head = newNode;
            size();
            actTail(head);
        } else if (index == 1){
            Node<T> current = head;
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size();
            actTail(head);
        }
        else {
            Node<T> current = head;
            while(index > 1){
                current = current.getNext();
                index--;
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size();
            actTail(head);
        }
    }

    
    /** 
     * @param index
     * @return T
     * @throws IllegalArgumentException
     * Returns the data located at the specified index in the list
     */
    public T getAtIndex(int index) throws IllegalArgumentException{
        if (index < 0 || index >= size()){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        } else if (index == 0){
            return head.getData();
        } else {
            Node<T> current = head;
            while(index > 0){
                current = current.getNext();
                index--;
            }
            return current.getData();
        }
    }

    
    /** 
     * @param index
     * @return T
     * @throws IllegalArgumentException
     * Removes the data (and the node that stores it) from the 
     * specified index of the list and returns that data of the 
     * node that was removed
     */
    public T removeAtIndex(int index) throws IllegalArgumentException{
        Node<T> removedData;
        Node<T> current = head;
        if (index < 0 || index >= size()){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        } 
        if (head.getNext() == null){
            removedData = head;
            head = null;
        }
        else if (index == 0 && size()>1){
            removedData = head;
            head = head.getNext();
            size();
            actTail(head);
        } 
        else if (index == 1){
            removedData = current.getNext();
            if(current.getNext().getNext() != null){
                current.setNext(current.getNext().getNext());
            } else {
                current.setNext(null);
            }
            size();
            actTail(head);
        } 
        else {
            while(index > 1){
                current = current.getNext();
                index--;
            }
            removedData = current.getNext();
            if(current.getNext().getNext() != null){
                current.setNext(current.getNext().getNext());
            } else {
                current.setNext(null);
            }
            size();
            actTail(head);
        }
        return removedData.getData();
    }

    
    /** 
     * @param data
     * @return T
     * @throws IllegalArgumentException
     * Removes the first occurrence of the passed data from the 
     * list (and also remove the node that holds it) and returns 
     * the data from the removed node
     */
    public T remove(T data) throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Your list is empty");
        }
        if(data == null){
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }

        boolean found = false;
        Node<T> current = head;
        int i = 0;
        while ((current != null) && (!found)){
            if(data.equals(current.getData())){
                found = true;
            }
            else {
                current = current.getNext();
                i++;
            }
        }
        if (current == null){
            throw new NoSuchElementException("The data is not present in the list");
        }
        T removedData;
        removedData = removeAtIndex(i);
        return removedData;
    }

    /**
     * The method clears the LinkedList
     */
    public void clear(){
        head = null;
        tail = null;
    }

    
    /** 
     * @param current
     */
    // update tail function
    private void actTail(Node<T> current){
        if (isEmpty()){
            tail = null;
        } else {
            while(current.getNext() != null){
                current = current.getNext();
            }
            tail = current;
        }
    }

    
    /** 
     * @return boolean
     * Returns a boolean value which represents whether the 
     * list is empty
     */
    public boolean isEmpty(){
        return (head == null);
    }

    
    /** 
     * @return int
     * Returns current size of the list
     */
    public int size(){
        Node<T> current = head;
        size = 0;
        if (isEmpty()){
            return size;
        } else {
            while(current.getNext() != null){
            current = current.getNext();
            size++;
            }
            return size + 1; 
        }   
    }
    
    
    /** 
     * @return Node<T>
     */
    /*Helpers*/
    public Node<T> getHead(){
        if (head == null){
            throw new IllegalArgumentException("Your list is empty. No throw RESULTS BROO");
        } else {
            return head;
        }
    }
    public Node<T> getTail(){
        if (tail == null){
            throw new IllegalArgumentException("Your list is empty. No throw RESULTS MAN");
        } else{
            return tail;
        }   
    }
    public int getSize(){
        return size;
    }

    public String toString(){
        Node<T> current = head;
        String result = "";

        while(current != null){
            result = result + current.getData().toString() + ", ";
            current = current.getNext();
        }
        result = "[" + result.replaceAll(", $", "") + "]";
        return  result;
    }

}
