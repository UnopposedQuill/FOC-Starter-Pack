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
public class Tabla {
    
    private ArrayList <Nivel> niveles;

    public Tabla(ArrayList<Nivel> niveles) {
        this.niveles = niveles;
    }

    public ArrayList<Nivel> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<Nivel> niveles) {
        this.niveles = niveles;
    }
    
    public boolean isEmpty(){
        return isEmpty_Aux(0);
    }
    
    public boolean isEmpty_Aux(int i){
        if(i >= this.niveles.size()){
            return true;
        }
        else{
            return (this.niveles.get(i).isEmpty() && isEmpty_Aux(i+1));
        }
    }

    @Override
    public String toString() {
        String salida = "Tabla:  \n";
        for (int i = 0; i < niveles.size(); i++) {
            Nivel get = niveles.get(i);
            salida = salida + get.toString();
        }
        return salida + "\n";
    }
}
