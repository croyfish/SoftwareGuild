/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.Change;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class VendingMachineView {

    private UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    public void printInventory(List<Item> items) {
        for (Item currentItem : items) {
            
            io.print("[" + currentItem.getSKU() + "] " + 
                    currentItem.getName() + " $" + 
                    currentItem.getPrice().setScale(2).toString() + " <" + 
                    currentItem.getInStock().toString() + "> in stock");
        }
    }
    
    public void printCurrentBalance(BigDecimal money) {
        io.print("Balance in machine: $" + money.setScale(2).toString());
    }

    public int printMainMenuAndGetSelection() {
        io.print("Please enter coins before purchasing an item.");
        io.print("1. Enter Coins");
        io.print("2. Purchase Item");
        io.print("3. Get Change");
        io.print("4. Quit");
        return io.readInt("Make your selection below (1-4):", 1, 4);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public void displayExitBanner() {
        io.print("Exiting Vending Machine");
    }

    public int printAddMoneyMenuAndGetSelection() {
        io.print("What coin would you like to enter?");
        io.print("0: No Coins");
        io.print("1: A Penny");
        io.print("2: A Nickel");
        io.print("3: A Dime");
        io.print("4: A Quarter");
        return io.readInt("Please make your selection below:", 0, 4);
        
    }

    public String askAndGetItemSelection() {
        return io.readString("Please select an item by typing its letter and number.");
    }

    public void returnChange(Change userChange) {
        io.print("Your change is:");
        io.print(userChange.getQuarters() + "Quarter(s)");
        io.print(userChange.getDimes() + "Dime(s)");
        io.print(userChange.getPennies() + "Penny(ies)");
    }
    
    public void displayErrorMessage(String message) {
        io.print("You got an Error.");
    }


    
}
