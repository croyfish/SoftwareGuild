/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jeffc
 */
public class VendingMachineDAOFileImpl implements VendingMachineDAO {
    
    // Instantiate HashMap to link SKU numbers to items
    private Map<String, Item> items = new HashMap<>();
    // Store name of inventory file
    private static final String INVENTORY_FILE = "inventory.txt";
    // Set delimiter
    private static final String DELIMITER = "::";
    // Instantiate BigDecimal to keep track of money entered to machine
    private BigDecimal moneyEntered;
    // These variables are reserved for future use
    // DAO should not decide dimensions of machine but
    // Machine object should keep that information
    private static final Integer NUM_ROWS = 3;
    private static final Integer NUM_COLUMNS = 3;
    
    // Read inventory from file when DAO object is constructed
    public VendingMachineDAOFileImpl() throws VendingMachineFilePersistenceException {
        readInventory();
        this.moneyEntered = new BigDecimal("0.00");
    }
    
    // Read the inventory from file 
    private void readInventory() throws VendingMachineFilePersistenceException {
        Scanner scanner;
        
        // Tries&Catches FileNotFoundException and translates it to DaoException
        // to maintain loose coupling between program layers
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineFilePersistenceException(
                "-_- Could not load inventory data into memory.", e);
        }
        
        // Declares a string to hold the data file data line by line
        String currentLine;
        // Declares a string array to hold data field data as tokens
        String[] currentTokens;
        // Reads in each existing line of data file, which represents a DVD object, 
        // and splits string into tokens representing each individual field of an object
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            // Splits string to tokens and throws away delimiters
            currentTokens = currentLine.split(DELIMITER);
            // Create new Item object based on unique SKU
            Item currentItem = new Item(currentTokens[0]);
            // Set all Item object fields from remaining tokens
            currentItem.setName(currentTokens[1]);
            currentItem.setPrice(new BigDecimal(currentTokens[2]));
            currentItem.setInStock(Integer.parseInt(currentTokens[3]));

            // Add new DVD object to HashMap
            items.put(currentItem.getSKU(), currentItem);
        }
        // Close the scanner stream
        scanner.close();
                
    }

    @Override
    public void writeInventory() throws VendingMachineFilePersistenceException {
                PrintWriter out;
        
        // Tries&Catches IOException and translates it to DaoException
        // to maintain loose coupling between program layers
        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachineFilePersistenceException(
                    "Could not save dvd data.", e);
        }

        // Get Arraylist of all DVD objects in dvds HashMap
        List<Item> itemList = this.getAllItems();
        // Get fields from all DVD objects in list and write them to lines of
        // data file with each field separated by delimiter.
        for (Item currentItem : itemList) {
            out.println(currentItem.getSKU() + DELIMITER
                    + currentItem.getName() + DELIMITER
                    + currentItem.getPrice().toString() + DELIMITER
                    + currentItem.getInStock().toString());
            // Force PrintWriter to finish writing file
            out.flush();
        }
        // Close data stream
        out.close();
    }
    
    @Override
    public Integer getNumberOfSlotsInMachine() {
        return (NUM_ROWS * NUM_COLUMNS);
    }    
    
    @Override
    public List<Item> getAllItems() throws VendingMachineFilePersistenceException {
        return new ArrayList(items.values());
    }

    @Override
    public Item getItem(String SKU) throws VendingMachineDataValidationException {
        return items.get(SKU);
    }

    @Override
    public void setMoneyEntered(BigDecimal money) {
        this.moneyEntered = money;
    }

    @Override
    public BigDecimal getMoneyEntered() {
        return moneyEntered;
    }

    @Override
    public Change addMoney(Change changeEntered) {
        
        moneyEntered = moneyEntered.add(new BigDecimal(changeEntered.getValueOfChange().toString()));
        return changeEntered;
    }

}
