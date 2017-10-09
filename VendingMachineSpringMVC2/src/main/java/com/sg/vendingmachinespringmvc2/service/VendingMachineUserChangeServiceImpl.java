/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

import com.sg.vendingmachinespringmvc2.dao.VendingMachineChangeDao;
import com.sg.vendingmachinespringmvc2.model.Change;

/**
 *
 * @author jeffc
 */
public class VendingMachineUserChangeServiceImpl implements VendingMachineUserChangeService {

    private VendingMachineChangeDao userChangeDao;
    
    public VendingMachineUserChangeServiceImpl(VendingMachineChangeDao userChangeDao) {
        this.userChangeDao = userChangeDao;
    }
    
    @Override
    public Change addChange(Change change) {
        return userChangeDao.addChange(change);
    }
    
    @Override
    public Change subtractChange(Change change) {
        Change currentUserChange = userChangeDao.getChange();
        currentUserChange.setDollars(currentUserChange.getDollars() - change.getDollars());
        currentUserChange.setQuarters(currentUserChange.getQuarters() - change.getQuarters());
        currentUserChange.setDimes(currentUserChange.getDimes() - change.getDimes());
        currentUserChange.setNickels(currentUserChange.getNickels() - change.getNickels());
        currentUserChange.setPennies(currentUserChange.getPennies() - change.getPennies());
        userChangeDao.updateChange(currentUserChange);
        return change;
    }

    @Override
    public Change getChange() {
        return userChangeDao.getChange();
    }

    @Override
    public Change updateChange(Change change) {
        return userChangeDao.updateChange(change);
    }

    @Override
    public void removeChange() {
        userChangeDao.removeChange();
    }


    
}
