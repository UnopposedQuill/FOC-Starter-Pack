/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class MainPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String opc = JOptionPane.showInputDialog("Ingrese un 1 para el Omnibaser, un 2 para el McQuinnator");
        if(opc == null || opc.equals("")){
            System.out.println("Entrada Incorrecta, saliendo...");
            System.exit(1);
        }
        int opcion = Integer.parseInt(opc);
        if(opcion == 1){
            JFrameConvertidora.main(args);
        }
        else{
            JFrameMcQuinnator.main(args);
        }
    }
}
