var list;

function setup() {
  createCanvas(400, 400);

  list = new LinkedList();  //creo la lista

  for(let i=0; i<10; i++){
    list.push(floor(random(0,100)));
  }
  
  list.print(list.head);
}

function draw() {
  background(220);
}

