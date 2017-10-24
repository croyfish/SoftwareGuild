/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.helpers.ApplicationContextHelper;
import com.sg.superherosightings.helpers.CompareObjects;
import com.sg.superherosightings.helpers.TearDownHelper;
import com.sg.superherosightings.model.Address;
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

/**
 *
 * @author jeffc
 */
public class SightingServiceTest {
    
    public SightingServiceTest() {
    }

    private static CompareObjects c = new CompareObjects();
    private static TearDownHelper tdh = new TearDownHelper();
    private static SightingService sightingService;
    private static LocationService locationService;
    private static AddressService addressService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    
    @BeforeClass

    public static void setUpClass() {
        ApplicationContext ctx = ApplicationContextHelper.getContext();
        sightingService = ctx.getBean("sightingService", SightingService.class);
        locationService = ctx.getBean("locationService", LocationService.class);
        addressService = ctx.getBean("addressService", AddressService.class);
        tdh.clearTables();        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        tdh.clearTables();   
    }

    /**
     *
     * Test of createSighting method, of class SightingService.
     *
     */
    @Test

    public void addGetDeleteSighting() {

        //arrange
        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");
        add = addressService.createAddress(add);
        
        
        Location loc = new Location();
        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude(" 23, 23");
        loc.setLongitude(" 23, 23");
        loc = locationService.createLocation(loc);
        
        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("20171022", formatter));
        sighting.setLocation(loc);
        sighting.setDescription("SuperPerson was learning to code....");

        //this actually fills the field of sp
        sighting = sightingService.createSighting(sighting); //check order of sping fields

//        Integer sightingId = sighting.getSightingId();
        Sighting fromDb = sightingService.getSightingById(sighting.getSightingId());
        String result = c.compareObjects(sighting, fromDb);
        assertEquals(result, "");

        sightingService.deleteSighting(sightingService.getSightingById(sighting.getSightingId()));
        assertNull(sightingService.getSightingById(sighting.getSightingId()));

    }

    /**
     *
     * Test of getAllSightinges method, of class SightingService.
     *
     */
    @Test

    public void testGetAllSightings() {

        //arrange
        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");
        add = addressService.createAddress(add);
        
        
        Location loc = new Location();
        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude(" 23, 23");
        loc.setLongitude(" 23, 23");
        loc = locationService.createLocation(loc);
        
        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("20171022", formatter));
        sighting.setLocation(loc);
        sighting.setDescription("SuperPerson was learning to code....");

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("20171021", formatter));
        sighting2.setLocation(loc);
        sighting2.setDescription("SuperPerson was cruising....");

        Sighting createdSighting1 = sightingService.createSighting(sighting);
        Sighting createdSighting2 = sightingService.createSighting(sighting2);

        //Integer numInDb = service.getAllSightinges(0, Integer.MAX_VALUE).size();
        List<Sighting> sightings = sightingService.getAllSightings(0, 10);

        String result1 = c.compareObjects(createdSighting1, sightings.get(0));
        String result2 = c.compareObjects(createdSighting2, sightings.get(0));
        String result3 = c.compareObjects(createdSighting1, sightings.get(1));
        String result4 = c.compareObjects(createdSighting2, sightings.get(1));

        assertTrue(result1.equals("") || result2.equals(""));
        assertTrue(result3.equals("") || result4.equals(""));
      
    }

    /**
     *
     * Test of updateSighting method, of class SightingService.
     *
     */
    @Test

    public void testUpdateSighting() {

       //arrange
        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");
        add = addressService.createAddress(add);
           
        Location loc = new Location();
        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude(" 23, 23");
        loc.setLongitude(" 23, 23");
        loc = locationService.createLocation(loc);
        
        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("20171022", formatter));
        sighting.setLocation(loc);
        sighting.setDescription("SuperPerson was learning to code....");
        sighting = sightingService.createSighting(sighting);
        
        sighting.setDate(LocalDate.parse("20160121", formatter));
        sighting.setLocation(loc);
        sighting.setDescription("SuperPerson wasn't learning to code");

        //'sped' is updated with setters
        //then the update method changes the original db entry
        //the 'sped' should be the same as the db entry
        Sighting updated = sightingService.updateSighting(sighting);
        String result = c.compareObjects(sighting, updated);

        assertEquals(result, "");
    }

    @Test
    public void testGetAllSightingsByDate() {
        
        Address add1 = new Address();
        add1.setStreet("123 Fake Street");
        add1.setCity("Faketown");
        add1.setState("OX");
        add1.setZipcode("12345");


        Address add2 = new Address();
        add2.setStreet("123 Fake Street");
        add2.setCity("Faketown");
        add2.setState("OX");
        add2.setZipcode("12345");

        Address addedAddress1 = addressService.createAddress(add1);
        Address addedAddress2 = addressService.createAddress(add2);

        Location loc1 = new Location();
        loc1.setDescription("Cool place for cool mutants");
        loc1.setName("The Software Guild");
        loc1.setAddress(addedAddress1);
        loc1.setLatitude("23, 23");
        loc1.setLongitude("23, 23");
        //arrange

        Location loc2 = new Location();
        loc2.setLocationId(2);
        loc2.setDescription("The home of Pat Toner");
        loc2.setName("The Software Guild");
        loc2.setAddress(add2);
        loc2.setLatitude("223, 32");
        loc2.setLongitude("233, 23");

        Location addedLoc1 = locationService.createLocation(loc1);
        Location addedLoc2 = locationService.createLocation(loc2);
        
        Sighting sighting1 = new Sighting();
        sighting1.setDate(LocalDate.parse("20171022", formatter));
        sighting1.setLocation(addedLoc1);
        sighting1.setDescription("SuperPerson was learning to code....");
        
        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("20171022", formatter));
        sighting2.setLocation(addedLoc2);
        sighting2.setDescription("SuperPerson was cruising....");

        Sighting createdSighting1 = sightingService.createSighting(sighting1);
        Sighting createdSighting2 = sightingService.createSighting(sighting2);

        List<Sighting> sightingsList = sightingService.
                getAllSightingsByDate(LocalDate.parse("20171022", formatter), 0, 10);

        assertEquals(2, sightingsList.size());

        for (Sighting currentSighting : sightingsList) {
            
            String result1 = c.compareObjects(createdSighting1, currentSighting);
            String result2 = c.compareObjects(createdSighting2, currentSighting);
            
            assertTrue(result1.equals("") ^ result2.equals(""));
        }

    }

}
