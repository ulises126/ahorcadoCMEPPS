package com.practicaahorcado.ahorcado;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ulises Benitez Dominguez
 */
public class Interfaz {
    private Consola consola;
    private ArrayList letrasUsadas;
    private ArrayList estadoPalabra;
    
    public Interfaz(){}
    
    public void comenzarPartida(){
        boolean salir = false;
        boolean resuelto = false;
        consola = new Consola();
        letrasUsadas = new ArrayList();
        estadoPalabra = new ArrayList();
        
        for (int i = 0; i < consola.getLongitudPalabra(); i++) {
            estadoPalabra.add("*");
        }
        
        while(!resuelto && consola.getIntentosRestantes() > 0 && !salir){
            muestraInfo();
            if(consola.estaResuelto(estadoPalabra)){
                resuelto = true;
                System.out.println("¡¡¡GANADOR!!!");
            } else {
                System.out.println("Introduzca una letra. Para resolver introduzca 'resuelvo'. Para salir del juego introduzca 'salir'.");
                
                Scanner sc = new Scanner(System.in);
                String entrada = sc.nextLine();
                
                switch(entrada){
                    case "salir":
                        salir = true;
                        break;
                        
                    case "resuelvo":
                        System.out.println("Introduzca palabra:");
                        entrada = sc.nextLine();
                        if (consola.resolverPalabra(entrada)) {
                            System.out.println("¡¡¡GANADOR!!!");
                            resuelto = true;
                        } else {
                            System.out.println("Palabra incorrecta...");
                        }
                        break;
                        
                    default:
                        if (entrada.length() > 1 || entrada.length() < 0) {
                            System.out.println("ERROR: entrada incorrecta...");
                        } else {
                            if (letrasUsadas.contains(entrada)) {
                                System.out.println("Esa letra ya ha sido usada...");
                            } else {
                                letrasUsadas.add(entrada);
                                if (consola.intentaLetra(entrada)) {
                                    System.out.println("Letra correcta!!");
                                    //actualiza estado palabra
                                    actualizaPalabra(consola.getPosLetra(entrada), entrada);
                                } else {
                                    System.out.println("Letra incorrecta...");
                                }
                            }
                        }
                }
            }
        }
        System.out.println("JUEGO TERMINADO");
    }
    
    public void actualizaPalabra(ArrayList posiciones, String letra){
        for (int i = 0; i < posiciones.size(); i++) {
            estadoPalabra.set((int)posiciones.get(i), letra);
        }
    }
    
    public void muestraInfo(){
        System.out.println("------------------------------------------------------------------------");
        System.out.print("--- ");
        for (int i = 0; i < estadoPalabra.size(); i++) {
            System.out.print(estadoPalabra.get(i) + " ");
        }
        System.out.print(" ---");
        System.out.println("");
        System.out.print("--- ");
        for (int i = 0; i < estadoPalabra.size(); i++) {
            System.out.print("_ ");
        }
        System.out.print(" ---");
        System.out.println("");
        System.out.println("");
        System.out.print("LETRAS USADAS: ");
        for (int i = 0; i < letrasUsadas.size(); i++) {
            System.out.print(letrasUsadas.get(i) + " ");
        }
        System.out.println("");
        System.out.println("INTENTOS RESTANTES: " + consola.getIntentosRestantes());
        System.out.println("------------------------------------------------------------------------");
        
    }
}
