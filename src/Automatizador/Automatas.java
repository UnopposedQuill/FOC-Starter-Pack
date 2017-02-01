/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatizador;

/**
 *
 * @author esteban
 */
public class Automatas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Automatizador automatizador = new Automatizador(36, 10);
            System.out.println(automatizador.toString());
        }catch(NonExistantBaseException exc){System.out.println("Error");}
    }
}
