/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.helpers.ApplicationContextHelper;
import com.sg.superherosightings.helpers.CompareObjects;
import com.sg.superherosightings.helpers.TearDownHelper;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
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
public class SuperPersonOrganizationDaoTest {
    private static SuperPersonOrganizationDao superPersonOrganizationDao;
    private static SuperPersonDao superPersonDao;
    private static OrganizationDao organizationDao;
    private static AddressDao addressDao;
    private static LocationDao locationDao;
    private static CompareObjects c = new CompareObjects();
    private static TearDownHelper tdh = new TearDownHelper();
    public SuperPersonOrganizationDaoTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = ApplicationContextHelper.getContext();
        superPersonOrganizationDao = ctx.getBean("superPersonOrganizationDao", SuperPersonOrganizationDao.class);
        superPersonDao = ctx.getBean("superPersonDao", SuperPersonDao.class);
        organizationDao = ctx.getBean("organizationDao", OrganizationDao.class);
        addressDao = ctx.getBean("addressDao", AddressDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);
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
    public void addGetDeleteSuperPersonOrganization() {
        
        //arrange
        SuperPerson sp = new SuperPerson();
        sp.setName("Batman");
        sp.setDescription("some rich dude with gadgets");
        sp.setIsGood(true);
        sp = superPersonDao.createSuperPerson(sp);
        
        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");
        add = addressDao.createAddress(add);
        
        Location loc = new Location();
        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude("23, 32");
        loc.setLongitude("23, 23");
        loc = locationDao.createLocation(loc);
        
        Organization org = new Organization();
        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        org = organizationDao.createOrganization(org);
        
        SuperPersonOrganization spo = new SuperPersonOrganization();
        spo.setSuperPerson(sp);
        spo.setOrganization(org);
        spo = superPersonOrganizationDao.createSuperPersonOrganization(spo);
        
        SuperPersonOrganization fromDb = superPersonOrganizationDao.getSuperPersonOrganizationById(spo.getSuperPersonOrganizationId());
        String result = c.compareObjects(spo, fromDb);
        assertEquals(result, "");
        superPersonOrganizationDao.deleteSuperPersonOrganization(superPersonOrganizationDao.getSuperPersonOrganizationById(spo.getSuperPersonOrganizationId()));
        assertNull(superPersonOrganizationDao.getSuperPersonOrganizationById(spo.getSuperPersonOrganizationId()));
        
    }
    
   @Test
    public void getAllSuperPersonOrganizations() {
        
        SuperPerson sp = new SuperPerson();
        sp.setName("Batman");
        sp.setDescription("some rich dude with gadgets");
        sp.setIsGood(true);
        sp = superPersonDao.createSuperPerson(sp);
        
        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");
        add = addressDao.createAddress(add);
        
        Location loc = new Location();
        loc.setDescription("Cool place for cool mutants!");
        loc.setName("The Software Guild");
        loc.setAddress(add);
        loc.setLatitude("23, 32");
        loc.setLongitude("23, 23");
        loc = locationDao.createLocation(loc);
        
        Organization org = new Organization();
        org.setDescription("Cool place for cool mutants!");
        org.setName("The Software Guild");
        org.setIsGood(Boolean.TRUE);
        org.setPhone("2159739182");
        org.setLocation(loc);
        org = organizationDao.createOrganization(org);
        
        Organization org2 = new Organization();
        org2.setDescription("Pool place for pool mutants!");
        org2.setName("The Software Build");
        org2.setIsGood(Boolean.FALSE);
        org2.setPhone("2159739183");
        org2.setLocation(loc);
        org2 = organizationDao.createOrganization(org2); 
        
        SuperPersonOrganization spo = new SuperPersonOrganization();
        spo.setSuperPerson(sp);
        spo.setOrganization(org);
        spo = superPersonOrganizationDao.createSuperPersonOrganization(spo);        
        
        SuperPersonOrganization spo2 = new SuperPersonOrganization();
        spo2.setSuperPerson(sp);
        spo2.setOrganization(org2);
        spo2 = superPersonOrganizationDao.createSuperPersonOrganization(spo2); 
        
        List<SuperPersonOrganization> spos = superPersonOrganizationDao.getAllSuperPersonOrganizations(0, 10);

        assertEquals(2, spos.size());

        String result1 = c.compareObjects(spo, spos.get(0));
        String result2 = c.compareObjects(spo2, spos.get(0));
        String result3 = c.compareObjects(spo, spos.get(1));
        String result4 = c.compareObjects(spo2, spos.get(1));

        assertTrue(result1.equals("") ^ result2.equals(""));
        assertTrue(result3.equals("") ^ result4.equals(""));        

    }
    
}
