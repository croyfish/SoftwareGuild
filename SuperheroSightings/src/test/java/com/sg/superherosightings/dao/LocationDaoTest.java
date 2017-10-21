/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
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
public class LocationDaoTest {
    
    public LocationDaoTest() {
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
     * Test of createLocation method, of class LocationDao.
     */
    @Test
    public void testCreateLocation() {
    }

    /**
     * Test of getLocationById method, of class LocationDao.
     */
    @Test
    public void testGetLocationById() {
    }

    /**
     * Test of getAllLocations method, of class LocationDao.
     */
    @Test
    public void testGetAllLocations() {
    }

    /**
     * Test of updateLocation method, of class LocationDao.
     */
    @Test
    public void testUpdateLocation() {
    }

    /**
     * Test of deleteLocation method, of class LocationDao.
     */
    @Test
    public void testDeleteLocation() {
    }

    /**
     * Test of getAllLocationsBySuperPerson method, of class LocationDao.
     */
    @Test
    public void testGetAllLocationsBySuperPerson() {
    }

    public class LocationDaoImpl implements LocationDao {

        public Location createLocation(Location location) {
            return null;
        }

        public Location getLocationById(Integer locationId) {
            return null;
        }

        public List<Location> getAllLocations(int offset, int limit) {
            return null;
        }

        public Location updateLocation(Location location) {
            return null;
        }

        public Location deleteLocation(Location location) {
            return null;
        }

        public List<Location> getAllLocationsBySuperPerson(SuperPerson superperson, int offset, int limit) {
            return null;
        }
    }
    
}
