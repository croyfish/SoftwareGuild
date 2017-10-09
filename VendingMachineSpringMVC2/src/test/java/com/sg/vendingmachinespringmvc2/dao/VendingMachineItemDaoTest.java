/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.dao;

import com.sg.vendingmachinespringmvc2.model.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class VendingMachineItemDaoTest {
    
    private VendingMachineItemDao itemDao;
    
    public VendingMachineItemDaoTest() {
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
        itemDao = ctx.getBean("vendingMachineItemDao", VendingMachineItemDao.class);
        
        List<Item> itemList = itemDao.getAllItems();
        
        for (Item currentItem : itemList) {
            itemDao.removeItem(currentItem.getItemId());
        }
    }
    
    @After
    public void tearDown() {
        
        List<Item> itemList = itemDao.getAllItems();
        
        for (Item currentItem : itemList) {
            itemDao.removeItem(currentItem.getItemId());
        }          
        
    }

    /**
     * Test of addItem method, of class VendingMachineItemDao.
     */
    @Test
    public void addGetDeleteItem() {
        Item item = new Item();
        item.setName("Jeff Bar");
        item.setPrice(new BigDecimal("0.95"));
        item.setInStock(2);
        itemDao.addItem(item);
        Item fromDao = itemDao.getItemById(item.getItemId());
        assertEquals(fromDao, item);
        itemDao.removeItem(item.getItemId());
        assertNull(itemDao.getItemById(item.getItemId()));
    }

    /**
     * Test of getAllItems method, of class VendingMachineItemDao.
     */
    @Test
    public void addUpdateItem() {
        Item item = new Item();
        item.setName("Jeff Bar");
        item.setPrice(new BigDecimal("0.95"));
        item.setInStock(2);
        itemDao.addItem(item);
        item.setName("Clark Bar");
        itemDao.updateItem(item);
        Item fromDao = itemDao.getItemById(item.getItemId());
        assertEquals(fromDao, item);      
    }

    /**
     * Test of getItemById method, of class VendingMachineItemDao.
     */
    @Test
    public void getAllItems() {
        
        Item item = new Item();
        item.setName("Jeff Bar");
        item.setPrice(new BigDecimal("0.95"));
        item.setInStock(2);
        itemDao.addItem(item);

        Item item2 = new Item();
        item2.setName("Jeff Bar");
        item2.setPrice(new BigDecimal("0.95"));
        item2.setInStock(2);
        itemDao.addItem(item2);
        
        List<Item> itemList = itemDao.getAllItems();
        assertEquals(2, itemList.size());
      
    }
    
}
