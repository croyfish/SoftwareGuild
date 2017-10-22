/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperPerson;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class SuperPersonDaoTest {
    
    private static SuperPersonDao dao;
    
    public SuperPersonDaoTest() {
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
        dao = ctx.getBean("superPersonDao", SuperPersonDao.class);

        // remove all of the Super People
        List<SuperPerson> superPersons = dao.getAllSuperPersons(0, Integer.MAX_VALUE);
        for (SuperPerson currentSuperPerson : superPersons) {
            dao.deleteSuperPerson(dao.getSuperPersonById(currentSuperPerson.getSuperPersonId()));
        }

    }
    
      @Test
        public void addGetDeleteSuperPerson() {
        // Name, Description, IsGood
        SuperPerson sp = new SuperPerson();
        sp.setName("The Hulk");
        sp.setDescription("He's mean and green.");
        sp.setIsGood(true);

        // act
        sp = dao.createSuperPerson(sp);
        SuperPerson actualSuperPerson = dao.getSuperPersonById(sp.getSuperPersonId());
        // assert
        assertEquals(sp, actualSuperPerson);
        // act
        dao.deleteSuperPerson(dao.getSuperPersonById(sp.getSuperPersonId()));
        // assert
        assertNull(dao.getSuperPersonById(sp.getSuperPersonId()));
    }
        
    @Test
    public void updateSuperPerson() {
        
        // arrange Street, City, State, Zipcode
        SuperPerson sp1 = new SuperPerson();
        sp1.setName("The Hulk");
        sp1.setDescription("He's mean and green.");
        sp1.setIsGood(true);
        
        SuperPerson added = dao.createSuperPerson(sp1);
        
        added.setName("The Bulk");
        added.setDescription("Not green");
        added.setIsGood(false);

        //act
        SuperPerson updated = dao.updateSuperPerson(added);
        
        //assert
        assertEquals(added, updated);
        
    }
    
    @Test
    public void getAllSuperPersons() {
        
        // arrange Street, City, State, Zipcode
        SuperPerson sp1 = new SuperPerson();
        sp1.setName("The Hulk");
        sp1.setDescription("He's mean and green.");
        sp1.setIsGood(true);
        
        SuperPerson sp2 = new SuperPerson();
        sp2.setName("The Bulk");
        sp2.setDescription("Not green.");
        sp2.setIsGood(false);
        
        //Integer numInDb = dao.getAllSuperPersons(0, Integer.MAX_VALUE).size();
        
        SuperPerson createdSP1 = dao.createSuperPerson(sp1);
        SuperPerson createdSP2 = dao.createSuperPerson(sp2);
        
        //act
        List<SuperPerson> superPersons = dao.getAllSuperPersons(0, 10);
        
        //assert
        assertEquals(2, superPersons.size());      
        assertTrue(createdSP1.equals(superPersons.get(0)) || createdSP2.equals(superPersons.get(0)));
        assertTrue(createdSP1.equals(superPersons.get(1)) || createdSP2.equals(superPersons.get(1)));
        
    }        

    
}
