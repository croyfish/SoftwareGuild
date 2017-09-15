/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDataValidationException;
import com.sg.vendingmachine.dao.VendingMachineFilePersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class App {
    public static void main(String[] args) throws VendingMachineFilePersistenceException, 
            VendingMachineDataValidationException  {
        
//        // Use dependency injection to instantiate objects for UserIO, View,
//        // DAO, and service, and pass them via constructors to the relevant classes.
//        UserIO myIO = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIO);
//        VendingMachineDAO myDAO = new VendingMachineDAOFileImpl();
//        VendingMachineService myService = new VendingMachineServiceImpl(myDAO);
//        VendingMachineController controller = new VendingMachineController(myService, myView);
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller =
                ctx.getBean("controller", VendingMachineController.class);
        controller.run();
        
    }
}
