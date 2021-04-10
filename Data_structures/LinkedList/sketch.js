function setup() {
  //createCanvas(400, 400);
  noCanvas();
  var node1= new Node();
  var node2= new Node();

  node1.item = "1";
  node2.item = "2";

  node1.next=node2;

  console.log(node1);
}


function Node(){
  this.item = null;
  this.next = null;
};

/*function draw() {
  background(220);
}*/
