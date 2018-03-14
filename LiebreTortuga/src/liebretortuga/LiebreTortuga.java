/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebretortuga;

/**
 *
 * @author Bonoso
 */
public class LiebreTortuga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carrera c = new Carrera();
        Liebre liebre = new Liebre(c);
        Tortuga tortuga = new Tortuga(c);
        liebre.start();                         //Comienza la liebre a correr
        tortuga.start();                        //Comienza la tortuga a correr
    }
    
}