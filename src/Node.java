public class Node {
    Album album;
    Node left, right;

    public Node(Album album) {
        this.album = album;
        left = right = null;
    }
}
