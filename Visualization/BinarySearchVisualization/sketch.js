var tree;

function setup() {
  createCanvas(600, 400);
  background(51);
  //noCanvas();
  
  tree = new Tree();

  /*tree.addValue(5);
  tree.addValue(3);
  tree.addValue(7);
  tree.addValue(6);*/

  for (let i = 0; i < 10; i++) {
    tree.addValue(floor(random(0,100)));
  }

  console.log(tree);

  tree.traverse();


}







/*function draw() {
  background(220);
}*/