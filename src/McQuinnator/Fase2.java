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
public class Fase2 {
    
    private Fase1 fase1AProcesar;
    private TablaPrimos tablaEsenciales;
    
    public Fase2(Fase1 fase1Nueva){
        this.fase1AProcesar = fase1Nueva;
        this.tablaEsenciales = new TablaPrimos(this.fase1AProcesar);
        
    }
    
    public Fase2(String funcionK){
        this.fase1AProcesar = new Fase1(funcionK);
        this.fase1AProcesar.hacerTablas();
        this.tablaEsenciales = new TablaPrimos(this.fase1AProcesar);
    }

    public Fase1 getFase1AProcesar() {
        return fase1AProcesar;
    }

    public TablaPrimos getTablaEsenciales() {
        return tablaEsenciales;
    }    
}
