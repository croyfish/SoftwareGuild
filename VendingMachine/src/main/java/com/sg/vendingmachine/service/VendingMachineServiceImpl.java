/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.InsufficientFundException;
import com.sg.vendingmachine.dao.NoItemInventoryException;
import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dao.VendingMachineDataValidationException;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineServiceImpl implements VendingMachineService {
    // declare AuditDao and Dao objects
    private VendingMachineAuditDao auditDao;
    private VendingMachineDAO dao;
    // create class constructor that takes dao and auditDao implementations as parameters
    public VendingMachineServiceImpl(VendingMachineDAO dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    // Pass through method to return list of all items from dao
    @Override
    public List<Item> getAllItemsFromDAO() 
     throws VendingMachineFilePersistenceException {
        return dao.getAllItems();
    }

    // Pass through method to set money entered in machine (in DAO) to zero
    @Override
    public void setMoneyEnteredInDAO(BigDecimal money) {
        dao.setMoneyEntered(money);
    }

    // Pass through method to get money entered in machine (from DAO)
    @Override
    public BigDecimal getMoneyEnteredFromDAO() {
        return dao.getMoneyEntered();
    }

    // pass through method to add money to money entered in machine (in DAO)
    @Override
    public void addMoneyEnteredToDAO(Change moneyEntered) {
        dao.addMoney(moneyEntered);
    }

    // Calculate change owed to user
    @Override
    public Change calculateChange() {
        
        // Instantiate change object, get money entered, and set
        // money entered in machine to $0.00.
        Change userChange = new Change();
        BigDecimal money = dao.getMoneyEntered();
        dao.setMoneyEntered(new BigDecimal("0.00"));
        
        // Calculate number of quarters to return
        BigDecimal quarters = money.divide(new BigDecimal("0.25"));
        quarters = quarters.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(quarters.multiply(new BigDecimal("0.25")));
        userChange.setQuarters(quarters.intValue());
        
        // Calculate number of dimes to return
        BigDecimal dimes = money.divide(new BigDecimal("0.1"));
        dimes = dimes.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(dimes.multiply(new BigDecimal("0.1")));
        userChange.setDimes(dimes.intValue());
        
        // Calculate number of nickels to return
        BigDecimal nickels = money.divide(new BigDecimal("0.05"));
        nickels = nickels.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(nickels.multiply(new BigDecimal("0.05")));
        userChange.setNickels(nickels.intValue());
        
        // Calculate number of pennies to return
        BigDecimal pennies = money.divide(new BigDecimal("0.01"));
        pennies = pennies.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(pennies.multiply(new BigDecimal("0.01")));
        userChange.setPennies(pennies.intValue());
        
        // Return user's change object
        return userChange;
    }

    // Peform business logic to decide whether machine will vend item or not
    @Override
    public Item purchaseItem(String SKU) 
            throws VendingMachineDataValidationException, 
            InsufficientFundException,
            NoItemInventoryException {
        // get selected item from DAO based on its SKU
        Item selectedItem = dao.getItem(SKU);
        // If the item is not in stock, throw a NoItemInventoryException and send
        // exception message to exception logger
        if (selectedItem.getInStock() < 1) {
            throw new NoItemInventoryException ("NoItemInventoryException"
                    + " encountered! Item: " + selectedItem.getName());
        }
        // get money entered in machine from DAO
        BigDecimal money = dao.getMoneyEntered();
        // get price of item from Item DTO
        BigDecimal price = selectedItem.getPrice();
        // if the price of the item is more than the money entered in the machine,
        // throw an InsufficientFundException and send message to exception logger
        if (price.compareTo(money) == 1) {  
            throw new InsufficientFundException ("InsufficientFundException"
                    + " encountered! Item: " + selectedItem.getName());
        }
        // Since no exceptions encountered, subtract price of item from money entered
        money = money.subtract(price);
        // Reduce number of item in inventory
        selectedItem.setInStock(selectedItem.getInStock() - 1);
        // set money entered value in DAO
        dao.setMoneyEntered(money);
        // return item to controller
        return selectedItem; 
    }

    /*
    // Take integer denoting type of coin deposited from user and create change object
    @Override
    public void depositCoin(int coinType) {
        // delcare change object
        Change changeEntered = new Change();
        // set the appropriate field in the object
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
        // call method to add money's value to money entered in machine in DAO
        this.addMoneyEnteredToDAO(changeEntered);
    }
    */
    
    // Write the inventory before exiting the program
    @Override
    public void saveOnExit() throws VendingMachineFilePersistenceException {
        dao.writeInventory();
    }
    
}
