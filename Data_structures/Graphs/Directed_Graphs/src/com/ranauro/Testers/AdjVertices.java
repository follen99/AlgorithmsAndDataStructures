/**
 * @author giuliano ranauro
 * Date: 18/05/2021 23:22
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package com.ranauro.Testers;

import com.ranauro.Graph.Digraph;

public class AdjVertices {
    public static void main(String[] args) {
        Digraph digraph = new Digraph(7);
        digraph.addEdge(1,2);
        digraph.addEdge(2,3);
        digraph.addEdge(2,5);
        digraph.addEdge(2,4);
        digraph.addEdge(4,5);
        digraph.addEdge(4,6);
        digraph.addEdge(6,3);

        int adjSearch = 1;

        System.out.print("Nodi adiacenti ad "+adjSearch+": ");
        for (int v : digraph.adj(adjSearch))
            System.out.print(v+" ");
        adjSearch+=1;
        System.out.println();

        System.out.print("Nodi adiacenti ad "+adjSearch+": ");
        for (int v : digraph.adj(adjSearch))
            System.out.print(v+" ");
        adjSearch+=1;
        System.out.println();


        System.out.print("Nodi adiacenti ad "+adjSearch+": ");
        for (int v : digraph.adj(adjSearch))
            System.out.print(v+" ");
        adjSearch+=1;
        System.out.println();
    }
}
