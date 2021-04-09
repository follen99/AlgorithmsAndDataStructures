var tree;

function setup() {
  //createCanvas(400, 400);
  noCanvas();
  
  tree = new Tree();

  tree.addValue(5);
  tree.addValue(3);
  tree.addValue(7);
  tree.addValue(6);

  console.log(tree);

}

function Tree(){
  this.root = null;
}

Tree.prototype.addValue = function(value){
  var n = new Node(value)
  if(this.root == null){
    this.root = n;
  }else{
    this.root.addNode(n);
  }

}

Node.prototype.addNode = function(n){
  if(n.value < this.value){
    if(this.left == null){
      this.left = n;
    }else{
      this.left.addNode(n);
    }
  }else if(n.value > this.value){
    if(this.right == null){
      this.right = n;
    }else{
      this.right.addNode(n);
    }
  }
}

function Node(value){
  this.value = value;
  this.left = null;
  this.right = null;
}



function draw() {
  background(220);
}