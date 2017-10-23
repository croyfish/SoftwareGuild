/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import java.util.List;
import org.junit.After;
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
public class AddressDaoTest {

    private static AddressDao dao;

    public AddressDaoTest() {
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
        dao = ctx.getBean("addressDao", AddressDao.class);

        // remove all of the Addresses
        List<Address> addresses = dao.getAllAddresses(0, Integer.MAX_VALUE);
        for (Address currentAddress : addresses) {
            dao.deleteAddress(dao.getAddressById(currentAddress.getAddressId()));
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteAddress() {
        // arrange Street, City, State, Zipcode
        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");

        // act
        add = dao.createAddress(add);
        Address actualAddress = dao.getAddressById(add.getAddressId());
        // assert
        assertEquals(add, actualAddress);
        // act
        dao.deleteAddress(dao.getAddressById(add.getAddressId()));
        // assert
        assertNull(dao.getAddressById(add.getAddressId()));
    }
    
    @Test
    public void updateAddress() {
        
        // arrange Street, City, State, Zipcode
        Address add = new Address();
        add.setStreet("123 Fake Street");
        add.setCity("Faketown");
        add.setState("OX");
        add.setZipcode("12345");
        
        Address added = dao.createAddress(add);
        
        added.setStreet("321 Not Fake Street");
        added.setCity("Not Faketown");
        added.setState("XO");
        added.setZipcode("54321");
              
        //act
        Address updated = dao.updateAddress(added);
        
        //assert
        assertEquals(added, updated);
        
//        //teardown
//        dao.deleteAddress(added);
    }
    
    @Test
    public void getAllAddresses() {
        
        // arrange Street, City, State, Zipcode
        Address add1 = new Address();
        add1.setStreet("123 Fake Street");
        add1.setCity("Faketown");
        add1.setState("OX");
        add1.setZipcode("12345");
        
        Address add2 = new Address();
        add2.setStreet("234 Fake Street");
        add2.setCity("Realtown");
        add2.setState("OY");
        add2.setZipcode("12346");
        
        //Integer numInDb = dao.getAllAddresses(0, Integer.MAX_VALUE).size();
        
        Address createdAdd1 = dao.createAddress(add1);
        Address createdAdd2 = dao.createAddress(add2);
        
        //act
        List<Address> addresses = dao.getAllAddresses(0, 10);
        
        //assert
        assertEquals(2, addresses.size());      
        assertTrue(createdAdd1.equals(addresses.get(0)) || createdAdd2.equals(addresses.get(0)));
        assertTrue(createdAdd1.equals(addresses.get(1)) || createdAdd2.equals(addresses.get(1)));
        
    }

}