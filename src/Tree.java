import java.util.ArrayList;

public class Tree {
    
    // will be using a red-black tree
    public Node root;
    private Node maxNode; // Reference to the maximum node
    private Node parent;
    private int height;

    // Implemented by Jarren
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
    
    // Implemented by Jarren
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

    // right and left rotation are necessary to keep the tree balanced

    public Tree(){
        this.root = null;
        this.maxNode = null;
        this.height = 0;
    }

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
    public void printTree() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.key.getSaying());
            printInOrder(node.right);
        }
    }

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

    public Saying First(){
        return root != null ? root.key : null;
    }
    public Saying Last(){
        return maxNode != null ? maxNode.key : null;
    }

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

    // Implemented by Jarren 
    public void inOrderHelp(Node node, ArrayList<Saying> sayings){
        if(node == null){
            return;
        }
        inOrderHelp(node.left, sayings);
        sayings.add(node.key);
        inOrderHelp(node.right, sayings);
    }

    // Implemented by Jarren
    public ArrayList<Saying> inOrder(Node node){
        ArrayList<Saying> sayings = new ArrayList<Saying>();
        inOrderHelp(node, sayings);
        return sayings;
    }

    // Implemented by Jarren 
    public ArrayList<Saying> MeHua(String word) {
        ArrayList<Saying> sayings = inOrder(this.root);
        sayings.removeIf(s -> !s.getSaying().contains(word));
        return sayings;
    }
    
    // Implemented by Jarren
    public ArrayList<Saying> WithWord(String word){
        ArrayList<Saying> sayings = inOrder(this.root);
        sayings.removeIf(s -> !s.getEnglishTranslation().contains(word));
        return sayings;
    }
}
