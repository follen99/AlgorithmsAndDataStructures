import java.util.Random;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class Tester {
    public static void main(String[] args) {
        int[] arr=new int[20];

        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(100);
        }

        System.out.print("Array non ordinato: ");
        for (Integer el:arr) {
            System.out.print(el+", ");
        }

        QuickSort qs = new QuickSort();
        qs.sort(arr,0,19);

        System.out.print("\nArray     ordinato: ");
        for (Integer el:arr) {
            System.out.print(el+", ");
        }
    }
}
