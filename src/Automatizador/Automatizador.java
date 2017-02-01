/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatizador;

import com.sun.istack.internal.logging.Logger;
import convertidormultibase.DigitOutOfBaseBoundsException;
import convertidormultibase.Numero;
import java.util.logging.Level;

/**
 * Esta clase sabe cómo sacar las transiciones matemáticamente de un autómata divisor
 * @author esteban
 */
public class Automatizador {
    
    private final int divisor;
    private final int baseADividir;

    /**
     * Este constructor crea una visualización matemática de las transiciones de un autómata divisor
     * @param divisor El divisor del cual se desea saber cuáles son los residuos
     * @param baseADividir La base a la cual pertenecen los dígitos del alfabeto
     * @throws NonExistantBaseException Si la base es 0
     * @throws ArithmeticException Si el divisor es 0
     */
    public Automatizador(int baseADividir,int divisor)throws NonExistantBaseException{
        if(baseADividir == 0){
            throw new NonExistantBaseException("La base 0 no está definida");
        }
        if(divisor == 0){
            throw new ArithmeticException("División por cero");
        }
        this.divisor = divisor;
        this.baseADividir = baseADividir;
    }

    @Override
    public String toString() {
        String resultado = "Automatizador de Base: " + baseADividir + " entre " + divisor + "\n";
        //para cada uno de los posibles residuos
        for (int i = 0; i < this.divisor; i++) {
            //para cada uno de los elementos del alfabeto defino a qué estado va a caer
            for (int j = 0; j < baseADividir; j++) {
                try{
                    //le agrega el Q al inicio
                    resultado = resultado.concat("\t" + "q" + String.valueOf(i));
                    //creo un nuevo ejemplar numero con base en el dígito que se está evaluando en el momento
                    Numero elementoActualAlfabeto = new Numero(10, String.valueOf(j));
                    //ahora el número va a convertirse en la representación de la base que se está dividiendo
                    elementoActualAlfabeto.cambiarBase(baseADividir);
                    //ahora lo junto con el string que se retornará
                    resultado = resultado.concat(", " + elementoActualAlfabeto.getValor() + " => ");
                    //ahora le junto el estado al que se supone que va
                    resultado = resultado.concat("q" + (String.valueOf((i*this.baseADividir+j)%divisor)) + "\n");
                }catch(DigitOutOfBaseBoundsException exc){
                    Logger.getLogger(Automatizador.class).log(Level.SEVERE, null, exc);
                }
            }
            resultado = resultado.concat("------------------------------------------------------------------------------------\n");
        }
        
        return resultado;
    }
}