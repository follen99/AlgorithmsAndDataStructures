/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */
package com.ranauro.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    public BreadthFirstPaths(Graph g, int s){
        this.marked = new boolean[g.getV()];
        this.distTo = new int[g.getV()];
        this.edgeTo = new int[g.getV()];

        checkVertex(s);         //controllo il vertice

        bfs(g,s);
    }


    private void bfs(Graph g, int s){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;
        distTo[s] = 0;

        //finche' la queue ha elementi
        while (!q.isEmpty()){
            int v = q.remove();             //rimuovo dalla queue il nodo visitato
            for (int w : g.getAdj(v)){      //per tutti i nodi adiacenti al nodo visitato...
                if (!marked[w]){            //se il nodo adiacente w non è stato ancora visitato...
                    q.add(w);               //aggiungo alla queue il nodo
                    marked[w] = true;       //lo marco come visitato (true)
                    edgeTo[w] = v;          //l'arco verso w è v
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }

    /**
     * ritorna {@code true} se esiste un percorso tra il nodo sorgente {@code s} ed il vertice {@code v} */
    public boolean hasPathTo(int v){
        checkVertex(v);
        return marked[v];       //ritorno il valore dell'array
    }

    /**
     * ritorna il numero di nodi in un percorso minimo tra il nodo sorgente {@code s} ed il vertice {@code v}*/
    public int distTo(int v){
        checkVertex(v);
        return this.distTo[v];
    }

    public Iterable<Integer> pathTo(int v){
        checkVertex(v);                     //se il vertice non è valido lancio una eccezione
        if (!hasPathTo(v)) return null;     //se non c'è un percorso ritorno null

        Stack<Integer> path = new Stack<>();            //creo lo stack che conterrà il path
        int x;
        /**
         * inizializzo x alla posizione richiesta v
         * ciclo finchè la distanza tra v ed x è uguale a 0
         * ad ogni iterazione inizializzo x con il nodo successivo*/
        for (x = v; distTo[x]!= 0; x = edgeTo[x]){
            path.push(x);   //ad ogni iterazione aggiungo il nodo corrente al path
        }

        path.push(x);       //aggiungo l'ultimo nodo
        return path;        //ritorno
    }


    /**
     * @throws IllegalArgumentException quando il vertice non è tra i parametri consentiti*/
    private void checkVertex(int v){
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Il vertice "+v+" non è compreso tra zero e "+(V-1)+". ");
    }

    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path
}
