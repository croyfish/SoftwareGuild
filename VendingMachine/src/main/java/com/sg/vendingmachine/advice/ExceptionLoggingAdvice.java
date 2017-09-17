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
    VendingMachineAuditDao auditDao;
    
    public ExceptionLoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

        public void createExceptionAuditEntry(JoinPoint jp, Exception ex) {
        
        String auditEntry = jp.getSignature().getName() + ": " + getMessage(ex) + " ";
        Object[] args = jp.getArgs();
          for (Object currentArg : args) {

            auditEntry += currentArg;
        }
          
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineFilePersistenceException e) {
            System.err.println(
                "ERROR: Could not create audit entry in ExceptionLoggingAdvice.");
        }
    }   
    
}
