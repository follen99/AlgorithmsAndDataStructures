/**
 * @author giuliano ranauro
 * Date: 18/05/2021 23:35
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package com.ranauro.Testers;

import com.ranauro.Graph.Digraph;
import com.ranauro.Graph.DirectedDFS;

public class DFSDemo {
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

        DirectedDFS dfs = new DirectedDFS(digraph, starting);  //creo la dfs sul grafo, a partire dal nodo 1

        System.out.println("Esiste un percorso da "+starting+" a: ");
        for (int i = 1; i < digraph.getV(); i++){
            if (dfs.visited(i))
                System.out.print(i+" ");
        }

    }
}
