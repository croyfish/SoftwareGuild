/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author jeffc
 */
public class LoggingAdvice {
    // Declare AuditDao object
    VendingMachineAuditDao auditDao;
    
    // Create LoggingAdvice constructor that takes AuditDao implementation as a parameter
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
        // Declare createAuditEntry method that takes a JoinPoint as a paramter
        public void createAuditEntry(JoinPoint jp) {
        // Initialize a String with the name of the JoinPoint method
        String methodName = jp.getSignature().getName();
        // Initialize a string for the audit Entry with the JP method name
        String auditEntry = methodName + ": ";
        
        // Initialize an array of strings with the string values of the JP method parameters 
        Object[] args = jp.getArgs();
        // For each element in parameter array, concatenate its String value with the auditEntry String
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        // Try to write audit entry using the auditDao object
        try {
            auditDao.writeAuditEntry(auditEntry);
        // If there is no audit file, print error
        } catch (VendingMachineFilePersistenceException e) {
            System.err.println(
                "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }   
    
}
