/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

// Import classes that will be referenced in App
import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author jeffc
 */
public class App {
    
    public static void main(String[] args) {
        
        // Instantiate UserIO interface implementation
        UserIO myIO = new UserIOConsoleImpl();
        // Pass UserIO implementation object to view
        DVDLibraryView myView = new DVDLibraryView(myIO);
        // Instantiate DAO interface implementation
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        // Pass DAO implementation to controller
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        // Start the controller
        controller.run();
    }
}
