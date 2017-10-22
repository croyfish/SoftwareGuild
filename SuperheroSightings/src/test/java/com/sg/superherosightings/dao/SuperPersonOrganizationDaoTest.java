/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
import java.time.LocalDate;
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
public class SuperPersonOrganizationDaoTest {
    
    private SuperPersonOrganizationDao dao;

    public SuperPersonOrganizationDaoTest() {
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
        dao = ctx.getBean("superPersonOrganizationDao", SuperPersonOrganizationDao.class);

        List<SuperPersonOrganization> superPersonOrganizations = dao.getAllSuperPersonOrganizations(0, Integer.MAX_VALUE);
        for (SuperPersonOrganization currentSuperPersonOrganization : superPersonOrganizations) {
            dao.deleteSuperPersonOrganization(currentSuperPersonOrganization);
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createSuperPersonOrganization method, of class SuperPersonOrganizationDao.
     */
    @Test
    public void addGetDeleteSuperPersonOrganization() {
        //arrange
        SuperPersonOrganization spo = new SuperPersonOrganization();
        
        SuperPerson superPerson = new SuperPerson();
        superPerson.setSuperPersonId(1);

        Organization organization = new Organization();
        organization.setOrganizationId(1);
        
        spo.setSuperPerson(superPerson);
        spo.setOrganization(organization);        

        spo = dao.createSuperPersonOrganization(spo);

        SuperPersonOrganization fromDb = dao.getSuperPersonOrganizationById(spo.getSuperPersonOrganizationId());
        assertEquals(spo, fromDb);
        
        dao.deleteSuperPersonOrganization(dao.getSuperPersonOrganizationById(spo.getSuperPersonOrganizationId()));
        assertNull(dao.getSuperPersonOrganizationById(spo.getSuperPersonOrganizationId()));

    }

    /**
     * Test of getAllSuperPersonOrganizationes method, of class SuperPersonOrganizationDao.
     */
    @Test
    public void testGetAllSuperPersonOrganizations() {
        
        
        SuperPersonOrganization spo1 = new SuperPersonOrganization();
        
        SuperPerson superPerson = new SuperPerson();
        superPerson.setSuperPersonId(1);

        Organization organization = new Organization();
        organization.setOrganizationId(1);
        
        spo1.setSuperPerson(superPerson);
        spo1.setOrganization(organization);        

        spo1 = dao.createSuperPersonOrganization(spo1);
        
        
        
        SuperPersonOrganization spo2 = new SuperPersonOrganization();
        
        SuperPerson superPerson2 = new SuperPerson();
        superPerson2.setSuperPersonId(2);

        Organization organization2 = new Organization();
        organization2.setOrganizationId(2);
        
        spo2.setSuperPerson(superPerson2);
        spo2.setOrganization(organization2);        

        spo2 = dao.createSuperPersonOrganization(spo2);        
        
        List<SuperPersonOrganization> superPersonOrganizations = dao.getAllSuperPersonOrganizations(0, 10);

        assertEquals(2, superPersonOrganizations.size());

        assertTrue(spo1.equals(superPersonOrganizations.get(0)) || spo2.equals(superPersonOrganizations.get(0)));
        assertTrue(spo1.equals(superPersonOrganizations.get(1)) || spo2.equals(superPersonOrganizations.get(1)));
    }

}
