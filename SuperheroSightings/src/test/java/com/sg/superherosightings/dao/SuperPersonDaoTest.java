/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
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
public class SuperPersonDaoTest {
    
    public SuperPersonDaoTest() {
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
     * Test of createSuperPerson method, of class SuperPersonDao.
     */
    @Test
    public void testCreateSuperPerson() {
    }

    /**
     * Test of getSuperPersonById method, of class SuperPersonDao.
     */
    @Test
    public void testGetSuperPersonById() {
    }

    /**
     * Test of getAllSuperPersons method, of class SuperPersonDao.
     */
    @Test
    public void testGetAllSuperPersons() {
    }

    /**
     * Test of updateSuperPerson method, of class SuperPersonDao.
     */
    @Test
    public void testUpdateSuperPerson() {
    }

    /**
     * Test of deleteSuperPerson method, of class SuperPersonDao.
     */
    @Test
    public void testDeleteSuperPerson() {
    }

    /**
     * Test of getAllSuperPersonsBySighting method, of class SuperPersonDao.
     */
    @Test
    public void testGetAllSuperPersonsBySighting() {
    }

    /**
     * Test of getAllSuperPersonsBySightingLocation method, of class SuperPersonDao.
     */
    @Test
    public void testGetAllSuperPersonsBySightingLocation() {
    }

    /**
     * Test of getAllSuperPersonsByOrganization method, of class SuperPersonDao.
     */
    @Test
    public void testGetAllSuperPersonsByOrganization() {
    }

    public class SuperPersonDaoImpl implements SuperPersonDao {

        public SuperPerson createSuperPerson(SuperPerson superPerson) {
            return null;
        }

        public SuperPerson getSuperPersonById(Integer superPersonId) {
            return null;
        }

        public List<SuperPerson> getAllSuperPersons(int offset, int limit) {
            return null;
        }

        public SuperPerson updateSuperPerson(SuperPerson superPerson) {
            return null;
        }

        public SuperPerson deleteSuperPerson(Integer superPersonId) {
            return null;
        }

        public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit) {
            return null;
        }

        public List<SuperPerson> getAllSuperPersonsBySightingLocation(Location location, int offset, int limit) {
            return null;
        }

        public List<SuperPerson> getAllSuperPersonsByOrganization(Organization organization, int offset, int limit) {
            return null;
        }
    }
    
}
