import java.util.ArrayList;

public class SelectionSort {
    public static void sort(int[] a){

        int N = a.length;
        for (int i = 0; i<N; i++){
            int min=i;
            for (int j = i+1; j<N; j++){
                if (less(a[j],a[min])){ min=j;}
                exch(a, i, min);
            }
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
