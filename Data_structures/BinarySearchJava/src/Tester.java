/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class Tester {
    public static void main(String[] args) {
        //chiamo la classe BinaryTreePersonal per evitare conflitti possibili
        BinaryTreePersonal tree = new BinaryTreePersonal(); //inizializzo l'oggetto


        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);


        //tree.printInOrder();
        System.out.println(tree.getSize());
    }
}
