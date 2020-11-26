package com.practicaahorcado.ahorcado;

import java.util.Random;

/**
 *
 * @author Ulises Benitez Dominguez
 */
public class Consola {
    
    private final int intentosRestantes;
    private final char[] palabraArray;
    private final String palabraString;
    
    public Consola(){
        String[] coleccion = {"casa", "arbol", "albaricoque", "bicicleta", "teclado", "tigre", "reloj", "lampara", "cuadro", "vestido", "armario", "ciudad",
            "tejado", "gaviota"};
        
        Random rand = new Random(); //instance of random class
        int numPalabras = coleccion.length;
        //generate random values from 0-lenght
        int intRandom = rand.nextInt(numPalabras - 1);
        
        palabraString = coleccion[intRandom];
  
        // Creating array of string length 
        palabraArray = new char[palabraString.length()]; 
  
        // Copy character by character into array 
        for (int i = 0; i < palabraString.length(); i++) { 
            palabraArray[i] = palabraString.charAt(i); 
        }
        
        intentosRestantes = 11;
    }
    
    public boolean intentaLetra(char letra){
        boolean letraCorrecta = false;
        int i = 0;
        while (!letraCorrecta && i < palabraArray.length) {            
            if (palabraArray[i] == letra) {
                letraCorrecta = true;
            }
        }
        return letraCorrecta;
    }
    
    public boolean resolverPalabra(String palabra){
        
    }
}
