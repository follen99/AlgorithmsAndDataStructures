import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        Comparable[] arr=new Comparable[10];
        Random random=new Random();
        for (int i=0; i<arr.length; i++)
            arr[i]=random.nextInt(100);


        System.out.print("Array non ordinato:");
        printArr(arr);

        System.out.print("Array ordinato:");
        InPlaceMerge.merge(arr,0,arr.length/2,arr.length);

    }
    public static void printArr(Comparable[] arrayToPrint){
        for (Comparable c:arrayToPrint)
            System.out.print(c+", ");
    }
}
