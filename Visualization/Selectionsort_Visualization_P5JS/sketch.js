let values = [];    //gli elementi che disegnerò sul canvas

let i=0;

let button;
let speed = 1;

let reset;

let rectangleWidth = 10;


function setup() {
  createCanvas(400, 300);  //finestra dove disegno gli elementi
  
  values = new Array(floor(width/rectangleWidth));
  randomize();
  
  
  stroke(255);
  button = createButton("Change speed");
  button.mousePressed(changeSpeed);
  
  
  reset = createButton("Reset");
  reset.mousePressed(resetArray);
  
  //bubbleSort();
  //selectionSort();
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

function swap(arr, i, j){
  temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}


function selectionSort(){
  for(var i = 0; i<values.length; i++){
    var min = i;    //indice dell'elemento minimo
    for(var j = i+1; j<values.length; j++){
      if(values[j]<values[min]){
        min = j;
      }
      swap(values, i, min);     //effettuo lo scambio per ogni loop interno
    }
  }
}

function draw() {
  background(0);  //sfondo nero
  /*
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
  i++;*/

  for(let f=0; f<speed; f++){
    if(i<values.length){
      var min = i;
      for(var j = i+1; j<values.length; j++){
        if(values[j] < values[min]){
          min = j;
        }
        swap(values, i, min);
      }
    }
    i++;
  }
  
  
  
  stroke(255);
  for(let i = 0; i < values.length; i++){
    //line(i,height,i,height-values[i]);
    stroke(0);
    fill(255);
    rect(i*rectangleWidth , height-values[i], rectangleWidth, values[i]);
  }
}