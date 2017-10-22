/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Power;
import java.util.List;
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
public class PowerDaoTest {

    private static PowerDao dao;

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

        // ask Spring for our Dao
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
        dao = ctx.getBean("powerDao", PowerDao.class);

        // remove all of the Addresses
        List<Power> powers = dao.getAllPowers(0, Integer.MAX_VALUE);
        for (Power currentPower : powers) {
            dao.deletePower(dao.getPowerById(currentPower.getPowerId()));
        }        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeletePower() {
        // arrange Street, City, State, Zipcode
        Power pow = new Power();
        pow.setName("Super Sneezing");

        // act
        pow = dao.createPower(pow);
        Power actualPower = dao.getPowerById(pow.getPowerId());
        // assert
        assertEquals(pow, actualPower);
        // act
        dao.deletePower(dao.getPowerById(pow.getPowerId()));
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
        assertTrue(createdPow1.equals(powers.get(0)) || createdPow2.equals(powers.get(0)));
        assertTrue(createdPow1.equals(powers.get(1)) || createdPow2.equals(powers.get(1)));

    }

}
