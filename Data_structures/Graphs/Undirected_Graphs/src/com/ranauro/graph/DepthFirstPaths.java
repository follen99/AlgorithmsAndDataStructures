/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */
package com.ranauro.graph;

import java.util.Stack;

public  class DepthFirstPaths{
    public DepthFirstPaths(Graph G, int s){
        this.s = s;
        edgeTo = new int[G.getV()];
        marked = new boolean[G.getV()];


        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w: G.adj(v))
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G , w);
            }
    }
    /**
     * ritorno il valore dell'array contenente il booleano.
     * se è true vuol dire che è stato visitato nella dfs, quindi c'è un path
     * @param v il vertice
     * @return {@code true} se c'è un cammino, {@code false} se non c'è un cammino.
     * @throws IllegalArgumentException se l'argomento (v) è {@code v <= 0 || v > V+1}
     * */
    public boolean hasPathTo(int v){
        checkVertex(v);
        return marked[v];
    }

    /**
     * @param v il vertice
     * @return la sequenza (a partire dal vertice scelto) di vertici che conducono alla radice (s)
     * @throws IllegalArgumentException se l'argomento (v) è {@code v <= 0 || v > V+1}
     * */
    public Iterable<Integer> pathTo(int v){
        checkVertex(v);
        if (!hasPathTo(v))  return null;    //ritorno null se non c'è un path per v

        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);       //aggiungo il nodo source
        return path;        //ritorno il cammino
    }


    private void checkVertex(int v){
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Il vertice "+v+" non è compreso tra zero e "+(V-1)+". ");
    }


    protected int[] getEdgeTo(){
        return this.edgeTo;
    }
    protected  boolean[] getMarked(){
        return this.marked;
    }
    protected int getS(){
        return this.s;
    }

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

}
