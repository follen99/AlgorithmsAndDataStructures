import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class BlackList {


    public static void main(String[] args) {
        Set<String> whiteList = readListFromFile();

        Scanner fromUser = new Scanner(System.in);
        System.out.println("Inserisci il tuo testo, termina dando invio.");
        String userString = fromUser.nextLine();

        String[] words = userString.split(" ");

        for (String word : words){
            assert whiteList != null;
            if (!(whiteList.contains(word.toLowerCase())))
                System.out.print(word+" ");
        }
    }


    private static Set<String> readListFromFile(){
        Scanner scanner;
        Set<String> temp = new HashSet<>();

        try {
            scanner = new Scanner(new File("BlackList.txt"));
            while (scanner.hasNextLine())
                temp.add(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.err.println("Non sono riuscito a leggere da file.");
            return null;
        }

        return temp;
    }
}
