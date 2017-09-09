/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDataValidationException;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import com.sg.vendingmachine.service.Change;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineController {
    
    VendingMachineService service;
    VendingMachineView  view;
    
    public VendingMachineController(VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws VendingMachineDataValidationException {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            
        
            while (keepGoing) {
            
                menuSelection = getMenuSelection();
            
                switch(menuSelection) {
                    case 1:
                        addMoney();
                        break;
                    case 2:
                        purchaseAnItem();
                        break;
                    case 3:
                        getChange();
                        break;
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
        
            exitMessage();
            service.saveOnExit();
        } catch (VendingMachineFilePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
        
    private int getMenuSelection() throws VendingMachineFilePersistenceException {
        List Items = service.getAllItemsFromDAO();
        view.printInventory(Items);
        return view.printMainMenuAndGetSelection();
    }
    
    private void addMoney() {
        view.printAddMoneyMenuAndGetSelection();    
    }
    
    private void purchaseAnItem() {
        view.askAndGetItemSelection();
    }
    
    private void getChange() {
        Change userChange = service.calculateChange();
        view.returnChange(userChange);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
