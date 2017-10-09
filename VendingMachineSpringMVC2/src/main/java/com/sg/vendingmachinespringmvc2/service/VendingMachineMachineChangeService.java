/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

import com.sg.vendingmachinespringmvc2.model.Change;

/**
 *
 * @author jeffc
 */
public interface VendingMachineMachineChangeService {

    public Change addChange(Change change);
    
    public Change subtractChange(Change change);

    public Change getChange();
    
    public Change updateChange(Change change);

    public void removeChange(); 
    
}
