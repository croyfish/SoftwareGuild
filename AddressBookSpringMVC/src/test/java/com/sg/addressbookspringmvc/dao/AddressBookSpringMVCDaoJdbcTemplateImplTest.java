/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookspringmvc.dao;

import com.sg.addressbookspringmvc.model.Address;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class AddressBookSpringMVCDaoJdbcTemplateImplTest {
    
    AddressBookSpringMVCDao dao;
    
    public AddressBookSpringMVCDaoJdbcTemplateImplTest() {
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

        dao = ctx.getBean("addressBookDao", AddressBookSpringMVCDao.class);

        // delete all addresses
        List<Address> addresses = dao.getAllAddresses();
        for (Address currentAddress : addresses) {
            dao.deleteAddress(currentAddress.getAddressId());
        }        
        
    }
    
    @Test
    public void addGetAddress() {
        Address address = new Address();
        address.setFirstName("Jane");
        address.setLastName("Smith");        
        address.setStreetAddress("123 Main Street");
        address.setCity("Address City");
        address.setState("OH");
        address.setZipCode(44123);

        dao.addAddress(address);

        Address fromDao = dao.getAddressById(address.getAddressId());
        assertEquals(fromDao, address);
    }

    @Test
    public void deleteAddress() {
        Address address = new Address();
        address.setFirstName("Jane");
        address.setLastName("Smith");        
        address.setStreetAddress("123 Main Street");
        address.setCity("Address City");
        address.setState("OH");
        address.setZipCode(44123);

        dao.addAddress(address);

        Address fromDao = dao.getAddressById(address.getAddressId());
        assertEquals(fromDao, address);
        dao.deleteAddress(address.getAddressId());
        assertNull(dao.getAddressById(address.getAddressId()));
    }
    
}
