/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

// Import classes that will be referenced in App
import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class App {
    
    public static void main(String[] args) throws DVDLibraryDataValidationException {
        
//        // Instantiate UserIO interface implementation
//        UserIO myIO = new UserIOConsoleImpl();
//        // Pass UserIO implementation object to view
//        DVDLibraryView myView = new DVDLibraryView(myIO);
//        // Instantiate DAO interface implementation
//        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
//        // Instantiate ServiceLayer interface implementation
//        DVDLibraryServiceLayer myService = new DVDLibraryServiceLayerImpl(myDao);
//        // Pass DAO implementation to controller
//        DVDLibraryController controller = new DVDLibraryController(myService, myView);
//        // Start the controller

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDLibraryController controller =
                ctx.getBean("controller", DVDLibraryController.class);
        controller.run();
    }
}
