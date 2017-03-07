/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McQuinnator;

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
        
        return "Fase3{" + "fase2AProcesar=" + fase2AProcesar + '}';
    }
    
    public String funcionResultante(){
        return "";
    }
}
