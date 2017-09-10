/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dao.VendingMachineDataValidationException;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    private VendingMachineDAO dao;
    
    public VendingMachineServiceImpl(VendingMachineDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Item> getAllItemsFromDAO() 
     throws VendingMachineFilePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItemFromDAO(String SKU) 
     throws VendingMachineDataValidationException {
        return dao.getItem(SKU);
    }

    @Override
    public void setMoneyEnteredInDAO(BigDecimal money) {
        dao.setMoneyEntered(money);
    }

    @Override
    public BigDecimal getMoneyEnteredFromDAO() {
        return dao.getMoneyEntered();
    }

    @Override
    public void addMoneyEnteredToDAO(BigDecimal money) {
        dao.addMoney(money);
    }

    @Override
    public Change calculateChange() {
        
        Change userChange = new Change();
        BigDecimal money = dao.getMoneyEntered();
        
        BigDecimal quarters = money.divide(new BigDecimal("0.25"));
        quarters = quarters.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(quarters.multiply(new BigDecimal("0.25")));
        userChange.setQuarters(quarters.intValue());
        System.out.println(money.toString());
        
        BigDecimal dimes = money.divide(new BigDecimal("0.1"));
        dimes = dimes.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(dimes.multiply(new BigDecimal("0.1")));
        userChange.setDimes(dimes.intValue());
        System.out.println(money.toString());
        
        BigDecimal nickels = money.divide(new BigDecimal("0.05"));
        nickels = nickels.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(nickels.multiply(new BigDecimal("0.05")));
        userChange.setNickels(nickels.intValue());
        System.out.println(money.toString());
        
        BigDecimal pennies = money.divide(new BigDecimal("0.01"));
        pennies = pennies.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(pennies.multiply(new BigDecimal("0.01")));
        userChange.setPennies(pennies.intValue());
        System.out.println(money.toString());
        
        return userChange;
    }

    @Override
    public Item purchaseItem(String SKU) throws VendingMachineDataValidationException {
        Item selectedItem = dao.getItem(SKU);
        BigDecimal money = dao.getMoneyEntered();
        BigDecimal price = selectedItem.getPrice();
        System.out.println(money.intValue());
        System.out.println(price.intValue());
        if (money.compareTo(price) == 1) {        
        money = money.subtract(price);
        dao.setMoneyEntered(money);
        return selectedItem;
        }
        return null;
    }

    @Override
    public void depositCoin(int coinType) {
        String moneyAdded = "0";
        switch (coinType) {
            case 1:
                moneyAdded = "0.01";
                return;
            case 2:
                moneyAdded = "0.05";
                return;
            case 3:
                moneyAdded = "0.1";
                return;
            case 4:
                moneyAdded = "0.25";
                return;
            default:
                moneyAdded = "0";
        }
        dao.addMoney(new BigDecimal(moneyAdded));
    }
    
    @Override
    public void saveOnExit() throws VendingMachineFilePersistenceException {
        dao.writeInventory();
    }
    
}
