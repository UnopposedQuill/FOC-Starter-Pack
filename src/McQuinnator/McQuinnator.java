/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McQuinnator;

/**
 *
 * @author Esteban
 */
public class McQuinnator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        //Fase1 fase1 = new Fase1("E6:(1,2,3)");
        
        Fase1 fase1 = new Fase1("E6:(0,1,2,3,20,21,22,23,24,29,30,31,58,59,60,61,62,63)");
        System.out.println("Fase 1: \n");
        System.out.println(fase1.toString());
        System.out.println(fase1.getTablas().get(0).isEmpty());
        
        //prueba 1 para el analizamiento de la segunda tabla
        //prueba 1 exitosa, estas cosas nunca pasan
        fase1.analizarTablas();
        fase1.analizarTablas();
        fase1.analizarTablas();
        fase1.analizarTablas();
        System.out.println("\n--------------------------------------------------------\n" + "Primer intento \n");
        System.out.println(fase1.toString());
        */
        
        Fase1 fase1 = new Fase1("E6:(0,1,2,3,20,21,22,23,24,29,30,31,58,59,60,61,62,63)");
        fase1.hacerTablas();
        System.out.println(fase1.toString());
    }
}
