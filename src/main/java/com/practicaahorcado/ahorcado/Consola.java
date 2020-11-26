package com.practicaahorcado.ahorcado;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ulises Benitez Dominguez
 */
public class Consola {
    
    private int intentosRestantes;
    private ArrayList palabraArray;
    private String palabraString;
    
    public Consola(){
        String[] coleccion = {"casa", "arbol", "albaricoque", "bicicleta", "teclado", "tigre", "reloj", "lampara", "cuadro", "vestido", "armario", "ciudad",
            "tejado", "gaviota", "amor", "rascacielos", "yate", "cojin", "monitor", "notificar", "proyecto"};
        
        Random rand = new Random(); 
        int numPalabras = coleccion.length;
        
        int intRandom = rand.nextInt(numPalabras - 1);
        
        palabraString = coleccion[intRandom];
  
        palabraArray = Consola.stringToArray(palabraString);
        
        intentosRestantes = 11;
    }
    
    public boolean intentaLetra(String letra){
        boolean letraCorrecta = false;
        int i = 0;
        while (!letraCorrecta && i < palabraArray.size()) {            
            if (palabraArray.get(i).equals(letra)) {
                letraCorrecta = true;
            }
            i++;
        }
        if(!letraCorrecta) intentosRestantes--;
        return letraCorrecta;
    }
    
    public boolean resolverPalabra(String palabra){
        if(!palabra.equals(this.palabraString)){
            intentosRestantes--;
            return false;
        } else return true;
    }
    
    public static ArrayList stringToArray(String palabra){
        
        ArrayList palabraAr = new ArrayList(); 
  
       
        for (int i = 0; i < palabra.length(); i++) {
            palabraAr.add(String.valueOf(palabra.charAt(i)));      
        }
        
        return palabraAr;
    }
    
    public int getIntentosRestantes(){
        return this.intentosRestantes;
    }
    
    public int getLongitudPalabra(){
        return this.palabraString.length();
    }
    
    public boolean estaResuelto(ArrayList estadoPalabra){
        boolean resuelto = true;
        int i = 0;
        while(resuelto && i < palabraArray.size()) {
            if(!estadoPalabra.get(i).equals(palabraArray.get(i)))
                resuelto = false;
            i++;
        }
        return resuelto;
    }
 
    public ArrayList getPosLetra(String letra){
        ArrayList posiciones = new ArrayList();
        for (int i = 0; i < palabraArray.size(); i++) {
            if (palabraArray.get(i).equals(letra)) {
                posiciones.add(i);
            }
        }
        return posiciones;
    }
}
