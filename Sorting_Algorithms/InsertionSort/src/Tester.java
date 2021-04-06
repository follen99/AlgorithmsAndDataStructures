import java.util.ArrayList;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class Tester {
    public static void main(String[] args) {
        ArrayList<Integer> toSort=new ArrayList<>();
        toSort.add(4);
        toSort.add(3);
        toSort.add(2);
        toSort.add(10);
        toSort.add(12);
        toSort.add(1);
        toSort.add(5);
        toSort.add(6);

        System.out.println("Array non ordinato: "+toSort);

        Insertion insertionSort=new Insertion(toSort);
        insertionSort.sort();
        System.out.println("Array  ordinato: "+insertionSort.getArray());
    }
}
