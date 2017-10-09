/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.dao;

import com.sg.vendingmachinespringmvc2.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public class VendingMachineItemDaoInMemImpl implements VendingMachineItemDao {
    
    private Map<Long, Item> itemMap = new HashMap<>();
    private static long itemIdCounter = 0;

    public VendingMachineItemDaoInMemImpl() {
        for (long i = 0; i < 9; i++) {
            Item newItem = new Item();
            newItem.setItemId(i + 1);
            newItem.setName("Item");
            newItem.setPrice(new BigDecimal("1.00"));
            newItem.setInStock(3);
            itemMap.put(newItem.getItemId(), newItem);
        }
    }
    
    
    @Override
    public Item addItem(Item item) {
        item.setItemId(itemIdCounter);
        itemIdCounter++;
        itemMap.put(item.getItemId(), item);
        return item;
                
    }

    @Override
    public List<Item> getAllItems() {
       return new ArrayList(itemMap.values());
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemMap.get(itemId);
    }

    @Override
    public Item updateItem(Item item) {
        itemMap.put(item.getItemId(),item);
        return item;
    }

    @Override
    public Item removeItem(Long itemId) {
        Item removedItem = itemMap.get(itemId);
        itemMap.remove(itemId);
        return removedItem;
    }      

    
}
