/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
import com.sg.superherosightings.model.SuperPersonPower;
import com.sg.superherosightings.model.SuperPersonSighting;
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
public class SuperPersonServiceTest {
    
    public SuperPersonServiceTest() {
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
     * Test of createSuperPerson method, of class SuperPersonService.
     */
    @Test
    public void testCreateSuperPerson() {
    }

    /**
     * Test of getSuperPersonById method, of class SuperPersonService.
     */
    @Test
    public void testGetSuperPersonById() {
    }

    /**
     * Test of getAllSuperPersons method, of class SuperPersonService.
     */
    @Test
    public void testGetAllSuperPersons() {
    }

    /**
     * Test of updateSuperPerson method, of class SuperPersonService.
     */
    @Test
    public void testUpdateSuperPerson() {
    }

    /**
     * Test of deleteSuperPerson method, of class SuperPersonService.
     */
    @Test
    public void testDeleteSuperPerson() {
    }

    /**
     * Test of getAllSuperPersonsBySighting method, of class SuperPersonService.
     */
    @Test
    public void testGetAllSuperPersonsBySighting() {
    }

    /**
     * Test of getAllSuperPersonsBySightingLocation method, of class SuperPersonService.
     */
    @Test
    public void testGetAllSuperPersonsBySightingLocation() {
    }

    /**
     * Test of getAllSuperPersonsByOrganization method, of class SuperPersonService.
     */
    @Test
    public void testGetAllSuperPersonsByOrganization() {
    }

    /**
     * Test of addSuperPersonToPower method, of class SuperPersonService.
     */
    @Test
    public void testAddSuperPersonToPower_SuperPerson_Power() {
    }

    /**
     * Test of addSuperPersonToPower method, of class SuperPersonService.
     */
    @Test
    public void testAddSuperPersonToPower_Integer_Integer() {
    }

    /**
     * Test of deleteSuperPersonFromPower method, of class SuperPersonService.
     */
    @Test
    public void testDeleteSuperPersonFromPower_SuperPerson_Power() {
    }

    /**
     * Test of deleteSuperPersonFromPower method, of class SuperPersonService.
     */
    @Test
    public void testDeleteSuperPersonFromPower_Integer_Integer() {
    }

    /**
     * Test of addSuperPersonToOrganization method, of class SuperPersonService.
     */
    @Test
    public void testAddSuperPersonToOrganization_SuperPerson_Organization() {
    }

    /**
     * Test of addSuperPersonToOrganization method, of class SuperPersonService.
     */
    @Test
    public void testAddSuperPersonToOrganization_Integer_Integer() {
    }

    /**
     * Test of deleteSuperPersonFromOrganization method, of class SuperPersonService.
     */
    @Test
    public void testDeleteSuperPersonFromOrganization_SuperPerson_Organization() {
    }

    /**
     * Test of deleteSuperPersonFromOrganization method, of class SuperPersonService.
     */
    @Test
    public void testDeleteSuperPersonFromOrganization_Integer_Integer() {
    }

    /**
     * Test of addSuperPersonToSighting method, of class SuperPersonService.
     */
    @Test
    public void testAddSuperPersonToSighting_SuperPerson_Sighting() {
    }

    /**
     * Test of addSuperPersonToSighting method, of class SuperPersonService.
     */
    @Test
    public void testAddSuperPersonToSighting_Integer_Integer() {
    }

    /**
     * Test of deleteSuperPersonFromSighting method, of class SuperPersonService.
     */
    @Test
    public void testDeleteSuperPersonFromSighting_SuperPerson_Sighting() {
    }

    /**
     * Test of deleteSuperPersonFromSighting method, of class SuperPersonService.
     */
    @Test
    public void testDeleteSuperPersonFromSighting_Integer_Integer() {
    }

    public class SuperPersonServiceImpl implements SuperPersonService {

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

        public SuperPersonPower addSuperPersonToPower(SuperPerson superPerson, Power power) {
            return null;
        }

        public SuperPersonPower addSuperPersonToPower(Integer superPersonId, Integer powerId) {
            return null;
        }

        public SuperPersonPower deleteSuperPersonFromPower(SuperPerson superPerson, Power power) {
            return null;
        }

        public SuperPersonPower deleteSuperPersonFromPower(Integer superPersonId, Integer powerId) {
            return null;
        }

        public SuperPersonOrganization addSuperPersonToOrganization(SuperPerson superPerson, Organization organization) {
            return null;
        }

        public SuperPersonOrganization addSuperPersonToOrganization(Integer superPersonId, Integer organizationId) {
            return null;
        }

        public SuperPersonOrganization deleteSuperPersonFromOrganization(SuperPerson superPerson, Organization organization) {
            return null;
        }

        public SuperPersonOrganization deleteSuperPersonFromOrganization(Integer superPersonId, Integer organizationId) {
            return null;
        }

        public SuperPersonSighting addSuperPersonToSighting(SuperPerson superPerson, Sighting sighting) {
            return null;
        }

        public SuperPersonSighting addSuperPersonToSighting(Integer superPersonId, Integer sightingId) {
            return null;
        }

        public SuperPersonSighting deleteSuperPersonFromSighting(SuperPerson superPerson, Sighting sighting) {
            return null;
        }

        public SuperPersonSighting deleteSuperPersonFromSighting(Integer superPersonId, Integer sightingId) {
            return null;
        }
    }
    
}
