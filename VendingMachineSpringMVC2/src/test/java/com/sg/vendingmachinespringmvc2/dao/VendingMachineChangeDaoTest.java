/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.dao;

import com.sg.vendingmachinespringmvc2.model.Change;
import java.math.BigDecimal;
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
public class VendingMachineChangeDaoTest {
    
    private VendingMachineChangeDao userChangeDao;
    private VendingMachineChangeDao machineChangeDao;
    
    public VendingMachineChangeDaoTest() {
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
        userChangeDao = ctx.getBean("vendingMachineUserChangeDao", VendingMachineChangeDao.class);
        machineChangeDao = ctx.getBean("vendingMachineMachineChangeDao", VendingMachineChangeDao.class);        
    }
    
    @After
    public void tearDown() {
        userChangeDao.removeChange();
        machineChangeDao.removeChange();
    }

    /**
     * Test of addChange method, of class VendingMachineChangeDao.
     */
    @Test
    public void updateGetRemoveUserChange() {
        Change userChange = new Change();
        userChange.setDollars(1);
        userChange.setQuarters(1);
        userChange.setDimes(1);
        userChange.setNickels(1);
        userChange.setPennies(1);
        userChangeDao.updateChange(userChange);
        Change fromUserChangeDao = userChangeDao.getChange();
        assertEquals(fromUserChangeDao, userChange);
        userChangeDao.removeChange();
        Change fromUserChangeDao2 = userChangeDao.getChange();
        assertEquals(0, fromUserChangeDao2.getValueOfChange().compareTo(new BigDecimal("0")));
        
    }

    /**
     * Test of getChange method, of class VendingMachineChangeDao.
     */
    @Test
    public void addUpdateUserChange() {
        
        Change userChange = new Change();
        userChange.setDollars(1);
        userChange.setQuarters(1);
        userChange.setDimes(1);
        userChange.setNickels(1);
        userChange.setPennies(1);
        userChangeDao.updateChange(userChange);
        
        Change addedUserChange = new Change();
        addedUserChange.setDollars(1);
        addedUserChange.setQuarters(1);
        addedUserChange.setDimes(1);
        addedUserChange.setNickels(1);
        addedUserChange.setPennies(1);
        userChangeDao.addChange(addedUserChange);
        
        Change fromUserChangeDao = userChangeDao.getChange();
        assertEquals(0, fromUserChangeDao.getValueOfChange().compareTo(new BigDecimal("2.82")));
         
    }
    
@Test
    public void updateGetRemoveMachineChange() {
        Change machineChange = new Change();
        machineChange.setDollars(1);
        machineChange.setQuarters(1);
        machineChange.setDimes(1);
        machineChange.setNickels(1);
        machineChange.setPennies(1);
        machineChangeDao.updateChange(machineChange);
        Change fromMachineChangeDao = machineChangeDao.getChange();
        assertEquals(fromMachineChangeDao, machineChange);
        machineChangeDao.removeChange();
        Change fromMachineChangeDao2 = machineChangeDao.getChange();
        assertEquals(0, fromMachineChangeDao2.getValueOfChange().compareTo(new BigDecimal("0")));
        
    }

    /**
     * Test of getChange method, of class VendingMachineChangeDao.
     */
    @Test
    public void addUpdateMachineChange() {
        
        Change machineChange = new Change();
        machineChange.setDollars(1);
        machineChange.setQuarters(1);
        machineChange.setDimes(1);
        machineChange.setNickels(1);
        machineChange.setPennies(1);
        machineChangeDao.updateChange(machineChange);
        
        Change addedMachineChange = new Change();
        addedMachineChange.setDollars(1);
        addedMachineChange.setQuarters(1);
        addedMachineChange.setDimes(1);
        addedMachineChange.setNickels(1);
        addedMachineChange.setPennies(1);
        machineChangeDao.addChange(addedMachineChange);
        
        Change fromMachineChangeDao = machineChangeDao.getChange();
        assertEquals(0, fromMachineChangeDao.getValueOfChange().compareTo(new BigDecimal("2.82")));
         
    }    

    
}
