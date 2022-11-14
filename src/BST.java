import java.util.LinkedList;
import java.util.Queue;

public class BST {

    // Root of BST
    Node root;

    // Constructor
    BST() {
        root = null;
    }

    // This method calls insertRec()
    void insert(Album key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, Album key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.numberOfSongs < root.album.numberOfSongs)
            root.left = insertRec(root.left, key);
        else if (key.numberOfSongs > root.album.numberOfSongs)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }
//    void deleteKey(Album key) {
//        root = deleteRec(root, key);
//    }
//
//    Node deleteRec(Node root, Album key) {
//        // Return if the tree is empty
//        if (root == null)
//            return root;
//
//        // Find the node to be deleted
//        if (key.numberOfSongs < root.album.numberOfSongs)
//            root.left = deleteRec(root.left, key);
//        else if (key.numberOfSongs > root.album.numberOfSongs)
//            root.right = deleteRec(root.right, key);
//        else {
//            // If the node is with only one child or no child
//            if (root.left == null)
//                return root.right;
//            else if (root.right == null)
//                return root.left;
//
//            // If the node has two children
//            // Place the inorder successor in position of the node to be deleted
//            root.album = minValue(root.right);
//
//            // Delete the inorder successor
//            root.right = deleteRec(root.right, root.album);
//        }
//
//        return root;
//    }
//    // Find the inorder successor
//    Album minValue(Node root) {
//        Album minv = root.album;
//        while (root.left != null) {
//            minv = root.left.album;
//            root = root.left;
//        }
//        return minv;
//    }
//
//    void printLevelOrder()
//    {
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//
//
//            Node tempNode = queue.poll();
//            System.out.print(tempNode.album.toString() + " ");
//
//            /*Enqueue left child */
//            if (tempNode.left == null) {
//                System.out.print("N ");
//            }else{
//                queue.add(tempNode.left);
//            }
//
//            /*Enqueue right child */
//            if (tempNode.right == null) {
//                System.out.print("N ");
//            }else{
//                queue.add(tempNode.right);
//            }
//        }
//    }

}
