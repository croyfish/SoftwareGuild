/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.helpers.ApplicationContextHelper;
import com.sg.superherosightings.helpers.CompareObjects;
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
    CompareObjects c = new CompareObjects();
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
        ApplicationContext ctx = ApplicationContextHelper.getContext();
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

        Organization org = new Organization();
        Location loc = new Location();
        loc.setLocationId(1);

        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        org = dao.createOrganization(org);
        Organization actualOrg = dao.getOrganizationById(org.getOrganizationId());
        String result = c.compareObjects(org, actualOrg);
        
        assertEquals(result, "");
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
        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        Organization added = dao.createOrganization(org);
        
        
        Location loc2 = new Location();
        loc2.setLocationId(2);
        org.setDescription("Cool place for cool people with coding powers!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.FALSE);
        org.setPhone("2159739182");
        org.setLocation(loc2);
        Organization updated = dao.updateOrganization(org);
        
        String result = c.compareObjects(added, updated);
        
    }
    @Test
    public void getAllOrganizations() {

        Organization org = new Organization();
        Location loc = new Location();
        loc.setLocationId(1);
        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        

        Organization org2 = new Organization();
        Location loc2 = new Location();
        loc2.setLocationId(2);

        org2.setDescription("Cool place for cool people with coding powers!");
        org2.setName("The Software Guild");
        org2.setIsGood(Boolean.FALSE);
        org2.setPhone("2159739182");
        org2.setLocation(loc2);
        
        Organization createdOrg1 = dao.createOrganization(org);
        Organization createdOrg2 = dao.createOrganization(org2);

        List<Organization> organizations = dao.getAllOrganizations(0, 10);
        assertEquals(2, organizations.size());
        
        String result1 = c.compareObjects(createdOrg1, organizations.get(0));
        String result2 = c.compareObjects(createdOrg2, organizations.get(0));
        String result3 = c.compareObjects(createdOrg1, organizations.get(1));
        String result4 = c.compareObjects(createdOrg2, organizations.get(1));
        
        assertTrue(result1.equals("") || result2.equals(""));
        
        assertTrue(result3.equals("") || result4.equals(""));
        

    }
}
