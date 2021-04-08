/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class QuickSort {
    public QuickSort(){}

    public void sort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }

        int index = partition(arr, start, end);

        sort(arr, start, end-1);
        sort(arr, index+1, end);

    }

    private int partition(int[] arr, int start, int end) {
        int pivotIndex = start;
        int pivotValue = arr[end];

        for (int i=start; i<end; i++){
            if (arr[i] < pivotValue){
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(arr, pivotIndex, end); //pongo il pivot al centro

        return  pivotIndex; //restituisco l'indice del pivot
    }

    private void swap(int[] arr, int i, int j){
        //aggiungi elementi qui per rallentare l'algoritmo
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] array;
}
