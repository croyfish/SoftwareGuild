/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dao.exception.FlooringPersistenceException;
import com.sg.flooringmastery.dto.UniqueOrderNumber;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author jeffc
 */
public class FlooringUniqueOrderNumberDaoInMemImpl implements FlooringUniqueOrderNumberDao {
    
    @Override
    public Integer getCurrentUniqueOrderNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCurrentUniqueOrderNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private UniqueOrderNumber readUniqueOrderNumberFile() throws FlooringPersistenceException {
        
        Scanner scanner;
        UniqueOrderNumber num = null;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("data/unique_order_number/UniqueOrderNumber.txt")));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException (
                "No unique order number was uniquely found.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            if (currentLine.length() == 0) {
                break;
            }

            num = new UniqueOrderNumber();
            num.setOrderNumber(Integer.parseInt(currentLine));

        }

        scanner.close();
        return num;
    }    
    
}
