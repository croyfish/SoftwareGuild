/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.app;

import com.sg.flooringmastery.controller.FlooringController;
import com.sg.flooringmastery.dao.FlooringOrderDao;
import com.sg.flooringmastery.dao.FlooringOrderDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringProductDao;
import com.sg.flooringmastery.dao.FlooringProductDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringTaxDao;
import com.sg.flooringmastery.dao.FlooringTaxDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringUniqueOrderNumberDao;
import com.sg.flooringmastery.dao.FlooringUniqueOrderNumberDaoFileImpl;
import com.sg.flooringmastery.service.FlooringOrderService;
import com.sg.flooringmastery.service.FlooringOrderServiceImpl;
import com.sg.flooringmastery.service.FlooringProductService;
import com.sg.flooringmastery.service.FlooringProductServiceImpl;
import com.sg.flooringmastery.service.FlooringTaxService;
import com.sg.flooringmastery.service.FlooringTaxServiceImpl;
import com.sg.flooringmastery.service.FlooringUniqueOrderNumberService;
import com.sg.flooringmastery.service.FlooringUniqueOrderNumberServiceImpl;
import com.sg.flooringmastery.ui.FlooringView;
import com.sg.flooringmastery.ui.UserIO;
import com.sg.flooringmastery.ui.UserIOConsoleImpl;

/**
 *
 * @author jeffc
 */
public class App {
    public static void main(String[] args) {
        
        UserIO myIO = new UserIOConsoleImpl(); // your IO console impl here!
        FlooringView myView = new FlooringView(myIO);
        
        FlooringOrderDao myOrderDao = new FlooringOrderDaoFileImpl("data/");
        FlooringUniqueOrderNumberDao myOrderNumberDao = new FlooringUniqueOrderNumberDaoFileImpl();
        FlooringProductDao myProductDao = new FlooringProductDaoFileImpl("data/");
        FlooringTaxDao myTaxDao = new FlooringTaxDaoFileImpl("data/");
        
        FlooringProductService myProductService = new FlooringProductServiceImpl(myProductDao);
        FlooringTaxService myTaxService = new FlooringTaxServiceImpl(myTaxDao);
        FlooringUniqueOrderNumberService myOrderNumberService = 
                new FlooringUniqueOrderNumberServiceImpl(myOrderNumberDao);
        FlooringOrderService myOrderService = new FlooringOrderServiceImpl(myOrderDao,
            myProductService, myTaxService, myOrderNumberService);
        
        FlooringController controller = new FlooringController(myView,
            myOrderService, myOrderNumberService);
        
        controller.run();
        
        
        
    }
    
    
}
