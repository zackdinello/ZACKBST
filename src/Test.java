import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        BST bst = new BST();

        ArrayList<String> listOfSongs = new ArrayList<>();
        listOfSongs.add("hello");
        listOfSongs.add("like you");
        listOfSongs.add("hello2");
        Album album = new Album(1,listOfSongs,"maula",3);
        Album album1 = new Album(2,listOfSongs,"maula2",4);
        Album album2 = new Album(3,listOfSongs,"maula3",5);
        Album album3 = new Album(4,listOfSongs,"maula3",6);

        bst.insert(album);
        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);
       // bst.deleteKey(album);
        //bst.printLevelOrder();

        //"100, 50, 150, 25, N, 125, 180, N, N, N, N, N, N, N, N"
    }
}
