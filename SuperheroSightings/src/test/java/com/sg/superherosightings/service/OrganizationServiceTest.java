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
import com.sg.superherosightings.model.Organization;
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
public class OrganizationServiceTest {
    private static OrganizationService organizationService;
    private static LocationService locationService;
    private static AddressService addressService;        
    private static CompareObjects c = new CompareObjects();
    private static TearDownHelper tdh = new TearDownHelper();
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    
    public OrganizationServiceTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = ApplicationContextHelper.getContext();
        organizationService = ctx.getBean("organizationService", OrganizationService.class);
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
    
    @Test
    public void addGetDeleteOrganization() {

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

        Organization org = new Organization();
        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        
        org = organizationService.createOrganization(org);
        Organization actualOrg = organizationService.getOrganizationById(org.getOrganizationId());
        String result = c.compareObjects(org, actualOrg);
        assertEquals(result, "");
        
        organizationService.deleteOrganization(organizationService.getOrganizationById(org.getOrganizationId()));
        assertNull(organizationService.getOrganizationById(org.getOrganizationId()));
    }
    @Test
    public void updateOrganization() {

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

        Organization org = new Organization();
        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        Organization added = organizationService.createOrganization(org);

        org.setDescription("Cool place for cool people with coding powers!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.FALSE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        Organization updated = organizationService.updateOrganization(org);
        
        String result = c.compareObjects(added, updated);
        assertEquals(result, "");
        
    }
    @Test
    public void getAllOrganizations() {
        
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
        loc.setLatitude("23, 23");
        loc.setLongitude("23, 23");
        loc = locationService.createLocation(loc);

        Organization org = new Organization();
        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        Organization createdOrg1 = organizationService.createOrganization(org);

        Organization org2 = new Organization();
        org2.setDescription("Cool place for cool people with coding powers!");
        org2.setName("The Software Guild");
        org2.setIsGood(Boolean.FALSE);
        org2.setPhone("2159739182");
        org2.setLocation(loc);
        Organization createdOrg2 = organizationService.createOrganization(org2);

        List<Organization> organizations = organizationService.getAllOrganizations(0, 10);
        assertEquals(2, organizations.size());
        
        String result1 = c.compareObjects(createdOrg1, organizations.get(0));
        String result2 = c.compareObjects(createdOrg2, organizations.get(0));
        String result3 = c.compareObjects(createdOrg1, organizations.get(1));
        String result4 = c.compareObjects(createdOrg2, organizations.get(1));
        
        assertTrue(result1.equals("") || result2.equals(""));
        assertTrue(result3.equals("") || result4.equals(""));
        

    }
}
