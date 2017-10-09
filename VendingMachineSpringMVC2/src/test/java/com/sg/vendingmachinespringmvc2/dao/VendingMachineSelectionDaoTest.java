/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.dao;

import com.sg.vendingmachinespringmvc2.model.Selection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class VendingMachineSelectionDaoTest {
    
    private VendingMachineSelectionDao selectionDao;
    
    public VendingMachineSelectionDaoTest() {
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
        selectionDao = ctx.getBean("vendingMachineSelectionDao", VendingMachineSelectionDao.class);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of select method, of class VendingMachineSelectionDao.
     */
    @Test
    public void selectGet() {
        Selection selection = new Selection();
        selection.setSelection(1L);
        selectionDao.select(selection);
        Selection fromSelectionDao = selectionDao.getSelection();
        assertTrue(selection.equals(fromSelectionDao));
        
    }

    /**
     * Test of updateSelection method, of class VendingMachineSelectionDao.
     */
    @Test
    public void updateGet() {
        Selection selection = new Selection();
        selection.setSelection(1L);
        selectionDao.updateSelection(selection);
        Selection fromSelectionDao = selectionDao.getSelection();
        assertTrue(selection.equals(fromSelectionDao));        
    }

    /**
     * Test of removeSelection method, of class VendingMachineSelectionDao.
     */
    @Test
    public void removeGet() {
        selectionDao.removeSelection();
        assertNull(selectionDao.getSelection());
        
    }
    
}
