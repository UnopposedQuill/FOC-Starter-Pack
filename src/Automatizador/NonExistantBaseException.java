/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatizador;

/**
 * Arrojada en el momento en el que se pida una base "0", la cual no está definida
 * @author esteban
 */
public class NonExistantBaseException extends Exception {

    /**
     * Creates a new instance of <code>NonExistantBaseException</code> without
     * detail message.
     */
    public NonExistantBaseException() {
    }

    /**
     * Constructs an instance of <code>NonExistantBaseException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NonExistantBaseException(String msg) {
        super(msg);
    }
}
