function MinHeap(){
    this.data = [];         //l'array dove verranno salvati i valori
}

MinHeap.prototype.insert = function(value){
    this.data.push(value);      //aggiungo il valore
    this.bubbleUp(this.data.length - 1);    //chiamo la funzione bubbleup che parte dall'ultimo elemento aggiunto
}

MinHeap.prototype.bubbleUp = function(index){

    //finchè l'indice è maggiore di zero, ovvero non corrisponde a root 
    while(index > 0){
        var parent = Math.floor((index + 1)/2) -1;  //se ho l'elemento K, allora il suo genitore si troverà a K/2

        //se il valore del padre è maggiore del figlio
        if(this.data[parent] > this.data[index]){
            //scambio i due valori
            var temp = this.data[parent];
            this.data[parent] = this.data[index];
            this.data[index] = temp;
        }

        index = parent;     
        /**
         * non ricorsione ma quasi; ritorno al while ma questa volta controllo il nodo
         * genitore; continuo in questo modo fino ad arrivare ad index (o parent) < 0
         * non ne sono sicuro ma si potrebbe ottimizzare ancora di piu
         * mettendo un else{ return; } dopo l'if
         */
    }
}

MinHeap.prototype.bubbleDown = function(index){
    while(true){
        var child = (index + 1) * 2;    //trovo il nodo figlio dato che se ho K allora K*2 = figlio1 e (K*2) + 1 = figlio2
        var sibling = (child -1);

        var toSwap = null;

        //se il valore del nodo corrente (index) è maggiore del valore del figlio
        if(this.data[index] > this.data[child]){
            toSwap = child;     //allora scambio il figlio.
        }

        //se il figlio2 è piu piccolo del figlio e piu piccolo del nodo corrente
        if(this.data[index] > this.data[sibling] && (this.data[child] == null || (this.data[child] !== null && this.data[sibling] < this.data[child]))){
            toSwap = sibling;   //scambio il figlio2
        }

        if(toSwap == null){
            break;  //se arrivo a questo punto e non sono entrato in nessuno degli if allora ritorno;
        }

        var temp = this.data[toSwap];
        this.data[toSwap] = this.data[index];
        this.data[index] = temp;

        index = toSwap;     //stessa idea della funzione bubbleUp
    }
}

MinHeap.prototype.delMin = function(){
    var min = this.data[0];     //il primo elemento è sempre il piu piccolo
    
    /**
     * assegno il valore dell'ultimo elemento al primo effettuando
     * il pop dell'ultimo elemento
     */
    this.data[0] = this.data.pop(); 

    //chiamo bubbleDown sul primo elemento in modo da riordinare il tutto
    this.bubbleDown(0);

    /**
     * essenzialmente ritorno il primo elemento
     * ma la parte importante di questa funzione è
     * l'eliminazione del minimo stesso e la riordinazione di tutti
     * gli elementi
     * La funzione getMin() potrebbe essere implementata banalmente
     * ritornando il primo elemento dell'array.
     */
    return min; 
}

var heap = new MinHeap();
/*heap.insert(2);
heap.insert(1);
heap.insert(3);*/

for(let i = 0; i < 100; i++){
    heap.insert(Math.random() * (500 - 0) + 0);
}

console.log(heap.delMin());
console.log(heap.delMin());
console.log(heap.delMin());
console.log(heap.delMin());


