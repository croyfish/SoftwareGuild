/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.helpers.ApplicationContextHelper;
import com.sg.superherosightings.helpers.CompareObjects;
import com.sg.superherosightings.model.Power;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author jeffc
 */
public class PowerDaoTest {

    PowerDao dao;
    CompareObjects c = new CompareObjects();

    public PowerDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = ApplicationContextHelper.getContext();
        dao = ctx.getBean("powerDao", PowerDao.class);
        
        List<Power> powers = dao.getAllPowers(0, Integer.MAX_VALUE);
        for (Power currentPower : powers) {
            dao.deletePower(currentPower);
        }        
        
    }
    
    

    @Test

    public void addGetDeletePower() {

        // arrange Street, City, State, Zipcode
        Power pow = new Power();

        pow.setName("Super Sneezing");

        // act
        dao.createPower(pow);

        Power actualPower = dao.getPowerById(pow.getPowerId());

        // assert
        String result = c.compareObjects(pow, actualPower);

        dao.deletePower(dao.getPowerById(pow.getPowerId()));
        assertEquals(result, "");
        // assert

        assertNull(dao.getPowerById(pow.getPowerId()));

    }

    @Test

    public void updatePower() {

        // arrange Street, City, State, Zipcode
        Power pow = new Power();

        pow.setName("Super Sneezing");

        Power added = dao.createPower(pow);

        added.setName("Super Sleezing");

        //act
        Power updated = dao.updatePower(added);

        //assert
        assertEquals(added, updated);

    }

    @Test

    public void getAllPowers() {

        // arrange Street, City, State, Zipcode
        Power pow1 = new Power();

        pow1.setName("Super Sneezing");

        Power pow2 = new Power();

        pow2.setName("Super Sleezing");

        //Integer numInDb = dao.getAllPoweres(0, Integer.MAX_VALUE).size();
        Power createdPow1 = dao.createPower(pow1);

        Power createdPow2 = dao.createPower(pow2);

        //act
        List<Power> powers = dao.getAllPowers(0, 10);

        //assert
        assertEquals(2, powers.size());

        String result1 = c.compareObjects(createdPow1, powers.get(0));

        String result2 = c.compareObjects(createdPow2, powers.get(0));

        String result3 = c.compareObjects(createdPow1, powers.get(1));

        String result4 = c.compareObjects(createdPow2, powers.get(1));

        assertTrue(result1.equals("") || result2.equals(""));

        assertTrue(result3.equals("") || result4.equals(""));

    }

}
