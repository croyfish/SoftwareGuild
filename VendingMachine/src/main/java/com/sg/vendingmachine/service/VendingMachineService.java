/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.InsufficientFundException;
import com.sg.vendingmachine.dao.NoItemInventoryException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dao.VendingMachineDataValidationException;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface VendingMachineService {
    
    public List<Item> getAllItemsFromDAO()
     throws VendingMachineFilePersistenceException;
    
    public void setMoneyEnteredInDAO(BigDecimal money);
    
    public BigDecimal getMoneyEnteredFromDAO();
    
    public void addMoneyEnteredToDAO(Change money);
    
    public Change calculateChange();
    
    public Item purchaseItem(String SKU)
     throws VendingMachineDataValidationException, 
            InsufficientFundException,
            NoItemInventoryException;
    
    // public void depositCoin(int coinType);
    
    public void saveOnExit()
     throws VendingMachineFilePersistenceException;
}
