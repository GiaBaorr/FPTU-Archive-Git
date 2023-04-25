// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private Laptop info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Laptop x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Laptop x) {
        this(x,null);
    }
    
    public Laptop getInfo() {
        return this.info;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setInfo(Laptop inBike) {
        this.info = inBike;
    }
    
    public void setNext(Node n) {
        this.next = n;
    }
 }

