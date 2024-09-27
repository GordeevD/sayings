/*
 * =====================================================================================
 *
 *       Filename:  Tree.java
 *
 *    Description:  Implementation of a Red-Black Tree in Java. A Red-Black Tree is a
 *                  self-balancing binary search tree, ensuring that operations like 
 *                  insertion, deletion, and search can be performed in O(log n) time.
 *
 *         Author:  Jarren Seson, Dmitry Gordeev
 *
 * =====================================================================================
 *
 *   Methods:
 *   1. leftRoation (Node x)
 *   2. rightRotation (Node x)
 *   3. meHua (String saying)
 *   4. withWord (String saying)
 *   5. inOrderHelp (Node node, ArrayList<Saying> sayings)
 *   6. inOrder (Node node)
 *   7. Insert (Saying key)
 *   8. fixInsert (Node k)
 *   9. printTree ()
 *   10. printInOrder (Node node)
 *   11. Member (Saying saying)
 *   12. First ()
 *   13. Last ()
 *   14. Predecessor (Saying saying)
 *   15. Successor (Saying saying)
 *   16. withWord (String word)
 *
 * =====================================================================================
 */

import java.util.ArrayList;

public class Tree {
    
    // will be using a red-black tree
    public Node root;
    private Node maxNode; // Reference to the maximum node

    /**
    * =====================================================================================
    * Method Name: leftRotation
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Moves subtree from the left to the right.
    * 
    * Parameters:
    *    @param x - Root node of the tree
    * 
    * Returns:
    *    @return - void
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    private void leftRoation(Node x){
        Node y = x.right;
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            root = y;
        }
        else if(x == x.parent.left){
            x.parent.left = y;
        }
        else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }
    
    /**
    * =====================================================================================
    * Method Name: rightRotation
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Moves subtree from the right to the left.
    * 
    * Parameters:
    *    @param x - Root node of the tree
    * 
    * Returns:
    *    @return - void
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    private void rightRotation(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    /**
    * =====================================================================================
    * Method Name: Tree
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Constructor for Tree object.
    * 
    * Parameters:
    *    N/A
    * 
    * Returns:
    *    N/A
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public Tree(){
        this.root = null;
        this.maxNode = null;
    }

    /**
     * =====================================================================================
     * Method Name: Insert
     * -------------------------------------------------------------------------------------
     * Description:
     *    Inserts a new Saying into the Red-Black Tree. This method ensures that the tree
     *    remains balanced after the insertion by calling the fixInsert method.
     * Parameters:
     *    @param key - The Saying object to be inserted into the tree.
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
     * =====================================================================================
     */
    public void Insert(Saying key) {
        Node newNode = new Node(key, true); // new nodes are red by default
        if (root == null) {
            root = newNode;
            root.red = false; // root is always black
            maxNode = newNode; // Update maxNode
            return;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (key.getSaying().compareTo(current.key.getSaying()) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        newNode.parent = parent;
        if (key.getSaying().compareTo(parent.key.getSaying()) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            maxNode = newNode; // Update maxNode if newNode is greater
        }
        fixInsert(newNode);
    }

    /**
     * =====================================================================================
     * Method Name: fixInsert
     * -------------------------------------------------------------------------------------
     * Description:
     *    Fixes the Red-Black Tree after an insertion to ensure that it maintains its
     *    properties. This method performs necessary rotations and recoloring to balance
     *    the tree.
     * Parameters:
     *    @param k - The newly inserted node that may violate Red-Black Tree properties.
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
     * =====================================================================================
     */
    private void fixInsert(Node k) {
        // Fixing the tree after insertion to maintain Red-Black properties
        Node u;
        while (k.parent != null && k.parent.red) {
            if (k.parent == k.parent.parent.left) {
                u = k.parent.parent.right;
                if (u != null && u.red) {
                    k.parent.red = false;
                    u.red = false;
                    k.parent.parent.red = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRoation(k);
                    }
                    k.parent.red = false;
                    k.parent.parent.red = true;
                    rightRotation(k.parent.parent);
                }
            } else {
                u = k.parent.parent.left;
                if (u != null && u.red) {
                    k.parent.red = false;
                    u.red = false;
                    k.parent.parent.red = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotation(k);
                    }
                    k.parent.red = false;
                    k.parent.parent.red = true;
                    leftRoation(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.red = false;
    }

    /**
     * =====================================================================================
     * Method Name: printTree
     * -------------------------------------------------------------------------------------
     * Description:
     *    Prints the Red-Black Tree in an in-order traversal. This method is a public
     *    interface to the private printInOrder method.
     * Parameters:
     *    N/A
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
     * =====================================================================================
     */
    public void printTree() {
        printInOrder(root);
    }

    /**
     * =====================================================================================
     * Method Name: printInOrder
     * -------------------------------------------------------------------------------------
     * Description:
     *    Recursively prints the nodes of the Red-Black Tree in an in-order traversal.
     * Parameters:
     *    @param node - The current node in the traversal.
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
     * =====================================================================================
     */
    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.key.getSaying());
            printInOrder(node.right);
        }
    }

    /**
     * =====================================================================================
     * Method Name: Member
     * -------------------------------------------------------------------------------------
     * Description:
     *    Checks if a given Saying is a member of the Red-Black Tree. This method traverses
     *    the tree to find the node with the specified key.
     * Parameters:
     *    @param saying - The Saying object to be checked for membership in the tree.
     * Returns:
     *    @return - boolean - Returns true if the Saying is found in the tree, otherwise false.
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
     * =====================================================================================
     */
    public boolean Member(Saying saying){
        Node current = root;
        while (current != null) {
            int cmp = (saying.getSaying().compareTo(current.key.getSaying()));
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    /**
     * =====================================================================================
     * Method Name: First
     * -------------------------------------------------------------------------------------
     * Description:
     *    Returns the first (smallest) Saying in the Red-Black Tree. This method assumes
     *    that the tree is not empty.
     * Returns:
     *    @return - Saying - The first (smallest) Saying in the tree, or null if the tree is empty.
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
     * =====================================================================================
     */
    public Saying First(){
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }
    /**
     * =====================================================================================
     * Method Name: Last
     * -------------------------------------------------------------------------------------
     * Description:
     *    Returns the last (largest) Saying in the Red-Black Tree. This method assumes
     *    that the tree is not empty.
     * Returns:
     *    @return - Saying - The last (largest) Saying in the tree, or null if the tree is empty.
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
    */
    public Saying Last(){
        return maxNode != null ? maxNode.key : null;
    }

    /**
     * =====================================================================================
     * Method Name: Predecessor
     * -------------------------------------------------------------------------------------
     * Description:
     *    Finds the predecessor of a given Saying in the Red-Black Tree. The predecessor is
     *    the node with the largest key that is smaller than the given key.
     * Parameters:
     *    @param saying - The Saying object for which the predecessor is to be found.
     * Returns:
     *    @return - Saying - The predecessor of the given Saying, or null if no predecessor exists.
     * -------------------------------------------------------------------------------------
     * Author:  Dmitry Gordeev
     * =====================================================================================
     */
    public Saying Predecessor(Saying saying){
        Node current = root;
        Node predecessor = null;
        while (current != null) {
            int cmp = saying.getSaying().compareTo(current.key.getSaying());
            if (cmp == 0) {
                if (current.left != null) {
                    predecessor = current.left;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                }
                break;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                predecessor = current;
                current = current.right;
            }
        }
        return predecessor != null ? predecessor.key : null;
    }
    /**
     * =====================================================================================
     * Method Name: Successor
     * -------------------------------------------------------------------------------------
     * Description:
     *    Finds the successor of a given Saying in the Red-Black Tree. The successor is
     *    the node with the smallest key that is larger than the given key.
     * Parameters:
     *    @param saying - The Saying object for which the successor is to be found.
     * Returns:
     *    @return - Saying - The successor of the given Saying, or null if no successor exists.
     * -------------------------------------------------------------------------------------
     *      Author:  Dmitry Gordeev
     * =====================================================================================
    */
    public Saying Successor(Saying saying){
        Node current = root;
        Node successor = null;
        while (current != null) {
            int cmp = saying.getSaying().compareTo(current.key.getSaying());
            if (cmp == 0) {
                if (current.right != null) {
                    successor = current.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }
                }
                break;
            } else if (cmp < 0) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return successor != null ? successor.key : null;
    }

    /**
    * =====================================================================================
    * Method Name: inOrderHelp
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Recursively traverses through a tree and adds each node to an array list.
    * 
    * Parameters:
    *    @param node - Root node of the tree
    *    @param sayings - Array list of Saying objects
    * 
    * Returns:
    *    @return - void
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public void inOrderHelp(Node node, ArrayList<Saying> sayings){
        if(node == null){
            return;
        }
        inOrderHelp(node.left, sayings);
        sayings.add(node.key);
        inOrderHelp(node.right, sayings);
    }
    

    /**
    * =====================================================================================
    * Method Name: inOrder
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Uses the inOrderHelp method to return the given array list.
    * 
    * Parameters:
    *    @param node - Root node of the tree
    * 
    * Returns:
    *    @return - Array list of sayings in a tree
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public ArrayList<Saying> inOrder(Node node){
        ArrayList<Saying> sayings = new ArrayList<Saying>();
        inOrderHelp(node, sayings);
        return sayings;
    }

    /**
    * =====================================================================================
    * Method Name: meHua
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Calls the inOrderHelp method and filters the array based on the given Hawaiian
    *    word.
    * 
    * Parameters:
    *    @param word - Word to be searched for
    * 
    * Returns:
    *    @return - Array list of Saying objects that contain the given Hawaiian word in the
    *              saying property of the object
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public ArrayList<Saying> meHua(String word) {
        ArrayList<Saying> sayings = inOrder(this.root);
        sayings.removeIf(s -> !s.getSaying().contains(word));
        return sayings;
    }
    
    /**
    * =====================================================================================
    * Method Name: withWord
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Calls the inOrderHelp method and filters the array based on the given English
    *    word.
    * 
    * Parameters:
    *    @param word - Word to be searched for
    * 
    * Returns:
    *    @return - Array list of Saying objects that contain the given English word in the 
    *              English translation property of the object
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public ArrayList<Saying> withWord(String word){
        ArrayList<Saying> sayings = inOrder(this.root);
        sayings.removeIf(s -> !s.getEnglishTranslation().contains(word));
        return sayings;
    }
}
