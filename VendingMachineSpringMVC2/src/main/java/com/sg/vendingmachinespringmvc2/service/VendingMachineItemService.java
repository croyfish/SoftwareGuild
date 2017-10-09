/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

import com.sg.vendingmachinespringmvc2.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface VendingMachineItemService {
    
    // Create
    public Item addItem(Item item);
    // Read
    public List<Item> getAllItems();
    public Item getItemById(Long itemId);    
    // Update
    public Item updateItem(Item item);
    // Delete    
    public Item removeItem(Long itemId);
    
    public boolean makePurchase(BigDecimal moneyEntered, Item item)
            throws VendingMachineItemNotInStockException,
            VendingMachineInsufficientFundsException;
}
