/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

import com.sg.vendingmachinespringmvc2.dao.VendingMachineSelectionDao;
import com.sg.vendingmachinespringmvc2.model.Selection;
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
public class VendingMachineSelectionServiceTest {
    
    private VendingMachineSelectionService selectionService;
    
    public VendingMachineSelectionServiceTest() {
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
        selectionService = ctx.getBean("vendingMachineSelectionService", VendingMachineSelectionService.class);         
        
    }
    
    @After
    public void tearDown() {
    }

  /**
     * Test of select method, of class VendingMachineSelectionService.
     */
    @Test
    public void selectGet() {
        Selection selection = new Selection();
        selection.setSelection(1L);
        selectionService.select(selection);
        Selection fromSelectionService = selectionService.getSelection();
        assertTrue(selection.equals(fromSelectionService));
        
    }

    /**
     * Test of updateSelection method, of class VendingMachineSelectionService.
     */
    @Test
    public void updateGet() {
        Selection selection = new Selection();
        selection.setSelection(1L);
        selectionService.updateSelection(selection);
        Selection fromSelectionService = selectionService.getSelection();
        assertTrue(selection.equals(fromSelectionService));        
    }

    /**
     * Test of removeSelection method, of class VendingMachineSelectionService.
     */
    @Test
    public void removeGet() {
        selectionService.removeSelection();
        assertNull(selectionService.getSelection());
        
    }
    
}
