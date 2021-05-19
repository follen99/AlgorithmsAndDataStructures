import Structures.In;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author giuliano ranauro
 * Date: 19/05/2021 14:39
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */

public class WebCrawler {
    public static void main(String[] args) {
        //timeout di connessione
        System.setProperty("sun.net.client.defaultConnectTimeout", "500");
        System.setProperty("sun.net.client.defaultReadTimeout",    "1000");

        String root = "https://www.ding.unisannio.it/";        //sito di inizio
        Queue<String> queue = new Queue<>();
        Set<String> marked = new HashSet<>();

        //marco come visitato il sito di partenza
        queue.enqueue(root);
        marked.add(root);

        //finchè la coda ha elementi...
        while (!queue.isEmpty()){
            String v = queue.dequeue();     //prendo il prossimo elemento (sito, link)
            System.out.println(v);          //lo stampo

            String input = null;
            try {
                In in = new In(v);
                input = in.readAll().toLowerCase();     //leggo tutto il sito (che conterrà anche i link)
            }
            catch (IllegalArgumentException e) {
                System.out.println("[could not open " + v + "]");
                continue;
            }

            String regexp = "(http|https)://(\\w+\\.)+(edu|com|gov|org)";   //filtro le stringhe alla ricerca di un sito, tramite pattern
            Pattern pattern = Pattern.compile(regexp);

            Matcher matcher = pattern.matcher(input);

            // find and print all matches
            while (matcher.find()) {
                String w = matcher.group();
                if (!marked.contains(w)) {
                    queue.enqueue(w);       //aggiungo i i siti alla coda
                    marked.add(w);          //li marco come visitati
                }
            }
        }



    }
}
