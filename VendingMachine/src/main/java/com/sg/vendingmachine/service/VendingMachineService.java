/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface VendingMachineService {
    
    public List<Item> getAllItemsFromDAO();
    
    public Item getItemFromDAO(String SKU);
    
    public void setMoneyEnteredInDAO(BigDecimal money);
    
    public BigDecimal getMoneyEnteredFromDAO();
    
    public BigDecimal addMoneyEnteredToDAO(BigDecimal money);
    
    public Change calculateChange();
    
    public Item purchaseItem(String SKU);
    
    public void saveOnExit();
}
