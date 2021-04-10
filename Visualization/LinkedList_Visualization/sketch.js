var list;
let defX = 20;
let defY = 20;

let rectSize = 30;

let flag = true;


let removeHeadButton;
let removeEndButton;
let addHeadButton;
let removeHeadButton;
let removeAtRandomButton;
let addAtRandomButton;

function setup() {
  createCanvas(420, 400);

  list = new LinkedList();  //creo la lista

  for(let i=0; i<20; i++){
    list.push(floor(random(0,100)));
    list.get(i).x = defX;
    list.get(i).y = defY;

    defX+=50;
    if(defX >= width){
      defX = 20;
      defY += 75;
    }

    /*if(flag){
      defX+=50;
      if(defX >= 300){
        flag = false;
        defY +=50;
      }
    }else{
      console.log("entro  ");
      defX-=50;
      if(defX <= 50){
        flag = true;
        defY +=50;
      }
    }*/
  }


  /*list.push(20);
  list.get(0).x = 20;
  list.get(0).y = 20;*/
  
  //console.log();
  //list.print(list.head);

  //console.log(list.get(0).next.x);

  //list.removeAt(list.size-1);
}

function draw() {
  background(220);
  for(let i=0; i<list.size; i++){

    let currentObject = list.get(i);

    rect(list.get(i).x,list.get(i).y,rectSize);

    textAlign(CENTER);
    text(currentObject.element,(currentObject.x)+(rectSize/2),(currentObject.y)+(rectSize/2));

    //line(list.get(i).x, list.get(i).y, 40,40 /*list.get(i).next.x, list.get(i).next.x*/);
    strokeWeight(2);
    if(list.get(i).next != null){
      line(currentObject.x+rectSize, currentObject.y+rectSize/2, currentObject.next.x,currentObject.next.y+rectSize/2);
      ellipse(currentObject.next.x,currentObject.next.y+rectSize/2,10);
    }
    
    
  
  }
  /*
  let v0 = createVector(list.get(0).x+rectSize, list.get(0).y+rectSize/2);
  let v1 = createVector(list.get(0).next.x,0);
  drawArrow(v0, v1, 'black');*/
  
}

function drawArrow(base, vec, myColor) {
  push();
  stroke(myColor);
  strokeWeight(2);
  fill(myColor);
  translate(base.x, base.y);
  line(0, 0, vec.x, vec.y);
  rotate(vec.heading());
  let arrowSize = 2;
  translate(vec.mag() - arrowSize, 0);
  triangle(0, arrowSize / 2, 0, -arrowSize / 2, arrowSize, 0);
  pop();
}

