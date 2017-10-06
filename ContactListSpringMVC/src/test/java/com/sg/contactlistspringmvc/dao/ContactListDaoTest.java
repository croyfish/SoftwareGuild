package com.sg.contactlistspringmvc.dao;

import com.sg.contactlistspringmvc.model.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeffc
 */
public class ContactListDaoTest {
    private static ContactListDao dao;
    
    public ContactListDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("contactListDao", ContactListDao.class);
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("contactListDao", ContactListDao.class);
    }
    
    @After
    public void tearDownC() {
        
    }    
    
    
    
    
    
    // Can we add a contact, get it, and delete it?
    
    @Test
    public void addGetDeleteContact() {
      // arrange
      Contact nc = new Contact();
      nc.setFirstName("Lloyd");
      nc.setLastName("Poopsplat");
      nc.setCompany("Tech Industries");
      nc.setEmail("lloyd@ti.com");
      nc.setPhone("555-1464");
      
      dao.addContact(nc);
      Contact actualContact = dao.getContactById(nc.getContactId());
      assertEquals(nc, actualContact);
      dao.removeContact(nc.getContactId());
      assertNull(dao.getContactById(nc.getContactId()));
              
      // act
      // assert
    
    }
    
    @Test
    public void searchContacts() {
      
      Contact nc = new Contact();
      nc.setFirstName("Lloyd");
      nc.setLastName("Poopsplat");
      nc.setCompany("Tech Industries");
      nc.setEmail("lloyd@ti.com");
      nc.setPhone("555-1234");
      dao.addContact(nc);
      
      Contact nc2 = new Contact();
      nc2.setFirstName("Lloyd");
      nc2.setLastName("Normal");
      nc2.setCompany("Tech Tech");
      nc2.setEmail("lloyd@tt.com");
      nc2.setPhone("555-1235");
      dao.addContact(nc2);

      Contact nc3 = new Contact();
      nc3.setFirstName("Boyd");
      nc3.setLastName("Poopsplat");
      nc3.setCompany("Tech Industries");
      nc3.setEmail("boyd@ti.com");
      nc3.setPhone("555-1236");
      dao.addContact(nc3);      
      
      Map<SearchTerm, String> criteria = new HashMap<>();
      criteria.put(SearchTerm.FIRST_NAME, "Boyd");
      criteria.put(SearchTerm.COMPANY, "Tech Industries");
      List<Contact> searchResults = dao.searchContacts(criteria);
      assertEquals(1, searchResults.size());
      Contact expectedContact = searchResults.get(0);
      assertEquals(nc3, expectedContact);
            
      criteria = new HashMap<>();
      criteria.put(SearchTerm.LAST_NAME, "Poopsplat");
      searchResults = dao.searchContacts(criteria);
      assertEquals(2, searchResults.size());
            
    }

    
}
