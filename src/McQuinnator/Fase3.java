/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McQuinnator;

import java.util.*;

/**
 * Esta clase contiene los datos necesarios para poder calcular la información
 * de la tercera fase del algoritmo de Quine McCluskey.
 * @author esteban
 */
public class Fase3 {
    private final Fase2 fase2AProcesar;

    //∑7:(0,1,2,3,16,17,18,19,32,33,34,35,44,45,46,47,60,61,62,63,71,81,83,108,109,110,111,116,117,124,125,126,127)
    public Fase3(String funcionK) {
        this.fase2AProcesar = new Fase2(funcionK);
    }

    public Fase2 getFase2AProcesar() {
        return fase2AProcesar;
    }

    @Override
    public String toString() {
        //tengo que recorrer todos los términos primos que posea la fase 2, y pasarlos a binario
        String resultado = "Fase 3:",
               funcionResultante = "F = ",
               letrasPorTermino;
        //tengo que recorrer todos los términos propios que quedaron al final de la segunda fase
        for (int i = 0; i < this.fase2AProcesar.getTablaEsenciales().getTerminosPrimosPropios().size(); i++) {
            Termino getTermino = this.fase2AProcesar.getTablaEsenciales().getTerminosPrimosPropios().get(i);
            String terminoEnBinario = Integer.toBinaryString(getTermino.getNumeros().get(0));
            letrasPorTermino = "";
            //si dio una string más pequeña de lo que necesito, tengo que rellenar con ceros a la izquierda
            while(terminoEnBinario.length() < this.fase2AProcesar.getFase1AProcesar().getCantidadBits()){
                terminoEnBinario = "0".concat(terminoEnBinario);
            }
            resultado = resultado.concat("\nTérmino: " + getTermino.numerosAString() + "\n");
            //necesito este booleano para saber si los valores del mismo bit son diferentes
            //en caso de serlo, no coloco la variable
            boolean diferente;
            
            for (int j = 0; j < this.fase2AProcesar.getFase1AProcesar().getCantidadBits(); j++) {
                diferente = false;
                String letraAAgregar = String.valueOf((char) ('A' + j));
                if(terminoEnBinario.charAt(j) == '0'){
                    letraAAgregar = letraAAgregar.concat("'");
                }
                for (int k = 1; k < getTermino.getNumeros().size() && !diferente; k++) {
                    Integer getNumero = getTermino.getNumeros().get(k);
                    String terminoEnBinarioComparador = Integer.toBinaryString(getNumero);
                    //si dio una string más pequeña de lo que necesito, tengo que rellenar con ceros a la izquierda
                    while(terminoEnBinarioComparador.length() < this.fase2AProcesar.getFase1AProcesar().getCantidadBits()){
                        terminoEnBinarioComparador = "0".concat(terminoEnBinarioComparador);
                    }
                    
                    if(terminoEnBinario.charAt(j) != terminoEnBinarioComparador.charAt(j)){
                        diferente = true;
                    }
                }
                if(!diferente){
                    funcionResultante = funcionResultante.concat(letraAAgregar);
                    letrasPorTermino = letrasPorTermino.concat(letraAAgregar);
                }
                else{
                    letrasPorTermino = letrasPorTermino.concat("X");
                }
            }
            for (Integer numero : getTermino.getNumeros()) {
                String numeroBinario = Integer.toBinaryString(numero);
                while(numeroBinario.length() < this.fase2AProcesar.getFase1AProcesar().getCantidadBits()){
                    numeroBinario = "0".concat(numeroBinario);
                }
                resultado = resultado.concat(numeroBinario + "\n");
            }
            
            funcionResultante = funcionResultante.concat("+");
            for (int j = 0; j < 3 * this.fase2AProcesar.getFase1AProcesar().getCantidadBits(); j++) {
                resultado = resultado.concat("-");
            }
            resultado = resultado.concat("\n" + letrasPorTermino + "\n");
        }
        
        
        return resultado.concat("\nFunción Resultante:\n" + funcionResultante.substring(0, funcionResultante.length()-1));
    }

    public String funcionResultante(){
        String resultado = "F = ";
        
        //tengo que recorrer todos los términos propios que quedaron al final de la segunda fase
        for (int i = 0; i < this.fase2AProcesar.getTablaEsenciales().getTerminosPrimosPropios().size(); i++) {
            Termino getTermino = this.fase2AProcesar.getTablaEsenciales().getTerminosPrimosPropios().get(i);
            String terminoEnBinario = Integer.toBinaryString(getTermino.getNumeros().get(0));
            
            //si dio una string más pequeña de lo que necesito, tengo que rellenar con ceros a la izquierda
            while(terminoEnBinario.length() < this.fase2AProcesar.getFase1AProcesar().getCantidadBits()){
                terminoEnBinario = "0".concat(terminoEnBinario);
            }
            //necesito este booleano para saber si los valores del mismo bit son diferentes
            //en caso de serlo, no coloco la variable
            boolean diferente;
            
            for (int j = 0; j < this.fase2AProcesar.getFase1AProcesar().getCantidadBits(); j++) {
                diferente = false;
                String letraAAgregar = String.valueOf((char) ('A' + j));
                if(terminoEnBinario.charAt(j) == '0'){
                    letraAAgregar = letraAAgregar.concat("'");
                }
                for (int k = 1; k < getTermino.getNumeros().size() && !diferente; k++) {
                    Integer getNumero = getTermino.getNumeros().get(k);
                    String terminoEnBinarioComparador = Integer.toBinaryString(getNumero);
                    
                    //si dio una string más pequeña de lo que necesito, tengo que rellenar con ceros a la izquierda
                    while(terminoEnBinarioComparador.length() < this.fase2AProcesar.getFase1AProcesar().getCantidadBits()){
                        terminoEnBinarioComparador = "0".concat(terminoEnBinarioComparador);
                    }
                    if(terminoEnBinario.charAt(j) != terminoEnBinarioComparador.charAt(j)){
                        diferente = true;
                    }
                }
                if(!diferente){
                    resultado = resultado.concat(letraAAgregar);
                }
            }
            resultado = resultado.concat("+");
        }
        return resultado.substring(0, resultado.length()-1);
    }
}