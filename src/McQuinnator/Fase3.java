/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McQuinnator;

import java.util.*;

/**
 *
 * @author esteban
 */
public class Fase3 {
    private final Fase2 fase2AProcesar;

    public Fase3(String funcionK) {
        this.fase2AProcesar = new Fase2(funcionK);
    }

    public Fase2 getFase2AProcesar() {
        return fase2AProcesar;
    }

    @Override
    public String toString() {
        //tengo que recorrer todos los términos primos que posea la fase 2, y pasarlos a binario
        ArrayList <ArrayList<String>> arrayLBinarios = new ArrayList<>();
        for (int i = 0; i < this.fase2AProcesar.getTablaEsenciales().getTerminosPrimosPropios().size(); i++) {
            Termino getTermino = this.fase2AProcesar.getTablaEsenciales().getTerminosPrimosPropios().get(i);
            ArrayList <String> binariosTermino = new ArrayList<>();//creo la lista que poseerá los strings del término
            for (int j = 0; j < getTermino.getNumeros().size(); j++) {
                Integer get = getTermino.getNumeros().get(j);
                String binarioAPasar = Integer.toBinaryString(get);
                for (int k = 0; k < Math.abs(this.fase2AProcesar.getFase1AProcesar().getCantidadBits()-binarioAPasar.length()); k++) {
                    binarioAPasar = "0".concat(binarioAPasar);
                }
                binariosTermino.add(Integer.toBinaryString(get));
            }
            arrayLBinarios.add(binariosTermino);
        }
        for (int i = 0; i < arrayLBinarios.size(); i++) {
            ArrayList <String> getTermino = arrayLBinarios.get(i);
            //ahora tengo que recorrer todos términos de la tabla, revisando los bits que sean diferentes
            //si son iguales, agrego la letra con el negado según corresponda
            char comparador = '0';//este será el que comparará el entero con el anterior
            for (int j = 0; j < getTermino.size(); j++) {
                String getNumerosTermino = getTermino.get(j);
                //ahora ya estoy comparando los números de los términos
                for (int k = 0; k < getNumerosTermino.length(); k++) {
                    char get = getNumerosTermino.charAt(k);
                    if(get != comparador && k != 0){
                        comparador = 0;
                    }
                }
            }
        }
        return "Fase3{" + "fase2AProcesar=" + fase2AProcesar + '}';
    }

    public String funcionResultante(){
        return "";
    }
}
