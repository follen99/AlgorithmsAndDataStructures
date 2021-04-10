
/**
 * Supponiamo di voler inserirre un elemento nella lista;
 * il posto piu semplice per fare questa operazione è la testa.
 * per fare questa operazione ci bastera creare un nuovo nodo e 
 * collegarlo al 'primo' nodo precedente.
 */

 function Node(){
    this.item = null;
    this.next = null;
  };
  /**
   * 
   * @param {Node} firstNode //first node
   */
  /*
  function printList(firstNode){
    var node = firstNode
    while(node.next!=null){
      console.log(node.item);
      node = node.next;
    }
  }*/
  
  
  /**
   * 
   * @param {Node} node (first node where to start)
   * @returns recursice function
   * 
   * La funzione come prima cosa stampa l'elemento corrente (che deve SEMPRE essere stampato)
   * dopo controlla se il nodo corrente ha un nodo successivo
   *  se non ha un successivo ritorna al chiamante
   *  se ha un successivo chiama se stessa con il nodo successivo
   */
  function printList(node){
    console.log(node.item);
    if(node.next == null){
      return;
    }
    return printList(node.next);
  }
  
  
  /**
   * 
   * @param {Node} node to insert
   */
  function insertHead(node){
    var oldFirst 
  }