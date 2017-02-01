/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McQuinnator;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Nivel {
    
    private ArrayList <Termino> terminos;

    public Nivel(ArrayList<Termino> terminos) {
        this.terminos = terminos;
    }

    public ArrayList<Termino> getTerminos() {
        return terminos;
    }

    public void setTerminos(ArrayList<Termino> terminos) {
        this.terminos = terminos;
    }
    
    public int cantidadTerminos(){
        return terminos.size();
    }
    
    public boolean isEmpty(){
        return (this.terminos == null || this.terminos.isEmpty());
    }

    @Override
    public String toString() {
        String salida = "---------------------------------------------------------------------------------\nNivel: \n";
        for (int i = 0; i < terminos.size(); i++) {
            Termino get = terminos.get(i);
            salida = salida + get.toString() + "\n";
        }
        return salida;
    }
}
