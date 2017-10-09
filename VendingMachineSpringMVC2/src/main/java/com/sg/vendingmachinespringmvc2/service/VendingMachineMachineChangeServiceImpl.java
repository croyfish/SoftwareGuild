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
public class VendingMachineMachineChangeServiceImpl implements VendingMachineMachineChangeService {
   private VendingMachineChangeDao machineChangeDao;
    
    public VendingMachineMachineChangeServiceImpl(VendingMachineChangeDao machineChangeDao) {
        this.machineChangeDao = machineChangeDao;
    }
    
    @Override
    public Change addChange(Change change) {
        return machineChangeDao.addChange(change);
    }
    
    @Override
    public Change subtractChange(Change change) {
        Change currentMachineChange = machineChangeDao.getChange();
        currentMachineChange.setDollars(currentMachineChange.getDollars() - change.getDollars());
        currentMachineChange.setQuarters(currentMachineChange.getQuarters() - change.getQuarters());
        currentMachineChange.setDimes(currentMachineChange.getDimes() - change.getDimes());
        currentMachineChange.setNickels(currentMachineChange.getNickels() - change.getNickels());
        currentMachineChange.setPennies(currentMachineChange.getPennies() - change.getPennies());
        machineChangeDao.updateChange(currentMachineChange);
        return change;
    }    

    @Override
    public Change getChange() {
        return machineChangeDao.getChange();
    }

    @Override
    public Change updateChange(Change change) {
        return machineChangeDao.updateChange(change);
    }

    @Override
    public void removeChange() {
        machineChangeDao.removeChange();
    }


        
}
