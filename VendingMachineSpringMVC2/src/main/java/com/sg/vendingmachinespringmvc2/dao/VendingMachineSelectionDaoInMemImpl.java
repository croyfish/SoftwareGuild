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
public class VendingMachineSelectionDaoInMemImpl implements VendingMachineSelectionDao {

    private Selection currentSelection;
    
    @Override
    public Selection select(Selection selection) {
       currentSelection = selection;
       return selection;
    }

    @Override
    public Selection getSelection() {
       return currentSelection;
    }

    @Override
    public Selection updateSelection(Selection selection) {
       currentSelection = selection;
       return selection;
    }

    @Override
    public void removeSelection() {
        currentSelection = null;
    }
    
}
