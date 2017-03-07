/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McQuinnator;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Esteban
 */
public class TablaPrimos {
    
    private Fase1 fase1Propia;
    private ArrayList<Termino> terminosPrimosPropios;
    private ArrayList<Integer> terminosOriginales;
    
    public TablaPrimos(Fase1 faseAImplementar) {
        this.fase1Propia = faseAImplementar;
        this.terminosOriginales = faseAImplementar.getTerminosOriginales();
        this.terminosPrimosPropios = faseAImplementar.getPrimos();
    }
     
    public DefaultTableModel toTabla(){

        /*
        la fila es el primer corchete
        Los términos primos no serán graficados de la misma manera en la que grafiqué las tablas
        En lugar de eso serán graficados en una tabla similar a la que usa excel
        En esta tabla los términos serán las filas y los términos originales serán las columnas
        */
        Object[][] tablaTerminos = new Object[terminosPrimosPropios.size()][terminosOriginales.size()+1];
        
        //Recorrer cada una de las casillas que acabo de crear, llenándolas a discreción
        for (int i = 0; i < this.terminosPrimosPropios.size(); i++) {
            Termino getTermino = this.terminosPrimosPropios.get(i);
            
            //llena la posición 0 con el string de los números del término
            tablaTerminos[i+1][0] = getTermino.numerosAString();

            //ahora recorre todas las columnas buscando las casillas donde debe marcar una X
            for (int j = 0; j < this.terminosOriginales.size(); j++) {
                
                //pregunto si el término que se está analizando contiene el término original
                if(getTermino.contains(terminosOriginales.get(j))){
                    
                    //el término original está contenido, así que le clavo una bonita X
                    tablaTerminos[i+1][j+1] = "X";
                }
            }
        }
        //hago que la primera casilla sea la cantidad de términos PRIMOS
        tablaTerminos[0][0] = terminosPrimosPropios.size();

        //Ahora las columnas que poseerá la tabla
        String [] columnasTabla = new String[terminosOriginales.size()];
        for (int i = 0; i < terminosOriginales.size(); i++) {
            Integer get = terminosOriginales.get(i);
            columnasTabla[i+1] = Integer.toString(get);
        }
        //esto es sólo para que al inicio tenga cuántos términos originales había
        columnasTabla[0] = Integer.toString(terminosOriginales.size());
        
        //retorna un default table model con lo que se hizo en el método
        return new DefaultTableModel(tablaTerminos, columnasTabla);
    }
    
    public String mostrarPrimosString(){
        String salida = "Términos Primos Colapsados: \n--------------------------------------------------------------------------------- \n";
        for (int i = 0; i < this.terminosPrimosPropios.size(); i++) {
            Termino get = this.terminosPrimosPropios.get(i);
            salida = salida + get.toString() + "\n";
        }
        return salida;
    }
    
    public String mostrarPrimosNoColapsadosString(){
        String salida = "Términos Primos No Colapsados: \n--------------------------------------------------------------------------------- \n";
        for (int i = 0; i < this.fase1Propia.getPrimosNoColapsado().size(); i++) {
            Termino get = this.fase1Propia.getPrimosNoColapsado().get(i);
            salida = salida + get.toString() + "\n";
        }
        return salida;
    }
}
