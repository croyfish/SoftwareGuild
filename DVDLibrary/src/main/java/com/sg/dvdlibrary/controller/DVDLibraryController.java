/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

// import classes that will be referenced in Controller
import com.sg.dvdlibrary.dao.*;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.*;
import java.util.List;


/**
 *
 * @author jeffc
 */
public class DVDLibraryController {
    
    // Declare DAO and View objects to be passed in as parameters via dependency injection.
    DVDLibraryServiceLayer service;
    DVDLibraryView view;

    
    public DVDLibraryController(DVDLibraryServiceLayer service, DVDLibraryView view) {
    // Instantiate Service and View objects from parameters    
        this.service  = service;
        this.view = view;
    }
    
    public void run() throws DVDLibraryDataValidationException {
        // User stays in Main Menu loop until keepGoing is false
        boolean keepGoing = true;
        // Initialize menuSelection to zero (no choice)
        int menuSelection = 0;
        // Try&Catch IOExceptions from DAO and translate to DaoExceptions
        try {
            
            // Main Menu Loop
            while(keepGoing) {
                
                // Call method to get menuSelection via view
                menuSelection = getMenuSelection();
            
                // Switch to direct user to appropriate method call
                switch(menuSelection) {
                    case 1: // 1. Add a DVD
                        createDVD();
                        break;
                    case 2: // 2. Delete a DVD
                        removeDVD();
                        break;
                    case 3: // 3. Edit a DVD
                        editDVD();
                        break;
                    case 4: // 4. List all DVDs
                        listDVDs();
                        break;
                    case 5: // 5. Display DVD information by SKU
                        viewDVD();
                        break;
                    case 6: // 6. Search for DVD by Title
                        searchByTitle();
                        break;
                    case 7: // 7. Exit
                        keepGoing = false;
                        break;
                    default:
                        // If IO input validation fails, call unknown command method
                        unknownCommand();                
                }
            
            }
            // Leave the loop via Menu choice 7
            exitMessage();
            // Call DAO method to marshal DVD object records
            service.saveOnExit();
            
        } catch (DVDLibraryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    // Direct program flow to view to print menu and return user's selection
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    // Ask user if they are sure they want to perform this action and return
    // a boolean to indicate user's intention (true = continue, false = back to Menu)
    private boolean verifyChoice() {
        boolean confirm = true;
        String answer = view.displayAreYouSureMessageAndGetAnswer();
        if (answer.equalsIgnoreCase("n")) {
            confirm = false;
        } else if (!answer.equalsIgnoreCase("y")) {
            view.displayUnknownCommandBanner();
            confirm = false;
        }
        return confirm;
    }
    
    private boolean verifyDoAgain() {
        boolean confirm = true;
        String answer = view.displayDoAgainMessageAndGetAnswer();
        if (answer.equalsIgnoreCase("n")) {
            confirm = false;
        } else if (!answer.equalsIgnoreCase("y")) {
            view.displayUnknownCommandBanner();
            confirm = false;
        }
        return confirm;
    }
    
    // Add a new DVD to library
    private void createDVD() 
     throws DVDLibraryPersistenceException, DVDLibraryDataValidationException {
        boolean doAgain = true;
        // Stay in add DVD mode until user chooses to exit
        while (doAgain == true) {
            view.displayCreateDVDBanner();
            // Check if user really wants to do this and return to Main Menu if not
            if (verifyChoice() == false) {
            return;
            }
            // Ask DAO for new SKU and return it as a string
            String SKU = service.getNewSKU();
            // Instantiate new DVD object based on unique SKU
            DVD newDVD = view.getNewDVDInfo(SKU);
            // Tell DAO to add new DVD object to DVD Library HashMap
            service.addDVD(newDVD.getSKU(), newDVD);
            view.displayCreateDVDSuccessBanner(SKU);
            // Call local method to ask user to edit another DVD or not
            doAgain  = verifyDoAgain();
        }  
    }

    // View a DVD in Library based on unique SKU
    private void viewDVD()
     throws DVDLibraryPersistenceException {
        view.displayDisplayDVDBanner();
    // Direct view to ask user for SKU of DVD to view and return it as a String    
        String SKU = view.getSKUChoice();
    // Direct to DAO to verify if SKU exists in library    
        if (service.verifySKU(SKU) == false) {
            view.displayUnknownSKUBanner();
            // If not, return to Main Menu
            return;
        }
        // If SKU exists, return corresponding DVD object
        DVD currentDVD = service.getDVD(SKU);
        // Direct to view to display DVD info
        view.displayDVD(currentDVD);
    }
    
    // Delete DVD from Library based on unique SKU
    private void removeDVD() 
     throws DVDLibraryPersistenceException {
        boolean doAgain = true;
        // Stay in add DVD mode until user chooses to exit
        while (doAgain == true) {
            view.displayRemoveDVDBanner();
            // Direct view to ask user for SKU of DVD to view and return it as a String   
            String SKU = view.getSKUChoice();
            // Direct to DAO to verify if SKU exists in library 
            if (service.verifySKU(SKU) == false) {
                view.displayUnknownSKUBanner();
                // If not, return to Main Menu
                return;
            }
            // If SKU exists, return corresponding DVD object
            DVD currentDVD = service.getDVD(SKU);
            // Direct to view to display DVD info
            view.displayDVD(currentDVD);
            // Check if user really wants to delete this DVD
            if (verifyChoice() == false) {
                return;
            }
            // Tell DAO to remove DVD object from HashMap
            service.removeDVD(SKU);
            view.displayRemoveSuccessBanner();
            // Call local method to ask user to edit another DVD or not
            doAgain  = verifyDoAgain();
            }             
    }
    
    // Display list of all DVDs in Library
    private void listDVDs()
     throws DVDLibraryPersistenceException {
        view.displayDisplayAllBanner();
        // Tell DAO to return an ArrayList of all DVD objects in library
        List<DVD> dvdList = service.getAllDVDs();
        // Tell view to display infor for all DVDs in ArrayList
        view.displayDVDList(dvdList);
    }
    
    // Edit the fields of one DVD object in Library
    private void editDVD()
     throws DVDLibraryPersistenceException, DVDLibraryDataValidationException {
        boolean doAgain = true;
        // Stay in edit mode until user wants to exit
        while (doAgain == true) {
            view.displayEditDVDBanner();
            // Direct view to ask user for SKU of DVD to view and return it as a String 
            String SKU = view.getSKUChoice();
            // Direct to DAO to verify if SKU exists in library
            if (service.verifySKU(SKU) == false) {
                view.displayUnknownSKUBanner();
                // If not, return to Main Menu
                return;
            }
            // If SKU exists, tell view to prompt user for updates to all of DVD's other fields
            DVD currentDVD = view.getNewDVDInfo(SKU);
            // Display user's entered info for current DVD
            view.displayDVD(currentDVD);
            // Check if user really wants to update DVD
            if (verifyChoice() == false) {
                // If no, return to Main Menu
                return;
            }
            // If yes, tell DAO to edit the DVD object by updating its fields
            service.addDVD(SKU, currentDVD);
            view.displayEditSuccessBanner();
            // Call local method to ask user to edit another DVD or not
            doAgain  = verifyDoAgain();
            }        
    }
    
    // Search for DVDs that match a specific title and display their info
    private void searchByTitle() 
     throws DVDLibraryPersistenceException {
        view.displaySearchByTitleBanner();
        // Tell view to prompt user for title and return it as a String
        String title = view.getSearchTitleChoice();
        // Tell DAO to search HashMap for DVDs with same title and return
        // corresponding DVD objects as a list.
        List<DVD> titleResults = service.getDVDsByTitle(title);
        view.displayDisplaySearchByTitleResultsBanner();
        if (titleResults.size() == 0) {
            // Tell view to display message if no results found
            view.displayNoResultsBanner();
        }
        // Tell view to display info for all DVDs in list
        view.displayDVDList(titleResults);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
