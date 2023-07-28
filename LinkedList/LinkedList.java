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

    /*Methods*/
    public void addAtIndex(T data, int index) throws IllegalArgumentException{
        Node<T> newNode = new Node<T> (data, null);
        if (index < 0 || index >= size()){
            throw new IllegalArgumentException("Your index is out of the list bounds");
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
        T removedData;
        removedData = removeAtIndex(i);
        return removedData;
    }

    // update tail function
    private void actTail(Node<T> current){
        while(current.getNext() != null){
                current = current.getNext();
            }
        tail.setData(current.getData());
        tail.setNext(null);
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public int size(){
        Node<T> current = head;
        if(isEmpty()){
            size = 0;
            return size;
        }
        else{
            while(current.getNext() != null){
                current = current.getNext();
                size++;
            }
            return size;
        }
    }
    
    /*Helpers*/
    public Node<T> getHead(){
        return head;
    }
    public Node<T> getTail(){
        return tail;
    }
    public int getSize(){
        return size;
    }
}
