/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

/**
 *
 * @author jeffc
 */
public class VendingMachineItemNotInStockException extends Exception {
 public VendingMachineItemNotInStockException(String message) {
        super(message);
    }
    
 public VendingMachineItemNotInStockException(String message,
            Throwable cause) {
        super(message, cause);
    }        
}
