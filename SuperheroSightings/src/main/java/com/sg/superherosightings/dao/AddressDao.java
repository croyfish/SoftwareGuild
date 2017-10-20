/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface AddressDao {
    
    public Address createAddress(Address address);
    
    public Address getAddressById(Integer addressId);
    
    public List<Address> getAllAddresses();
    
    public Address updateAddress(Address address);
    
    public Address deleteAddress(Address address);    
    
}

