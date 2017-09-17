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
    VendingMachineAuditDao auditDao;
    
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

        public void createAuditEntry(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String auditEntry = methodName + ": ";
        
        Object[] args = jp.getArgs();
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
    
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineFilePersistenceException e) {
            System.err.println(
                "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }   
    
}
