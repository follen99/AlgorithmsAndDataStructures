function LinkedList(){
    this.size = 0;
    this.head = null;
}

LinkedList.prototype.createNode = function(element){
    return {element, next: null, x: null, y: null}
}

LinkedList.prototype.push = function(element){
    const node = this.createNode(element);

    if (!this.head) {
        this.head = node;
      } else {
        let current = this.head;

        while(current.next != null){
          current = current.next;
        }
        current.next = node;
      }
  
      this.size += 1;
      return this.size;
}

LinkedList.prototype.removeAt = function(index){
    var curr, prev, it = 0;
    curr = this.head;
    prev = curr;

    // deleting first element
    if (index === 0) {
        this.head = curr.next;
    } else {
        // iterate over the list to the
        // position to removce an element
        while (it < index) {
            it++;
            prev = curr;
            curr = curr.next;
        }

        // remove the element
        prev.next = curr.next;
    }
    this.size--;

    // return the remove element
    return curr.element;
}

LinkedList.prototype.toString = function(){
    if (!this.size) return "";
  
      let str = `${this.head.element}`;
      let current = this.head;
      
      for(let i=0; i < this.size - 1; i++) {
        current = current.next;
        str += `,${current.element}`;
      }
      
      return str;
}

LinkedList.prototype.print = function(node){
    let string = "";
    string += "Valore Nodo: "+node.element+"\n";
    if(node.next!=null){
        string += "Nodo successivo (valore): "+node.next.element+"\n";
    }else{
        string += "Ultimo nodo."
    }
    string += "X: "+node.x+" Y: "+node.y;

    console.log(string);
    
      if(node.next == null){
        return;
      }
      return this.print(node.next);  
}

/**
     * 
     * @param {Node} element 
     * @param {Int} index (default is 0)
     * la funzione inserisce un elemento ad un indice preciso, se l'indice non viene specificato
     * l'elemento viene inserito di default alla posizione head
*/
LinkedList.prototype.insert = function(element, index = 0){
    if(index < 0 || index > this.size) return false;

    const node = this.createNode(element);  // creo un nuovo oggetto nodo
    
    //caso in cui l'inserzione è in testa
    if(index === 0){
      //this.push(element); inserisce l'elemento nell'ultima posizione
      node.next = this.head;  //faccio puntare il prossimo elemento del nuovo elemento alla 'vecchia' testa della lista
      this.head = node;       //aggiorno la lista 
    }else{
      let previous = this.head; //se non entro nel loop

      for(let i=0; i<index -1; i++){
        previous = previous.next;
      }

      node.next = previous.next;
      previous.next = node;
    }

    this.size +=1; //inserisco quindi aumento il size
    return true;  //ritorno true quando l'operazione va a buon fine.
}

LinkedList.prototype.get = function(index){
    if(index === undefined || index <0 || index > this.size) return  null;
      if(index == 0) return this.head;  //ritorno l'elemento e non l'oggetto

      let current = this.head;

      for(let i=0; i<index; i++){
        current = current.next;
      }

      return current;
}

/*
COMPLETAMENTE INUTILE!
LinkedList.prototype.setXY = function(index, x, y){
    if(index === undefined || index <0 || index > this.size) return  null;
      if(index == 0){
        this.head.x = x;
        this.head.y = y;
      }

      let current = this.head;

      for(let i=0; i<index; i++){
        current = current.next;
      }

      current.x = x;
      current.y = y;
}*/

LinkedList.prototype.indexOf = function(element){
    let current = this.head;
      if(this.head.element === element) return 0;

      for(let i=0; i<this.size; i++){
        if(current.element === element){
          return i;
        }
        current = current.next;
      }
      return null;
}