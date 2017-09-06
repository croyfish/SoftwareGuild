/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class PlayOutsideTest {
    
    private PlayOutside po = new PlayOutside();
    
    public PlayOutsideTest() {
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
     * Test of playOutside method, of class PlayOutside.
     * @throws java.lang.Exception
     */
    @Test
    public void testPlayOutside59False() throws Exception {
        assertFalse(po.playOutside(59, false));
    }    

    @Test
    public void testPlayOutside59True() throws Exception {
        assertFalse(po.playOutside(59, true));
    }    
    
    @Test
    public void testPlayOutside70False() throws Exception {
        assertTrue(po.playOutside(70, false));
    }
    
    @Test
    public void testPlayOutside95False() throws Exception {
        assertFalse(po.playOutside(95, false));
    }

    @Test
    public void testPlayOutside95True() throws Exception {
        assertTrue(po.playOutside(95, true));
    }    
    
}
