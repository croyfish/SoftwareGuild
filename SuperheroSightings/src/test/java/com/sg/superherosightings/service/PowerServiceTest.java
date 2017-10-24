/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.helpers.CompareObjects;
import com.sg.superherosightings.model.Power;
import java.util.List;
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
public class PowerServiceTest {
    
    private static CompareObjects compare = new CompareObjects();    
    
    public PowerServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
//        ApplicationContext ctx = ApplicationContextHelper.getContext();
//        dao = ctx.getBean("powerService", PowerService.class);        
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
     * Test of createPower method, of class PowerService.
     */
    @Test
    public void testCreatePower() {
    }

    /**
     * Test of getPowerById method, of class PowerService.
     */
    @Test
    public void testGetPowerById() {
    }

    /**
     * Test of getAllPowers method, of class PowerService.
     */
    @Test
    public void testGetAllPowers() {
    }

    /**
     * Test of updatePower method, of class PowerService.
     */
    @Test
    public void testUpdatePower() {
    }

    /**
     * Test of deletePower method, of class PowerService.
     */
    @Test
    public void testDeletePower() {
    }

    public class PowerServiceImpl implements PowerService {

        public Power createPower(Power power) {
            return null;
        }

        public Power getPowerById(Integer powerId) {
            return null;
        }

        public List<Power> getAllPowers(int offset, int limit) {
            return null;
        }

        public Power updatePower(Power power) {
            return null;
        }

        public Power deletePower(Integer powerId) {
            return null;
        }
    }
    
}
