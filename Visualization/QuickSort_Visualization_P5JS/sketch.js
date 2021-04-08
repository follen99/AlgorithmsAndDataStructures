let values = [];    //gli elementi che disegnerò sul canvas

let i=0;
let w=3;

let slider;

let button;



function setup() {
  createCanvas(800, 300);  //finestra dove disegno gli elementi
  
  values = new Array(floor(width/w));
  randomize();

  

  stroke(255);
  slider = createSlider(0,300,5);
  button = createButton("reset");
  button.mousePressed(resetArray);
  //bubbleSort();
  quickSort(values, 0, values.length -1);

}
function resetArray(){
  i=0;
  randomize();

  quickSort(values, 0, values.length -1);
}
function randomize(){
  for(let i = 0; i<values.length; i++){
    values[i] = random(height);    //inizializzo ogni elemento dell'array
  }
}

async function quickSort(arr, start, end){
  if(start >= end){
    return;
  }

  let index = await partition(arr, start, end);
  await Promise.all([quickSort(arr, start, index -1),quickSort(arr, index+1 , end)]);
  //RICORSIONE
  /*await quickSort(arr, start, index -1);        //eseguo la partizione per la parte sinistra
  await quickSort(arr, index+1 , end);          //eseguo la partizione per la parte destra
  */
}

/**
 * ci sono diversi tipi di approccio per la funzione partition()
 * La funzione che segue utilizza lo schema 'Lomuto'
 * Un altro metodo è rappresentato dal metodo di 'Hoare' (studiato nel corso di ASD)
 * che consiste nell'inizializzare i due indici alle due estremità, i due indici si muovono 
 * verso il centro finchè un' 'inversione' viene trovata. Un'inversione è definita nel seguente modo:
 * "Un valore piu piccolo sul lato sinistro ed un valore piu grande sul lato destro".
 * Quando un'inversione viene trovata, i due valori vengono scambiati ed il processo viene ripetuto.
 */

/**
 * 9 3 4 6 5
 * pivot = 5
 * iteriamo per ogni elemento dell'array: i=0 -> end-1
 * confrontiamo ogni elemento dell'array con 5 e devo tenere traccia anche dell'indice.
 * index = 0, pivot = 5
 * 9<5 ? NO
 * if( arr[i] < pivot) NO -> noop
 * 3<5 ? SI -> SWAP (i,index) -> index++
 * Alla fine scambio l'ultimo indice con il pivot
 * 
 * otteniamo che il pivot si trova al centro dell'array (idealmente) ed ogni elemento
 * piu piccolo è alla sua sinistra, mentre ogni elemento piu grande è alla sua destra.
 */
async function partition(arr, start, end){
  let pivotIndex = start;
  let pivotValue = arr[end];

  for(let i = start; i< end; i++){
    if(arr[i]< pivotValue){
      await swap(arr,i, pivotIndex);
      pivotIndex ++;
    }
  }

  await swap(arr, pivotIndex, end);
  
  return pivotIndex;
}
async function swap(arr, i, j){
  await sleep(Math.floor(slider.value()));

  temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}
/**
 * 
 * @param {int} ms to wait
 */
function sleep(ms){
  return new Promise(resolve => setTimeout(resolve, ms));
}

function draw() {
  background(51);  //sfondo 
  textSize(32);

  for(let i = 0; i < values.length; i++){
    stroke(0);
    fill(255);
    //line(i,height,i,height-values[i]);
    rect(i*w , height-values[i], w, values[i]);
  }
}