/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class LocationDaoTest {

    private static LocationDao dao;

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
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        dao = ctx.getBean("locationDao", LocationDao.class);

        List<Location> locations = dao.getAllLocations(0, Integer.MAX_VALUE);
        for (Location currentLocation : locations) {
            dao.deleteLocation(currentLocation);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteLocation() {

        //arrange
        Location loc = new Location();
        Address add = new Address();
        add.setAddressId(1);

        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude("23,32");
        loc.setLongitude("23, 23");
        loc = dao.createLocation(loc);

        Location actualLoc = dao.getLocationById(loc.getLocationId());
        assertEquals(loc, actualLoc);
        dao.deleteLocation(dao.getLocationById(loc.getLocationId()));
        assertNull(dao.getLocationById(loc.getLocationId()));

    }

public void updateLocation() {

         //First Location 

        Location loc = new Location();
        Address add = new Address(); 
        add.setAddressId(1);      
        loc.setLocationId(1);
        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);       
        loc.setLatitude("23, 32");
        loc.setLongitude("23, 23");       

        Location loc2 = dao.createLocation(loc);

        //Second location 
        Address add2 = new Address();
        add2.setAddressId(1);         
        loc2.setLocationId(1);
        loc2.setDescription("Terrible place for awful coders and no lives!");
        loc2.setName("The Software Guild");
        loc2.setAddress(add);      
        loc2.setLatitude("25, 32");
        loc2.setLongitude("39, 23");     

        Location updated = dao.updateLocation(loc2);

        assertEquals(updated, loc2);
    }

    @Test
    public void getAllLocations() {

        //arrange
        Location loc = new Location();
        Address add = new Address(); 
        add.setAddressId(1);      
        loc.setLocationId(1);
        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);       
        loc.setLatitude("23, 32");
        loc.setLongitude("23, 23"); 
        
        loc = dao.createLocation(loc);

        //arrange
        Location loc2 = new Location();
        Address add2 = new Address();
        add2.setAddressId(2);
        loc2.setLocationId(2);
        loc2.setDescription("Cool place for cool people with coding powers!");
        loc2.setName("The Software Guild");
        loc2.setAddress(add2);       
        loc2.setLatitude("23, 32");
        loc2.setLongitude("23, 23");
        
        loc2 = dao.createLocation(loc2);


        List<Location> Locations = dao.getAllLocations(0, 10);
        assertEquals(2, Locations.size());

    }

}
