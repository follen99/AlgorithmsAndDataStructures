function Tree(){
    this.root = null;
  }

  Tree.prototype.traverse = function(){
    this.root.visit();
  }
  
  Tree.prototype.addValue = function(value){
    var n = new Node(value)
    if(this.root == null){
      this.root = n;
    }else{
      this.root.addNode(n);
    }
  }

  Tree.prototype.searchValue = function(toFind){
      var found = this.root.search(toFind);

      return found;
      /*if(found!= null){
          console.log("Trovato! ");
          confirm.log(found);
      }else{
          console.log("Non trovato ! :/");
      }*/
  }
  
 