/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao.exception;

/**
 *
 * @author jeffc
 */
public class NoOrdersForDateException extends Exception {
    public NoOrdersForDateException (String message) {
        super(message);
    }
    
    public NoOrdersForDateException (String message, Throwable cause) {
        super(message, cause);
    }     
}
