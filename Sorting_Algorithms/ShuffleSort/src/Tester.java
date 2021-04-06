import java.util.ArrayList;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class Tester {
    public static void main(String[] args) {
        ArrayList<Integer> array=new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);


        Shuffle shuffler=new Shuffle(array);
        shuffler.shuffle();

        System.out.println(shuffler.getArray());
    }
}
