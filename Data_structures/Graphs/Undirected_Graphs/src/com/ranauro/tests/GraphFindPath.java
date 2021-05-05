/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */
package com.ranauro.tests;

import com.ranauro.graph.DepthFirstPaths;
import com.ranauro.graph.Graph;

public class GraphFindPath {
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

        for (Integer vertice:graph.adj(0)
        ) {System.out.println(vertice);

        }

        DepthFirstPaths dfs = new DepthFirstPaths(graph, 1);
        for (Integer vertice : dfs.pathTo(6))
            System.out.print(vertice+", ");
    }
}
