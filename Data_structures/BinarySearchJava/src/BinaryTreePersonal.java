/**
 * @author giuliano ranauro
 * Date: 29-10-20
 * Ide: Intellij
 * JDK: 1.8
 */

public class BinaryTreePersonal {
    class Node{
        int key;            //ogni nodo ha una chiava (valore)
        Node left, right;   //ogni nodo ha un sottonodo destro e sinistro

        /**
         *costruttore che inizializza la classe
         * */
        public Node(int item){
            key = item;             //inizializzo la chiave con il valore fornito
            left = right = null;    //i due sottonodi sono vuoti al momento dell'inizializzazione
        }
    }

    Node root;      //creo una variabile di istanza che rappresenta la root del tree

    BinaryTreePersonal(){
        root = null;    //al momento della creazione la root è vuota.
    }

    public void insert(int key){
        root = insertRec(root, key);    //chiamo il metodo ricorsivo
    }

    /**
     * questa è una funzione ricorsiva che corrisponde al metodo rank() spiegato nella lezione
     * lezione : 13-04-2021
     *
     * */
    private Node insertRec(Node root, int key){
        /**
         * Se inserisco il primo elemento dall'inizializzazione dell'albero binario
         * allora esso verrà impostato come radice dell'albero*/
        if(root == null){
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public Node getMax(){
        return max(this.root);
    }

    private Node max(Node root){
        /**
         * per prendere il massimo mi basta visitare i nodi destri finchè non trovo null*/
        if(root == null){
            return null;
        }

        if (root.right != null)
            return max(root.right);
        else return root;
    }

    void printInOrder(){
        inOrder(root);  //parto dal primo nodo (root)
    }

    public Node getMin(){
        return min(this.root);
    }

    private Node min(Node root){
        /**
         * per prendere il massimo mi basta visitare i nodi destri finchè non trovo null*/
        if(root == null){
            return null;
        }

        if (root.left != null)
            return min(root.left);

        else return root;
    }

    void inOrder(Node root){
        // se la root non è vuota allora procedo

        /**
         * Essenzialmente chiamo ricorsivamente il metodo passando ogni volta come argomento il nodo
         * (prima) sinistro. il metodo ricorsivo continua a chiamare se stesso fino a che il nodo sinistro passato == null
         * ovvero è il primo nodo da stampare; la funzione quindi torna al chiamante e stampa la root, che corrisponde al primo elemento.
         * dopo aver stampato la root chiamo ricorsivamente il metodo per il sottoalbero destro e cosi via finchè non stampo l'ultimo eleneto a destra.*/
        if (root != null){
            /**
             * per stampare l'albero in ordine devo prima stampare il sottoalbero sinistro
             * partendo dall'ultimo nodo, che corrisponde al primo elemento a sinistra che abbia
             * il node.left == null
             *
             * dopodichè stampo la root
             *
             * infine stampo il sottoalbero destro nello stesso modo precedentemente descritto
             *
             * Utilizzo un metodo ricorsivo per farlo:
             * */

            inOrder(root.left); //chiamo il metodo passando il nodo sinistro
            /**stampo il nodo corrente (che è stato passato dal metodo ricorsivo chiamato precedentemente)*/
            System.out.println(root.key);
            inOrder(root.right);//chiamo il metodo passavo il nodo destro
        }
    }

    /**
     * questo metodo ricorsivo riceve come parametro una chiave e ritorna il nodo qualora fosse
     * presente nell'albero.
     * */
    Node get(int key){
        Node x = root;

        /**
         * continuo ad effettuare il controllo sul nodo X che cambia ad ogni iterazione.
         * continuero quindi ad effettuare il controllo finchè non si verificano queste situazioni:
         *  - il nodo risulta null, quindi esco dal ciclo e ritorno null; non trovo il nodo.
         *  - trovo il nodo e lo ritorno*/
        while (x != null){
            if(key < x.key)
                x = x.left;
            else  if (key > x.key)
                x = x.right;
            else return x;
        }
        return null;
    }






    public Node getRoot(){
        return this.root;
    }

}
