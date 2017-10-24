/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.helpers.ApplicationContextHelper;
import com.sg.superherosightings.helpers.CompareObjects;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonSighting;
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
public class SuperPersonSightingDaoTest {

    private SuperPersonSightingDao dao;
    private static CompareObjects compare = new CompareObjects();

    public SuperPersonSightingDaoTest() {
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
        dao = ctx.getBean("superPersonSightingDao", SuperPersonSightingDao.class);

        List<SuperPersonSighting> superPersonSightings = dao.getAllSuperPersonSightings(0, Integer.MAX_VALUE);
        for (SuperPersonSighting currentSuperPersonSighting : superPersonSightings) {
            dao.deleteSuperPersonSighting(currentSuperPersonSighting);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createSuperPersonSighting method, of class
     * SuperPersonSightingDao.
     */
    @Test
    public void addGetDeleteSuperPersonSighting() {
        //arrange
        SuperPersonSighting spp = new SuperPersonSighting();

        SuperPerson superPerson = new SuperPerson();
        superPerson.setSuperPersonId(1);
        Sighting sighting = new Sighting();
        sighting.setSightingId(1);

        spp.setSuperPerson(superPerson);
        spp.setSighting(sighting);
        spp = dao.createSuperPersonSighting(spp);
        SuperPersonSighting fromDb = dao.getSuperPersonSightingById(spp.getSuperPersonSightingId());

        String result = compare.compareObjects(spp, fromDb);
        assertEquals(result, "");

        dao.deleteSuperPersonSighting(dao.getSuperPersonSightingById(spp.getSuperPersonSightingId()));
        assertNull(dao.getSuperPersonSightingById(spp.getSuperPersonSightingId()));
    }

    /**
     * Test of getAllSuperPersonSightinges method, of class
     * SuperPersonSightingDao.
     */
    @Test
    public void testGetAllSuperPersonSightings() {

        SuperPersonSighting spp1 = new SuperPersonSighting();

        SuperPerson superPerson = new SuperPerson();
        superPerson.setSuperPersonId(1);
        Sighting sighting = new Sighting();
        sighting.setSightingId(1);

        spp1.setSuperPerson(superPerson);
        spp1.setSighting(sighting);
        spp1 = dao.createSuperPersonSighting(spp1);

        SuperPersonSighting spp2 = new SuperPersonSighting();

        SuperPerson superPerson2 = new SuperPerson();
        superPerson2.setSuperPersonId(2);
        Sighting sighting2 = new Sighting();
        sighting2.setSightingId(2);

        spp2.setSuperPerson(superPerson2);
        spp2.setSighting(sighting2);
        spp2 = dao.createSuperPersonSighting(spp2);

        List<SuperPersonSighting> superPersonSightings = dao.getAllSuperPersonSightings(0, 10);
        assertEquals(2, superPersonSightings.size());
        assertTrue(spp1.equals(superPersonSightings.get(0)) || spp2.equals(superPersonSightings.get(0)));
        assertTrue(spp1.equals(superPersonSightings.get(1)) || spp2.equals(superPersonSightings.get(1)));
    }
}
