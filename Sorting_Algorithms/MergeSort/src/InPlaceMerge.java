public class InPlaceMerge {
    public static Comparable[] aux=new Comparable[10];

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i=lo, j=mid+1;

        for (int k=lo; k<=hi-1; k++){
            //System.out.println(a[k]);
            aux[k] = a[k];
        }
        for (int k = lo; k<=hi; k++){
            if (i > mid-1)
                a[k] = aux[j++];
            else if (j > hi-1 )
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable aux, Comparable aux1) {
        return aux.compareTo(aux1)<0;
    }

}
