/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.*;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.ui.*;
import java.util.List;


/**
 *
 * @author jeffc
 */
public class AddressBookController {
    
    AddressBookDao dao;
    AddressBookView view;

    
    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao  = dao;
        this.view = view;
    }
    
    public void run() {
        
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while(keepGoing) {
            
                menuSelection = getMenuSelection();
            
                switch(menuSelection) {
                
                    case 1:
                        listAddresses();
                        break;
                    case 2:
                        createAddress();
                        break;
                    case 3:
                        viewAddress();
                        break;
                    case 4:
                        removeAddress();
                        break;
                    case 5:
                        viewAddressCount();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            
            }
            exitMessage();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createAddress() 
     throws AddressBookDaoException {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateAddressSuccessBanner();
    }

    private void viewAddress()
     throws AddressBookDaoException {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }

    private void removeAddress() 
     throws AddressBookDaoException {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }
    
    private void listAddresses()
     throws AddressBookDaoException {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }
    
    private void viewAddressCount()
     throws AddressBookDaoException {
        view.displayDisplayAddressCountBanner();
        Integer addressCount = dao.getAddressCount();
        view.displayAddressCount(addressCount);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
