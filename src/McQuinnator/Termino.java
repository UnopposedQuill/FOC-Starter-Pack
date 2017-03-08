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
public class Termino {
 
    private ArrayList <Integer> numeros;
    private String diferencia;
    private boolean equisado;

    public Termino(ArrayList<Integer> numeros, String diferencia) {
        this.numeros = numeros;
        this.diferencia = diferencia;
        this.equisado = false;
    }
    
    /**
     * Este constructor sólo podrá usarse para los términos de la primera tabla, a partir de ese entonces se vuelve inútil
     * @param numeroTermino Número que contendrá el término, este término lo contendrá por el resto de su vida
     */
    public Termino(int numeroTermino){
        
        this.numeros = new ArrayList<>();
        this.numeros.add(numeroTermino);
        this.diferencia = "";
        this.equisado = false;
    }
    
    /**
     * Este método retorna todos los números que pertenecen al término dentro de un ArrayList
     * @return Un ArrayList conteniendo todos los números del término
     */
    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    public String getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(String diferencia) {
        this.diferencia = diferencia;
    }
    
    /**
     * Este método lo que hace es que averigua si un término no tiene números, osea que si es nulo
     * @return Si la lista de números es nula o está vacía
     */
    public boolean isEmpty(){
        return (this.numeros == null || this.numeros.isEmpty());
    }
    
    /**
     * Este método lo que hace es que averigua si el término está o no equisado
     * @return True si el término está equisado, false en otro caso
     */
    public boolean equisado(){
        return this.equisado;
    }
    
    /**
     * Este método equisa el término si no estaba equisado, si ya lo estaba, entonces no hace nada
     * @return True si el término no estaba equisado y se equisó, False en el otro caso
     */
    public boolean equisar(){
        if(!this.equisado){
            this.equisado = !this.equisado;
            return true;
        }
        return false;
    }
    
    /**
     * Este método averigua si el número está contenido dentro de los números del término
     * En otras palabras, si el término contiene el término original
     * @param termino El término original a buscar en el término
     * @return True si el término original está contenido, false en otro caso
     */
    public boolean contains(int termino){
        
        for (int i = 0; i < numeros.size(); i++) {
            Integer get = numeros.get(i);
            if(get == termino){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        //return "Termino{" + "numeros=" + numeros + '}';
        String salida = "";
        for (int i = 0; i < numeros.size(); i++) {
            Integer get = numeros.get(i);
            
            if(i == 0){
                salida = salida + get;
            }
            else{
                salida = salida + "-" + get;
                
            }
        }
        if(!this.diferencia.equals("")){
            salida = salida + "\t\t" + this.diferencia;
        }
        if(this.equisado){
            salida = salida + "\tX";
        }
        return salida;
    }
    
    public String numerosAString(){
        String salida = "";
        for (int i = 0; i < numeros.size(); i++) {
            Integer get = numeros.get(i);
            
            if(i == 0){
                salida = salida + get;
            }
            else{
                salida = salida + "-" + get;
                
            }
        }
        return salida;
    }
}