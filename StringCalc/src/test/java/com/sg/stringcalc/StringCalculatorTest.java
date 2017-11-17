/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.stringcalc;

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
public class StringCalculatorTest {
    
    public StringCalculatorTest() {
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
    public void shouldreturnNumber() {
        StringCalculator target = new StringCalculator();
        for (int i = 0; i < 10; i++) {
            int expected = i;
            String input;
            input = String.valueOf(i);
        int actual = target.sum(input);
        
        assertEquals(expected, actual);
        }
        
        
    }
    
    @Test
    public void shouldreturnsumfromcommadelimitedinput() {
        StringCalculator target = new StringCalculator();
        int expected = 6;
            String input = "1,2,3";
        int actual = target.sum(input);
        
        assertEquals(expected, actual);
        
        
    }
      @Test
    public void shouldallownewlinesreturnsum() {
        StringCalculator target = new StringCalculator();
        int expected = 6;
            String input = "1\n2,3";
        int actual = target.sum(input);
        
        assertEquals(expected, actual);
        
        
    }
      @Test
    public void shouldallowchange() {
        StringCalculator target = new StringCalculator();
        int expected = 6;
            String input = "//;\n1\n2;3";
        int actual = target.sum(input);
        
        assertEquals(expected, actual);
        
        
    }
}
