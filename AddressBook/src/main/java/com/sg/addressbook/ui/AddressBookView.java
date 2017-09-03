/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class AddressBookView {
    
    private UserIO io;
    
    public AddressBookView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        
        io.print("Main Menu");
        io.print("1. List All Addresses");
        io.print("2. Add Address");
        io.print("3. Find Address");
        io.print("4. Delete Address");
        io.print("5. List Address Count");
        io.print("6. Exit");
        
        int menuSelection = io.readInt("Please select from the above choices", 1, 5);
        
        return(menuSelection);
    }
    
    public void printUnknownCommand() {
        io.print("Unknown command. Please try again.");
    }
    
    public void displayCreateAddressBanner() {
        io.print("**** Create Address ****");
    }

    public Address getNewAddressInfo() {
        
        String lastName = io.readString("Please enter Last Name");
        String firstName = io.readString("Please enter First Name");
        String streetAddress = io.readString("Please enter Street Address");
        String city = io.readString("Please enter City");
        String state = io.readString("please enter State");
        Integer zipCode = io.readInteger("please enter Zip Code");
        
        Address currentAddress = new Address(lastName);
        
        currentAddress.setFirstName(firstName);
        currentAddress.setStreetAddress(streetAddress);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZipCode(zipCode);
        
        return currentAddress;
        
    }

    public void displayCreateAddressSuccessBanner() {
        io.readString("Address successfully created. Please hit enter to continue.");
    }
    
    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getFirstName() + " "
                + currentAddress.getLastName());
            io.print(currentAddress.getStreetAddress());
            io.print(currentAddress.getCity() + ", " + 
                currentAddress.getState() + " " + 
                currentAddress.getZipCode());
            io.print("");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("**** Display All Addresss ****");
    }
    
    public void displayDisplayAddressBanner() {
        io.print("**** Display Address ****");
    }
    
    public String getLastNameChoice() {
        return io.readString("Please enter the Last Name.");
    }
    
    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getFirstName() + " "
                + address.getLastName());
            io.print(address.getStreetAddress());
            io.print(address.getCity() + ", " + 
                address.getState() + " " + 
                address.getZipCode()
                + address.getLastName());
            io.print("");
        } else {
            io.print("No such entry.");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveAddressBanner () {
        io.print("**** Remove Address ****");
    }
    
    public void displayRemoveSuccessBanner () {
        io.readString("Address successfully removed. Please hit enter to continue.");
    }
    
    public void displayDisplayAddressCountBanner () {
        io.print("**** Number of Addresses Currently in Book ****");
    }
    
    public void displayAddressCount (Integer addressCount) {
        io.print(addressCount + ((addressCount == 1) ? " entry" : "entries"));
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("**** Error ****");
        io.print(errorMsg);
    }
    
}
