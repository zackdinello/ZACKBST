import java.util.*;

public class BST {

    // Root of BST
    Node root;

    Node getRoot(){
        return this.root;
    }

    // Constructor
    BST() {
        root = null;
    }

    // This method calls insertRec()
    Node insert(Album key) {
        root =  insertRec(root, key);
        return new Node(key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, Album key) {

        /* If the tree is empty, return a new node */
        Node temp = new Node(key);
        if (root == null) {
            return temp;
        }

        /* Otherwise, recur down the tree */
        if (key.numberOfSongs < root.album.numberOfSongs)
            root.left = insertRec(root.left, key);
        else if (key.numberOfSongs > root.album.numberOfSongs)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }
    Node deleteKey(Album key) {
        root = deleteRec(root, key);
        return new Node(key);
    }

    Node deleteRec(Node root, Album key) {
        // Return if the tree is empty

        if(!contains(key)){
            throw new IllegalArgumentException();
        }
        if (root == null)
            return root;


        // Find the node to be deleted
        if (key.numberOfSongs < root.album.numberOfSongs)
            root.left = deleteRec(root.left, key);
        else if (key.numberOfSongs > root.album.numberOfSongs)
            root.right = deleteRec(root.right, key);
        else {
            // If the node is with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.album = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.album);
        }

        return root;
    }
    public boolean contains( Album x )
    {
        return contains( x, root );
    }
    private boolean contains( Album x, Node t )
    {
        if( t == null )
            return false;
        int compareResult = x.compareTo( t.album );
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true; // Match
    }

    // Find the inorder successor
    Album minValue(Node root) {
        Album minv = root.album;
        while (root.left != null) {
            minv = root.left.album;
            root = root.left;
        }
        return minv;
    }

    void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {


            Node tempNode = queue.poll();
            System.out.print(tempNode.album.numberOfSongs + " ");

            /*Enqueue left child */
            if (tempNode.left == null) {
                System.out.print("N ");
            }else{
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right == null) {
                System.out.print("N ");
            }else{
                queue.add(tempNode.right);
            }
        }
    }

    void storeBSTNodes(Node root, Vector<Node> nodes)
    {
        // Base case
        if (root == null)
            return;

        // Store nodes in Inorder (which is sorted
        // order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    /* Recursive function to construct binary tree */
    Node buildTreeUtil(Vector<Node> nodes, int start,
                       int end)
    {
        // base case
        if (start > end)
            return null;

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtress */
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    // This functions converts an unbalanced BST to
    // a balanced BST
    void rebalance(){
        root = buildTree(root);
    }
    Node buildTree(Node root)
    {
        // Store nodes of given BST in sorted order
        Vector<Node> nodes = new Vector<Node>();
        storeBSTNodes(root, nodes);

        // Constructs BST from nodes[]
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    ArrayList<Album> partion(Album album){
        ArrayList<Album> result = new ArrayList<>();
        inorder(root,result,album);
        return result;
    }
    void inorder(Node node, ArrayList<Album> result, Album album)
    {
        if (node == null)
            return;

        /* first recur on left child */
        inorder(node.left, result,album);

        /* then print the data of node */
       if(node.album.numberOfSongs > album.numberOfSongs){
           result.add(album);
       }

        /* now recur on right child */
        inorder(node.right,result,album);
    }



}
