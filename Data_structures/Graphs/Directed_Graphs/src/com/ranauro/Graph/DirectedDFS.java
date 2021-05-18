/**
 * @author giuliano ranauro
 * Date: 18/05/2021 23:03
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package com.ranauro.Graph;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.getV()];
        dfs(G,s);       //chiamo ricorsivamente la dfs
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;                   //marco il nodo corrente come visitato
        for (int w : G.adj(v))              //per ogni nodo adiacente a v....
            if (!marked[w]) dfs(G, w);      //se non è stato visitato, effettuo la dfs su di esso

        /**
         * come si nota dall'algoritmo, la DFS o Depth-first search, va alla ricerca dei nodi,
         * e non ritorna finchè TUTTI non sono stati visitati. Di conseguenza NON puo essere utilizzata
         * per alcune applicazioni.*/
    }

    public boolean visited(int v){
        return marked[v];
    }
}
