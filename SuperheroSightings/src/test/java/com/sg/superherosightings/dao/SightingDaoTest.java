/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class SightingDaoTest {
    
    SightingDao dao = new SightingDaoDbImpl();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    
    
    //issue with dates
    //dates are stored in mySQL as a subclass of java's Date
    //thus to enter a date, we need to convert 
    
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
        ApplicationContext ctx
            = new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
        dao = ctx.getBean("sightingDao", SightingDao.class);
        
        List<Sighting> sightings = dao.getAllSightings(0, Integer.MAX_VALUE);
        for (Sighting currentSighting : sightings) {
            dao.deleteSighting(currentSighting);
        }
     
    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSighting method, of class SightingDao.
     */
    @Test
    public void addGetDeleteSighting() {
        //arrange
        Sighting sighting = new Sighting();
        Location location = new Location();
        location.setLocationId(1);
        
        sighting.setDate(LocalDate.parse("20171022", formatter));
        sighting.setLocation(location);
        sighting.setDescription("SuperPerson was learning to code....");
        
        //this actually fills the field of sp
        sighting = dao.createSighting(sighting); //check order of sping fields
        
//        Integer sightingId = sighting.getSightingId();
        
        Sighting fromDb = dao.getSightingById(sighting.getSightingId());
        
        
        assertEquals(sighting, fromDb);
        dao.deleteSighting(dao.getSightingById(sighting.getSightingId()));
        assertNull(dao.getSightingById(sighting.getSightingId()));
        
    }

    
    /**
     * Test of getAllSightinges method, of class SightingDao.
     */
    @Test
    public void testGetAllSightings() {
        Sighting sighting = new Sighting();
        Location location = new Location();
        location.setLocationId(1);
        
        sighting.setDate(LocalDate.parse("20171022", formatter));
        sighting.setLocation(location);
        sighting.setDescription("SuperPerson was learning to code....");
        
        Sighting sighting2 = new Sighting();
        Location location2 = new Location();
        location2.setLocationId(2);
        
        sighting2.setDate(LocalDate.parse("20171021", formatter));
        sighting2.setLocation(location2);
        sighting2.setDescription("SuperPerson was cruising....");
        
        Sighting createdSighting1 = dao.createSighting(sighting);
        Sighting createdSighting2 = dao.createSighting(sighting2);
        
        //Integer numInDb = dao.getAllSightinges(0, Integer.MAX_VALUE).size();
        
        
        List<Sighting> sightings = dao.getAllSightings(0, 10);
        
        
        
        assertEquals(2, sightings.size());
        
        assertTrue(createdSighting1.equals(sightings.get(0)) || createdSighting2.equals(sightings.get(0)));
        assertTrue(createdSighting1.equals(sightings.get(1)) || createdSighting2.equals(sightings.get(1)));
    }

    /**
     * Test of updateSighting method, of class SightingDao.
     */
    @Test
    public void testUpdateSighting() {
    
        Sighting sighting = new Sighting();
        Location location = new Location();
        location.setLocationId(1);
        
        sighting.setDate(LocalDate.parse("20171022", formatter));
        sighting.setLocation(location);
        sighting.setDescription("SuperPerson was learning to code....");
        
        dao.createSighting(sighting); 
        
        sighting.setDate(LocalDate.parse("20160121", formatter));
        sighting.setLocation(location);
        sighting.setDescription("SuperPerson wasn't learning to code");
        
        //'sped' is updated with setters
        //then the update method changes the original db entry
        //the 'sped' should be the same as the db entry
        
        Sighting updated = dao.updateSighting(sighting);
        
        assertEquals(sighting, updated);
        
    
    }

    @Test
    public void testGetAllSightingsByDate() {
        Sighting sighting1 = new Sighting();
        
        Location location = new Location();
        location.setLocationId(1);
        
        sighting1.setDate(LocalDate.parse("20171022", formatter));
        sighting1.setLocation(location);
        sighting1.setDescription("SuperPerson was learning to code....");
        
        Sighting sighting2 = new Sighting();
        
        Location location2 = new Location();
        location2.setLocationId(2);
        
        sighting2.setDate(LocalDate.parse("20171022", formatter));
        sighting2.setLocation(location2);
        sighting2.setDescription("SuperPerson was cruising....");
        
//        Sighting sighting3 = new Sighting();
//        
//        Location location3 = new Location();
//        location.setLocationId(3);
//        
//        sighting3.setDate(LocalDate.parse("20160121", formatter));
//        sighting3.setLocation(location3);
//        sighting3.setDescription("SuperPerson was on fire in a church....");
        
        Sighting createdSighting1 = dao.createSighting(sighting1);
        Sighting createdSighting2 = dao.createSighting(sighting2);
//        Sighting createdSighting3 = dao.createSighting(sighting3);
        
        List<Sighting> sightingsList = dao.getAllSightingsByDate(LocalDate.parse("20171022", formatter), 0, 10);
        
        assertEquals(2, sightingsList.size());
        
        for (Sighting currentSighting : sightingsList){
            assertTrue(currentSighting.equals(createdSighting1) || currentSighting.equals(createdSighting2) );
        }
        
        
    }

    
}