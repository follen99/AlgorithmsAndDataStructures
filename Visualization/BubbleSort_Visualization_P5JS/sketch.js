let values = [];    //gli elementi che disegnerò sul canvas

let i=0;
let j=0;

let button;
let speed = 1;

let reset;


function setup() {
  createCanvas(400, 300);  //finestra dove disegno gli elementi
  
  values = new Array(width);
  randomize();
  
  
  stroke(255);
  button = createButton("Change speed");
  button.mousePressed(changeSpeed);
  
  
  reset = createButton("Reset");
  reset.mousePressed(resetArray);
  
  //bubbleSort();
}
function resetArray(){
  i=0;
  j=0;
  
  randomize();
}

function randomize(){
  for(let i = 0; i<values.length; i++){
    values[i] = random(height);    //inizializzo ogni elemento dell'array
  }
}

function changeSpeed(){
  if(speed < 3){
     speed ++;
   } else {
     speed = 0;
   }
}

function bubbleSort(){
  for(let i=0; i<values.length; i++){
    for(let j=0; j<values.length-i-1; j++){
      if(values[j]>values[j+1]){
        swap(values, j, j+1);
      }
    }
  }
}
function swap(arr, i, j){
  temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

function draw() {
  background(0);  //sfondo nero
  
  for(let f=0; f<speed; f++){
    if(i<values.length){
     for(let j=0; j<values.length-i-1;j++){
       if(values[j]>values[j+1]){
        swap(values, j, j+1);
      }
     }
    } else {
      console.log("Finito");
      //noLoop();
    }
  }
  i++;
  
  
  stroke(255);
  for(let i = 0; i < values.length; i++){
    line(i,height,i,height-values[i]);
  }
}