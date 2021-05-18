/**
 * @author giuliano ranauro
 * Date: 18/05/2021 23:13
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package com.ranauro.Graph;

import com.ranauro.Structures.Queue;

import java.util.LinkedList;


public class DirectedBFS {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean marked[] ;
    private int[] distTo;
    private int[] edgeTo;
    LinkedList<Integer> queue;

    public DirectedBFS(Digraph G ,int s){
        marked = new boolean[G.getV()];
        distTo = new int[G.getV()];
        edgeTo = new int[G.getV()];
        for (int v = 0; v < G.getV(); v++)
            distTo[v] = INFINITY;
        //validateVertex(s);        //funzione per assicurarsi che i parametri siano corretti
        bfs(G, s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue<>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        //validateVertex(s);        //funzione per assicurarsi che i parametri siano corretti
        return marked[v];
    }
}
