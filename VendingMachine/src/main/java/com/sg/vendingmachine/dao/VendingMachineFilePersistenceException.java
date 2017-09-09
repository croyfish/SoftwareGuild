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
public class VendingMachineFilePersistenceException extends Exception {
 public VendingMachineFilePersistenceException(String message) {
        super(message);
    }
    
    VendingMachineFilePersistenceException(String message,
            Throwable cause) {
        super(message, cause);
    }        
}
