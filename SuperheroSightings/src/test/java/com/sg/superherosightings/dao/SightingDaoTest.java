/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
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
public class SightingDaoTest {
    
    public SightingDaoTest() {
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
     * Test of createSighting method, of class SightingDao.
     */
    @Test
    public void testCreateSighting() {
    }

    /**
     * Test of getSightingById method, of class SightingDao.
     */
    @Test
    public void testGetSightingById() {
    }

    /**
     * Test of getAllSightings method, of class SightingDao.
     */
    @Test
    public void testGetAllSightings() {
    }

    /**
     * Test of updateSighting method, of class SightingDao.
     */
    @Test
    public void testUpdateSighting() {
    }

    /**
     * Test of deleteSighting method, of class SightingDao.
     */
    @Test
    public void testDeleteSighting() {
    }

    /**
     * Test of getAllSightingsByDate method, of class SightingDao.
     */
    @Test
    public void testGetAllSightingsByDate() {
    }

    public class SightingDaoImpl implements SightingDao {

        public Sighting createSighting(Sighting sighting) {
            return null;
        }

        public Sighting getSightingById(Integer sightingId) {
            return null;
        }

        public List<Sighting> getAllSightings(int offset, int limit) {
            return null;
        }

        public Sighting updateSighting(Sighting sighting) {
            return null;
        }

        public Sighting deleteSighting(Integer sightingId) {
            return null;
        }

        public List<Sighting> getAllSightingsByDate(LocalDate date, int offset, int limit) {
            return null;
        }
    }
    
}
