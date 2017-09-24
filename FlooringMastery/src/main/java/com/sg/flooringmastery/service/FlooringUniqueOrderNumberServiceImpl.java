/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringUniqueOrderNumberDao;
import com.sg.flooringmastery.dto.UniqueOrderNumber;

/**
 *
 * @author jeffc
 */
public class FlooringUniqueOrderNumberServiceImpl implements FlooringUniqueOrderNumberService {

    FlooringUniqueOrderNumberDao orderNumberDao;
    
    public FlooringUniqueOrderNumberServiceImpl(FlooringUniqueOrderNumberDao orderNumberDao) {
        this.orderNumberDao = orderNumberDao;
    }
    
    @Override
    public UniqueOrderNumber getNewUniqueOrderNumber() {
        UniqueOrderNumber orderNumber = orderNumberDao.getCurrentUniqueOrderNumber();
        Integer num = orderNumber.getOrderNumber();
        num++;
        orderNumber.setOrderNumber(num);
        orderNumberDao.setCurrentUniqueOrderNumber(orderNumber);
        return orderNumber;     
    }

    @Override
    public UniqueOrderNumber getCurrentOrderNumber() {
        return orderNumberDao.getCurrentUniqueOrderNumber();
    }

    @Override
    public void setCurrentOrderNumber(UniqueOrderNumber orderNumber) {
        orderNumberDao.setCurrentUniqueOrderNumber(orderNumber);
    }
    
}
