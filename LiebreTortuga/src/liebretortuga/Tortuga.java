/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebretortuga;

/**
 * Clase que calcula el movimiento de la tortuga cada turno
 * @author Bonoso
 */
public class Tortuga extends Thread{
    private final Carrera carrera;
    public Tortuga(Carrera c){
        carrera = c;
    }
    
    /**
     * Método que se encarga de obtener la posición de la tortuga cada turno
     */
    @Override
    public void run(){
        int posicion = 1;
        int prob;
        while (posicion < 70){
            prob = (int) (Math.random()*10) + 1;
            
            if (prob < 6){
                posicion += 3;
            }
            else    if (prob < 8){
                posicion -= 6;
            }
            else{
                posicion ++;
            }
            
            if (posicion < 1){
                posicion = 1;
            }
            carrera.CarreraTortuga(posicion);
        }
    }
}

