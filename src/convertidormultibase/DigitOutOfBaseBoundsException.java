/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidormultibase;

/**
 * Esta excepción sucede cuando un dígito es mayor a la capacidad de la base
 * @author esteban
 */
public class DigitOutOfBaseBoundsException extends Exception {

    /**
     * Creates a new instance of <code>DigitOutOfBaseBoundsException</code>
     * without detail message.
     */
    public DigitOutOfBaseBoundsException() {
    }

    /**
     * Constructs an instance of <code>DigitOutOfBaseBoundsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DigitOutOfBaseBoundsException(String msg) {
        super(msg);
    }
}
