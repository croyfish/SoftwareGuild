/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.service;

import com.sg.vendingmachinespringmvc2.dao.VendingMachineSelectionDao;
import com.sg.vendingmachinespringmvc2.model.Selection;

/**
 *
 * @author jeffc
 */
public class VendingMachineSelectionServiceImpl implements VendingMachineSelectionService {
    
    private VendingMachineSelectionDao selectionDao;
    
    public VendingMachineSelectionServiceImpl(VendingMachineSelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    @Override
    public Selection select(Selection selection) {
       return selectionDao.select(selection);
    }

    @Override
    public Selection getSelection() {
        return selectionDao.getSelection();
    }

    @Override
    public Selection updateSelection(Selection selection) {
        return selectionDao.updateSelection(selection);
    }

    @Override
    public void removeSelection() {
        selectionDao.removeSelection();
    }
    
}
