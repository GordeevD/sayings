//Implemented by Jarren

public class Node {
    Node left;
    Node right;
    Node parent;
    Saying key;
    boolean red;
    // will be true if tree is red and false if black

    // constructor
    public Node(Saying key, boolean red){
        this.left = null;
        this.right = null;
        this.key = key;
        this.red = red;
        this.parent = null;
    }
}
