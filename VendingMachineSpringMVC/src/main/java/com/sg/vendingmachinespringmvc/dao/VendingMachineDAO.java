/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface VendingMachineDAO {
    
    public List<Item> getAllItems()
     throws VendingMachineFilePersistenceException;
    
    public Item getItem(String SKU)
     throws VendingMachineDataValidationException;
    
    public BigDecimal getMoneyEntered();
    
    public void setMoneyEntered(BigDecimal money);
    
    public Change addMoney(Change changeEntered);
    
    public void writeInventory()
     throws VendingMachineFilePersistenceException;
    
    public Integer getNumberOfSlotsInMachine();
    
}