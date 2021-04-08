import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class BubbleSortVisualization extends PApplet {

float[] values;

int i,j = 0;

public void setup(){
  
  //fullScreen();
  values = new float[width];
  
  /**
  *  riempio l'array con dei valori random che vanno da 0 a heigth, ovvero 600
  */
  for(int i = 0; i < values.length; i++){
    values[i] = random(height);
  }
  
  //bubbleSort(); funzionante
}

/**
*la funzione bubbleSort ordina in ordine crescente i valori.
*non è perfetta, dovrebbe accettare un array come argomento invece di usare
*quello globale.
*/

public void bubbleSort(){
  for(int i=0; i<values.length; i++){
    for(int j=0; j<values.length-i-1; j++){
      if(values[j]>values[j+1]){
        swap(values, j, j+1);
      }
    }
  }
}

/**
*la funzione swap scambia nell'array i due indici i e j
*/
public void swap(float[] arr, int i, int j){
  float temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

public void draw(){
  background(0);
  
  /*
  //eseguire il controllo una volta per ogni frame
  if(values[j]>values[j+1]){
        swap(values, j, j+1);
  }*/
  
  /**
  *  essenzialmente sto costruendo le condizioni
  *  del loop for nella funzione draw()
  */
  if(i < values.length){
    for(int j = 0; j<values.length-i-1; j++){
      if(values[j]>values[j+1]){
        stroke(150);
        swap(values, j, j+1);
      }
    }
    /*j+=1;
    if(j >= values.length-i-1){
      j=0;
      i+=1;
    }*/
  }else{
    //se ho ordinato smetto di aggiornare il canvas
    println("Ordinamento completato");
    noLoop();
  }
  
  
  
  
  for(int i = 0; i<values.length; i++){
    stroke(255);
    //disegno una linea dalla posizione i alla base (height)
    //fino all'opportuna lunghezza rappresentata dal valore nell'array.
    line(i,height,i,height - values[i]);
  }
}
  public void settings() {  size(400,300); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BubbleSortVisualization" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
