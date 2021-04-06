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
        array.add(12);
        array.add(34);
        array.add(54);
        array.add(2);
        array.add(3);

        ShellSort sorter=new ShellSort(array);
        sorter.sort();
        System.out.println("Array ordinato: "+sorter.getArray());
    }
}
