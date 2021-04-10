class LinkedList {
    size = 0;
    head = null;
  
    get isEmpty() {
      return this.size === 0;
    }
  
    createNode(element) {
      return {element, next: null}
    }
  
  
    push(element) {
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

    toString() {
      if (!this.size) return "";
  
      let str = `${this.head.element}`;
      let current = this.head;
      
      for(let i=0; i < this.size - 1; i++) {
        current = current.next;
        str += `,${current.element}`;
      }
      
      return str;
    }

    print(node){
      console.log(node.element);
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
    insert(element, index = 0){
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
    

    get(index){
      if(index === undefined || index <0 || index > this.size) return  null;
      if(index == 0) return this.head.element;  //ritorno l'elemento e non l'oggetto

      let current = this.head;

      for(let i=0; i<index; i++){
        current = current.next;
      }

      return current.element;
    }

    indexOf(element){
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
  }

  const list = new LinkedList();

  list.push(12);
  list.push(2);
  list.push(20);
  list.push(1);
  list.push(10);

  //list.insert(50);

  //console.log(list.toString());
  //list.print(list.head);
  
  
  /*console.log(list.get(0));
  console.log(list.get(1));
  console.log(list.get(2));*/

  console.log(list.indexOf(20));
