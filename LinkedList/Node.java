public class Node <T> {
    private T data;
    private Node <T> next;

    /*Constructor methods*/
    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
    Node(T data){
        this(data, null);
    }

    
    /** 
     * @return T
     */
    /*Methods*/
    public T getData(){
        return data;
    }
    
    /** 
     * @param data
     */
    public void setData(T data){
        this.data = data;
    }

    
    /** 
     * @return Node<T>
     */
    public Node <T> getNext(){
        return next;
    }
    
    /** 
     * @param next
     */
    public void setNext(Node <T> next){
        this.next = next;
    }

}
