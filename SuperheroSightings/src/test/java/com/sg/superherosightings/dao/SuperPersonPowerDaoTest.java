/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonPower;
import java.util.List;
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
public class SuperPersonPowerDaoTest {
private SuperPersonPowerDao dao;
    public SuperPersonPowerDaoTest() {
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
                = new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
        dao = ctx.getBean("superPersonPowerDao", SuperPersonPowerDao.class);
        
        List<SuperPersonPower> superPersonPowers = dao.getAllSuperPersonPowers(0, Integer.MAX_VALUE);
        for (SuperPersonPower currentSuperPersonPower : superPersonPowers) {
            dao.deleteSuperPersonPower(currentSuperPersonPower);
        }
    }
    @After
    public void tearDown() {
    }
    /**
     * Test of createSuperPersonPower method, of class SuperPersonPowerDao.
     */
    @Test
    public void addGetDeleteSuperPersonPower() {
        //arrange
        SuperPersonPower spp = new SuperPersonPower();
        
        SuperPerson superPerson = new SuperPerson();
        superPerson.setSuperPersonId(1);
        Power power = new Power();
        power.setPowerId(1);
        
        spp.setSuperPerson(superPerson);
        spp.setPower(power);        
        spp = dao.createSuperPersonPower(spp);
        SuperPersonPower fromDb = dao.getSuperPersonPowerById(spp.getSuperPersonPowerId());
        assertEquals(spp, fromDb);
        
        dao.deleteSuperPersonPower(dao.getSuperPersonPowerById(spp.getSuperPersonPowerId()));
        assertNull(dao.getSuperPersonPowerById(spp.getSuperPersonPowerId()));
    }
    /**
     * Test of getAllSuperPersonPoweres method, of class SuperPersonPowerDao.
     */
    @Test
    public void testGetAllSuperPersonPowers() {
        
        
        SuperPersonPower spp1 = new SuperPersonPower();
        
        SuperPerson superPerson = new SuperPerson();
        superPerson.setSuperPersonId(1);
        Power power = new Power();
        power.setPowerId(1);
        
        spp1.setSuperPerson(superPerson);
        spp1.setPower(power);        
        spp1 = dao.createSuperPersonPower(spp1);
        
        
        
        SuperPersonPower spp2 = new SuperPersonPower();
        
        SuperPerson superPerson2 = new SuperPerson();
        superPerson2.setSuperPersonId(2);
        Power power2 = new Power();
        power2.setPowerId(2);
        
        spp2.setSuperPerson(superPerson2);
        spp2.setPower(power2);        
        spp2 = dao.createSuperPersonPower(spp2);        
        
        List<SuperPersonPower> superPersonPowers = dao.getAllSuperPersonPowers(0, 10);
        assertEquals(2, superPersonPowers.size());
        assertTrue(spp1.equals(superPersonPowers.get(0)) || spp2.equals(superPersonPowers.get(0)));
        assertTrue(spp1.equals(superPersonPowers.get(1)) || spp2.equals(superPersonPowers.get(1)));
    }
}
