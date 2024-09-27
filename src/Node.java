/*
 * =====================================================================================
 *
 *       Filename:  Node.java
 *
 *    Description:  Implementation of node
 *
 *         Author:  Jarren Seson
 *
 * =====================================================================================
 */

public class Node {
    Node left;
    Node right;
    Node parent;
    Saying key;
    boolean red; // will be true if tree is red and false if black

    /**
    * =====================================================================================
    * Method Name: Node
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Constructor for Node obejct
    * 
    * Parameters:
    *    @param key - Saying object to be stored in the node
    *    @param red - Color of node. Red if true and black is false.
    * 
    * Returns:
    *    N/A
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public Node(Saying key, boolean red){
        this.left = null;
        this.right = null;
        this.key = key;
        this.red = red;
        this.parent = null;
    }
}
