/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.PowerDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperPersonOrganizationDao;
import com.sg.superherosightings.dao.SuperPersonPowerDao;
import com.sg.superherosightings.dao.SuperPersonSightingDao;
import com.sg.superherosightings.helpers.ApplicationContextHelper;
import com.sg.superherosightings.helpers.CompareObjects;
import com.sg.superherosightings.helpers.TearDownHelper;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonPower;
import com.sg.superherosightings.model.SuperPersonSighting;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;





/**
 *
 * @author jeffc
 */
public class SuperPersonServiceTest {
    
        private static CompareObjects c = new CompareObjects();
        private static TearDownHelper tdh = new TearDownHelper();
        
        private static SuperPersonService superPersonService;
        private static LocationService locationService;
        private static AddressService addressService;
        
        private static OrganizationService organizationService;
        private static PowerService powerService;
        private static SightingService sightingService;
        
        private static SuperPersonOrganizationDao superPersonOrganizationDao;
        private static SuperPersonPowerDao superPersonPowerDao;
        private static SuperPersonSightingDao superPersonSightingDao;               
    
    public SuperPersonServiceTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        ApplicationContext ctx = ApplicationContextHelper.getContext();
        
        superPersonService = ctx.getBean("superPersonService", SuperPersonService.class);
        
        organizationService = ctx.getBean("organizationService", OrganizationService.class);
        powerService = ctx.getBean("powerService", PowerService.class);
        sightingService = ctx.getBean("sightingService", SightingService.class);
        
        superPersonOrganizationDao = ctx.getBean("superPersonOrganizationDao", SuperPersonOrganizationDao.class);
        superPersonPowerDao = ctx.getBean("superPersonPowerDao", SuperPersonPowerDao.class);
        superPersonSightingDao = ctx.getBean("superPersonSightingDao", SuperPersonSightingDao.class);
        
        tdh.clearTables();
        
    }      
    
    @After
    public void tearDown() {
        
        tdh.clearTables();
    }

       @Test
    public void testAddGetDeleteSuperPerson() {
// Arrange - set up your givens
        SuperPerson sp = new SuperPerson();
        sp.setName("Batman");
        sp.setDescription("some rich dude with gadgets");
        sp.setIsGood(true);
// Act - call the method you're testing
        sp = superPersonService.createSuperPerson(sp);
        SuperPerson fromDb = superPersonService.getSuperPersonById(sp.getSuperPersonId());
        String result = c.compareObjects(sp, fromDb);
// Assert - assert that the actual matches the expected
        assertEquals(result, "");
        superPersonService.deleteSuperPerson(superPersonService.getSuperPersonById(sp.getSuperPersonId()));
        assertNull(superPersonService.getSuperPersonById(sp.getSuperPersonId()));
    }

    @Test
    public void updateSuperPerson() {
// Arrange 
        SuperPerson sp = new SuperPerson();
        sp.setName("Batman");
        sp.setDescription("some rich dude with gadgets");
        sp.setIsGood(true);
        SuperPerson added = superPersonService.createSuperPerson(sp);
        added.setName("Trumpus");
        added.setDescription("builds walls");
        added.setIsGood(false);
// Act
        SuperPerson updated = superPersonService.updateSuperPerson(added);
        String result = c.compareObjects(added, updated);
// Assert
        assertEquals(result, "");
    }

    @Test
    public void getAllSuperPersons() {
// Arrange  
        SuperPerson sp1 = new SuperPerson();
        sp1.setName("Batman");
        sp1.setDescription("some rich dude with gadgets");
        sp1.setIsGood(true);
        SuperPerson sp2 = new SuperPerson();
        sp2.setName("Trumpus");
        sp2.setDescription("builds walls");
        sp2.setIsGood(false);
// next 2 rows commented out b/c we removed dummy data from DB        
// want number of SuperPersones in DB, then use as OFFSET in Act        
//        Integer numInDb = superPersonService.getAllSuperPersones(0, Integer.MAX_VALUE).size();
        SuperPerson createdSP1 = superPersonService.createSuperPerson(sp1);
        SuperPerson createdSP2 = superPersonService.createSuperPerson(sp2);
// Act
        List<SuperPerson> superPersons = superPersonService.getAllSuperPersons(0, 100);
// Assert
        assertEquals(2, superPersons.size());
        String result1 = c.compareObjects(createdSP1, superPersons.get(0));
        String result2 = c.compareObjects(createdSP2, superPersons.get(0));
        String result3 = c.compareObjects(createdSP1, superPersons.get(1));
        String result4 = c.compareObjects(createdSP2, superPersons.get(1));
        // don't know what order they'll be in
        assertTrue(result1.equals("") || result2.equals(""));
        assertTrue(result3.equals("") || result4.equals(""));
    }
    /**
     * Test of getAllSuperPersonsBySighting method, of class SuperPersonService.
     */
   @Test
    public void getAllSuperPersonsBySighting() {
        
        Address add1 = new Address();
        add1.setCity("Faketown");
        add1.setStreet("123 Fake Street");
        add1.setState("OX");
        add1.setZipcode("12345");
        add1 = addressService.createAddress(add1);

        Location loc1 = new Location();
        loc1.setDescription("Cool place for cool mutants!");
        loc1.setName("The Software Guild");
        loc1.setAddress(add1);
        loc1.setLatitude(" 23, 23");
        loc1.setLongitude(" 23, 23");
        loc1 = locationService.createLocation(loc1);
        
        Address add2 = new Address();
        add2.setCity("Akron");
        add2.setStreet("123 Quaran Rd");
        add2.setState("OX");
        add2.setZipcode("12345");
        add2 = addressService.createAddress(add1);

        Location loc2 = new Location();
        loc2.setDescription("Cool place for cool mutants!");
        loc2.setName("Taliban HQ");
        loc2.setAddress(add2);
        loc2.setLatitude(" 23, 23");
        loc2.setLongitude(" 23, 23");
        loc2 = locationService.createLocation(loc1);
        
        SuperPerson sp1 = new SuperPerson();
        sp1.setName("Mario Lemieux");
        sp1.setDescription("The Best");
        sp1.setIsGood(true);

        sp1 = superPersonService.createSuperPerson(sp1);

        SuperPerson sp2 = new SuperPerson();
        sp2.setName("Jaromir Jagr");
        sp2.setDescription("The Next Best");
        sp2.setIsGood(true);

        sp2 = superPersonService.createSuperPerson(sp1);
        SuperPerson sp3 = new SuperPerson();
        sp3.setName("Wayne Gretzky");
        sp3.setDescription("The Great One");
        sp3.setIsGood(true);

        sp3 = superPersonService.createSuperPerson(sp1);

        
        
        Sighting s1 = new Sighting();
        s1.setDate(LocalDate.parse("1992-01-01"));
        s1.setLocation(loc1);
        s1.setDescription("Penguins");
        s1 = sightingService.createSighting(s1);
        
        
        Sighting s2 = new Sighting();
        s2.setDate(LocalDate.parse("1986-01-01"));
        s2.setLocation(loc2);
        s2.setDescription("Oilers");

        s2 = sightingService.createSighting(s2);

        SuperPersonSighting sps1 = new SuperPersonSighting();
        sps1.setSuperPerson(sp1);
        sps1.setSighting(s1);
        sps1 = superPersonSightingDao.createSuperPersonSighting(sps1);

        SuperPersonSighting sps2 = new SuperPersonSighting();
        sps2.setSuperPerson(sp2);
        sps2.setSighting(s1);
        sps2 = superPersonSightingDao.createSuperPersonSighting(sps2);
        
        SuperPersonSighting sps3 = new SuperPersonSighting();
        sps3.setSuperPerson(sp3);
        sps3.setSighting(s2);
        sps3 = superPersonSightingDao.createSuperPersonSighting(sps3);
        

        assertEquals(2, superPersonService.getAllSuperPersonsBySighting(s1, 0, 10).size());
        assertEquals(1, superPersonService.getAllSuperPersonsBySighting(s2, 0, 10).size());
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
        
        SuperPerson sp = createAndAddSuperPerson();
        
        Power pow = new Power();
        pow.setName("Super Sneezing");
        powerService.createPower(pow);
        
//        SuperPersonPower spp = new SuperPersonPower();
//        spp.setSuperPerson(sp);
//        spp.setPower(pow);
//        spp = superPersonPowerDao.createSuperPersonPower(spp);
        
        SuperPersonPower spp = superPersonService.addSuperPersonToPower(sp, pow);
        SuperPersonPower fromDao = superPersonPowerDao.getSuperPersonPowerById(spp.getSuperPersonPowerId());
        
        String result = c.compareObjects(spp, fromDao);
        assertEquals("",result);
        
        
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
    
    public SuperPerson createAndAddSuperPerson() {
        SuperPerson sp = new SuperPerson();
        sp.setName("Batman");
        sp.setDescription("some rich dude with gadgets");
        sp.setIsGood(true);
        sp = superPersonService.createSuperPerson(sp);
        return sp;
    }
    
}
