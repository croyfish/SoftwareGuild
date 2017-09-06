/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class AddressBookDaoTest {
    
    private AddressBookDao dao = new AddressBookDaoFileImpl();
    
    public AddressBookDaoTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<Address> addressList = dao.getAllAddresses();
        for (Address address : addressList) {
        dao.removeAddress(address.getLastName());        
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void testAddGetAddress() throws Exception {
        Address address = new Address("Smith");
        address.setFirstName("Joe");
        address.setStreetAddress("123 Fake Street");
        address.setCity("Faketon");
        address.setState("Fakington");
        address.setZipCode(12345);
  
        dao.addAddress(address.getLastName(), address);
        
        Address fromDao = dao.getAddress(address.getLastName());
        
        assertEquals(address, fromDao);        
    }

    /**
     * Test of getAllAddresses method, of class AddressBookDao.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
        
        Address address1 = new Address("Smith");
        address1.setFirstName("Joe");
        address1.setStreetAddress("123 Fake Street");
        address1.setCity("Faketon");
        address1.setState("Fakington");
        address1.setZipCode(12345);
  
        dao.addAddress(address1.getLastName(), address1);
        
        Address address2 = new Address("Smithers");
        address2.setFirstName("Joe");
        address2.setStreetAddress("123 Fake Street");
        address2.setCity("Faketon");
        address2.setState("Fakington");
        address2.setZipCode(12345);
  
        dao.addAddress(address2.getLastName(), address2);
        
        assertEquals(2, dao.getAllAddresses().size());        
    }


    /**
     * Test of removeAddress method, of class AddressBookDao.
     */
    @Test
    public void testRemoveAddress() throws Exception {
        
        Address address1 = new Address("Smith");
        address1.setFirstName("Joe");
        address1.setStreetAddress("123 Fake Street");
        address1.setCity("Faketon");
        address1.setState("Fakington");
        address1.setZipCode(12345);
  
        dao.addAddress(address1.getLastName(), address1);
        
        Address address2 = new Address("Smithers");
        address2.setFirstName("Joe");
        address2.setStreetAddress("123 Fake Street");
        address2.setCity("Faketon");
        address2.setState("Fakington");
        address2.setZipCode(12345);
  
        dao.addAddress(address2.getLastName(), address2);
        
        dao.removeAddress(address1.getLastName());
        
        assertEquals(1, dao.getAllAddresses().size());
        
        assertNull(dao.getAddress(address1.getLastName()));
        
        dao.removeAddress(address2.getLastName());
        
        assertEquals(0, dao.getAllAddresses().size());
        
        assertNull(dao.getAddress(address2.getLastName()));        
    }

    /**
     * Test of getAddressCount method, of class AddressBookDao.
     */
    @Test
    public void testGetAddressCount() throws Exception {
    }

    
}
