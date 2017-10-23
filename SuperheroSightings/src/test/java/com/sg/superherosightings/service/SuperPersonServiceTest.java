/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.PowerDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperPersonDao;
import com.sg.superherosightings.dao.SuperPersonOrganizationDao;
import com.sg.superherosightings.dao.SuperPersonPowerDao;
import com.sg.superherosightings.dao.SuperPersonSightingDao;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
import com.sg.superherosightings.model.SuperPersonPower;
import com.sg.superherosightings.model.SuperPersonSighting;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class SuperPersonServiceTest {
    
        private static SuperPersonDao superPersonDao;
        private static OrganizationDao organizationDao;
        private static PowerDao powerDao;
        private static SightingDao sightingDao;
        private static SuperPersonOrganizationDao superPersonOrganizationDao;
        private static SuperPersonPowerDao superPersonPowerDao;
        private static SuperPersonSightingDao superPersonSightingDao;               
    
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
        
        // ask Spring for our Dao
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
        superPersonDao = ctx.getBean("superPersonDao", SuperPersonDao.class);
        organizationDao = ctx.getBean("organizationDao", OrganizationDao.class);
        powerDao = ctx.getBean("powerDao", PowerDao.class);
        sightingDao = ctx.getBean("sightingDao", SightingDao.class);
        superPersonOrganizationDao = ctx.getBean("superPersonOrganizationDao", SuperPersonOrganizationDao.class);
        superPersonPowerDao = ctx.getBean("superPersonPowerDao", SuperPersonPowerDao.class);
        superPersonSightingDao = ctx.getBean("superPersonSightingDao", SuperPersonSightingDao.class);
        

        List<SuperPerson> superPersons = superPersonDao.getAllSuperPersons(0, Integer.MAX_VALUE);
        for (SuperPerson currentSuperPerson : superPersons) {
            superPersonDao.deleteSuperPerson(superPersonDao.getSuperPersonById(
                    currentSuperPerson.getSuperPersonId()));
        }
        
        List<Organization> organizations = organizationDao.getAllOrganizations(0, Integer.MAX_VALUE);
        for (Organization currentOrganization : organizations) {
            organizationDao.deleteOrganization(organizationDao.getOrganizationById(
                    currentOrganization.getOrganizationId()));
        }  

        List<Power> powers = powerDao.getAllPowers(0, Integer.MAX_VALUE);
        for (Power currentPower : powers) {
            powerDao.deletePower(powerDao.getPowerById(
                    currentPower.getPowerId()));
        }  

        List<Sighting> sightings = sightingDao.getAllSightings(0, Integer.MAX_VALUE);
        for (Sighting currentSighting : sightings) {
            sightingDao.deleteSighting(sightingDao.getSightingById(
                    currentSighting.getSightingId()));
        }  

        List<SuperPersonOrganization> superPersonOrganization = 
                superPersonOrganizationDao.getAllSuperPersonOrganizations(0, Integer.MAX_VALUE);
        for (SuperPersonOrganization currentSuperPersonOrganization : superPersonOrganization) {
            superPersonOrganizationDao.deleteSuperPersonOrganization(
                    superPersonOrganizationDao.getSuperPersonOrganizationById(
                    currentSuperPersonOrganization.getSuperPersonOrganizationId()));
        }  

        List<SuperPersonPower> superPersonPower = 
                superPersonPowerDao.getAllSuperPersonPowers(0, Integer.MAX_VALUE);
        for (SuperPersonPower currentSuperPersonPower : superPersonPower) {
            superPersonPowerDao.deleteSuperPersonPower(superPersonPowerDao.getSuperPersonPowerById(
                    currentSuperPersonPower.getSuperPersonPowerId()));
        }  

        List<SuperPersonSighting> superPersonSighting = 
                superPersonSightingDao.getAllSuperPersonSightings(0, Integer.MAX_VALUE);
        for (SuperPersonSighting currentSuperPersonSighting : superPersonSighting) {
            superPersonSightingDao.deleteSuperPersonSighting(
                    superPersonSightingDao.getSuperPersonSightingById(
                    currentSuperPersonSighting.getSuperPersonSightingId()));
        }          
        
        
        
        
        
        
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
        
        SuperPerson sp1 = new SuperPerson();
        sp1.setName("Mario Lemieux");
        sp1.setDescription("The Best");
        sp1.setIsGood(true);
        
        sp1 = superPersonDao.createSuperPerson(sp1);
        
        SuperPerson sp2 = new SuperPerson();
        sp2.setName("Jaromir Jagr");
        sp2.setDescription("The Next Best");
        sp2.setIsGood(true);
        
        sp2 = superPersonDao.createSuperPerson(sp1);

        SuperPerson sp3 = new SuperPerson();
        sp3.setName("Wayne Gretzky");
        sp3.setDescription("The Great One");
        sp3.setIsGood(true);
        
        sp3 = superPersonDao.createSuperPerson(sp1);    
        
        Location l1 = new Location();
        l1.setLocationId(1);      
        Sighting s1 = new Sighting();
        s1.setDate(LocalDate.parse("1992-01-01"));
        s1.setLocation(l1);
        s1.setDescription("Penguins");
        
        s1 = sightingDao.createSighting(s1);
                
        Location l2 = new Location();
        l2.setLocationId(2);      
        Sighting s2 = new Sighting();
        s2.setDate(LocalDate.parse("1986-01-01"));
        s2.setLocation(l2);
        s2.setDescription("Oilers");
        
        s2 = sightingDao.createSighting(s2);
        
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
        
        
        assertEquals(2, superPersonDao.getAllSuperPersonsBySighting(s1, 0, 10).size());
        assertEquals(1, superPersonDao.getAllSuperPersonsBySighting(s2, 0, 10).size());
        

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
    
}
