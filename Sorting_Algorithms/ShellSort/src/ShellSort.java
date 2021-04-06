import java.util.ArrayList;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class ShellSort {
    public ShellSort(ArrayList<Integer> toSort){
        this.array=toSort;
    }
    public void sort(){
        int n=array.size();     //lunghezza dell'array
        /**
         * il loop viene eseguito finche il gap = 0, ovvero abbiamo ordinato l'array
         * ad ogni passaggio, ovvero dopo aver controllato l'intero array riduco il gap*/
        for (int gap=n/2; gap>0; gap/=2){
            for (int i=gap; i<n; i+=1){
                int temp=array.get(i);

                int j;
                for (j=i; j>=gap && array.get(j-gap)>temp; j-=gap){
                    array.set(j,array.get(j-gap));
                }

                array.set(j,temp);
            }
        }
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }
    public ArrayList<Integer> getArray() {
        return array;
    }

    ArrayList<Integer> array;
}
