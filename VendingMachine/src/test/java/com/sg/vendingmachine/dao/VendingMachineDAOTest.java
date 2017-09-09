/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeffc
 */
public class VendingMachineDAOTest {
    
    VendingMachineDAO dao;
    
    
    public VendingMachineDAOTest() throws VendingMachineFilePersistenceException {
        this.dao = new VendingMachineDAOFileImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<Item> itemList = dao.getAllItems();
        for (Item item : itemList) {
            item.setInStock(2);
        }
    }
    
    @After
    public void tearDown() {
    }

        /**
     * Test of getAllItems method, of class VendingMachineDAO.
     */
    @Test
    public void testGetAllItems() throws Exception {
        List<Item> itemList = dao.getAllItems();
        Integer numItems = itemList.size();
        Integer numSlots = dao.getNumberOfSlotsInMachine();
        assertNotNull(numSlots);
        assertEquals(numItems, numSlots);
        for (Item item : itemList) {
            assertNotNull(item);
        }
    }
    
    @Test
    public void testGetNumberOfSlotsInMachine() throws Exception {
        List<Item> itemList = dao.getAllItems();
        Integer numItems = itemList.size();
        Integer numSlots = dao.getNumberOfSlotsInMachine();
        assertNotNull(numSlots);
        assertEquals(numItems, numSlots);
    }
    

    /**
     * Test of getItem method, of class VendingMachineDAO.
     */
    @Test
    public void testGetItem() throws Exception {
        Item itemA1 = dao.getItem("A1");
        assertNotNull(itemA1);
        List<Item> itemList = dao.getAllItems();
        Item currentItem = null;
        for (Item item : itemList) {
            if (item.getSKU().equals("A1")) {
                currentItem = item;
            }
        }
        assertEquals(itemA1, currentItem);
    }

    /**
     * Test of getMoneyEntered method, of class VendingMachineDAO.
     */
    
    @Test
    public void testSetMoneyAndGetMoneyEntered() {
        
        dao.setMoneyEntered(new BigDecimal("0"));
        assertEquals("0", dao.getMoneyEntered().toString());
        
        dao.setMoneyEntered(new BigDecimal("0.05"));
        assertEquals("0.05", dao.getMoneyEntered().toString());
        
        dao.setMoneyEntered(new BigDecimal("0.1"));
        assertEquals("0.1", dao.getMoneyEntered().toString());
        
        dao.setMoneyEntered(new BigDecimal("0.25"));
        assertEquals("0.25", dao.getMoneyEntered().toString());
        
        dao.setMoneyEntered(new BigDecimal("12345"));
        assertEquals("12345", dao.getMoneyEntered().toString());
        
    }

    /**
     * Test of addMoney method, of class VendingMachineDAO.
     */
    
    @Test
    public void addMoneyEntered() {
        
        dao.setMoneyEntered(new BigDecimal("0"));
        assertEquals("0", dao.getMoneyEntered().toString());
        
        dao.addMoney(new BigDecimal("0.05"));
        assertEquals("0.05", dao.getMoneyEntered().toString());
        
        dao.addMoney(new BigDecimal("0.1"));
        assertEquals("0.15", dao.getMoneyEntered().toString());
        
        dao.addMoney(new BigDecimal("0.25"));
        assertEquals("0.40", dao.getMoneyEntered().toString());
        
        dao.addMoney(new BigDecimal("12345"));
        assertEquals("12345.40", dao.getMoneyEntered().toString());
        
    }
}
