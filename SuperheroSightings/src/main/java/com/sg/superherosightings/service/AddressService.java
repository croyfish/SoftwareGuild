/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.model.Address;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface AddressService {
    
    public Address createAddress(Address address);
    
    public Address getAddressById(Integer addressId);
    
    public List<Address> getAllAddresss(int offset, int limit);
    
    public Address updateAddress(Address address);
    
    public Address deleteAddress(Address address);
    
}