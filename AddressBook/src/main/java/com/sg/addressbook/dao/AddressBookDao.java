/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface AddressBookDao {
    
    public Address addAddress(String lastName, Address address)
     throws AddressBookDaoException;
    
    public List<Address> getAllAddresses()
     throws AddressBookDaoException;
    
    public Address getAddress(String lastName)
     throws AddressBookDaoException;
    
    public Address removeAddress(String lastName)
     throws AddressBookDaoException;
    
    public Integer getAddressCount() 
     throws AddressBookDaoException;
    
}
