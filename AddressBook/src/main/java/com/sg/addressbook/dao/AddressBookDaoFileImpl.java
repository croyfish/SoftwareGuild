/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author jeffc
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    private Map<String, Address> addresses = new HashMap<>();
    public static final String ADDRESS_FILE = "addresses.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public Address addAddress(String lastName, Address address) 
     throws AddressBookDaoException {
        Address newAddress = addresses.put(lastName, address);
        writeRoster();
        return newAddress;
    }

    @Override
    public List<Address> getAllAddresses() 
     throws AddressBookDaoException {
        loadRoster();
        return new ArrayList(addresses.values());
    }

    @Override
    public Address getAddress(String lastName) 
     throws AddressBookDaoException {
        loadRoster();
        return addresses.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName) 
     throws AddressBookDaoException {
        Address removedAddress = addresses.remove(lastName);
        writeRoster();
        return removedAddress;
    }
    
    @Override
    public Integer getAddressCount() 
     throws AddressBookDaoException {
        loadRoster();
        return addresses.size();
    }
    
    private void loadRoster() throws AddressBookDaoException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
                "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Address currentAddress = new Address(currentTokens[0]);
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setStreetAddress(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            currentAddress.setZipCode(Integer.parseInt(currentTokens[5]));
            
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        
        scanner.close();
    }
    
    private void writeRoster() throws AddressBookDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException(
                    "Could not save address data.", e);
        }
        
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            out.println(currentAddress.getLastName() + DELIMITER
                    + currentAddress.getFirstName() + DELIMITER
                    + currentAddress.getStreetAddress() + DELIMITER
                    + currentAddress.getCity() + DELIMITER 
                    + currentAddress.getState() + DELIMITER
                    + currentAddress.getZipCode());
            out.flush();
        }
        
        out.close();
    }
    
}
