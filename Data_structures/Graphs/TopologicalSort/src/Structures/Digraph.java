package Structures;
/**
 * @author giuliano ranauro
 * Date: 18/05/2021 22:59
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */

import com.ranauro.Structures.Bag;

public class Digraph {
    private int V;
    public Bag<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];

        //inizializzo l'array di bags
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }

    public void addEdge(int v, int w){
        adj[v].add(w);  //aggiungo ad un solo vertice (il primo è quello di partenza)
    }

    public Iterable<Integer> adj(int V){
        return this.adj[V];
    }
    public int getV(){
        return this.V;
    }
}
