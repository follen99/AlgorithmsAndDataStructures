import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        int[] arr = new int[8];
        arr[0]=10;
        arr[1]=19;
        arr[2]=2;
        arr[3]=100;
        arr[4]=44;
        arr[5]=36;
        arr[6]=20;



        //System.out.println(arr);
        //printArr(arr);
        SelectionSort.sort(arr);
        printArr(arr);

        //System.out.println(arr);
    }
    public static void printArr(int[] arr){
        for (Integer i: arr) {
            System.out.print(i+", ");
        }
    }
}
