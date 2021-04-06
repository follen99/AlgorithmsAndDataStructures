import java.util.ArrayList;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class Insertion {
    public Insertion(ArrayList<Integer> toSort){
        this.array=toSort;
    }
    public void sort(){
        int n=this.array.size();

        for (int i=1;i<n;i++){
            int key=array.get(i);   //la chiave è l'elemento corrente
            int j=i-1;              //j è l'elemento precedente ad i

            /**
             * finchè j è maggiore = zero (quando j<0 vuol dire che ho controllato tutto l'array)
             * e finchè array[j] (ovvero l'elemento corrente nel loop interno) è maggiore di key...
             * continuo a scambiare */
            while (j>=0 && array.get(j)>key){
                array.set(j+1,array.get(j));    //array[j+1]=array[j]
                j-=1;                           //decremento
            }
            array.set(j+1,key);                 //imposto la key all'ultimo elemento del loop precedente
        }
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private ArrayList<Integer> array;
}
