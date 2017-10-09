/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

import com.sg.vendingmachinespringmvc2.model.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class VendingMachineItemServiceTest {
    
    private VendingMachineItemService itemService;
    
    public VendingMachineItemServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        itemService = ctx.getBean("vendingMachineItemService", VendingMachineItemService.class);
    
        List<Item> itemList = itemService.getAllItems();
        
        for (Item currentItem : itemList) {
            itemService.removeItem(currentItem.getItemId());
        }
    
    }
    
    @After
    public void tearDown() {
        
        List<Item> itemList = itemService.getAllItems();
        
        for (Item currentItem : itemList) {
            itemService.removeItem(currentItem.getItemId());
        }  
    }

    /**
     * Test of addItem method, of class VendingMachineItemService.
     */
    @Test
    public void addGetDeleteItem() {
        Item item = new Item();
        item.setName("Jeff Bar");
        item.setPrice(new BigDecimal("0.95"));
        item.setInStock(2);
        itemService.addItem(item);
        Item fromService = itemService.getItemById(item.getItemId());
        assertEquals(fromService, item);
        itemService.removeItem(item.getItemId());
        assertNull(itemService.getItemById(item.getItemId()));
    }

    /**
     * Test of getAllItems method, of class VendingMachineItemService.
     */
    @Test
    public void addUpdateItem() {
        Item item = new Item();
        item.setName("Jeff Bar");
        item.setPrice(new BigDecimal("0.95"));
        item.setInStock(2);
        itemService.addItem(item);
        item.setName("Clark Bar");
        itemService.updateItem(item);
        Item fromService = itemService.getItemById(item.getItemId());
        assertEquals(fromService, item);      
    }

    /**
     * Test of getItemById method, of class VendingMachineItemService.
     */
    @Test
    public void getAllItems() {
        
        Item item = new Item();
        item.setName("Jeff Bar");
        item.setPrice(new BigDecimal("0.95"));
        item.setInStock(2);
        itemService.addItem(item);

        Item item2 = new Item();
        item2.setName("Jeff Bar");
        item2.setPrice(new BigDecimal("0.95"));
        item2.setInStock(2);
        itemService.addItem(item2);
        
        List<Item> itemList = itemService.getAllItems();
        assertEquals(2, itemList.size());
      
    }
    
}