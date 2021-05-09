/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */
package com.ranauro.tests;

import com.ranauro.graph.BreadthFirstPaths;
import com.ranauro.graph.Graph;

public class GraphBFSTest {
    public static void main(String[] args) {
        Graph graph = new Graph(10);     //creo un grafo di 5 elementi
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,2);
        graph.addEdge(4,3);
        graph.addEdge(4,6);
        graph.addEdge(5,3);
        graph.addEdge(5,5);
        graph.addEdge(5,6);
        graph.addEdge(6,4);
        graph.addEdge(6,5);
        graph.addEdge(7,8);
        graph.addEdge(7,9);

        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 1);

        System.out.println(bfs.hasPathTo(5));       //corretto
        System.out.println(bfs.hasPathTo(6));       //corretto
        System.out.println(bfs.hasPathTo(9));       //corretto

        System.out.println("Il numero di nodi tra 1 e 5 è: "+bfs.distTo(5));
        System.out.println("Il numero di nodi tra 1 e 6 è: "+bfs.distTo(6));
        System.out.println("Il numero di nodi tra 1 e 9 è: "+bfs.distTo(9));


        System.out.print("Path da 1 a 5:    ");
        for (int nodo : bfs.pathTo(5))
            System.out.print(nodo+", ");
    }
}
