/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.InsufficientFundException;
import com.sg.vendingmachine.dao.NoItemInventoryException;
import com.sg.vendingmachine.dao.VendingMachineDataValidationException;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineController {
    
    // Declare service and view objects
    VendingMachineService service;
    VendingMachineView  view;
    
    // Constructor to receive Service and View implementations from Spring DI
    public VendingMachineController(VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    // Main menu selection switch
    public void run() {
        // set keepgoing flag to true
        boolean keepGoing = true;
        // initialize menu selecction
        int menuSelection = 0;
        
        // try-catch to catch the File Persistence Exception 
        // that may occur when inventory is loaded
        try {
            // keepgoing while flag is set to true
            while (keepGoing) {
                
                // Call method to manage Main Menu selection process
                menuSelection = getMenuSelection();
                // Call appropriate method based on user's selection
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
                    // If user chooses 4, set keepgoing flag to false
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            // print message when leaving machine
            exitMessage();
            // persist item data to data file
            service.saveOnExit();
            
        } catch (VendingMachineFilePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (VendingMachineDataValidationException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }

    // Main menu selection process.
    private int getMenuSelection() throws VendingMachineFilePersistenceException {
        view.clearScreen();
        // get inventory from DAO
        List<Item> items = service.getAllItemsFromDAO();
        // print inventory
        view.printInventory(items);
        // get money entered from DAO
        BigDecimal money = service.getMoneyEnteredFromDAO();
        // print balance
        view.printCurrentBalance(money);
        // print menu options and get selection
        return view.printMainMenuAndGetSelection();
    }
    
    // Add coins to machine
    private void addMoney() {
        // print coins menu
        int coinType = view.printAddMoneyMenuAndGetSelection();
        if (coinType != 0) {
            // set fields in new change object appropriately
        String moneyAdded = "0.00";
        Change changeEntered = new Change();
        switch (coinType) {
            case 1:
                changeEntered.setPennies(1);
                break;
            case 2:
                changeEntered.setNickels(1);
                break;
            case 3:
                changeEntered.setDimes(1);
                break;
            case 4:
                changeEntered.setQuarters(1);
                break;
            default:
        }
              service.addMoneyEnteredToDAO(changeEntered);
        }
    }
    
    // Attempt to buy an item from the machine
    private void purchaseAnItem() throws VendingMachineDataValidationException {
        // Print item selection menu and get result as string
        String SKU = view.askAndGetItemSelection();
        // Try to purchase the item from service
        try {
            Item purchasedItem = service.purchaseItem(SKU);
            if (purchasedItem != null) {
                view.displayItemPurchaseSuccessBanner(purchasedItem);
                view.pressEnter();
                getChange();
            } else {
                view.displayErrorMessage("You cannot buy that item.");
            }
        } catch (VendingMachineDataValidationException e) {
            view.displayErrorMessage("Inventory not loaded.");
        } catch (NoItemInventoryException ex) {
            view.displayErrorMessage("Item is out of stock.");
        } catch (InsufficientFundException exc) {
            view.displayErrorMessage("Your fund is insufficient.");
        }  

    }
    
    // Call method to return money entered as change to user
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
