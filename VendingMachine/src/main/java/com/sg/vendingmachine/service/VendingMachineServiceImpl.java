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

    private VendingMachineAuditDao auditDao;
    private VendingMachineDAO dao;
    
    public VendingMachineServiceImpl(VendingMachineDAO dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    // Pass through menu to return all items
    @Override
    public List<Item> getAllItemsFromDAO() 
     throws VendingMachineFilePersistenceException {
        return dao.getAllItems();
    }

    // Implement purchasing process
    @Override
    public Item getItemFromDAO(String SKU) 
     throws VendingMachineDataValidationException {
//        // Get money entered to machine from DAO
//        BigDecimal money = dao.getMoneyEntered();
//        // Get purchased item object from DAO
//        Item selectedItem = dao.getItem(SKU);
//        // Extract price field from purchased item
//        BigDecimal price = selectedItem.getPrice();
//        // Extract in stock field from purchased item
//        Integer leftInStock = selectedItem.getInStock();
//        // Check if user has enough money and item is in stock
//        if ((money.compareTo(price) == 1 || money.compareTo(price) == 0) && leftInStock > 0) {
//            // Subtract item price from money entered
//            dao.setMoneyEntered(money.subtract(price));
//            // Remove one item from stock
//            selectedItem.setInStock(leftInStock - 1);
//            // Return purchased item
//            return dao.getItem(SKU);
//        }
          return null;      
    }

    @Override
    public void setMoneyEnteredInDAO(BigDecimal money) {
        dao.setMoneyEntered(money);
    }

    @Override
    public BigDecimal getMoneyEnteredFromDAO() {
        return dao.getMoneyEntered();
    }

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

    // Is this a duplicate method? What happened here?
    // It appears this method is not called from controller... delete?
    @Override
    public Item purchaseItem(String SKU) 
            throws VendingMachineDataValidationException, 
            InsufficientFundException,
            NoItemInventoryException {
        Item selectedItem = dao.getItem(SKU);
        if (selectedItem.getInStock() < 1) {
            throw new NoItemInventoryException ("NoItemInventoryException"
                    + " encountered! Item: " + selectedItem.getName());
        }
        
        BigDecimal money = dao.getMoneyEntered();
        BigDecimal price = selectedItem.getPrice();
        if (money.compareTo(price) == -1) {  
            throw new InsufficientFundException ("InsufficientFundException"
                    + " encountered! Item: " + selectedItem.getName());
        }
     
        money = money.subtract(price);
        dao.setMoneyEntered(money);
        return selectedItem; 
    }


    // Take coin deposited from user and send its value to DAO
    @Override
    public void depositCoin(int coinType) {
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
        this.addMoneyEnteredToDAO(changeEntered);
    }
    
    // Write the inventory before exiting the program
    @Override
    public void saveOnExit() throws VendingMachineFilePersistenceException {
        dao.writeInventory();
    }
    
}
