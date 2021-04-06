import java.util.ArrayList;
import java.util.Random;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class Shuffle {
    public Shuffle(ArrayList<Integer> array){
        this.array=array;
    }
    public void shuffle(){
        Random ran=new Random();
        int n=array.size();
        for (int i=0; i<n; i++){
            int random=ran.nextInt(n-i);

            int temp = array.get(i);
            array.set(i,array.get(random));
            array.set(random,temp);
        }
    }

    public ArrayList<Integer> getArray() {
        return array;
    }
    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }

    ArrayList<Integer> array;
}
