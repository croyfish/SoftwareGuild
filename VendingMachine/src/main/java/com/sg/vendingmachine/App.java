/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;

/**
 *
 * @author jeffc
 */
public class App {
    public static void main(String[] args) throws VendingMachineFilePersistenceException {
        VendingMachineDAO myDAO = new VendingMachineDAOFileImpl();
        System.out.println("At least we're here.");
    }
}
