/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

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
public class StringTimesTest {
    
    StringTimes st = new StringTimes();
    
    public StringTimesTest() {
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

    @Test
    public void test0NoString() {
        assertTrue("".equals(st.stringTimes("", 0)));
    }
    
    @Test
    public void test0Hi() {
        assertTrue("".equals(st.stringTimes("Hi", 0)));
    }
    
    @Test
    public void testNeg3Hi() {
        assertTrue("".equals(st.stringTimes("Hi", -3)));
    }

    @Test
    public void test2Hi() {
        assertTrue("HiHi".equals(st.stringTimes("Hi", 2)));
    }       
    
    @Test
    public void test3Hi() {
        assertTrue("HiHiHi".equals(st.stringTimes("Hi", 3)));
    }
    
    @Test
    public void test3Space() {
        assertTrue("   ".equals(st.stringTimes(" ", 3)));
    }    
    
    @Test
    public void test1Hi() {
        assertTrue("Hi".equals(st.stringTimes("Hi", 1)));
    }
    
    @Test
    public void test3and3() {
        assertTrue("333".equals(st.stringTimes("3", 3)));
    }       
    
    
}
