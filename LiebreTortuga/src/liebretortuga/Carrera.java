/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebretortuga;

/**
 * Clase que se encarga de sincronizar a liebre y tortuga.
 * Además también imprime por pantalla el progreso de la carrera.
 * @author Bonoso
 */
public class Carrera {
    private int posicionLiebre;
    private int posicionTortuga;
    private boolean disponible;
    
    /**
     * Constructor de la clase carrera
     */
    public Carrera(){
        posicionLiebre=1;
        posicionTortuga=1;
    }
    
    public void SetPosLiebre(int posi){
        
        
    }
    
    public void SetPosTortuga(int posi){
        
    }
    /**
     * Método sincronizado que se encarga de realizar el movimiento
     * de la liebre. Cuando ésta termina de moverse cede el turno a
     * la tortuga.
     * @param posi 
     */
    public synchronized void CarreraLiebre(int posi){
        if (this.HasTerminado()==false){
            while (disponible == false ){
               try {
                   wait();
               } catch (InterruptedException e) {}
          }
          this.HasTerminado();
          posicionLiebre= posi;
          disponible = false;
          notify();
       }
        else posicionLiebre = 70;
    }
    /**
     * Método sincronizado que se encarga de realizar el movimiento
     * de la tortuga. Cuando ésta termina de moverse cede el turno 
     * a la liebre.
     * @param posi 
     */
    public synchronized void CarreraTortuga(int posi){
        if (this.HasTerminado()==false){
            while (disponible == true ) {
               try {
                   wait();
               } catch (InterruptedException e) {}
          }
          posicionTortuga= posi;  
          this.Recorrido();
          disponible = true;
          notify();
        }
        else posicionTortuga = 70;
    }
    
    /**
     * Método que se encarga de mostrar el resultado de la carrera cada turno
     */
    public void Recorrido(){
        for (int i = 0; i < posicionLiebre; i++){
            System.out.print(" ");
        }
        System.out.println("L");
        for (int i = 0; i < posicionTortuga; i++){
            System.out.print(" ");
        }
        System.out.println("T");
        System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]");
    }
    
    /**
     * Método que se encarga de comprobar si uno de los participantes ha llegado
     * a la meta.
     * @return 
     */
    public boolean HasTerminado(){
        boolean terminado = false;
        if(posicionLiebre >= 70 || posicionTortuga >= 70){
            terminado = true;
        }
        return terminado;
    }
}
