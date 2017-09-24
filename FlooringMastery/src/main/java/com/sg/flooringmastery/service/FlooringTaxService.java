/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Tax;

/**
 *
 * @author jeffc
 */
public interface FlooringTaxService {
    
    // create
    public Tax addTaxByState(String state, Tax tax);
    // remove
    public Tax getTaxByState(String state);
    // update
    public void editTaxByState(String state, Tax tax);
    // delete
    public Tax removeTaxByState(String state);
    
}
