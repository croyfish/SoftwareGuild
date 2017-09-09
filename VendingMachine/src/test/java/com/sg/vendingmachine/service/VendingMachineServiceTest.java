/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dao.VendingMachineDAOStubImpl;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class VendingMachineServiceTest {
    
    private VendingMachineService service;
    
    public VendingMachineServiceTest() {
        VendingMachineDAO dao = new VendingMachineDAOStubImpl();
        service = new VendingMachineServiceImpl(dao);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        service.setMoneyEnteredInDAO(new BigDecimal("0"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItemsFromDAO method, of class VendingMachineService.
     */
    @Test
    public void testGetAllItemsFromDAO() {
        assertEquals(3, service.getAllItemsFromDAO().size());
    }

    /**
     * Test of getItemFromDAO method, of class VendingMachineService.
     */
    @Test
    public void testGetItemFromDAO() {
        Item item = service.getItemFromDAO("A1");
        assertNotNull(item);
        item = service.getItemFromDAO("B1");
        assertNull(item);
        
    }

    /**
     * Test of setMoneyEnteredInDAO method, of class VendingMachineService.
     */
    @Test
    public void testSetandGetMoneyEnteredInDAO() {
        service.setMoneyEnteredInDAO(new BigDecimal("0"));
        assertEquals("0", service.getMoneyEnteredFromDAO().toString());
        service.setMoneyEnteredInDAO(new BigDecimal("12345.67"));
        assertEquals("12345.67", service.getMoneyEnteredFromDAO().toString());
        service.setMoneyEnteredInDAO(new BigDecimal("0"));
        assertEquals("0", service.getMoneyEnteredFromDAO().toString());
        service.setMoneyEnteredInDAO(new BigDecimal("0.01"));
        assertEquals("0.01", service.getMoneyEnteredFromDAO().toString());
    }


    /**
     * Test of addMoneyEnteredToDAO method, of class VendingMachineService.
     */
    @Test
    public void testAddMoneyEnteredToDAO() {
        service.addMoneyEnteredToDAO(new BigDecimal("0"));
        assertEquals("0", service.getMoneyEnteredFromDAO().toString());
        service.addMoneyEnteredToDAO(new BigDecimal("12345.67"));
        assertEquals("12345.67", service.getMoneyEnteredFromDAO().toString());
        service.addMoneyEnteredToDAO(new BigDecimal("0"));
        assertEquals("12345.67", service.getMoneyEnteredFromDAO().toString());
        service.addMoneyEnteredToDAO(new BigDecimal("0.01"));
        assertEquals("12345.58", service.getMoneyEnteredFromDAO().toString());    
    }

    /**
     * Test of calculateChange method, of class VendingMachineService.
     */
    @Test
    public void testCalculateChange() {
        service.setMoneyEnteredInDAO(new BigDecimal("0.45"));
        Change change1 = service.calculateChange();
        Integer quarters = 1;
        assertEquals(quarters, change1.getQuarters());
        Integer dimes = 2;
        assertEquals(dimes, change1.getDimes());
        Integer nickels = 0;
        assertEquals(nickels, change1.getNickels());
        Integer pennies = 0;
        assertEquals(pennies, change1.getPennies());
        
        service.setMoneyEnteredInDAO(new BigDecimal("0.59"));
        Change change2 = service.calculateChange();
        quarters = 2;
        assertEquals(quarters, change2.getQuarters());
        dimes = 0;
        assertEquals(dimes, change2.getDimes());
        nickels = 1;
        assertEquals(nickels, change2.getNickels());        
        pennies = 4;
        assertEquals(pennies, change2.getPennies());
        
        service.setMoneyEnteredInDAO(new BigDecimal("0"));
        Change change3 = service.calculateChange();
        quarters = 0;
        assertEquals(quarters, change1.getQuarters());
        nickels = 0;
        assertEquals(nickels, change2.getNickels());         
        dimes = 0;
        assertEquals(dimes, change1.getDimes());
        pennies = 0;
        assertEquals(pennies, change1.getPennies());
    }

    /**
     * Test of purchaseItem method, of class VendingMachineService.
     */
    @Test
    public void testPurchaseItem() {
         service.setMoneyEnteredInDAO(new BigDecimal("0.14"));
         Item item1 = service.purchaseItem("A1");
         assertNull(item1.getName());
         service.setMoneyEnteredInDAO(new BigDecimal("0.26"));
         Item item2 = service.purchaseItem("A2");
         assertEquals("Candy2", item2.getName());
         assertEquals("0", service.getMoneyEnteredFromDAO().toString());
         service.setMoneyEnteredInDAO(new BigDecimal("0.38"));
         Item item3 = service.purchaseItem("A3");
         assertNull(item3.getName());
         assertEquals("0.38", service.getMoneyEnteredFromDAO().toString());   
    }

    /**
     * Test of saveOnExit method, of class VendingMachineService.
     */
    @Test
    public void testSaveOnExit() {
        service.saveOnExit();
    }
    
}
