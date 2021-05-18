/**
 * @author giuliano ranauro
 * Date: 18/05/2021 23:41
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package com.ranauro.Testers;

import com.ranauro.Graph.Digraph;
import com.ranauro.Graph.DirectedBFS;

public class BFSDemp {
    public static void main(String[] args) {
        int starting = 2;

        Digraph digraph = new Digraph(7);
        digraph.addEdge(1,2);
        digraph.addEdge(2,3);
        digraph.addEdge(2,5);
        digraph.addEdge(2,4);
        digraph.addEdge(4,5);
        digraph.addEdge(4,6);
        digraph.addEdge(6,3);

        DirectedBFS bfs = new DirectedBFS(digraph, starting);

        System.out.println("Esiste un percorso da "+starting+" a: ");
        for (int i = 1; i < digraph.getV(); i++){
            if (bfs.hasPathTo(i))
                System.out.print(i+" ");
        }
    }
}
