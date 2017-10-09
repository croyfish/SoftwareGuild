/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

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
public class VendingMachineChangeServiceTest {
    
    private VendingMachineUserChangeService userChangeService;
    private VendingMachineMachineChangeService machineChangeService;
    
    public VendingMachineChangeServiceTest() {
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
        userChangeService = ctx.getBean("vendingMachineUserChangeService", VendingMachineUserChangeService.class);
        machineChangeService = ctx.getBean("vendingMachineMachineChangeService", VendingMachineMachineChangeService.class);        
    }
    
    @After
    public void tearDown() {
        userChangeService.removeChange();
        machineChangeService.removeChange();
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
        userChangeService.updateChange(userChange);
        Change fromUserChangeService = userChangeService.getChange();
        assertEquals(fromUserChangeService, userChange);
        userChangeService.removeChange();
        Change fromUserChangeService2 = userChangeService.getChange();
        assertEquals(0, fromUserChangeService2.getValueOfChange().compareTo(new BigDecimal("0")));
        
    }

    /**
     * Test of getChange method, of class VendingMachineUserChangeService.
     */
    @Test
    public void addUpdateSubtractUserChange() {
        
        Change userChange = new Change();
        userChange.setDollars(1);
        userChange.setQuarters(1);
        userChange.setDimes(1);
        userChange.setNickels(1);
        userChange.setPennies(1);
        
        userChangeService.updateChange(userChange);
        
        Change addedUserChange = new Change();
        addedUserChange.setDollars(1);
        addedUserChange.setQuarters(1);
        addedUserChange.setDimes(1);
        addedUserChange.setNickels(1);
        addedUserChange.setPennies(1);
        
        userChangeService.addChange(addedUserChange);
        
        Change fromUserChangeService = userChangeService.getChange();
        assertEquals(0, fromUserChangeService.getValueOfChange().compareTo(new BigDecimal("2.82")));
        
        userChangeService.subtractChange(addedUserChange);
        
        Change fromUserChangeService2 = userChangeService.getChange();
        assertEquals(0, fromUserChangeService2.getValueOfChange().compareTo(new BigDecimal("1.41")));
        
         
    }
    
@Test
    public void updateGetRemoveMachineChange() {
        Change machineChange = new Change();
        machineChange.setDollars(1);
        machineChange.setQuarters(1);
        machineChange.setDimes(1);
        machineChange.setNickels(1);
        machineChange.setPennies(1);
        machineChangeService.updateChange(machineChange);
        Change fromMachineChangeService = machineChangeService.getChange();
        assertEquals(fromMachineChangeService, machineChange);
        machineChangeService.removeChange();
        Change fromMachineChangeService2 = machineChangeService.getChange();
        assertEquals(0, fromMachineChangeService2.getValueOfChange().compareTo(new BigDecimal("0")));
        
    }

    /**
     * Test of getChange method, of class VendingMachineUserChangeService.
     */
    @Test
    public void addUpdateMachineChange() {
        
        Change machineChange = new Change();
        machineChange.setDollars(1);
        machineChange.setQuarters(1);
        machineChange.setDimes(1);
        machineChange.setNickels(1);
        machineChange.setPennies(1);
        machineChangeService.updateChange(machineChange);
        
        Change addedMachineChange = new Change();
        addedMachineChange.setDollars(1);
        addedMachineChange.setQuarters(1);
        addedMachineChange.setDimes(1);
        addedMachineChange.setNickels(1);
        addedMachineChange.setPennies(1);
        machineChangeService.addChange(addedMachineChange);
        
        Change fromMachineChangeService = machineChangeService.getChange();
        assertEquals(0, fromMachineChangeService.getValueOfChange().compareTo(new BigDecimal("2.82")));
         
    }    

    
}