/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import static org.apache.commons.lang3.exception.ExceptionUtils.getMessage;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author jeffc
 */
public class ExceptionLoggingAdvice {
    // Declare AuditDao object
    VendingMachineAuditDao auditDao;
    
    // Create class constructor that takes auditDao implementation as parameter
    public ExceptionLoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
        // Declare createExceptionAuditEntry method that takes JP and Exception as parameters
        public void createExceptionAuditEntry(JoinPoint jp, Exception ex) {        
        // Initialize auditEntry String with Name of JP method and exception message 
        String auditEntry = jp.getSignature().getName() + ": " + ex.getMessage();
        // Use auditDao object to try to write audit entry to file  
        try {
            auditDao.writeAuditEntry(auditEntry);
        // If the audit file does not exist, print error message
        } catch (VendingMachineFilePersistenceException e) {
            System.err.println(
                "ERROR: Could not create audit entry in ExceptionLoggingAdvice.");
        }
    }   
    
}
