/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author jeffc
 */
public class VendingMachineAuditDaoFileImpl implements VendingMachineAuditDao {
    // create constant String for audit file name
    public static final String AUDIT_FILE = "audit.txt";
    
    // method for writing audit entry that takes a string as a parameter
    @Override
    public void writeAuditEntry(String entry) throws VendingMachineFilePersistenceException {
        // declare new printwriter object
        PrintWriter out;
        
        // try to open filewriter for audit file
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        // if file is not there, catch IOException and throw new FilePersistenceException
        } catch (IOException e) {
            throw new VendingMachineFilePersistenceException("Could not persist audit information.", e);
        }
        
        // create a LocalDateTime timestamp from the current time and date
        LocalDateTime timestamp = LocalDateTime.now();
        // write timestamp plus entry to audit file
        out.println(timestamp.toString() + " : " + entry);
        out.flush();        
    }
    
}
