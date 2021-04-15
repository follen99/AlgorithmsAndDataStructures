import java.util.ArrayList;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class BinarySearchArray {
    private int[] array;
    /**
     * come funziona questa struttura dati?
     * essenzialmente abbiamo come struttura base un array, che risulta in ogni momento ordinato.
     * ogni volta che inseriamo un nuovo elemento nella struttura, questo viene posto in modo ordinato nell'array.
     * il problema con questa struttura è che ogni volta dobbiamo effettuare lo shift di tutti gli elementi dell'array.*/
    BinarySearchArray(){
        this.array = new int[100];
    }

    public void add(int element){
        if(this.array.length == 0){

        }
    }
}
