/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.dao;

import com.sg.contactlistspringmvc.model.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author jeffc
 */
public class ContactListDaoInMemImpl implements ContactListDao {
    
    private Map<Long, Contact> contactMap = new HashMap<>();
    private static long contactIdCounter = 0;

    @Override
    public Contact addContact(Contact contact) {
        // set the new contact to the current ID
        contact.setContactId(contactIdCounter++);
        contactMap.put(contact.getContactId(), contact);
        return contact;
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList(contactMap.values());
    }

    @Override
    public Contact getContactById(long contactId) {
        return contactMap.get(contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public void removeContact(long contactId) {
        contactMap.remove(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        // Get all values from map
        String firstNameSearchCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameSearchCriteria = criteria.get(SearchTerm.LAST_NAME);
        String companySearchCriteria = criteria.get(SearchTerm.COMPANY);
        String emailSearchCriteria = criteria.get(SearchTerm.EMAIL);
        String phoneSearchCriteria = criteria.get(SearchTerm.PHONE);
        // Build predicate condition for each criteria
        Predicate<Contact> firstNameSearchPredicate;
        Predicate<Contact> lastNameSearchPredicate;
        Predicate<Contact> companySearchPredicate;
        Predicate<Contact> emailSearchPredicate;
        Predicate<Contact> phoneSearchPredicate;  
        // Define Predicates
        
        
        
        // Default empty value predicate
        Predicate<Contact> truePredicate = (c) -> {return true;};
        
        
        // Check each reterion - if empty or null, set to truePredicate, otherwise lambda expression
        if (firstNameSearchCriteria == null || firstNameSearchCriteria.isEmpty()) {
            firstNameSearchPredicate = truePredicate;
        } else {
            firstNameSearchPredicate = (c) -> (c.getFirstName().equalsIgnoreCase(firstNameSearchCriteria));
        }
        if (lastNameSearchCriteria == null || lastNameSearchCriteria.isEmpty()) {
            lastNameSearchPredicate = truePredicate;
        } else {
            lastNameSearchPredicate = (c) -> (c.getLastName().equalsIgnoreCase(lastNameSearchCriteria));
        }        
        if (companySearchCriteria == null || companySearchCriteria.isEmpty()) {
            companySearchPredicate = truePredicate;
        } else {
            companySearchPredicate = (c) -> (c.getCompany().equalsIgnoreCase(companySearchCriteria));
        }        
        if (emailSearchCriteria == null || emailSearchCriteria.isEmpty()) {
            emailSearchPredicate = truePredicate;
        } else {
            emailSearchPredicate = (c) -> (c.getEmail().equalsIgnoreCase(emailSearchCriteria));
        }
        if (phoneSearchCriteria == null || phoneSearchCriteria.isEmpty()) {
            phoneSearchPredicate = truePredicate;
        } else {
            phoneSearchPredicate = (c) -> (c.getPhone().equalsIgnoreCase(phoneSearchCriteria));
        }
        
        // Filter our map with the predicates
        return contactMap.values().stream()
                .filter((firstNameSearchPredicate)
                    .and(lastNameSearchPredicate)
                    .and(companySearchPredicate)
                    .and(emailSearchPredicate)
                    .and(phoneSearchPredicate))
                .collect(Collectors.toList());             
    }
    
}
