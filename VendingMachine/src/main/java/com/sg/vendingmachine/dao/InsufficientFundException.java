/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author jeffc
 */
public class InsufficientFundException extends Exception {
 public InsufficientFundException(String message) {
        super(message);
    }
    
    InsufficientFundException(String message,
            Throwable cause) {
        super(message, cause);
    }        
}    

