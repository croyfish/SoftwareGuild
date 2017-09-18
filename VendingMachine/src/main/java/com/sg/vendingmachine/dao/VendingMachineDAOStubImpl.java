/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineDAOStubImpl implements VendingMachineDAO {
    // declare three items
    private Item item1, item2, item3;
    // declare ArrayList to store items
    private List<Item> ItemList = new ArrayList<>();
    // declare BigDecimal to store money entered to machine
    private BigDecimal moneyEntered;
    
    // Create stub class constructor
    public VendingMachineDAOStubImpl() {
        // Create thee new items and add them to the item list
        item1 = new Item("A1");
        item1.setName("Candy1");
        item1.setPrice(new BigDecimal("0.05"));
        item1.setInStock(1);
        
        ItemList.add(item1);
        
        item2 = new Item("A2");
        item2.setName("Candy2");
        item2.setPrice(new BigDecimal("0.17"));
        item2.setInStock(1);
        
        ItemList.add(item2);
        
        item3 = new Item("A3");
        item3.setName("Candy3");
        item3.setPrice(new BigDecimal("0.39"));
        item3.setInStock(1);

        ItemList.add(item3);
    }
    
    // Return list of three items
    @Override
    public List<Item> getAllItems() throws VendingMachineFilePersistenceException {
        return ItemList;
    }
    // get item from the list by SKU. If it does not exist, throw Data Validation Exception
    @Override
    public Item getItem(String SKU) throws VendingMachineDataValidationException {
        try {
            Item selectedItem = null;
            for (Item currentItem : ItemList) {
                if(SKU.equals(currentItem.getSKU())) {
                selectedItem = currentItem;
                } 
            }
            return selectedItem;
        } catch (NullPointerException e) {
            throw new VendingMachineDataValidationException("Data Validation Exception has been thrown");
        }
    }
    // set value of money in machine
    @Override
    public void setMoneyEntered(BigDecimal money) {
        moneyEntered = money;
    }    
    // return value of money in machine
    @Override
    public BigDecimal getMoneyEntered() {
        return moneyEntered;
    }
    // add change object to money in machine
    @Override
    public Change addMoney(Change money) {
        moneyEntered = moneyEntered.add(new BigDecimal(money.getValueOfChange().toString()));
        return money;
    }
    // do nothing for write inventory
    @Override
    public void writeInventory() throws VendingMachineFilePersistenceException {
        // do nothing
    }

    // get number of slots in machine
    @Override
    public Integer getNumberOfSlotsInMachine() {
        return 3;
    }
    
}
