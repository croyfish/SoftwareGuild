/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineDAOStubImpl implements VendingMachineDAO {

    Item item1, item2, item3;
    List<Item> ItemList = new ArrayList<>();
    BigDecimal moneyEntered = new BigDecimal("0");
    
    public VendingMachineDAOStubImpl() {
        item1 = new Item("A1");
        item1.setName("Candy1");
        item1.setPrice(new BigDecimal("0.05"));
        item1.setInStock(0);
        
        ItemList.add(item1);
        
        item1 = new Item("A2");
        item1.setName("Candy2");
        item1.setPrice(new BigDecimal("0.17"));
        item1.setInStock(0);
        
        ItemList.add(item2);
        
        item1 = new Item("A3");
        item1.setName("Candy3");
        item1.setPrice(new BigDecimal("0.39"));
        item1.setInStock(0);

        ItemList.add(item3);
    }
    
    @Override
    public List<Item> getAllItems() throws VendingMachineFilePersistenceException {
        return ItemList;
    }

    @Override
    public Item getItem(String SKU) {
        for (Item currentItem : ItemList) {
            if(SKU.equals(currentItem.getSKU())) {
            return currentItem;
            } 
        }
        return null;      
    }

    @Override
    public void setMoneyEntered(BigDecimal money) {
        moneyEntered = money;
    }    
    
    @Override
    public BigDecimal getMoneyEntered() {
        return moneyEntered;
    }

    @Override
    public void addMoney(BigDecimal money) {
        moneyEntered = new BigDecimal(money.add(moneyEntered).toString());
    }

    @Override
    public void writeInventory() throws VendingMachineFilePersistenceException {
        return;
    }

    @Override
    public Integer getNumberOfSlotsInMachine() {
        return 3;
    }
    
}