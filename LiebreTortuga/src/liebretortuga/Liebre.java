/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebretortuga;

/**
 * Clase que calcula el movimiento de la liebre cada turno
 * @author Bonoso
 */

public class Liebre extends Thread{
    private final Carrera carrera; 
    public Liebre(Carrera c){
        carrera = c;
    }
    
    /**
     * Método que se encarga de obtener la posición de la liebre cada turno
     */    
    @Override
    public void run(){
        int posicion = 1;
        int prob;
        while (posicion < 70){
            prob = (int) (Math.random()*10) + 1;
            
            if (prob < 3){
            }
            else    if (prob < 5){
                posicion += 9;
            }
            else    if (prob < 6){
                posicion -= 12; 
            }
            else    if (prob < 9){
                posicion ++;
            }
            else{
                posicion -= 2;
            }
            
            if (posicion < 1){
                posicion = 1;
            }
            carrera.CarreraLiebre(posicion);
        }
    }
}
