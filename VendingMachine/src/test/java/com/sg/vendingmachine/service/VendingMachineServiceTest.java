/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.InsufficientFundException;
import com.sg.vendingmachine.dao.NoItemInventoryException;
import com.sg.vendingmachine.dao.VendingMachineDataValidationException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class VendingMachineServiceTest {
    
//    private VendingMachineService service;
//    private UserIO io = new UserIOConsoleImpl();
//    
//    public VendingMachineServiceTest() {
//        VendingMachineDAO dao = new VendingMachineDAOStubImpl();
//        service = new VendingMachineServiceImpl(dao);
    
    VendingMachineService service;  
    
    public VendingMachineServiceTest() {
        
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    service = ctx.getBean("service", VendingMachineService.class);    
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
    public void testGetAllItemsFromDAO() throws Exception {
        assertEquals(3, service.getAllItemsFromDAO().size());
    }

    /**
     * Test of getItemFromDAO method, of class VendingMachineService.
     */
//    @Test
//    public void testGetItemFromDAO() 
//            throws VendingMachineDataValidationException,
//            InsufficientFundException,
//            NoItemInventoryException
//        {
//        service.setMoneyEnteredInDAO(new BigDecimal("0.15"));
//        Item item = service.getItemFromDAO("A1");
//        assertNotNull(item);
//        try {
//            item = service.getItemFromDAO("B1");
//            assertNull(item);
//        } catch (NullPointerException e) {
//            System.out.println("NullPointerException was encountered.");
//        }
//        
//    }

    /**
     * Test of setMoneyEnteredInDAO method, of class VendingMachineService.
     */
    @Test
    public void testSetandGetMoneyEnteredInDAO() throws Exception {
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
        
        Change myChange = new Change();
        myChange.setNickels(1);
        
        service.addMoneyEnteredToDAO(myChange);
        assertEquals("0.05", service.getMoneyEnteredFromDAO().toString());
        
        myChange.setNickels(2);
        
        service.addMoneyEnteredToDAO(myChange);
        assertEquals("0.15", service.getMoneyEnteredFromDAO().toString());
        
        myChange.setDimes(1);
        myChange.setNickels(3);
        
        service.addMoneyEnteredToDAO(myChange);
        assertEquals("0.40", service.getMoneyEnteredFromDAO().toString());
        
        myChange.setChangeToZero();
        myChange.setQuarters(100);
        
        service.addMoneyEnteredToDAO(myChange);
        assertEquals("25.40", service.getMoneyEnteredFromDAO().toString());    
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
        assertEquals(quarters, change3.getQuarters());
        nickels = 0;
        assertEquals(nickels, change3.getNickels());         
        dimes = 0;
        assertEquals(dimes, change3.getDimes());
        pennies = 0;
        assertEquals(pennies, change3.getPennies());
    }

    /**
     * Test of purchaseItem method, of class VendingMachineService.
     */
    @Test
    public void testPurchaseItem() throws Exception {

         service.setMoneyEnteredInDAO(new BigDecimal("0.26"));
         Item item2 = service.purchaseItem("A2");
         assertEquals("Candy2", item2.getName());
         assertEquals("0.09", service.getMoneyEnteredFromDAO().toString());
         
         try {
            service.setMoneyEnteredInDAO(new BigDecimal("0.04"));
            Item item1 = service.purchaseItem("A1");
            assertNull(item1.getName());
            fail ("Expected Insufficient Fund Excepion Not Encountered.");
         } catch (InsufficientFundException e) {
             
         }

         try {
            service.setMoneyEnteredInDAO(new BigDecimal("0.38"));
            Item item3 = service.purchaseItem("A2");
            assertNull(item3.getName());
            fail ("Item Not in Inventory Exception Not Encountered.");
         } catch (NoItemInventoryException e) {
         assertEquals("0.38", service.getMoneyEnteredFromDAO().toString());
         }

    }

    /*
    @Test
    public void testDepositCoin() throws Exception {
        service.setMoneyEnteredInDAO(new BigDecimal("0"));        
        service.depositCoin(4);
        assertEquals("0.25", service.getMoneyEnteredFromDAO().toString());
        service.depositCoin(3);
        assertEquals("0.35", service.getMoneyEnteredFromDAO().toString());
        service.depositCoin(2);
        assertEquals("0.40", service.getMoneyEnteredFromDAO().toString());
        service.depositCoin(1);
        assertEquals("0.41", service.getMoneyEnteredFromDAO().toString());
        service.depositCoin(0);
        assertEquals("0.41", service.getMoneyEnteredFromDAO().toString());        
    }
    
    */
    /**
     * Test of saveOnExit method, of class VendingMachineService.
     */
    @Test
    public void testSaveOnExit() throws Exception {
        service.saveOnExit();
    }
    
}
