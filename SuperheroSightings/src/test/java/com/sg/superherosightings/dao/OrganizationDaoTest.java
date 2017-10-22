/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
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
public class OrganizationDaoTest {

    OrganizationDao dao;

    public OrganizationDaoTest() {
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

        dao = ctx.getBean("organizationDao", OrganizationDao.class);

        List<Organization> organizations = dao.getAllOrganizations(0, Integer.MAX_VALUE);
        for (Organization currentOrganization : organizations) {
            dao.deleteOrganization(currentOrganization);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteOrganization() {

        //arrange
        //how is the ID being set? 
        Organization org = new Organization();
        Location loc = new Location();
        loc.setLocationId(1);

//        //Set up address 
//        Address add = new Address(); 
//        add.setAddressId(1);
//        //Set up Location 
//        loc.setAddress(add);
//        loc.setDescription("Oranges go great here!");
//        loc.setLatitude("25,38");
//        loc.setLongitude("25,37");
//        loc.setName("California");
        org.setDescription("Cool place for cool mutants!");

        org.setName("The Software Guild");

        org.setIsGood(Boolean.TRUE);
        
        org.setPhone("2169739182");

        org.setLocation(loc);

        org = dao.createOrganization(org);

        Organization actualOrg = dao.getOrganizationById(org.getOrganizationId());

        assertEquals(org, actualOrg);

        dao.deleteOrganization(dao.getOrganizationById(org.getOrganizationId()));

        assertNull(dao.getOrganizationById(org.getOrganizationId()));

    }

    @Test
    public void updateOrganization() {
        //arrange
        //how is the ID being set? 
        Organization org = new Organization();
        Location loc = new Location();
        loc.setLocationId(1);

//        //Set up address 
//        Address add = new Address();
//        add.setAddressId(1);
////Set up Location 
//        loc.setAddress(add);
//        loc.setDescription("Oranges go great here!");
//        loc.setLatitude("25,38");
//        loc.setLongitude("25,37");
//        loc.setName("California");
        org.setDescription("Cool place for cool mutants!");

        org.setName("The Software Guild");

        org.setIsGood(Boolean.TRUE);
        
        org.setPhone("2169739182");

        org.setLocation(loc);


        Organization org2 = dao.createOrganization(org);
        
        //arrange
        //how is the ID being set? 

        Location loc2 = new Location();
        loc2.setLocationId(2);

        //Set up address 
//      Address add2 = new Address(); 
//      add2.setAddressId(1);
//Set up Location 
//        loc2.setAddress(add);
//        loc2.setDescription("Oranges go bad here!");
//        loc2.setLatitude("25,39");
//        loc2.setLongitude("25,40");
//        loc2.setName("Virginia");
        org2.setDescription("Cool place for cool people with coding powers!");

        org2.setName("The Software Guild");

        org2.setIsGood(Boolean.FALSE);
        
        org2.setPhone("2169739182");

        org2.setLocation(loc);

        org2 = dao.createOrganization(org2);

        Organization updated = dao.updateOrganization(org2);
        assertEquals(org, org2);
    }

    @Test
    public void getAllOrganizations() {

        //arrange
        //how is the ID being set? 
        Organization org = new Organization();
        Location loc = new Location();
        loc.setLocationId(1);

//        //Set up address 
//        Address add = new Address();
//        add.setAddressId(1);
//
////Set up Location 
//        loc.setAddress(add);
//        loc.setDescription("Oranges go great here!");
//        loc.setLatitude("25,38");
//        loc.setLongitude("25,37");
//        loc.setName("California");
        org.setDescription("Cool place for cool mutants!");

        org.setName("The Software Guild");

        org.setIsGood(Boolean.TRUE);
        
        org.setPhone("2169739182");

        org.setLocation(loc);

        org = dao.createOrganization(org);

        //arrange
        //how is the ID being set? 
        Organization org2 = new Organization();
        Location loc2 = new Location();
        loc2.setLocationId(2);

//        //Set up address 
//      Address add2 = new Address(); 
//      add2.setAddressId(1);
//        
////Set up Location 
//        loc2.setAddress(add);
//        loc2.setDescription("Oranges go bad here!");
//        loc2.setLatitude("25,39");
//        loc2.setLongitude("25,40");
//        loc2.setName("Virginia");
        org2.setDescription("Cool place for cool people with coding powers!");

        org2.setName("The Software Guild");

        org2.setIsGood(Boolean.FALSE);
        
        org2.setPhone("2169739182");

        org2.setLocation(loc2);

        org2 = dao.createOrganization(org2);

//        Organization createdOrg1 = dao.createOrganization(org);
//
//        Organization createdOrg2 = dao.createOrganization(org2);

        //Integer numInDb = dao.getAllAddresses(0, Integer.MAX_VALUE).size();
        List<Organization> organizations = dao.getAllOrganizations(0, 10);

        assertEquals(2, organizations.size());

//        assertTrue(createdAddress1.equals(addresses.get(0)) || createdAddress2.equals(addresses.get(0)));
//
//        assertTrue(createdAddress1.equals(addresses.get(1)) || createdAddress2.equals(addresses.get(1)));
    }

}
