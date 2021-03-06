/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.helpers.ApplicationContextHelper;
import com.sg.superherosightings.helpers.CompareObjects;
import com.sg.superherosightings.helpers.CreateAndAddObjectsForServiceTests;
import com.sg.superherosightings.helpers.TearDownHelper;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
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
public class LocationServiceTest {
    
    private static CompareObjects c = new CompareObjects();
    private static TearDownHelper tdh = new TearDownHelper();    
    private static CreateAndAddObjectsForServiceTests co = new CreateAndAddObjectsForServiceTests();
    
    private static LocationService locationService;
    private static AddressService addressService;
    private static SuperPersonService superPersonService;
    private static SightingService sightingService;
    

    
    
    public LocationServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = ApplicationContextHelper.getContext();
        locationService = ctx.getBean("locationService", LocationService.class);
        addressService = ctx.getBean("addressService", AddressService.class);
        superPersonService = ctx.getBean("superPersonService", SuperPersonService.class);
        sightingService = ctx.getBean("sightingService", SightingService.class);
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

   @Test
    public void addGetDeleteLocation() {
        // arrange
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

        Location actualLoc = locationService.getLocationById(loc.getLocationId());

        String result = c.compareObjects(loc, actualLoc);
        assertEquals(result, "");

        locationService.deleteLocation(locationService.getLocationById(loc.getLocationId()));

        assertNull(locationService.getLocationById(loc.getLocationId()));
    }

    @Test
    public void updateLocation() {

        // arrange
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
        Location added = locationService.createLocation(loc);

        loc.setDescription("Terrible place for awful coders and no lives!");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude("25, 32");
        loc.setLongitude("39, 23");

        Location updated = locationService.updateLocation(loc);

        String result = c.compareObjects(added, updated);
        assertEquals(result, "");

    }

    @Test
    public void getAllLocations() {
        //arrange
        //how is the ID being set? 

        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");
        add = addressService.createAddress(add);

        Location loc = new Location();
        loc.setDescription("Cool place for cool mutants");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude("23, 23");
        loc.setLongitude("23, 23");
        Location createdLoc1 = locationService.createLocation(loc);
        //arrange

        Location loc2 = new Location();
        loc2.setDescription("The home of Pat Toner");
        loc2.setName("The Software Guild");
        loc2.setAddress(add);
        loc2.setLatitude("223, 32");
        loc2.setLongitude("233, 23");
        
        Location createdLoc2 = locationService.createLocation(loc2);

        List<Location> locations = locationService.getAllLocations(0, 10);
        assertEquals(2, locations.size());
        
        String result1 = c.compareObjects(createdLoc1, locations.get(0));
        String result2 = c.compareObjects(createdLoc2, locations.get(0));
        String result3 = c.compareObjects(createdLoc1, locations.get(1));
        String result4 = c.compareObjects(createdLoc2, locations.get(1));
        
        assertTrue(result1.equals("") || result2.equals(""));
        
        assertTrue(result3.equals("") || result4.equals(""));
        
        
    }

    /**
     * Test of getAllLocationsBySuperPerson method, of class LocationService.
     */
    @Test
    public void testGetAllLocationsBySuperPerson() {

        //make some people
        SuperPerson sp1 = co.createAndAddSuperPerson();
        SuperPerson sp2 = co.createAndAddSuperPerson();
        
        //make some orgs
        Sighting s1 = co.createAndAddSighting();
        Sighting s2 = co.createAndAddSighting();
        
        Location loc1 = s1.getLocation();
        Location loc2 = s2.getLocation();
        loc2.setName("A Differet Location");
        loc2 = locationService.createLocation(loc2);

        s2.setLocation(loc2);
        Sighting s3 = sightingService.createSighting(s2);

        
        //associate them 
        superPersonService.addSuperPersonToSighting(sp1, s1);
        superPersonService.addSuperPersonToSighting(sp2, s1);
        superPersonService.addSuperPersonToSighting(sp2, s3);
        
        //pull them out lists
        
        List<Location> listOfLoc1 = locationService.getAllLocationsBySuperPerson(sp1, 0, 10);
        List<Location> listOfLoc2 = locationService.getAllLocationsBySuperPerson(sp2, 0, 10);
        
        //assertions
        
        assertEquals(1, listOfLoc1.size());
        assertEquals(2, listOfLoc2.size());

        for (Location currentLoc : listOfLoc2) {
            
            String result1 = c.compareObjects(loc1, currentLoc);
            String result2 = c.compareObjects(loc2, currentLoc);
            
            assertTrue(result1.equals("") ^ result2.equals(""));
        }
        
        String result3 = c.compareObjects(loc2, listOfLoc2.get(0));
        assertEquals("", result3);      
        
    }
    
}
