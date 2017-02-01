/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidormultibase;

import java.io.IOException;
import gui.JFrameConvertidora;

/**
 *
 * @author Esteban
 */
public class ConvertidorMultibase{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        /*
        Numero numero = new Numero(4022, "X''''''''");
        try{
        
        System.out.println(numero.toString());
        numero.cambiarBase(10);
        try{
            System.out.println(numero.toString());
        }catch(UnknownError ex){
            System.out.println("error");
        }
        }catch(NullPointerException exc){
            System.out.println("No es un número válido");
        }
        
        */
        
        //Numero numero2 = new Numero(10, "72812");
        //numero2.cambiarBase(41);
        
        //Numero numero3 = new Numero(8,"12");
        //numero3.cambiarBase(10);
        //System.out.println(numero3.getValor());
        
        //crea la zukulemta ventana de la calculadora
        JFrameConvertidora ventana = new JFrameConvertidora();
        ventana.setVisible(true);
        
    }
    
    public static int potenciarNumero(int base,int exponente){
        
        int resultado = 1;
        
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}