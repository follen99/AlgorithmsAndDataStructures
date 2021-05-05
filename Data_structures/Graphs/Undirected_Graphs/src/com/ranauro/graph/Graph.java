/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */
package com.ranauro.graph;

public class Graph {
    public Graph(int V) {
        this.V = V;                         //inizializzo il numero di nodi
        adj = (Bag<Integer>[]) new Bag[V];  //creo l'array di bags

        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();           //inizializzo ogni elemento
    }

    public  void addEdge(int v, int w){
        //aggiungo il vertice sia a v che a w
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];      //ritorno i nodi adiacenti a v
    }

    public int getV(){
        return this.V;
    }

    private final int V;            //numero di nodi
    private Bag<Integer>[] adj;     //nodi adiacenti
}
