/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringUniqueOrderNumberDao;
import com.sg.flooringmastery.dao.FlooringUniqueOrderNumberDaoInMemImpl;
import com.sg.flooringmastery.dto.UniqueOrderNumber;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class FlooringUniqueOrderNumberServiceTest {
    
    FlooringUniqueOrderNumberDao orderNumberDao = new FlooringUniqueOrderNumberDaoInMemImpl();
    
    FlooringUniqueOrderNumberService serviceDao = 
        new FlooringUniqueOrderNumberServiceImpl(orderNumberDao); 
    
    public FlooringUniqueOrderNumberServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNewUniqueOrderNumber method, of class FlooringUniqueOrderNumberService.
     */
    @Test
    public void testGetNewUniqueOrderNumber() {
        UniqueOrderNumber oldNumber = serviceDao.getCurrentOrderNumber();
        int oldNumberInt = oldNumber.getOrderNumber();
        UniqueOrderNumber newNumber = serviceDao.getNewUniqueOrderNumber();
        int newNumberInt = newNumber.getOrderNumber();
        
        assertTrue(oldNumberInt + 1 == newNumberInt); 
    }

    /**
     * Test of getCurrentOrderNumber method, of class FlooringUniqueOrderNumberService.
     */
    @Test
    public void testGetCurrentOrderNumber() {
        
        UniqueOrderNumber setNum = new UniqueOrderNumber();
        setNum.setOrderNumber(999);
        
        serviceDao.setCurrentOrderNumber(setNum);
        
        UniqueOrderNumber testNum = serviceDao.getCurrentOrderNumber();
        
        int testNumInt = testNum.getOrderNumber();
        
        assertTrue(testNumInt == 999);
        
    }

    /**
     * Test of setCurrentOrderNumber method, of class FlooringUniqueOrderNumberService.
     */
    @Test
    public void testSetCurrentOrderNumber() {
        
        UniqueOrderNumber setNum = new UniqueOrderNumber();
        setNum.setOrderNumber(999);
        
        serviceDao.setCurrentOrderNumber(setNum);
        
        UniqueOrderNumber testNum = serviceDao.getCurrentOrderNumber();
        
        int testNumInt = testNum.getOrderNumber();
        
        assertTrue(testNumInt == 999);        
        
    }
    
}
