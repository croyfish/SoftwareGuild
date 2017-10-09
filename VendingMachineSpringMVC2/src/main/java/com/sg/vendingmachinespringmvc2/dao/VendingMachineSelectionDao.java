/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.dao;

import com.sg.vendingmachinespringmvc2.model.Selection;

/**
 *
 * @author jeffc
 */
public interface VendingMachineSelectionDao {
    
    // Create
    public Selection select(Selection selection);
    // Read
    public Selection getSelection();
    // Update
    public Selection updateSelection(Selection selection);
    // Delete    
    public void removeSelection();      
    
    
}
