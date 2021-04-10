//var linkedList;

function setup() {
  //createCanvas(400, 400);
  noCanvas();

  //var node1 = new Node();

  
  
  var node1= new Node();
  var node2= new Node();
  var node3= new Node();
  var node4= new Node();

  node1.item = "1";
  node2.item = "2";
  node3.item = "3";
  node4.item = "4";

  node1.next=node2;
  node2.next=node3;
  node3.next=node4;


  //console.log(node1);

  printList(node1);
  
}


/*function draw() {
  background(220);
}*/
