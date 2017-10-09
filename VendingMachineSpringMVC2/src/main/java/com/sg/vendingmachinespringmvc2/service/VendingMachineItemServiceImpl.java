/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

import com.sg.vendingmachinespringmvc2.dao.VendingMachineItemDao;
import com.sg.vendingmachinespringmvc2.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineItemServiceImpl implements VendingMachineItemService {

    private VendingMachineItemDao itemDao;
    
    public VendingMachineItemServiceImpl (VendingMachineItemDao itemDao) {
        this.itemDao = itemDao;
    }
    
    @Override
    public Item addItem(Item item) {
        return itemDao.addItem(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemDao.getItemById(itemId);
    }

    @Override
    public Item updateItem(Item item) {
        return itemDao.updateItem(item);
    }

    @Override
    public Item removeItem(Long itemId) {
        return itemDao.removeItem(itemId);
    }
    
    @Override
    public boolean makePurchase(BigDecimal moneyEntered, Item item) 
        throws VendingMachineItemNotInStockException,
            VendingMachineInsufficientFundsException {
        
        if (item.getInStock() == 0) {
            throw new VendingMachineItemNotInStockException("That item is not in stock.");
        }
        
        if (item.getPrice().compareTo(moneyEntered) == 1) {
            throw new VendingMachineInsufficientFundsException("Your funds are insufficient.");
        }
        
        item.setInStock(item.getInStock() - 1);
        itemDao.updateItem(item);
        
        return true;

    }
    
}
